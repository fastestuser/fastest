package nlg.pipeline.microplanner;

import java.util.ArrayList;
import java.util.List;

import nlg.base.designation.DesignationRepo;
import nlg.base.designation.DesignationUtils;
import nlg.base.expression.ExprApply;
import nlg.base.expression.ExprDom;
import nlg.base.expression.ExprEq;
import nlg.base.expression.ExprIn;
import nlg.base.expression.ExprIntersection;
import nlg.base.expression.ExprMapsTo;
import nlg.base.expression.ExprNot;
import nlg.base.expression.ExprNotEq;
import nlg.base.expression.ExprNotIn;
import nlg.base.expression.ExprRan;
import nlg.base.expression.ExprRef;
import nlg.base.expression.ExprSet;
import nlg.base.expression.ExprSubSet;
import nlg.base.expression.ExprSubSetEq;
import nlg.base.expression.ExprUnion;
import nlg.base.expression.ExprZ;
import nlg.base.expression.ExprZVisitor;
import nlg.base.expression.matching.MatchUtils;
import nlg.base.linguistic.CategoriaGramatical;
import nlg.base.linguistic.InfoMorfologica;
import nlg.base.textSpecification.PSFraseNominal;
import nlg.base.textSpecification.PSTextoEnlatado;
import nlg.base.textSpecification.PhraseSpec;
import nlg.util.FreeLingAnalyzer;
import nlg.util.FreeLingUtils;
import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.Word;

public class PhraseSpecBuilder {
	
	private DesignationRepo desigRepo;
	
	public PhraseSpecBuilder(DesignationRepo desigRepo) {
		this.desigRepo = desigRepo;
	}
	
	/**
	 * Construye phrase specification a partir de ExprZ
	 * Aca deberian implementar las "reglas de traduccion" definidas
	 */
	public PhraseSpec buildExprZ(ExprZ expr, String schName) {
		PhraseSpec ret;
		
		if (DesignationUtils.isDesignated(expr, schName, desigRepo)) {
			// expresion designada
			ret = buildDesignation(DesignationUtils.applyDesignation(expr, schName, desigRepo));
			
		} else {
			// expresion no designada
			// construyo phrase specification segun reglas
			ExprZToPSVisitor visitor = new ExprZToPSVisitor(this, schName);
			
			ret = expr.accept(visitor);
		}
		
		return ret;
	}
	
