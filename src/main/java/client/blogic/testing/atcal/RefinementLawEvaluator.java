package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.*;
import client.blogic.testing.atcal.parser.AtcalBaseVisitor;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Cristian on 4/16/15.
 */
public class RefinementLawEvaluator extends AtcalBaseVisitor<CodeBlock> {

    private final ZExprSchema zScope;   // Scope for z expressions
    private final APLLValue aplScope;      // Scope for APL code
    private final Map<String, ATCALType> types; // Declared types
    private final LValueFactory lValueFactory; // LValue manager
    // The constant mapper manages the mappings from Z constants to APL expressions
    private final Map<String, ConstantMapper> zVarConstantMaps;
    private final BiMap<ZVar, String> zVarToImpVarName;

    public RefinementLawEvaluator(ZExprSchema zScope, APLLValue aplScope, Map<String, ATCALType> types,
                                  LValueFactory lValueFactory, Map<String, ConstantMapper> zVarConstantMaps,
                                  BiMap<ZVar, String> zVarToImpVarName) {
        this.zScope = zScope;
        this.aplScope = aplScope;
        this.types = types;
        this.lValueFactory = lValueFactory;
        this.zVarConstantMaps = zVarConstantMaps;
        this.zVarToImpVarName = zVarToImpVarName;
    }

    private ZExpr getZScope() {
        return this.zScope.getVar("zScope").get().getValue();
    }

    public Map<String, ConstantMapper> getZVarConstantMaps() {
        return zVarConstantMaps;
    }

    @Override
    public CodeBlock visitLaws(@NotNull AtcalParser.LawsContext ctx) {
        CodeBlock codeBlock = new CodeBlock();
        for (AtcalParser.LawContext lawCtx : ctx.law()) {
            if (lawCtx.lawRefinement() != null)
                codeBlock.join(visit(lawCtx.lawRefinement()));
            else
                codeBlock.join(visit(lawCtx.biRefLaw()));
        }
        return codeBlock;
    }

    @Override
    public CodeBlock visitBiRefLaw(AtcalParser.BiRefLawContext ctx) {
        // Get the ZVar and associate it with the implementation var name for the abstraction phase.
        Optional<ZVar> var = zScope.getVar(ctx.ID().getText());
        if (var.isPresent())
            zVarToImpVarName.put(var.get(), ctx.refinement(0).lvalue().getText());
        else
            throw new RuntimeException(String.format("Unknown identifier %s.", ctx.ID().getText()));

        // Evaluate the Z expressions of the law
        ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
        ZExpr zExpr = var.get().getValue();

        // Evaluate the refinement using the list of Z expressions as contexts
        CodeBlock codeBlock = new CodeBlock();

        // Create a new zScope that includes the result of evaluating the Z expressions of the law
        ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

        // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
        // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
        RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, aplScope, types, lValueFactory, zVarConstantMaps, zVarToImpVarName);
        for (AtcalParser.RefinementContext context : ctx.refinement())
            codeBlock.join(lawEvaluator.visit(context));

