// Generated from FTCRL.g4 by ANTLR 4.0

package client.blogic.testing.refinement;

import org.antlr.v4.runtime.tree.*;

public interface FTCRLVisitor<T> extends ParseTreeVisitor<T> {
	T visitRefinement(FTCRLParser.RefinementContext ctx);

	T visitZExprSet(FTCRLParser.ZExprSetContext ctx);

	T visitSetExtension(FTCRLParser.SetExtensionContext ctx);

	T visitZExprSeq(FTCRLParser.ZExprSeqContext ctx);

	T visitZExprString(FTCRLParser.ZExprStringContext ctx);

	T visitFName(FTCRLParser.FNameContext ctx);

	T visitReference2(FTCRLParser.Reference2Context ctx);

	T visitWithSynonym(FTCRLParser.WithSynonymContext ctx);

	T visitRefinementRule(FTCRLParser.RefinementRuleContext ctx);

	T visitFile(FTCRLParser.FileContext ctx);

	T visitName(FTCRLParser.NameContext ctx);

	T visitPreamble(FTCRLParser.PreambleContext ctx);

	T visitPath(FTCRLParser.PathContext ctx);

	T visitLaws(FTCRLParser.LawsContext ctx);

	T visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx);

	T visitWithRefinement(FTCRLParser.WithRefinementContext ctx);

	T visitExprRefinement(FTCRLParser.ExprRefinementContext ctx);

	T visitIName(FTCRLParser.INameContext ctx);

	T visitDataStruct(FTCRLParser.DataStructContext ctx);

	T visitAsSynonym(FTCRLParser.AsSynonymContext ctx);

	T visitUut(FTCRLParser.UutContext ctx);

	T visitLaw(FTCRLParser.LawContext ctx);

	T visitSExprRefinement(FTCRLParser.SExprRefinementContext ctx);

	T visitSynonymLaw(FTCRLParser.SynonymLawContext ctx);

	T visitListType(FTCRLParser.ListTypeContext ctx);

	T visitNumber(FTCRLParser.NumberContext ctx);

	T visitList(FTCRLParser.ListContext ctx);

	T visitTable(FTCRLParser.TableContext ctx);

	T visitLawName(FTCRLParser.LawNameContext ctx);

	T visitReference(FTCRLParser.ReferenceContext ctx);

	T visitDotSetOper(FTCRLParser.DotSetOperContext ctx);

	T visitPlcode(FTCRLParser.PlcodeContext ctx);

	T visitDigit(FTCRLParser.DigitContext ctx);

	T visitEpilogue(FTCRLParser.EpilogueContext ctx);

	T visitIIdent(FTCRLParser.IIdentContext ctx);

	T visitFunAppExpr(FTCRLParser.FunAppExprContext ctx);

	T visitAsRefinement(FTCRLParser.AsRefinementContext ctx);

	T visitString(FTCRLParser.StringContext ctx);

	T visitRefinementSentence(FTCRLParser.RefinementSentenceContext ctx);

	T visitZExpr(FTCRLParser.ZExprContext ctx);

	T visitEnumeration(FTCRLParser.EnumerationContext ctx);

	T visitZExprNum(FTCRLParser.ZExprNumContext ctx);

	T visitSName(FTCRLParser.SNameContext ctx);

	T visitRefinementLaw(FTCRLParser.RefinementLawContext ctx);
}