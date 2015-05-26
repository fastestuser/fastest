package org.fastest.atcal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.misc.NotNull;
import org.fastest.atcal.apl.*;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprConst;
import org.fastest.atcal.z.ast.ZExprSchema;
import org.fastest.atcal.z.ast.ZVar;

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

    private ZExpr getScope() {
        return this.zScope.getVar("zScope").get().getValue();
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
    public List<APLExpr> visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
        ZExpr zExpr = zExprEvaluator.visit(ctx.zExpr());

        // Create a new zScope that includes the result of evaluating the Z expressions of the law
        ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

        // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
        // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
        List<APLExpr> codeBlock = Lists.newArrayList();
        RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, aplScope, types);
        for (AtcalParser.RefinementContext context : ctx.refinement())
            codeBlock.addAll(lawEvaluator.visit(context));

        return codeBlock;
    }

    @Override
    public List<APLExpr> visitVarLValue(@NotNull AtcalParser.VarLValueContext ctx) {
        return Lists.newArrayList((APLExpr) new APLVar(ctx.ID().getText()));
    }

    @Override
    public List<APLExpr> visitArrayLValue(@NotNull AtcalParser.ArrayLValueContext ctx) {
        if (ctx.NUMBER() != null) {
            return Lists.newArrayList((APLExpr) new APLArray(aplScope.getName(), Integer.valueOf(ctx.NUMBER().getText())));
        } else {
            return Lists.newArrayList((APLExpr) new APLVar(aplScope + "[]"));
        }
    }

    @Override
    public List<APLExpr> visitFieldLValue(@NotNull AtcalParser.FieldLValueContext ctx) {
        return Lists.newArrayList((APLExpr) new APLVar(aplScope + "." + ctx.ID().getText()));
    }

    @Override
    public List<APLExpr> visitImplRef(@NotNull AtcalParser.ImplRefContext ctx) {
        List<APLExpr> lvalueCodeBlock = visit(ctx.lvalue());
        APLLValue lvalue = (APLLValue) lvalueCodeBlock.get(0);
        RefinementLawEvaluator newScopeEvaluator = new RefinementLawEvaluator(zScope, lvalue, types);
        return newScopeEvaluator.visit(ctx.asRef());
    }

    @Override
    public List<APLExpr> visitWithRef(@NotNull AtcalParser.WithRefContext ctx) {
        List<APLExpr> codeBlock = Lists.newArrayList();

        // Get the ATCAL type of the refinement.
        ATCALType asType = resolveType(ctx.type());

        // Generate code according to the type of the refinement variable.
        // Contract types are used to create complex data structures that have a contract (an interface).
        // They have a constructor, a getter and a setter function that instantiate, extract or insert values.
        if (asType instanceof ContractType) {
            ContractType type = (ContractType) asType;

            // Create a new temporal variable to hold the data structure under construction.
            APLVar var = new APLVar(aplScope.getName() + '_' + type.getSetterArgs().get(0));
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

            // Array types are handled as a special case because they often have native support in the target language.
        } else if (asType instanceof ArrayType) {
            ArrayType type = (ArrayType) asType;

            // Allocate a new array using the APL built-in function newArray and assign it to the current APL variable in scope.
            codeBlock.add(new AssignStmt(aplScope, new CallExpr("newArray", Lists.newArrayList(String.valueOf(type.getSize())))));

            // Evaluate the WITH-clauses. The evaluation produces a block of code that assign values to many indices in
            // the array (or all).
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.addAll(visit(lawRefinementContext));
            }

            // Record types are handled separately because they have native support in the target language.
        } else if (asType instanceof RecordType) {
            RecordType type = (RecordType) asType;

            // Evaluate the WITH-clauses. The evaluation must produce a block of code that defines one variable for each
            // field of the record type.
            for (AtcalParser.LawRefinementContext lawRefinementContext : ctx.lawRefinement()) {
                codeBlock.addAll(visit(lawRefinementContext));
            }


        }
        return codeBlock;
    }

    @Override
    public List<APLExpr> visitSimpleRef(@NotNull AtcalParser.SimpleRefContext ctx) {
        List<APLExpr> codeBlock = Lists.newArrayList();

        // Get the ATCAL type of the refinement.
        ATCALType asType = resolveType(ctx.type());

        // Refine the Z expression to an APL expression of the given type.
        // There are restrictions on the refinement options for Z expressions (i.e an alphanumeric string cannot be
        // refined into an integer).
        // If we try such refinement an exception is produced that we capture here to notify the user.
        try {
        /* The behavior of the simple refinement depends on both the type of the implementation variable and the specification value. */
            APLExpr value = asType.fromZExpr(this.getScope());
            codeBlock.add(new AssignStmt(aplScope, value));
        } catch (Exception e) {
            System.out.println("Type error on SimpleRef");
        }
        return codeBlock;
    }

    @Override
    public List<APLExpr> visitBijMapRef(@NotNull AtcalParser.BijMapRefContext ctx) {
        List<APLExpr> codeBlock = Lists.newArrayList();

        // Get the ATCAL type of the refinement.
        ATCALType asType = resolveType(ctx.type());

        // The source and destination types must be constants, fail otherwise.
        if (this.getScope() instanceof ZExprConst) {
            ZExprConst zExprConst = (ZExprConst) this.getScope();

            // Create bijection map
            Map<ZExprConst, ConsExpr> map = Maps.newHashMap();
            for (AtcalParser.TypeCaseContext typeCase : ctx.typeCases().typeCase()) {
                map.put(new ZExprConst(typeCase.ID(0).getText(), 0, ZExprConst.ConstantType.BASIC), new ConsExpr(typeCase.ID(1).getText()));
            }

            // Check that the mapping contains the Z constant mapping and generate code for the refinement
            if (map.containsKey(zExprConst))
                codeBlock.add(new AssignStmt(aplScope, map.get(zExprConst)));
            else
                System.out.println("Z Constant " + zExprConst.toString() + " not present in bijection map.");
        } else {
            System.out.println("Type error on BijMapRef");
        }
        return codeBlock;
    }

    @Override
    public List<APLExpr> visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx) {
        return visitLawRefinement(ctx.lawRefinement());
    }
}