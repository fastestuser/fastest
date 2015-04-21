package org.fastest.atcal;

import com.google.common.collect.Lists;
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
public class RefinementLawEvaluator extends AtcalBaseVisitor<List<APLStmt>> {

    private final ZExprSchema zScope;   // Evaluator's scope for z expressions
    private final String aplScope;      // Evaluator's scope for APL code
    private final Map<String, ATCALType> types; // Evaluator's declared types

    public RefinementLawEvaluator(ZExprSchema zScope, String aplScope, Map<String, ATCALType> types) {
        this.zScope = zScope;
        this.aplScope = aplScope;
        this.types = types;
    }

    private static APLExpr ZExprToAPLExpr(ZExpr zExpr) throws Exception {
        ZExprConst exp = zExpr instanceof ZExprConst ? ((ZExprConst) zExpr) : null;
        if (exp != null)
            return new ConsExpr(exp.getValue());

        ZExprNum exp2 = zExpr instanceof ZExprNum ? ((ZExprNum) zExpr) : null;
        if (exp2 != null)
            return new IntExpr(exp2.getNum());

        throw new Exception();
    }

    private ZExpr getScope(){
        return this.zScope.getVar("zScope").get().getValue();
    }

    @Override
    public List<APLStmt> visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
        ZExpr zExpr = zExprEvaluator.visit(ctx.zExpr());

        // Create a new zScope that includes the result of evaluating the Z expressions of the law
        ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

        // Recursively evaluate the refinements of the law with the new Z scope and the current APL scope
        // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
        List<APLStmt> codeBlock = Lists.newArrayList();
        RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope, aplScope, types);
        for (AtcalParser.RefinementContext context : ctx.refinement())
            codeBlock.addAll(lawEvaluator.visit(context));

        return codeBlock;
    }

    @Override
    public List<APLStmt> visitBasicRef(@NotNull AtcalParser.BasicRefContext ctx) {

        List<APLStmt> codeBlock = Lists.newArrayList();
        try {
            if (ctx.ID() != null) {
                codeBlock.add(new AssignStmt(ctx.ID().getText(), ZExprToAPLExpr(this.getScope())));
            } else if (ctx.NUMBER() != null) {
                codeBlock.add(new AssignStmt(aplScope + "[" + ctx.NUMBER().getText() + "]", ZExprToAPLExpr(this.getScope())));
            } else {
                codeBlock.add(new AssignStmt(aplScope + "[ ]", ZExprToAPLExpr(this.getScope())));
            }
        } catch (Exception e) {
            System.out.println("Unimplemented ZExpr translation.");
        }

        return codeBlock;
    }

    @Override
    public List<APLStmt> visitWithRef(@NotNull AtcalParser.WithRefContext ctx) {
        List<APLStmt> codeBlock = Lists.newArrayList();

        ATCALType asType = null;
        String typeId = null;
        if((typeId = ctx.ID(1).getText()) != null)
            asType = types.get(typeId);

        // TODO : if type is defined in the refinement law, parse it with ATCAL's type visitor

        RefinementLawEvaluator evaluator = new RefinementLawEvaluator(zScope, ctx.ID(1).getText(), types);

        if(asType instanceof ContractType){
            codeBlock.add(new AssignStmt(aplScope, new CallExpr(((ContractType) asType).getConstructor(), Lists.newArrayList(""))));
            for(AtcalParser.LawRefinementContext lawRefinementContext: ctx.lawRefinement()){
                codeBlock.addAll(evaluator.visit(lawRefinementContext));
                codeBlock.add(new AssignStmt("_", new CallExpr(((ContractType) asType).getSetter(), Lists.newArrayList("_"))));
            }
        }

        return codeBlock;
    }

    @Override
    public List<APLStmt> visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx) {
        return visitLawRefinement(ctx.lawRefinement());
    }
}