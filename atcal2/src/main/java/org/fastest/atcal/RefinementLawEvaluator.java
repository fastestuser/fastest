package org.fastest.atcal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.misc.NotNull;
import org.fastest.atcal.apl.*;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Cristian on 4/16/15.
 */
public class RefinementLawEvaluator extends AtcalBaseVisitor<List<APLExpr>> {

    private final ZExprSchema zScope;   // Evaluator's scope for z expressions
    private final APLLValue aplScope;      // Evaluator's scope for APL code
    private final Map<String, ATCALType> types; // Evaluator's declared types

    public RefinementLawEvaluator(ZExprSchema zScope, APLLValue aplScope, Map<String, ATCALType> types) {
        this.zScope = zScope;
        this.aplScope = aplScope;
        this.types = types;
    }

    private ZExpr getZScope() {
        return this.zScope.getVar("zScope").get().getValue();
    }

    @Override
    public List<APLExpr> visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprList zExprList = null;
        {
            ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
            ZExpr zExpr = zExprEvaluator.visit(ctx.zExpr());

            // If the evaluation of the Z expression returns a single Z expression, package it in a single element list to
            // factorize the rest of the code.
            if (zExpr instanceof ZExprList) {
                zExprList = (ZExprList) zExpr;
            } else {
                zExprList = new ZExprList(ImmutableList.of(zExpr));
            }
        }

        // Evaluate the refinement using the list of Z expressions as contexts
        List<APLExpr> codeBlock = Lists.newArrayList();
        for (ZExpr zExpr : zExprList) {
            // Create a new zScope that includes the result of evaluating the Z expressions of the law
            ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

            // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
            // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
            RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, aplScope, types);
            for (AtcalParser.RefinementContext context : ctx.refinement())
                codeBlock.addAll(lawEvaluator.visit(context));
        }
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
            if(type instanceof ArrayType)
                return new APLArray(ctx.ID().getText(), type);
            else
                return new APLVar(ctx.ID().getText(), type);
        }

        @Override
        public APLLValue visitArrayLValue(@NotNull AtcalParser.ArrayLValueContext ctx) {
            if (ctx.NUMBER() != null) {
                return ((APLArray)aplScope).getIndex(Integer.valueOf(ctx.NUMBER().getText()));
            } else {
                return ((APLArray)aplScope).getNextIndex();
            }
        }

        @Override
        public APLLValue visitFieldLValue(@NotNull AtcalParser.FieldLValueContext ctx) {
            return new APLVar(aplScope + "." + ctx.ID().getText(), type);
        }
    }

    @Override
    public List<APLExpr> visitImplRef(@NotNull AtcalParser.ImplRefContext ctx) {
        List<APLExpr> codeBlock = Lists.newArrayList();
        // Get the ATCAL lvalue of the refinement and use it as the new APL scope.
        LValueEvaluator lValueEval = new LValueEvaluator(ctx.type());
        APLLValue newAPLScope = lValueEval.visit(ctx.lvalue());

        // If there is a mapping of constants then check source and destination types and build mapping table.
        if (ctx.constMapping() != null) {
            if (this.getZScope() instanceof ZExprConst) {
                ZExprConst zExprConst = (ZExprConst) this.getZScope();

                // Create constants map
                Map<ZExprConst, ConsExpr> map = Maps.newHashMap();
                for (AtcalParser.ConstMapContext constMap : ctx.constMapping().constMap()) {
                    map.put(new ZExprConst(constMap.ID(0).getText(), 0, ZExprConst.ConstantType.BASIC), new ConsExpr(constMap.ID(1).getText()));
                }

                // Check that the mapping contains the Z constant mapping and generate code for the refinement
                if (map.containsKey(zExprConst))
                    codeBlock.add(new AssignStmt(newAPLScope, map.get(zExprConst)));
                else
                    System.out.println("Z Constant " + zExprConst.toString() + " not present in constants mapping.");

                return codeBlock;
            } else {
                throw new RuntimeException("Type error on BijMapRef");
            }
        } else if (ctx.withRef() != null) {
            // If there is a WITH clause then create an evaluator with the new APL lvalue and type scopes and evaluate it.
            RefinementLawEvaluator newScopeEvaluator = new RefinementLawEvaluator(zScope, newAPLScope, types);
            return newScopeEvaluator.visit(ctx.withRef());
        } else {
            // Refine the Z expression to an APL expression of the given type.
            // There are restrictions on the refinement options for Z expressions (i.e an alphanumeric string cannot be
            // refined into an integer).
            // If we try such refinement an exception is produced that we capture here to notify the user.
            try {
            /* The behavior of the simple refinement depends on both the type of the implementation variable and the specification value. */
                APLExpr value = newAPLScope.getType().fromZExpr(this.getZScope());
                codeBlock.add(new AssignStmt(newAPLScope, value));
                return codeBlock;
            } catch (Exception e) {
                throw new RuntimeException("Type error on simple refinement");
            }
        }
    }

    @Override
    public List<APLExpr> visitWithRef(@NotNull AtcalParser.WithRefContext ctx) {
        List<APLExpr> codeBlock = Lists.newArrayList();
        // Generate code according to the type of the refinement variable.
        // Contract types are used to create complex data structures that have a contract (an interface).
        // They have a constructor, a getter and a setter function that instantiate, extract or insert values.
        if (aplScope.getType() instanceof ContractType) {
            ContractType type = (ContractType) aplScope.getType();

            // Create a new temporal variable to hold the data structure under construction.
            APLVar var = new APLVar(aplScope.getName() + '_' + type.getSetterArgs().get(0), aplScope.getType());
            codeBlock.add(new AssignStmt(var, new CallExpr(type.getConstructor(), Lists.newArrayList(""))));

            // Evaluate the WITH-clauses. The evaluation must produce a block of code that defines one variable for each
            // argument of the setter function in the contract type.
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.addAll(visit(lawRefinementContext));
            }

            // Insert the values of the refined WITH-clauses into the data structure using the provided setter function
            // TODO: check the type values with the types of the arguments (the amount of them must also match!)
            List<String> args = Lists.newArrayList(aplScope.getName() + '_' + type.getSetterArgs().get(0));
            args.addAll(type.getSetterArgs().subList(1, type.getSetterArgs().size()));
            codeBlock.add(new CallExpr(type.getSetter(), args));

            // Assign the temporal variable holding the data structure to the real refinement variable.
            codeBlock.add(new AssignStmt(aplScope, var));

        } else if (aplScope.getType() instanceof ArrayType) {
            // Array types are handled as a special case because they often have native support in the target language.
            ArrayType type = (ArrayType) aplScope.getType();

            // Allocate a new array using the APL built-in function newArray and assign it to the current APL variable in scope.
            codeBlock.add(new AssignStmt(aplScope, new CallExpr("newArray", Lists.newArrayList(String.valueOf(type.getSize())))));

            // Evaluate the WITH-clauses. The evaluation produces a block of code that assign values to many indices in
            // the array (or all).
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.addAll(visit(lawRefinementContext));
            }

        } else if (aplScope.getType() instanceof RecordType) {
            // Record types are handled separately because they have native support in the target language.
            RecordType type = (RecordType) aplScope.getType();

            // Evaluate the WITH-clauses. The evaluation must produce a block of code that defines one variable for each
            // field of the record type.
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.addAll(visit(lawRefinementContext));
            }
        }
        return codeBlock;
    }

    @Override
    public List<APLExpr> visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx) {
        return visitLawRefinement(ctx.lawRefinement());
    }
}