	/**
	 * Intenta parsear texto de designacion.
	 * Se espera una frase nominal del tipo
	 *    [articulo] nucleo [complemento]
	 * De no poder hacerlo devolvera un elemento
	 * de tipo "texto enlatado" con la designacion dada.
	 */
	private PhraseSpec buildDesignation(String texto) {
		PhraseSpec ret;
		
		Sentence s = new FreeLingAnalyzer().analyze(texto);
		
		if (null == s) {
			ret = new PSTextoEnlatado(texto);
			
		} else {
		
			// Proceso el resultado del analisis e intento 
			// construir una PhraseSpecification
			ListWordIterator wIt = new ListWordIterator(s);
			
			if (wIt.hasNext()) {
				Word w1 = wIt.next();
				InfoMorfologica info = FreeLingUtils.getInfoMorfologica(w1.getTag());
	
				// TODO mover esto de aca, sería mas apropiado que este dentro de la parte de realización linguistica
				if (null != info.getCatGramatical() && info.getCatGramatical().equals(CategoriaGramatical.ARTICULO)) {
					// primer palabra: articulo
					// verifico si la seguna palabra es un nombre
					if (wIt.hasNext()) {
						Word w2 = wIt.next();
						InfoMorfologica info2 = FreeLingUtils.getInfoMorfologica(w2.getTag());
						
						if (null != info2.getCatGramatical() && info2.getCatGramatical().equals(CategoriaGramatical.NOMBRE)) {
							// nombre propio o sustantivo
							// construyo frase sustantival
							PSFraseNominal fn = new PSFraseNominal();
							fn.setNucleo(w2.getForm());
							fn.setInfoNucleo(info2);
							
							String comp = "";
							while (wIt.hasNext()) {
								String tmp = wIt.next().getForm();
								if (tmp.equals(".")) break;
								comp = comp + " " + tmp;
							}
							
							fn.setComplemento(new PSTextoEnlatado(comp.trim()));
							
							ret = fn;
							
						} else {
							// se esperaba el nucleo
							// devuelvo texto enlatado
							ret = new PSTextoEnlatado(texto);
						}
						
					} else {
						// se esperaba el nucleo
						// devuelvo texto enlatado
						ret = new PSTextoEnlatado(texto);
					}
					
					
				} else if (null != info.getCatGramatical() && info.getCatGramatical().equals(CategoriaGramatical.NOMBRE)) {
					// primer palabra: nombre
					// construyo frase sustantival
					PSFraseNominal fn = new PSFraseNominal();
					fn.setNucleo(w1.getForm());
					
					// analizo informacion morfolofica nucleo
					InfoMorfologica im = FreeLingUtils.getInfoMorfologica(w1.getTag());
					fn.setInfoNucleo(im);
					
					String comp = "";
					while (wIt.hasNext()) {
						String tmp = wIt.next().getForm();
						if (tmp.equals(".")) break;
						comp = comp + " " + tmp;
					}
					
					fn.setComplemento(new PSTextoEnlatado(comp.trim()));
					
					ret = fn;
					
				} else {
					// la primer palabra no es articulo ni nombre
					// devuelvo texto enlatado
					ret = new PSTextoEnlatado(texto);
				}
	
			} else {
				// wIt no tiene elementos. podria darse este caso ?
				ret = new PSTextoEnlatado(texto);
				
			}
		} 
		
		return ret;
	}
	
	public PhraseSpec buildIntroduction(String tClassName, String opDescription) {
		return new PSTextoEnlatado(tClassName + ": " + opDescription);
	}
	
	////////////////
	/**
	 * Aca se implementan las reglas de traduccion 
	 * de exresiones Z a lenguaje natural
	 *
	 */
	private class ExprZToPSVisitor implements ExprZVisitor<PhraseSpec> {

		private PhraseSpecBuilder psBuilder;
		private PhraseSpecFactory psFactory;
		private String schName;
		
		public ExprZToPSVisitor(PhraseSpecBuilder psBuilder, String schName) {
			this.psBuilder = psBuilder;
			this.schName = schName;
			this.psFactory = new PhraseSpecFactory();
		}
		
		@Override
		public PhraseSpec visitExprApply(ExprApply expr) {
			PhraseSpec psFun = psBuilder.buildExprZ(expr.getFunction(), schName);
			PhraseSpec psArg = psBuilder.buildExprZ(expr.getArgument(), schName);
			
			return psFactory.createPSApply(psFun, psArg);
		}

		@Override
		public PhraseSpec visitExprDom(ExprDom expr) {
			PhraseSpec psFun = psBuilder.buildExprZ(expr.getFunction(), schName);
			
			return psFactory.createPSDom(psFun);
		}

