package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;

import net.sourceforge.czt.animation.eval.ExprComparator;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.oz.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.typecheck.z.TypeCheckUtils;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.Pred;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import common.util.ExprIterator;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.StringToNumReplacer;
import compserver.tcasegen.strategies.setlog.SetLogUtils;
import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
import compserver.tcasegen.strategies.setlog.TypeManagerParser;

public class Test {
	private static ExprIterator schemaTypeToExprIterator(String tipoCompleto,String nomTipo){
		// ej SchemaType:Estado:[var1:\num,var2:E]
		// "SchemaType:".length() = 
		tipoCompleto = tipoCompleto.substring(12+nomTipo.length());
		ExprIterator expr = new ExprIterator(tipoCompleto);
		String elem,aux[],salida="";
		while(expr.hasNext()){
			elem = expr.next();
			aux = elem.split(":");
			salida += "," + aux[1];
			System.out.println(elem);
		}
		salida = "{" + salida.substring(1) + "}";
		return new ExprIterator(salida);
	}
	
//	private class Tipo{
//		int cardinalidad;
//		String nombre;
//		public String toString(){
//			return nombre;
//		}
//	}
//	private  static class Par{
//		Par x,y;
//		int valor;
//		Tipo tipo;
//		public String toString(){
//			return "(" + x.toString2() + " \\mapsto " + y.toString2() + ")";
//		}
//		private String toString2(){
//			if (esHoja())
//				return String.valueOf(valor);
//			return this.toString(); 
//		}
//		Par(Par p1,Par p2,Tipo t){
//			x = p1; y = p2;valor = 0;tipo = t;
//		}
//		Par(int n,Tipo t){
//			valor = n;x=y=null;tipo = t;
//		}
//		boolean esHoja(){
//			return (x==null);
//		}
//	}	
//	//devuelve el bit que corresponde a la posicion, ej bitFromFreeType(FT::=a|b|c , a)
//	// = 100 en binario = 4 en decimal
//	private static int numFromFreeType(String tipo,String elem){
//		String s;
//		String aux[] = tipo.split(":");
//		s = aux[2].substring(1, aux[2].length()-1);
//		aux = s.split(",");
//		for(int i=0;i<aux.length;i++){
//			if (aux[i].equals(elem))
//				return i+1;
//		}
//		return 0;
//	}
//	private static String[] elemsFromExpr(String tipo, String expr){
//		String[] elems = new String[10];
//		char c;
//		char exprC[] = expr.toCharArray();
//		int s,f,ind,abierto,length; //abierto cantidad de parentesis o corchetes abierros
//		ind = abierto = f = 0; 
//		length = expr.length();
//		s = 1;
//		if (tipo.equals("\\power")){
//			for(int i=1;i<length-1;++i){
//				c = exprC[i];
//				if ( c==',' && abierto ==0){
//					elems[ind] = expr.substring(s, i-1);
//					s = i+1;
//					ind++;
//				}
//			}
//		}
//		return elems;
//	}
	public static String printTree(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return tree.toString();
		if (tree.toString().equals("()"))
			return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
		int i;
		String salida=tree.toString();
		for (i=0;i<tree.getChildCount();i++)
			salida += " " + printTree((DefaultMutableTreeNode) tree.getChildAt(i));
		return salida; 
	}
	
