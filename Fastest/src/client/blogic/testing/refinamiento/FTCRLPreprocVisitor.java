package client.blogic.testing.refinamiento;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import client.blogic.testing.refinamiento.FTCRLParser.IExprRefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementRuleContext;

public final class FTCRLPreprocVisitor extends FTCRLBaseVisitor<String>{

	private ParserRuleContext root;
	public FTCRLPreprocVisitor(RefinementRuleContext tree){
		root = tree;
	}

/* solamente puede haber estos punteros a synonimos en la regla refinement.
 * */
	public String visitRefinement(RefinementContext ctx){
		IExprRefinementContext ctxIexprRefinementContext = ctx.iExprRefinement();
		if (ctx.sExprRefinement() == null && ctxIexprRefinementContext.asRefinement() == null && ctxIexprRefinementContext.asSynonym() == null){
			String iname = ctxIexprRefinementContext.iName().getText();
			if ( iname.contains(".")==false && iname.contains("[")==false){
				FTCRLSynonymLawExtractor synonymLawExtractor = new FTCRLSynonymLawExtractor(iname);
				ParserRuleContext parserRuleContext = root.accept(synonymLawExtractor);
				if (parserRuleContext!=null)
					return visitGenerico(parserRuleContext);
			}
		}
		return visitGenerico(ctx);
	}

	private String visitGenerico(ParseTree ctx){
		int tot = ctx.getChildCount();
		if (tot==0) return ctx.getText(); 
		StringBuilder s = new StringBuilder(); 
		ParseTree hijo;
		for (int i=0;i<tot;i++){
			hijo = ctx.getChild(i);
			if (hijo.getChildCount()==0) 
				s.append(visitGenerico(hijo));
			else 
				s.append(hijo.accept(this));
		}
		return s.toString();
	}

	public String visitZExprSet(FTCRLParser.ZExprSetContext ctx) { return visitGenerico(ctx); }

	public String visitSetExtension(FTCRLParser.SetExtensionContext ctx) { return visitGenerico(ctx); }

	public String visitZExprSeq(FTCRLParser.ZExprSeqContext ctx) { return visitGenerico(ctx); }

	public String visitZExprString(FTCRLParser.ZExprStringContext ctx) { return visitGenerico(ctx); }

	public String visitFName(FTCRLParser.FNameContext ctx) { return visitGenerico(ctx); }

	public String visitReference2(FTCRLParser.Reference2Context ctx) { return visitGenerico(ctx); }

	public String visitWithSynonym(FTCRLParser.WithSynonymContext ctx) { return visitGenerico(ctx); }

	public String visitRefinementRule(FTCRLParser.RefinementRuleContext ctx) { return visitGenerico(ctx); }

	public String visitFile(FTCRLParser.FileContext ctx) { return visitGenerico(ctx); }

	public String visitName(FTCRLParser.NameContext ctx) { return visitGenerico(ctx); }

	public String visitPreamble(FTCRLParser.PreambleContext ctx) { return visitGenerico(ctx); }

	public String visitPath(FTCRLParser.PathContext ctx) { return visitGenerico(ctx); }

	public String visitLaws(FTCRLParser.LawsContext ctx) { return visitGenerico(ctx); }

	public String visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx) { return visitGenerico(ctx); }

	public String visitWithRefinement(FTCRLParser.WithRefinementContext ctx) { return visitGenerico(ctx); }

	public String visitExprRefinement(FTCRLParser.ExprRefinementContext ctx) { return visitGenerico(ctx); }

	public String visitIName(FTCRLParser.INameContext ctx) { return visitGenerico(ctx); }

	public String visitDataStruct(FTCRLParser.DataStructContext ctx) { return visitGenerico(ctx); }

	public String visitAsSynonym(FTCRLParser.AsSynonymContext ctx) { return visitGenerico(ctx); }

	public String visitUut(FTCRLParser.UutContext ctx) { return visitGenerico(ctx); }

	public String visitLaw(FTCRLParser.LawContext ctx) { return visitGenerico(ctx); }

	public String visitSExprRefinement(FTCRLParser.SExprRefinementContext ctx) { return visitGenerico(ctx); }

	public String visitSynonymLaw(FTCRLParser.SynonymLawContext ctx) { return visitGenerico(ctx); }

	public String visitListType(FTCRLParser.ListTypeContext ctx) { return visitGenerico(ctx); }

	public String visitNumber(FTCRLParser.NumberContext ctx) { return visitGenerico(ctx); }

	public String visitList(FTCRLParser.ListContext ctx) { return visitGenerico(ctx); }

	public String visitTable(FTCRLParser.TableContext ctx) { return visitGenerico(ctx); }

	public String visitLawName(FTCRLParser.LawNameContext ctx) { return visitGenerico(ctx); }

	public String visitReference(FTCRLParser.ReferenceContext ctx) { return visitGenerico(ctx); }

	public String visitDotSetOper(FTCRLParser.DotSetOperContext ctx) { return visitGenerico(ctx); }

	public String visitPlcode(FTCRLParser.PlcodeContext ctx) { return visitGenerico(ctx); }

	public String visitDigit(FTCRLParser.DigitContext ctx) { return visitGenerico(ctx); }

	public String visitEpilogue(FTCRLParser.EpilogueContext ctx) { return visitGenerico(ctx); }

	public String visitIIdent(FTCRLParser.IIdentContext ctx) { return visitGenerico(ctx); }

	public String visitFunAppExpr(FTCRLParser.FunAppExprContext ctx) { return visitGenerico(ctx); }

	public String visitAsRefinement(FTCRLParser.AsRefinementContext ctx) { return visitGenerico(ctx); }

	public String visitString(FTCRLParser.StringContext ctx) { return visitGenerico(ctx); }

	public String visitRefinementSentence(FTCRLParser.RefinementSentenceContext ctx) { return visitGenerico(ctx); }

	public String visitZExpr(FTCRLParser.ZExprContext ctx) { return visitGenerico(ctx); }

	public String visitEnumeration(FTCRLParser.EnumerationContext ctx) { return visitGenerico(ctx); }

	public String visitZExprNum(FTCRLParser.ZExprNumContext ctx) { return visitGenerico(ctx); }

	public String visitSName(FTCRLParser.SNameContext ctx) { return visitGenerico(ctx); }

	public String visitRefinementLaw(FTCRLParser.RefinementLawContext ctx) { return visitGenerico(ctx);}

}