		@Override
		public PhraseSpec visitExprEq(ExprEq expr) {
			PhraseSpec ret;
			
			ExprZ left = expr.getLeftExpr();
			ExprZ right = expr.getRightExpr();
			
			
			if (MatchUtils.matchSingleton(left)) {
			// {exp1} = exp2
				ExprZ elem = ((ExprSet) left).getElements().get(0);
				
				PhraseSpec psElem = psBuilder.buildExprZ(elem, schName);
				PhraseSpec psSet = psBuilder.buildExprZ(right, schName);
				
				ret = psFactory.createPSElemUnico(psElem, psSet);
				
			} else if (MatchUtils.matchSingleton(right)) {
			// exp1 = {exp2}
				ExprZ elem = ((ExprSet) right).getElements().get(0);
				
				PhraseSpec psSet = psBuilder.buildExprZ(left, schName);
				PhraseSpec psElem = psBuilder.buildExprZ(elem, schName);
				
				ret = psFactory.createPSElemUnico(psElem, psSet);
				
			} else if (MatchUtils.matchIntersectionSingleton1(left) && MatchUtils.matchEmptySet(right)) {
			// {x} ∩ exp2 = {}
				ExprZ x = ((ExprSet) ((ExprIntersection) left).getLeftSet()).getElements().get(0);
				ExprZ exp2 = ((ExprIntersection) left).getRightSet();
				
				PhraseSpec psElem = psBuilder.buildExprZ(x, schName);
				PhraseSpec psSet = psBuilder.buildExprZ(exp2, schName);
				
				ret = psFactory.createPSElemNoPertenece(psElem, psSet);
				
			} else if (MatchUtils.matchIntersectionSingleton2(left) && MatchUtils.matchEmptySet(right)) {
			// exp2 ∩ {x} = {}
				ExprZ x = ((ExprSet) ((ExprIntersection) left).getRightSet()).getElements().get(0);
				ExprZ exp2 = ((ExprIntersection) left).getLeftSet();
				
				PhraseSpec psElem = psBuilder.buildExprZ(x, schName);
				PhraseSpec psSet = psBuilder.buildExprZ(exp2, schName);
				
				ret = psFactory.createPSElemNoPertenece(psElem, psSet);
				
			} else if (MatchUtils.matchEmptySet(left) && MatchUtils.matchIntersectionSingleton1(right)) {
			// {} = {x} ∩ exp2 
				ExprZ x = ((ExprSet) ((ExprIntersection) right).getLeftSet()).getElements().get(0);
				ExprZ exp2 = ((ExprIntersection) right).getRightSet();
				
				PhraseSpec psElem = psBuilder.buildExprZ(x, schName);
				PhraseSpec psSet = psBuilder.buildExprZ(exp2, schName);
				
				ret = psFactory.createPSElemNoPertenece(psElem, psSet);
				
			} else if (MatchUtils.matchEmptySet(left) && MatchUtils.matchIntersectionSingleton2(right)) {
			// {} = exp2 ∩ {x}
				ExprZ x = ((ExprSet) ((ExprIntersection) right).getRightSet()).getElements().get(0);
				ExprZ exp2 = ((ExprIntersection) right).getLeftSet();
				
				PhraseSpec psElem = psBuilder.buildExprZ(x, schName);
				PhraseSpec psSet = psBuilder.buildExprZ(exp2, schName);
				
				ret = psFactory.createPSElemNoPertenece(psElem, psSet);
				
			} else if (MatchUtils.matchIntersection(left) && MatchUtils.matchEmptySet(right)) {
			// exp1 ∩ exp2 = {}
				PhraseSpec psSet1 = psBuilder.buildExprZ(((ExprIntersection) left).getLeftSet(), schName);
				PhraseSpec psSet2 = psBuilder.buildExprZ(((ExprIntersection) left).getRightSet(), schName);
				
				ret = psFactory.createPSNoElemCom(psSet1, psSet2);
			
			} else if (MatchUtils.matchEmptySet(left) && MatchUtils.matchIntersection(right)) {
			// {} = exp1 ∩ exp2
				PhraseSpec psSet1 = psBuilder.buildExprZ(((ExprIntersection) right).getLeftSet(), schName);
				PhraseSpec psSet2 = psBuilder.buildExprZ(((ExprIntersection) right).getRightSet(), schName);
				
				ret = psFactory.createPSNoElemCom(psSet1, psSet2);
				
			} else if (MatchUtils.matchEmptySet(right)) {
			// exp1 = {}
				PhraseSpec psSet1 = psBuilder.buildExprZ(left, schName);
				ret = psFactory.createPSNoHayElem(psSet1);
				
			} else if (MatchUtils.matchEmptySet(left)) {
			// {} = exp2
				PhraseSpec psSet2 = psBuilder.buildExprZ(right, schName);
				ret = psFactory.createPSNoHayElem(psSet2);
				
			} else {
			// exp1 = exp2
				PhraseSpec psExp1 = psBuilder.buildExprZ(left, schName);
				PhraseSpec psExp2 = psBuilder.buildExprZ(right, schName);
				
				ret = psFactory.createPSEsIgual(psExp1, psExp2);
			}
			
			return ret;
		}

