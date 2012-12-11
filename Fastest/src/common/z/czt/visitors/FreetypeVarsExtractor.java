package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.*;
import net.sourceforge.czt.base.visitor.*;
import java.util.*;

import client.presentation.ClientTextUI;

import net.sourceforge.czt.z.visitor.VarDeclVisitor;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.Name;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.TypeAnn;
import net.sourceforge.czt.z.ast.VarDecl;
import net.sourceforge.czt.z.ast.ZNameList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;
import net.sourceforge.czt.z.impl.ZParaListImpl;
import common.z.UtilSymbols;

/*
 * A visitor that obtains all the needed predicates to use in the NR strategy
 */

public class FreetypeVarsExtractor
implements TermVisitor<Map<Term,String>>, VarDeclVisitor<Map<Term,String>>
{

	protected ZFreetypeListImpl zFreetypeListImpl;

	public FreetypeVarsExtractor(ClientTextUI clientTextUI){
		Spec spec = clientTextUI.getMyController().getOriginalSpec();

		for (Sect sect : spec.getSect()) {
			if (sect instanceof ZSect) {
				ParaList paraList = ((ZSect) sect).getParaList();
				if (paraList instanceof ZParaList) {
					ZParaList zParaList = (ZParaList) paraList;
					for (int i = 0; i < zParaList.size(); i++) {
						Para para = zParaList.get(i);
						if (para instanceof FreePara) {
							FreetypeList freetypeList = ((FreePara) para).getFreetypeList();
							if (freetypeList instanceof ZFreetypeListImpl) {
								if (zFreetypeListImpl != null) {
									zFreetypeListImpl.addAll((ZFreetypeListImpl) freetypeList);
								} else {
									zFreetypeListImpl = (ZFreetypeListImpl) freetypeList;
								}
							}
						}
					}
				}
			}
		}
	}


	public Map<Term,String> visitTerm(Term term)
	{
		Map<Term,String> mapList = new HashMap<Term,String>();
		try{
			if(term != null){
				Object[] array = term.getChildren();
				Term auxTerm = null;
				if(array!=null){
					for (int i = 0; i < array.length; i++) {
						final Object object = array[i];
						if (object instanceof Term && object != null){
							auxTerm = (Term) object;
							if(auxTerm!=null){
								Map<Term,String> auxMap = auxTerm.accept(this);
								if(auxMap!=null)
									mapList.putAll(auxMap);
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception: \n"+e.toString());
		}
		return mapList;
	}

	public Map<Term,String> visitVarDecl(VarDecl varDecl)
	{
		Map<Term,String> mapList = new HashMap<Term,String>();

		String typeName = "";
		List<Object> anns = varDecl.getExpr().getAnns();
		for (int i = 0; i < anns.size(); i++) {
			Object ann = anns.get(i);
			if (ann instanceof TypeAnn) {
				TypeAnn typeAnn = (TypeAnn) ann;
				typeName = typeAnn.getType().toString();
			}
		}

		Freetype freeType = null;

		for (int j = 0; j < zFreetypeListImpl.size(); j++) {
			Freetype auxFreetype = zFreetypeListImpl.get(j);
			String freeTypeName = "POWER GIVEN " + auxFreetype.getName().toString();
			if (freeTypeName.equals(typeName)) {
				freeType = auxFreetype;
				break;
			}
		}

		if (freeType != null) {
			ZNameList zNameList = varDecl.getZNameList(); //Todas las variables
			Iterator<Name> zNameListIt = zNameList.iterator();
			while (zNameListIt.hasNext()) {
				Name name = zNameListIt.next();
				mapList.put(name, name.toString());
			}
		}

		//		//System.out.println("El tipo es: " + typeName);
		//		String arithmosTypeName = "POWER GIVEN " + UtilSymbols.arithmosSymbol();
		//		if (typeName.equals(arithmosTypeName)) {
		//			ZNameList zNameList = varDecl.getZNameList(); //Todas las variables
		//			Iterator<Name> zNameListIt = zNameList.iterator();
		//			while (zNameListIt.hasNext()) {
		//				Name name = zNameListIt.next();
		//				mapList.put(name, name.toString());
		//			}
		//		}

		return mapList;
	}
}