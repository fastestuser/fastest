// Generated from FTCRL.g4 by ANTLR 4.0

package client.blogic.testing.refinamiento;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface FTCRLVisitor<T> extends ParseTreeVisitor<T> {
	T visitRefinement(FTCRLParser.RefinementContext ctx);

	T visitZExprSet(FTCRLParser.ZExprSetContext ctx);

	T visitSetExtension(FTCRLParser.SetExtensionContext ctx);

	T visitPLCode(FTCRLParser.PLCodeContext ctx);

	T visitZExprSeq(FTCRLParser.ZExprSeqContext ctx);

	T visitIType(FTCRLParser.ITypeContext ctx);

	T visitZExprString(FTCRLParser.ZExprStringContext ctx);

	T visitFName(FTCRLParser.FNameContext ctx);

	T visitReference2(FTCRLParser.Reference2Context ctx);

	T visitWithSynonym(FTCRLParser.WithSynonymContext ctx);

	T visitFile(FTCRLParser.FileContext ctx);

	T visitName(FTCRLParser.NameContext ctx);

	T visitPreamble(FTCRLParser.PreambleContext ctx);

	T visitPath(FTCRLParser.PathContext ctx);

	T visitMap(FTCRLParser.MapContext ctx);

	T visitLaws(FTCRLParser.LawsContext ctx);

	T visitWithRefinement(FTCRLParser.WithRefinementContext ctx);

	T visitExprRefinement(FTCRLParser.ExprRefinementContext ctx);

	T visitLawSynonym(FTCRLParser.LawSynonymContext ctx);

	T visitIName(FTCRLParser.INameContext ctx);

	T visitDataStruct(FTCRLParser.DataStructContext ctx);

	T visitAsSynonym(FTCRLParser.AsSynonymContext ctx);

	T visitUut(FTCRLParser.UutContext ctx);

	T visitLaw(FTCRLParser.LawContext ctx);

	T visitListType(FTCRLParser.ListTypeContext ctx);

	T visitNumber(FTCRLParser.NumberContext ctx);

	T visitList(FTCRLParser.ListContext ctx);

	T visitLawRefinement(FTCRLParser.LawRefinementContext ctx);

	T visitTable(FTCRLParser.TableContext ctx);

	T visitLawName(FTCRLParser.LawNameContext ctx);

	T visitReference(FTCRLParser.ReferenceContext ctx);

	T visitPlcode(FTCRLParser.PlcodeContext ctx);

	T visitDotSetOper(FTCRLParser.DotSetOperContext ctx);

	T visitEpilogue(FTCRLParser.EpilogueContext ctx);

	T visitIIdent(FTCRLParser.IIdentContext ctx);

	T visitAnychar(FTCRLParser.AnycharContext ctx);

	T visitAsRefinement(FTCRLParser.AsRefinementContext ctx);

	T visitString(FTCRLParser.StringContext ctx);

	T visitZExpr(FTCRLParser.ZExprContext ctx);

	T visitEnumeration(FTCRLParser.EnumerationContext ctx);

	T visitZExprNum(FTCRLParser.ZExprNumContext ctx);

	T visitSName(FTCRLParser.SNameContext ctx);

	T visitRefinementLaw(FTCRLParser.RefinementLawContext ctx);
}