		@Override
		public PhraseSpec visitExprIn(ExprIn expr) {
			PhraseSpec psElem = psBuilder.buildExprZ(expr.getElement(), schName);
			PhraseSpec psSet = psBuilder.buildExprZ(expr.getSet(), schName);
			
			return psFactory.createPSElemPertenece(psElem, psSet);
		}

		@Override
		public PhraseSpec visitExprIntersection(ExprIntersection expr) {
			PhraseSpec psSet1 = psBuilder.buildExprZ(expr.getLeftSet(), schName);
			PhraseSpec psSet2 = psBuilder.buildExprZ(expr.getRightSet(), schName);
			
			return psFactory.createPSElemEnYTambienEn(psSet1, psSet2);
		}

		@Override
		public PhraseSpec visitExprMapsTo(ExprMapsTo expr) {
			PhraseSpec ps1 = psBuilder.buildExprZ(expr.getLeft(), schName);
			PhraseSpec ps2 = psBuilder.buildExprZ(expr.getRight(), schName);
			
			return psFactory.createPSElemEnYTambienEn(ps1, ps2);
		}

		@Override
		public PhraseSpec visitExprRefExpr(ExprRef expr) {
			return new PSTextoEnlatado(expr.getName());
		}

		@Override
		public PhraseSpec visitExprNotEq(ExprNotEq expr) {
			PhraseSpec ret;
			
			ExprZ left = expr.getLeftExpr();
			ExprZ right = expr.getRightExpr();
			
			if (MatchUtils.matchIntersection(left) && MatchUtils.matchEmptySet(right)) {
				// exp1 ∩ exp2 != {}
				PhraseSpec ps1 = psBuilder.buildExprZ(((ExprIntersection) left).getLeftSet(), schName);
				PhraseSpec ps2 = psBuilder.buildExprZ(((ExprIntersection) left).getRightSet(), schName);
				ret = psFactory.createPSElemCom(ps1, ps2);
				
			} else if (MatchUtils.matchIntersection(right) && MatchUtils.matchEmptySet(left)) {
				// {} != exp1 ∩ exp2
				PhraseSpec ps1 = psBuilder.buildExprZ(((ExprIntersection) right).getLeftSet(), schName);
				PhraseSpec ps2 = psBuilder.buildExprZ(((ExprIntersection) right).getRightSet(), schName);
				ret = psFactory.createPSElemCom(ps1, ps2);
				
			} else if (MatchUtils.matchEmptySet(right)) {
				// exp1 != {}
				PhraseSpec ps1 = psBuilder.buildExprZ(left, schName);
				ret = psFactory.createPSHayElem(ps1);
				
			} else if (MatchUtils.matchEmptySet(left)) {
				// {} != exp2
				PhraseSpec ps1 = psBuilder.buildExprZ(right, schName);
				ret = psFactory.createPSHayElem(ps1);
				
			} else {
				// exp1 != exp2
				PhraseSpec ps1 = psBuilder.buildExprZ(left, schName);
				PhraseSpec ps2 = psBuilder.buildExprZ(right, schName);
				ret = psFactory.createPSNoEsIgual(ps1, ps2);
			}
			
			return ret;
		}

		@Override
		public PhraseSpec visitExprNotIn(ExprNotIn expr) {
			PhraseSpec psElem = psBuilder.buildExprZ(expr.getElement(), schName);
			PhraseSpec psSet = psBuilder.buildExprZ(expr.getSet(), schName);
			
			return psFactory.createPSElemNoPertenece(psElem, psSet);
		}

