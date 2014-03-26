package common.z.czt.visitors;

import java.util.*;
import common.z.SpecUtils;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.ConstDecl;
import net.sourceforge.czt.z.ast.Decl;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.NameList;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.ZNameList;
import net.sourceforge.czt.z.ast.Box;
import net.sourceforge.czt.z.visitor.AxParaVisitor;

/**
 * This visitor makes it possible to extract the types defined by the user, like "BALANCE = \nat"
 */
public class UserDefinedTypesExtractor implements AxParaVisitor<HashMap<String,String>>,
TermVisitor<HashMap<String,String>> {



	public HashMap<String,String> visitAxPara(AxPara axPara) {
		HashMap<String,String> userDefinedTypes = new HashMap<String,String>();

		if (axPara.getBox().equals(Box.OmitBox)){ //Tiene que ser una definion horizontal
			NameList l = axPara.getZNameList();
			if (((ZNameList) l).isEmpty()){
				ZDeclList zDeclList = axPara.getZSchText().getZDeclList();
				if (zDeclList.size() == 1){
					Decl constDecl = zDeclList.get(0);
					if (constDecl instanceof ConstDecl){
						Expr expr = ((ConstDecl) constDecl).getExpr();
						if (expr instanceof RefExpr){ //Un RefExpr comunmente es un nuevo tipo
							userDefinedTypes.put(((ConstDecl) constDecl).getZName().toString(), SpecUtils.termToLatex(expr));
							}
					}
				}
			}
		}

		return userDefinedTypes;
	}

	public HashMap<String,String> visitTerm(Term term) {
		Object[] array = term.getChildren();
		HashMap<String,String> userDefinedTypes = new HashMap<String,String>();
		for (int i = 0; i < array.length; i++) {
			final Object object = array[i];
			if (object instanceof Term) {
				HashMap<String,String> auxFreeTypeNames = ((Term) object).accept(this);
				userDefinedTypes.putAll(auxFreeTypeNames);
			}
		}
		return userDefinedTypes;
	}
}
