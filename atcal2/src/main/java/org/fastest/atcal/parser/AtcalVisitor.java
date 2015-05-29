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
	 * Visit a parse tree produced by {@link AtcalParser#typeDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDec(@NotNull AtcalParser.TypeDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameType(@NotNull AtcalParser.NameTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull AtcalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(@NotNull AtcalParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull AtcalParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull AtcalParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnumType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(@NotNull AtcalParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecordType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(@NotNull AtcalParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContractType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractType(@NotNull AtcalParser.ContractTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull AtcalParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#constMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstMapping(@NotNull AtcalParser.ConstMappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#constMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstMap(@NotNull AtcalParser.ConstMapContext ctx);
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
	 * Visit a parse tree produced by the {@code ImplRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplRef(@NotNull AtcalParser.ImplRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ZExprRef}
	 * labeled alternative in {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZExprRef(@NotNull AtcalParser.ZExprRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLValue(@NotNull AtcalParser.VarLValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLValue(@NotNull AtcalParser.ArrayLValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldLValue(@NotNull AtcalParser.FieldLValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleRef}
	 * labeled alternative in {@link AtcalParser#asRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleRef(@NotNull AtcalParser.SimpleRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BijMapRef}
	 * labeled alternative in {@link AtcalParser#asRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBijMapRef(@NotNull AtcalParser.BijMapRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithRef}
	 * labeled alternative in {@link AtcalParser#asRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRef(@NotNull AtcalParser.WithRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull AtcalParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMod}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMod(@NotNull AtcalParser.NumModContext ctx);
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
	 * Visit a parse tree produced by the {@code NumMul}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMul(@NotNull AtcalParser.NumMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDiff}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDiff(@NotNull AtcalParser.SetDiffContext ctx);
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
	 * Visit a parse tree produced by the {@code SetUnion}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetUnion(@NotNull AtcalParser.SetUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDom}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDom(@NotNull AtcalParser.SetDomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemExpr}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExpr(@NotNull AtcalParser.ElemExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(@NotNull AtcalParser.NumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMinus}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMinus(@NotNull AtcalParser.NumMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiteral(@NotNull AtcalParser.StrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AutoExpr}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExpr(@NotNull AtcalParser.AutoExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCons}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCons(@NotNull AtcalParser.SetConsContext ctx);
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
	 * Visit a parse tree produced by the {@code SetCard}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCard(@NotNull AtcalParser.SetCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumDiv}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDiv(@NotNull AtcalParser.NumDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetProj}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetProj(@NotNull AtcalParser.SetProjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetRan}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRan(@NotNull AtcalParser.SetRanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetInter}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetInter(@NotNull AtcalParser.SetInterContext ctx);
}