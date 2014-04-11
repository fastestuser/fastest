package client.blogic.testing.refinement.tcrlrules;

import org.antlr.v4.runtime.ParserRuleContext;

import client.blogic.testing.refinement.FTCRLBaseVisitor;
import client.blogic.testing.refinement.FTCRLParser;
import client.blogic.testing.refinement.FTCRLParser.SynonymLawContext;
import client.blogic.testing.refinement.FTCRLParser.WithRefinementContext;

/* dado un arbol y un nombre de synonimo en String, te devuelve el 
 * WithRefinement de WithSynonym de SynonymLaws. Se usa en PrePrcoVisitor. 
 * */
public final class FTCRLSynonymLawExtractor extends FTCRLBaseVisitor<ParserRuleContext>{

	private String iname;
	public FTCRLSynonymLawExtractor(String iname){
		this.iname = iname;
	}
	public WithRefinementContext visitSynonymLaw(SynonymLawContext ctx){
		if (ctx.name().getText().equals(iname)) 
			return ctx.withSynonym().withRefinement();
		return null;
	}

	private ParserRuleContext visitGenerico(ParserRuleContext ctx){
		int tot = ctx.getChildCount();
		if (tot == 0 ) return null; 
		ParserRuleContext parserRuleContext = null;
		for (int i=0;i<tot;i++){
			parserRuleContext = ctx.getChild(i).accept(this);
			if ( parserRuleContext != null)
				return parserRuleContext;
		}
		return parserRuleContext;
	}

	public ParserRuleContext visitRefinement(FTCRLParser.RefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitZExprSet(FTCRLParser.ZExprSetContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitSetExtension(FTCRLParser.SetExtensionContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitZExprSeq(FTCRLParser.ZExprSeqContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitZExprString(FTCRLParser.ZExprStringContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitFName(FTCRLParser.FNameContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitReference2(FTCRLParser.Reference2Context ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitWithSynonym(FTCRLParser.WithSynonymContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitRefinementRule(FTCRLParser.RefinementRuleContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitFile(FTCRLParser.FileContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitName(FTCRLParser.NameContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitPreamble(FTCRLParser.PreambleContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitPath(FTCRLParser.PathContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitLaws(FTCRLParser.LawsContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitWithRefinement(FTCRLParser.WithRefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitExprRefinement(FTCRLParser.ExprRefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitIName(FTCRLParser.INameContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitDataStruct(FTCRLParser.DataStructContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitAsSynonym(FTCRLParser.AsSynonymContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitUut(FTCRLParser.UutContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitLaw(FTCRLParser.LawContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitSExprRefinement(FTCRLParser.SExprRefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitListType(FTCRLParser.ListTypeContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitNumber(FTCRLParser.NumberContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitList(FTCRLParser.ListContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitTable(FTCRLParser.TableContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitLawName(FTCRLParser.LawNameContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitReference(FTCRLParser.ReferenceContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitDotSetOper(FTCRLParser.DotSetOperContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitPlcode(FTCRLParser.PlcodeContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitDigit(FTCRLParser.DigitContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitEpilogue(FTCRLParser.EpilogueContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitIIdent(FTCRLParser.IIdentContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitFunAppExpr(FTCRLParser.FunAppExprContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitAsRefinement(FTCRLParser.AsRefinementContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitString(FTCRLParser.StringContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitRefinementSentence(FTCRLParser.RefinementSentenceContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitZExpr(FTCRLParser.ZExprContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitEnumeration(FTCRLParser.EnumerationContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitZExprNum(FTCRLParser.ZExprNumContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitSName(FTCRLParser.SNameContext ctx) { return visitGenerico(ctx); }

	public ParserRuleContext visitRefinementLaw(FTCRLParser.RefinementLawContext ctx) { return visitGenerico(ctx); }

}
