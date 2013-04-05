package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.*;
import net.sourceforge.czt.base.visitor.*;
import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import client.presentation.ClientTextUI;

import net.sourceforge.czt.z.visitor.VarDeclVisitor;
import net.sourceforge.czt.z.ast.Expr;
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
import common.z.SpecUtils;
import common.z.UtilSymbols;
import compserver.tcasegen.strategies.SetLogGrammar.TypeManagerLexer;
import compserver.tcasegen.strategies.SetLogGrammar.TypeManagerParser;

/*
 * A visitor that obtains all the needed types (basic, free and schema types) from a Z schema,
 * needed to create ANTLR input when parsing to setlog, in the process
 * to generate a Z test case
 */

public class TypesExtractor
implements TermVisitor<HashSet<String>>, VarDeclVisitor<HashSet<String>>
{

	public HashSet<String> visitTerm(Term term)
	{
		HashSet<String> list = new HashSet<String>();
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
								HashSet<String> auxList = auxTerm.accept(this);
								if(auxList!=null)
									list.addAll(auxList);
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception: \n"+e.toString());
		}
		return list;
	}

	public HashSet<String> visitVarDecl(VarDecl varDecl)
	{
		String typeExpr = SpecUtils.termToLatex(varDecl.getExpr());
		
		//Como la expresion de tipo, puede contener multiples tipos schema,
		//debemos revisar de forma completa, para eso creamos el arbol de tipo
		//con TypeManager (ANTLR) y chequeamos las hojas
		
		ANTLRInputStream input = new ANTLRInputStream(typeExpr);
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode tree = parser.getRoot();
        
        //recorremos el arbol en busca de las hojas, y chequeamos que no sean tipos basicos,
        //si no lo son agregamos ese esquema al input de antlr
        
        return getTypeLeafs(tree);
		
	}

	private HashSet<String> getTypeLeafs(DefaultMutableTreeNode tree) {
		
		HashSet<String> list = new HashSet<String>();
		
		if (tree.isLeaf()) {
			//chequeamos si es un tipo basico, si no lo es, es un esquema
			String value = tree.getUserObject().toString();
			
			if (value.equals("\\num") || value.equals("\\nat"))
				return list;
			
			list.add(value);
			return list;
			
		}
		
		int childs = tree.getChildCount();
		for (int i = 0; i < childs ; i++)
			list.addAll(getTypeLeafs((DefaultMutableTreeNode) tree.getChildAt(i)));
		
		return list;
	}
}