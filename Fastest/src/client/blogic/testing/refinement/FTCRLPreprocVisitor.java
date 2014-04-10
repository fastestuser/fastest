package client.blogic.testing.refinement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import client.blogic.testing.refinement.FTCRLParser.*;

/* Esto lo que hace es reemplazar el numero de la regla por la regla correspondiente ej:
 * a ==> .... l15
 * ...
 * l15: REGLA 
 * 
 * lo cambia por
 * 
 * a == ....REGLA
 * ...
 * l15: REGLA
 * ademas resuelve los linkeos entre reglas
 * 
 * @RRULE client3
 * @LAWS
 * client1.@LAWS
 * client2.l01 
 * 
 * @RRULE client1
 * @LAWS
 * l01:u1? ==> u1
 *
 * @RRULE client2
 * @LAWS
 * l01:client1.l01
 * */
public final class FTCRLPreprocVisitor extends FTCRLBaseVisitor<String> {

	private ParserRuleContext root;

	public FTCRLPreprocVisitor(RefinementRuleContext tree) {
		root = tree;
	}

	/*
	 * solamente puede haber estos punteros a synonimos en la regla refinement.
	 */
	public String visitRefinement(RefinementContext ctx) {
		IExprRefinementContext ctxIexprRefinementContext = ctx.iExprRefinement();
		if (ctx.sExprRefinement() == null
				&& ctxIexprRefinementContext.asRefinement() == null
				&& ctxIexprRefinementContext.asSynonym() == null) {
			String iname = ctxIexprRefinementContext.iName().getText();
			if (iname.contains(".") == false && iname.contains("[") == false) {
				FTCRLSynonymLawExtractor synonymLawExtractor = new FTCRLSynonymLawExtractor(iname);
				ParserRuleContext parserRuleContext = root.accept(synonymLawExtractor);
				if (parserRuleContext != null)
					return visitGenerico(parserRuleContext);
			}
		}
		return visitGenerico(ctx);
	}
/*
 * esto es para visitar los hijos de laws y buscar si hay un link
 * a otra regla*/
	public String visitLaws(LawsContext ctx){
		int tot = ctx.getChildCount();
		if (tot==0) return visitGenerico(ctx);
		StringBuilder s = new StringBuilder("@LAWS\n"); 
		ParseTree hijo;
		for (int i=0;i<tot;i++){
			hijo = ctx.getChild(i);
			if (hijo instanceof LawContext) 
				s.append(visitLaw((LawContext)hijo));
			else if (hijo instanceof ReferenceContext)
				s.append(visitReference((ReferenceContext)hijo));
			else if(hijo instanceof NameContext)//es un [name].@LAW
				s.append(visitALaw((NameContext)hijo));
		}
		return  s.toString();
	}

	public String visitReference(ReferenceContext ctx) {
		String lawname = ctx.lawName().getText();
		String ruleName = ctx.name().getText();
		RefinementRule rule = RefinementRules.getInstance().getRule(ruleName);
		RefinementRuleContext r = rule.getTree();
		LawsContext laws = r.laws();
		int tot = laws.getChildCount();
		if (tot == 0) return null;
		ParseTree hijo = null;
		for (int i=0;i<tot;i++){
			hijo = laws.getChild(i);
			if(hijo instanceof LawContext && ((LawContext) hijo).name().getText().equals(lawname))
				return ((LawContext) hijo).accept(this);
			}
		return null;
	}
	
	private String visitALaw(NameContext hijo) {
		RefinementRule rule = RefinementRules.getInstance().getRule(hijo.getText());
		return (rule.getTree().laws()).accept(this).replace("@LAWS\n","");
	}

	private String visitGenerico(ParseTree ctx) {
		int tot = ctx.getChildCount();
		if (tot == 0)
			return ctx.getText();
		StringBuilder s = new StringBuilder();
		ParseTree hijo;
		for (int i = 0; i < tot; i++) {
			hijo = ctx.getChild(i);
			if (hijo.getChildCount() == 0)
				s.append(visitGenerico(hijo));
			else
				s.append(hijo.accept(this));
		}
		return s.toString();
	}


	public String visitLaw(LawContext ctx) {
		return visitGenerico(ctx)  + "\n";
	}
	
	public String visitZExprSet(ZExprSetContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitSetExtension(SetExtensionContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitZExprSeq(ZExprSeqContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitZExprString(ZExprStringContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitFName(FNameContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitWithSynonym(WithSynonymContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitRefinementRule(RefinementRuleContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitFile(FileContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitName(NameContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitPreamble(PreambleContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitPath(PathContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitIExprRefinement(IExprRefinementContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitWithRefinement(WithRefinementContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitExprRefinement(ExprRefinementContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitIName(INameContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitDataStruct(DataStructContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitAsSynonym(AsSynonymContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitUut(UutContext ctx) {
		return visitGenerico(ctx);
	}


	public String visitSExprRefinement(SExprRefinementContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitSynonymLaw(SynonymLawContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitListType(ListTypeContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitNumber(NumberContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitList(ListContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitTable(TableContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitLawName(LawNameContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitReference2(Reference2Context ctx) {
		return visitGenerico(ctx);
	}

	public String visitDotSetOper(DotSetOperContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitPlcode(PlcodeContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitDigit(DigitContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitEpilogue(EpilogueContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitIIdent(IIdentContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitFunAppExpr(FunAppExprContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitAsRefinement(AsRefinementContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitString(StringContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitRefinementSentence(
			RefinementSentenceContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitZExpr(ZExprContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitEnumeration(EnumerationContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitZExprNum(ZExprNumContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitSName(SNameContext ctx) {
		return visitGenerico(ctx);
	}

	public String visitRefinementLaw(RefinementLawContext ctx) {
		return visitGenerico(ctx);
	}

}