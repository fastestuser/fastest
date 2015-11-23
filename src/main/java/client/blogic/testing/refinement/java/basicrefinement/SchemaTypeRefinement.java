//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo cross product. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.FTCRLtoJavaVisitor;

public class SchemaTypeRefinement extends Refinement {

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLtoJavaVisitor ftcrl) {
		
		SExpr exp = FTCRLUtils.convertSchemaToCross(zExpr);
		
		CrossProductRefinement refinement = new CrossProductRefinement();
		return refinement.refine(exp, toType, javaExpr, ftcrl);
	}

	@Override
	String refineTo(SExpr zExpr, SExpr javaExpr) {
		return null;
	}
}