        return codeBlock;
    }

    @Override
    public CodeBlock visitLawRefinement(AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprList zExprList;
        {
            ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
            ZExpr zExpr = zExprEvaluator.visit(ctx.zExprs());

            // If the evaluation of the Z expression returns a single Z expression, package it in a single element list to
            // factorize the rest of the code.
            if (zExpr instanceof ZExprList) {
                zExprList = (ZExprList) zExpr;
            } else {
                zExprList = new ZExprList(ImmutableList.of(zExpr));
            }
        }

        // Evaluate the refinement using the list of Z expressions as contexts
        CodeBlock codeBlock = new CodeBlock();
        for (ZExpr zExpr : zExprList) {
            // Create a new zScope that includes the result of evaluating the Z expressions of the law
            ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

            // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
            // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
            RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, aplScope, types, lValueFactory, zVarConstantMaps, zVarToImpVarName);
            for (AtcalParser.RefinementContext context : ctx.refinement())
                codeBlock.join(lawEvaluator.visit(context));
        }
        return codeBlock;
    }

    @Override
    public CodeBlock visitRefinement(@NotNull AtcalParser.RefinementContext ctx) {
        CodeBlock codeBlock = new CodeBlock();
        // Get the ATCAL lvalue of the refinement and use it as the new APL scope.
        LValueEvaluator lValueEval = new LValueEvaluator(ctx.type());
        APLLValue newAPLScope = lValueEval.visit(ctx.lvalue());
        ATCALType newAPLScopeType = newAPLScope.getType();

        if (this.getZScope() instanceof ZExprConst) {
            ZExprConst zExprConst = (ZExprConst) this.getZScope();
            APLExpr aplExpr = null;
            if (newAPLScopeType instanceof IntType) {
                aplExpr = zVarConstantMaps.getOrDefault(zExprConst.getZVarName(), new ConstantMapper()).toInt(zExprConst);
            } else if (newAPLScopeType instanceof StringType) {
                aplExpr = zVarConstantMaps.getOrDefault(zExprConst.getZVarName(), new ConstantMapper()).toString(zExprConst);
            } else if (newAPLScopeType instanceof EnumType) {
                // Use a custom mapping for enum constants if present.
                EnumType enumType = (EnumType) newAPLScopeType;
                if (ctx.constMapping() != null) {
                    Map<ZExprConst, ConsExpr> customMap = Maps.newHashMap();
                    for (AtcalParser.ConstMapContext constMap : ctx.constMapping().constMap()) {
                        customMap.put(ZExprConst.basic(constMap.ID(0).getText(), zExprConst.getZVarName()),
                                enumType.getElemByName(constMap.ID(1).getText()));
                    }
                    aplExpr = zVarConstantMaps.getOrDefault(zExprConst.getZVarName(), new ConstantMapper()).toEnum(zExprConst, customMap);
                } else {
                    aplExpr = zVarConstantMaps.getOrDefault(zExprConst.getZVarName(), new ConstantMapper()).toEnum(zExprConst, enumType);
                }
            } else {
                throw new RuntimeException(
                        String.format("Cannot map Z constant %s to lvalue of type %s.",
                                zExprConst.getValue(), newAPLScopeType.toString()));
            }

            codeBlock.addStmt(new AssignStmt(newAPLScope, aplExpr));
            return codeBlock;

        } else if (ctx.constMapping() != null) {
            throw new RuntimeException("Bijection mappings only apply to refine constant values.");
        } else if (ctx.withRef() != null) {
            // If there is a WITH clause then create an evaluator with the new APL lvalue and type scopes and evaluate it.
            // TODO: check that the type of the new APL scope and the type of the refinement are compatible
            RefinementLawEvaluator newScopeEvaluator = new RefinementLawEvaluator(zScope, newAPLScope, types, lValueFactory, zVarConstantMaps, zVarToImpVarName);
            return newScopeEvaluator.visit(ctx.withRef());
        } else {
            // Refine the Z expression to an APL expression of the given type.
            // There are restrictions on the refinement options for Z expressions (i.e an alphanumeric string cannot be
            // refined into an integer).
            // If we try such refinement an exception is produced that we capture here to notify the user.
            /* The behavior of the simple refinement depends on both the type of the implementation variable and the specification value. */
            APLExpr value = newAPLScope.getType().fromZExpr(this.getZScope());
            codeBlock.addStmt(new AssignStmt(newAPLScope, value));
            return codeBlock;
        }
    }

    @Override
    public CodeBlock visitWithRef(@NotNull AtcalParser.WithRefContext ctx) {
        CodeBlock codeBlock = new CodeBlock();
        // Generate code according to the type of the refinement variable.
        if (aplScope.getType() instanceof ContractType) {
            // Contract types are used to create complex data structures that have a contract (an interface).
            // They have a constructor, a getter and a setter function that instantiate, extract or insert values.
            ContractType type = (ContractType) aplScope.getType();

            // Create a new temporal variable to hold the data structure under construction.
            APLVar var = new APLVar(aplScope.getName() + "_tmp", aplScope.getType());
            codeBlock.addStmt(new ConstructorCallStmt(var, type.getConstArgs()));

            // The evaluation of the WITH clause for a contract type requires evaluating all the Z expressions of the
            // refinements in the clause beforehand. The result of this evaluation is a list of iterable Z expressions.
            // The number of elements in each iterable Z expressions must be the same, and the number of these iterables
            // must be equal to the arity of the contract type's setter function.
            // Consider a contract type with a setter of arity equal to 3 and a WITH clause such as:
            //     [ {a,b} ==> fst, {c,d} ==> snd, {e,f} ==> trd ]
            // to refine this, first evaluate the Z expressions into a list of iterables L = [ [a,b], [c,d], [e,f] ].
            // Then, refine the setter arguments fst, snd, and trd over the iterables:
            // a ==> fst, c ==> snd, e ==> trd (call setter) b ==> fst, d ==> snd, f ==> trd (call setter).

            // Check if setter arity matches
            if (ctx.lawRefinement().size() != (type.getSetterArgs().size()))
                throw new RuntimeException("The number of refinements in WITH clause does not match the arity of " +
                        "contract type's setter.");

            // Evaluate Z expressions of refinements into a list of ZExpr iterators (one for each argument of the setter).
            List<Iterator<ZExpr>> iteratorList = Lists.newArrayList();
            ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                ZExpr zExpr = zExprEvaluator.visit(lawRefinementContext.zExprs());
                if (zExpr instanceof Iterable)
                    iteratorList.add(((Iterable<ZExpr>) zExpr).iterator());
                else
                    // pack non-iterable Z expressions into an iterable collection to simplify the rest of the code.
                    iteratorList.add(ImmutableList.of(zExpr).iterator());
            }

            // Evaluate the refinement clauses. The evaluation must produce a block of code that defines one variable
            // for each argument of the setter function in the contract type.
            while (iteratorList.get(0).hasNext()) {
                for (Iterator<ZExpr> it : iteratorList) {
                    // Create a new Z scope corresponding to the setters argument.
                    ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", it.next()));

                    // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
                    // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
                    RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, var, types, new LValueFactory(), zVarConstantMaps, zVarToImpVarName);
                    codeBlock.join(lawEvaluator.visit(ctx.lawRefinement(iteratorList.indexOf(it)).refinement(0)));
                }

                // Insert the values of the refined clauses into the data structure using the provided setter function
                // TODO: check the type values with the types of the arguments.
                codeBlock.addStmt(new SetterCallStmt(var, type.getSetterArgs()));
            }

            // Assign the temporal variable holding the data structure to the real refinement variable.
            codeBlock.addStmt(new AssignStmt(aplScope, var));

        } else if (aplScope.getType() instanceof ArrayType) {
            // Array types are handled as a special case because they often have native support in the target language.
            ArrayType type = (ArrayType) aplScope.getType();

            // Allocate a new array using the APL built-in function newArray and assign it to the current APL variable in scope.
            codeBlock.addStmt(new ArrayDeclStmt(type, aplScope.getName(), type.getSize()));
//            codeBlock.add(new AssignStmt(aplScope, new CallExpr("newArray", Lists.newArrayList(new LongExpr(type.getSize())))));

            // Evaluate the WITH-clauses. The evaluation produces a block of code that assign values to many indices in
            // the array (or all).
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.join(visit(lawRefinementContext));
            }

        } else if (aplScope.getType() instanceof RecordType) {
            // Record types are handled separately because they have native support in the target language.
            RecordType type = (RecordType) aplScope.getType();

            // Evaluate the WITH-clauses. The evaluation must produce a block of code that defines one variable for each
            // field of the record type.
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.join(visit(lawRefinementContext));
            }
        }
        return codeBlock;
    }

    @Override
    public CodeBlock visitUUTNoRetVal(AtcalParser.UUTNoRetValContext ctx) {
        CodeBlock codeBlock = new CodeBlock();
        List<APLLValue> uutCallArgs = Lists.transform(ctx.args().ID(), tn -> lValueFactory.getLValue(tn.getText()));
        CallExpr uutCall = new CallExpr(ctx.ID().getText(), uutCallArgs);
        codeBlock.addStmt(uutCall);
        return codeBlock;
    }

    @Override
    public CodeBlock visitUUTRetVal(AtcalParser.UUTRetValContext ctx) {
        CodeBlock codeBlock = new CodeBlock();
        List<APLLValue> uutCallArgs = Lists.transform(ctx.args().ID(), tn -> lValueFactory.getLValue(tn.getText()));
        CallExpr uutCall = new CallExpr(ctx.ID(1).getText(), uutCallArgs);
        APLLValue retVal = this.lValueFactory.newVar(ctx.ID(0).getText(), this.types.get(ctx.type().getText()));
        AssignStmt uutRetVal = new AssignStmt(retVal, uutCall);
        codeBlock.addStmt(uutRetVal);
        return codeBlock;
    }

    // Private nested class to evaluate lvalues and their APL types.
    public class LValueEvaluator extends AtcalBaseVisitor<APLLValue> {

        private final ATCALType type;

        public LValueEvaluator(AtcalParser.TypeContext typeCtx) {
            // Parse and resolve the type of the lvalue
            this.type = resolveType(typeCtx);
        }

        private ATCALType resolveType(AtcalParser.TypeContext typeCtx) {
            // Lookup the type id in the types table. If not found it may be an in-place declaration, thus parse it.
            ATCALType asType = types.get(typeCtx.getText());
            if (asType == null) {
                asType = new TypesEvaluator.TypeEvaluator(types).visit(typeCtx);
            }
            return asType;
        }

        @Override
        public APLLValue visitVarLValue(@NotNull AtcalParser.VarLValueContext ctx) {
            if (type instanceof ArrayType)
                return lValueFactory.newArray(ctx.ID().getText(), type);
            else
                return lValueFactory.newVar(ctx.ID().getText(), type);
        }

        @Override
        public APLLValue visitArrayLValue(@NotNull AtcalParser.ArrayLValueContext ctx) {
            if (ctx.NUMBER() != null) {
                return ((APLArray) aplScope).getIndex(Integer.valueOf(ctx.NUMBER().getText()));
            } else {
                return ((APLArray) aplScope).getNextIndex();
            }
        }

        @Override
        public APLLValue visitFieldLValue(@NotNull AtcalParser.FieldLValueContext ctx) {
            return new APLVar(aplScope + "." + ctx.ID().getText(), type);
        }
    }
}