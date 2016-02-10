// Generated from /home/cristian/workspace/fastest/src/main/java/client/blogic/testing/atcal/Atcal.g4 by ANTLR 4.5.1
package client.blogic.testing.atcal.parser;
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
	T visitRefinementRule(AtcalParser.RefinementRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#preamble}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreamble(AtcalParser.PreambleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#datatypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatypes(AtcalParser.DatatypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#typeDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDec(AtcalParser.TypeDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameType(AtcalParser.NameTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(AtcalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(AtcalParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(AtcalParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(AtcalParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnumType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(AtcalParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecordType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(AtcalParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContractType}
	 * labeled alternative in {@link AtcalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractType(AtcalParser.ContractTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(AtcalParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#constMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstMapping(AtcalParser.ConstMappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#constMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstMap(AtcalParser.ConstMapContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#laws}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaws(AtcalParser.LawsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UUTNoRetVal}
	 * labeled alternative in {@link AtcalParser#uut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUUTNoRetVal(AtcalParser.UUTNoRetValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UUTRetVal}
	 * labeled alternative in {@link AtcalParser#uut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUUTRetVal(AtcalParser.UUTRetValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#epilogue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpilogue(AtcalParser.EpilogueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#law}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaw(AtcalParser.LawContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#biRefLaw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBiRefLaw(AtcalParser.BiRefLawContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#lawRefinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLawRefinement(AtcalParser.LawRefinementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#zExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZExprs(AtcalParser.ZExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefinement(AtcalParser.RefinementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLValue(AtcalParser.VarLValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLValue(AtcalParser.ArrayLValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldLValue}
	 * labeled alternative in {@link AtcalParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldLValue(AtcalParser.FieldLValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AtcalParser#withRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRef(AtcalParser.WithRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(AtcalParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMod}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMod(AtcalParser.NumModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProdProj}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdProj(AtcalParser.ProdProjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(AtcalParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMul}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMul(AtcalParser.NumMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDiff}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDiff(AtcalParser.SetDiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrConcat}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrConcat(AtcalParser.StrConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProdCons}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdCons(AtcalParser.ProdConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetUnion}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetUnion(AtcalParser.SetUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetDom}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDom(AtcalParser.SetDomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemExpr}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExpr(AtcalParser.ElemExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(AtcalParser.NumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumMinus}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumMinus(AtcalParser.NumMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrLiteral}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiteral(AtcalParser.StrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AutoExpr}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExpr(AtcalParser.AutoExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCons}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCons(AtcalParser.SetConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumPlus}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPlus(AtcalParser.NumPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetElem}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElem(AtcalParser.SetElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCard}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCard(AtcalParser.SetCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumDiv}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDiv(AtcalParser.NumDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetProj}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetProj(AtcalParser.SetProjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetRan}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRan(AtcalParser.SetRanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetInter}
	 * labeled alternative in {@link AtcalParser#zExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetInter(AtcalParser.SetInterContext ctx);
}