	private static DefaultMutableTreeNode aglutinarCorss(DefaultMutableTreeNode nodo){
		String ct = nodo.toString();
		
		DefaultMutableTreeNode n = new DefaultMutableTreeNode(ct);
		if(ct.equals("\\cross")){
			DefaultMutableTreeNode izq = (DefaultMutableTreeNode) nodo.getChildAt(0);
			DefaultMutableTreeNode der = (DefaultMutableTreeNode) nodo.getChildAt(1);
			if (izq.toString().equals("\\cross")){
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq.getChildAt(0)));
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq.getChildAt(0)));
			}
			else
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq));
			if (der.toString().equals("\\cross")){
				n.add(aglutinarCorss((DefaultMutableTreeNode) der.getChildAt(0)));
				n.add(aglutinarCorss((DefaultMutableTreeNode) der.getChildAt(0)));
			}
			else
				n.add(aglutinarCorss((DefaultMutableTreeNode) der));
			return n;
		}
		if(!nodo.isLeaf()){
			n.add(aglutinarCorss((DefaultMutableTreeNode) nodo.getChildAt(0)));
			return n;
		}
		
		return n;
	}
	
	public static void main(String[] args) throws IOException, CommandException {
		
/*
		IntExprMap.Tuple tuple = new IntExprMap(null).new Tuple(4);
		tuple.setCardinality(0, 2);
		tuple.setCardinality(1, 3);
		tuple.setCardinality(2, 4);
		tuple.setCardinality(3, 5);
		tuple = new IntExprMap(null).tupleFromInt(tuple, 120);
		System.out.println("NUM: " + new IntExprMap(null).intFromTuple(tuple));
*/		
		
		
/*		String tipo = "\\power \\num \\cross \\num";

		
		ANTLRInputStream input = new ANTLRInputStream(tipo);
		//ANTLRInputStream input = new ANTLRInputStream(" \\power ((\\power FT) \\cross FT)");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
        System.out.println(parser.printTree(root));
        System.out.println("PADRE " + root.getUserObject());
        System.out.println("IZQ " + parser.printTree((DefaultMutableTreeNode) root.getChildAt(0)));
        System.out.println("DER " + parser.printTree((DefaultMutableTreeNode) root.getChildAt(1)));
 */       
        
//        
//        input = new ANTLRInputStream(tipo);
//		//ANTLRInputStream input = new ANTLRInputStream(" \\power ((\\power FT) \\cross FT)");
//        lexer = new TypeManagerLexer(input);
//        tokens = new CommonTokenStream(lexer);
//        parser = new TypeManagerParser(tokens);
//        parser.typeManage();
//        DefaultMutableTreeNode root2 =  parser.getRoot();
//      
//        
//        HashMap<String,String> tipos = new HashMap<String, String>();
//		tipos.put("FT", "EnumerationType:FT:{a,b,c}");
//		tipos.put("Estado", "SchemaType:Estado:[var1:\\num,var2:FT]");
//		tipos.put("V", "Estado");
//		
//		String s = "X";
////		
//        ConstantCreator cc = new ConstantCreator(tipos, null, null, null);
//		 String salida = cc.getCte(s,root);
////		
////		 System.out.println("ENTRADA\n" + s);
//		 System.out.println("SALIDA\n" + salida);
//        
        
        
        
        
        
//		IntExprMap tmp = new IntExprMap(tipos);
//		int num = 5;
//		String expr1 = tmp.toExpr(root,num);
//		
//		String expr2 = "[{a,b},{{{a}}}]";
//		System.out.println( num + " to expr = " + expr1);
//		int num2 = tmp.toNum(root2,expr1);
//		System.out.println( expr1 + " to num = " + num2);
		
		/*String tipo =  "EnumerationType:FT:{a,b,c,d}";
		System.out.println("posicion: " + numFromFreeType(tipo,""));
		*/
		/*Expr e = new Expr("","[a,a]");
		Iterator<String> it = e.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		String s = "aaa}";
		System.out.println(s.charAt(s.length()-1));*/
//		ExprIterator e = new ExprIterator("{a,b,c,d,e}");
//		e.remove();
//		System.out.println(e +" "+ String.valueOf(e.cardinalidad()));
//		HashMap<String, String> valoresProhibidos = new HashMap();
//		valoresProhibidos.put("X", "{a}");
		

//		String e = "X";
//		ConstantGenIterator c = new ConstantGenIterator(root,e,tipos); 
//		String s = c.generate();
//		System.out.println(e + " --> " + s);
//		long a = new Integer("-1000000000");
//		int b = 2147483647;
//		int c = -2147483648;
////		String s1 = "SchemaType:Estado:[var1:\\num,var2:E]";
////		String s2 = "Estado";
////		System.out.println("" + schemaTypeToExprIterator(s1,s2));
//        String exprS = "int(33,XX)";
//        String aux[] = exprS.substring(4,exprS.length()-1).split(",");
 /*       
        ZLive zLive = UniqueZLive.getInstance();
        Pred pred = ParseUtils.parsePred(new StringSource("ab = ab"), zLive.getCurrentSection(), zLive.getSectionManager());
        pred = (Pred)pred.accept(new StringToNumReplacer());
        TypeCheckUtils.typecheck(pred, zLive.getSectionManager(),false, zLive.getCurrentSection());
 */       
//        Expr e1 = ParseUtils.parseExpr(new StringSource("\\{22\\}"),zLive.getCurrentSection(), zLive.getSectionManager());
//		
//        Expr e2 = ParseUtils.parseExpr(new StringSource("\\{23\\}"),zLive.getCurrentSection(), zLive.getSectionManager());
//        boolean a = ExprComparator.equalZ(e2,e1);
 /*       
        pred = zLive.evalPred(pred);
        System.out.println(SpecUtils.termToLatex(pred));*/
		
		ExprIterator it = new ExprIterator("{1,\\2\\,(2,3)}");
		System.out.println("imprimir expr iterator");
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
