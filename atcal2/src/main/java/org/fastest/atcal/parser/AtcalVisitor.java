// Generated from /home/cristian/workspace/fastest/atcal2/src/main/java/org/fastest/atcal/Atcal.g4 by ANTLR 4.5
package org.fastest.atcal.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AtcalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AtcalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AtcalParser#refinementRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefinementRule(@NotNull AtcalParser.RefinementRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#preamble}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreamble(@NotNull AtcalParser.PreambleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#plcode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlcode(@NotNull AtcalParser.PlcodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#preambleImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreambleImport(@NotNull AtcalParser.PreambleImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#datatypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatypes(@NotNull AtcalParser.DatatypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull AtcalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#aliasType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasType(@NotNull AtcalParser.AliasTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#recordType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(@NotNull AtcalParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull AtcalParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#contractType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractType(@NotNull AtcalParser.ContractTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(@NotNull AtcalParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#intType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull AtcalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#floatType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(@NotNull AtcalParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#stringType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull AtcalParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#typeCases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCases(@NotNull AtcalParser.TypeCasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#typeCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCase(@NotNull AtcalParser.TypeCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#laws}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaws(@NotNull AtcalParser.LawsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#uut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUut(@NotNull AtcalParser.UutContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#epilogue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpilogue(@NotNull AtcalParser.EpilogueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#law}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaw(@NotNull AtcalParser.LawContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#lawRefinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLawRefinement(@NotNull AtcalParser.LawRefinementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicRef(@NotNull AtcalParser.BasicRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnumRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumRef(@NotNull AtcalParser.EnumRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRef(@NotNull AtcalParser.WithRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ZExprRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDom}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDom(@NotNull AtcalParser.SetDomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDiff}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDiff(@NotNull AtcalParser.SetDiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetInter}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetInter(@NotNull AtcalParser.SetInterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProdProj}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdProj(@NotNull AtcalParser.ProdProjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull AtcalParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMod}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMod(@NotNull AtcalParser.NumModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetRan}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRan(@NotNull AtcalParser.SetRanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCons}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCons(@NotNull AtcalParser.SetConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCard}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCard(@NotNull AtcalParser.SetCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull AtcalParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiteral(@NotNull AtcalParser.StrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumDiv}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDiv(@NotNull AtcalParser.NumDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMinus}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMinus(@NotNull AtcalParser.NumMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMul}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMul(@NotNull AtcalParser.NumMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumPlus}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPlus(@NotNull AtcalParser.NumPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetElem}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElem(@NotNull AtcalParser.SetElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetProj}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetProj(@NotNull AtcalParser.SetProjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrConcat}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrConcat(@NotNull AtcalParser.StrConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProdCons}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdCons(@NotNull AtcalParser.ProdConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(@NotNull AtcalParser.NumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AutoExpr}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExpr(@NotNull AtcalParser.AutoExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetUnion}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetUnion(@NotNull AtcalParser.SetUnionContext ctx);
}