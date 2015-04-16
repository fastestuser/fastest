package org.fastest.atcal;

import org.antlr.v4.runtime.misc.NotNull;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprSchema;
import org.fastest.atcal.z.ast.ZVar;

/**
 * Created by Cristian on 4/16/15.
 */
public class RefinementLawEvaluator extends AtcalBaseVisitor<String> {

    private final ZExprSchema scope;

    public RefinementLawEvaluator(ZExprSchema scope) {
        this.scope = scope;
    }

    @Override
    public String visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx) {
        // Evaluate the Z expressions of the law
        ZExprEvaluator zExprEvaluator = new ZExprEvaluator(scope);
        ZExpr zExpr = zExprEvaluator.visit(ctx.zExpr());

        // Create a new scope that includes the result of evaluating the Z expressions of the law
        ZExprSchema newScope = ZExprSchema.add(scope, new ZVar("scope", zExpr));

        // Recursively evaluate the refinements of the law with the new scope.
        // The evaluation of each refinement produces a block of intermediate code that is collected to produce the output.
        String codeBlock = "";
        RefinementLawEvaluator lawEvaluator = new RefinementLawEvaluator(newScope);
        for(AtcalParser.RefinementContext context: ctx.refinement())
            codeBlock += lawEvaluator.visit(context);

        return codeBlock;
    }

    @Override
    public String visitAssignZExpr(@NotNull AtcalParser.AssignZExprContext ctx) {

        String codeBlock = "";
        if(ctx.ID() != null){
            codeBlock += ctx.ID().getText() + " = " + scope.getVar("scope").get().getValue().toString() + "\n";
        }else if(ctx.NUMBER() != null){
            codeBlock += "[" + ctx.NUMBER().getText() + "]" + " = " + scope.getVar("scope").get().getValue().toString() + "\n";
        }else {
            codeBlock += "[ ]" + " = " + scope.getVar("scope").get().getValue().toString() + "\n";
        }
        return codeBlock;
    }

    @Override
    public String visitRefineZExpr(@NotNull AtcalParser.RefineZExprContext ctx) {
        return visitLawRefinement(ctx.lawRefinement());
    }

    @Override
    public String visitAsWith(@NotNull AtcalParser.AsWithContext ctx) {
        return super.visitAsWith(ctx);
    }

    @Override
    public String visitAsEnum(@NotNull AtcalParser.AsEnumContext ctx) {
        return super.visitAsEnum(ctx);
    }
}