		@Override
		public PhraseSpec visitExprRan(ExprRan expr) {
			PhraseSpec psFun = psBuilder.buildExprZ(expr.getFunction(), schName);
			
			return psFactory.createPSRan(psFun);
		}

		@Override
		public PhraseSpec visitExprSet(ExprSet expr) {
			PhraseSpec ret;
			
			if (MatchUtils.matchEmptySet(expr)) {
				ret = psFactory.createPSConjVacio();
				
			} else {
				List<PhraseSpec> elems = new ArrayList<PhraseSpec>();
				for (ExprZ exp : expr.getElements()) {
					elems.add(buildExprZ(exp, schName));
				}
				
				ret = psFactory.createPSConj(elems);
			}
			
			return ret;
		}

		@Override
		public PhraseSpec visitExprSubSetEq(ExprSubSetEq expr) {
			PhraseSpec ret;
			
			ExprZ left = expr.getLeftSet();
			ExprZ right = expr.getRightSet();
			
			if (MatchUtils.matchSet(left)) {
				List<PhraseSpec> elems = new ArrayList<PhraseSpec>();
				for (ExprZ exp : ((ExprSet) left).getElements()) {
					elems.add(buildExprZ(exp, schName));
				}
				ret = psFactory.createPSPertenecen(
						elems, 
						psBuilder.buildExprZ(right, schName));
				
			} else {
				ret = psFactory.createPSIncluidoIgual(
						psBuilder.buildExprZ(left, schName), 
						psBuilder.buildExprZ(right, schName));
			}
			
			return ret;
		}

		@Override
		public PhraseSpec visitExprSubSet(ExprSubSet expr) {
			PhraseSpec ret;
			
			ExprZ left = expr.getLeftSet();
			ExprZ right = expr.getRightSet();
			
			if (MatchUtils.matchSet(left)) {
				List<PhraseSpec> elems = new ArrayList<PhraseSpec>();
				for (ExprZ exp : ((ExprSet) left).getElements()) {
					elems.add(buildExprZ(exp, schName));
				}
				ret = psFactory.createPSPertenecen(
						elems, 
						psBuilder.buildExprZ(right, schName));
				
			} else {
				ret = psFactory.createPSIncluidoEn(
						psBuilder.buildExprZ(left, schName), 
						psBuilder.buildExprZ(right, schName));
			}
			
			return ret;
		}

		@Override
		public PhraseSpec visitExprUnion(ExprUnion expr) {
			PhraseSpec psSet1 = psBuilder.buildExprZ(expr.getLeftSet(), schName);
			PhraseSpec psSet2 = psBuilder.buildExprZ(expr.getRightSet(), schName);
			
			return psFactory.createPSElemEnYEn(psSet1, psSet2);
		}

		@Override
		public PhraseSpec visitNot(ExprNot expr) {
			PhraseSpec ret;
			
			ExprZ exp = expr.getExpr();
			
			if (MatchUtils.matchSubSetEq(exp)) {
				PhraseSpec ps1 = psBuilder.buildExprZ(((ExprSubSetEq) exp).getLeftSet(), schName);
				PhraseSpec ps2 = psBuilder.buildExprZ(((ExprSubSetEq) exp).getRightSet(), schName);
				
				ret = psFactory.createPSNoIncluidoEn(ps1, ps2);
						
			} else if (MatchUtils.matchSubSet(exp)) {
				PhraseSpec ps1 = psBuilder.buildExprZ(((ExprSubSet) exp).getLeftSet(), schName);
				PhraseSpec ps2 = psBuilder.buildExprZ(((ExprSubSet) exp).getRightSet(), schName);
				
				ret = psFactory.createPSNoIncluidoEn(ps1, ps2); 
						
			} else {
				// algo salio mal, no deberia ocurrir...
				ret = null;
				
			}
				
			return ret;
		}

	}

	
	
}
