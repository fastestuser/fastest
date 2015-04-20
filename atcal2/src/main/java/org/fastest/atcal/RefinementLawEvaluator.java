package org.fastest.atcal;

import com.google.common.collect.Lists;
import org.antlr.v4.runtime.misc.NotNull;
import org.fastest.atcal.apl.*;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;

import java.util.List;

/**
 * Created by Cristian on 4/16/15.
 */
public class RefinementLawEvaluator extends AtcalBaseVisitor<List<APLStmt>> {

    private final ZExprSchema zScope;

    public RefinementLawEvaluator(ZExprSchema zScope) {
        this.zScope = zScope;
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

    @Override
    public List<APLStmt> visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprEvaluator zExprEvaluator = new ZExprEvaluator(zScope);
        ZExpr zExpr = zExprEvaluator.visit(ctx.zExpr());

        // Create a new zScope that includes the result of evaluating the Z expressions of the law
        ZExprSchema newScope = ZExprSchema.add(zScope, new ZVar("zScope", zExpr));

        // Recursively evaluate the refinements of the law with the new zScope.
        // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
        List<APLStmt> codeBlock = Lists.newArrayList();
        RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope);
        for (AtcalParser.RefinementContext context : ctx.refinement())
            codeBlock.addAll(lawEvaluator.visit(context));

        return codeBlock;
    }

    @Override
    public List<APLStmt> visitBasicRef(@NotNull AtcalParser.BasicRefContext ctx) {

        List<APLStmt> codeBlock = Lists.newArrayList();
        try {
            if (ctx.ID() != null) {
                codeBlock.add(new AssignStmt(ctx.ID().getText(), ZExprToAPLExpr(zScope.getVar("zScope").get().getValue())));
            } else if (ctx.NUMBER() != null) {
                //codeBlock += "[" + ctx.NUMBER().getText() + "]" + " = " + zScope.getVar("zScope").get().getValue().toString() + "\n";
                codeBlock.add(new AssignStmt("[" + ctx.NUMBER().getText() + "]", ZExprToAPLExpr(zScope.getVar("zScope").get().getValue())));
            } else {
                codeBlock.add(new AssignStmt("[ ]", ZExprToAPLExpr(zScope.getVar("zScope").get().getValue())));
            }
        } catch (Exception e) {
            System.out.println("Unimplemented ZExpr translation.");
        }

        return codeBlock;
    }

    @Override
    public List<APLStmt> visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx) {
        return visitLawRefinement(ctx.lawRefinement());
    }
}