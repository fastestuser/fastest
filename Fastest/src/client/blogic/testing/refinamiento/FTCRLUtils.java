package client.blogic.testing.refinamiento;

import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import compserver.tcasegen.strategies.setlog.SetLogUtils;
import client.blogic.testing.refinamiento.FTCRLParser.SExprRefinementContext;


public class FTCRLUtils {

	//Crea un map con los valores de las variables de Z, a partir del caso de prueba
	public static HashMap<String, String> createZValuesMap(String tcase){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//Limpiamos los espacios y doble barras
		tcase = tcase.replaceAll(" ", "");
		tcase = tcase.replaceAll("\\\\\\\\", "");
		
		String lineas[] = tcase.split("\\where");
		
		//si no tiene where
		if (lineas.length == 1) return map;
		
		lineas = lineas[1].split("\\n");
		
		//la ultima linea siempre es "\\end{schema}"
		for (int i = 1; i < lineas.length -1; i++){
			String[] reg = lineas[i].split("=");
			map.put(reg[0], reg[1]);
		}
		
		return map;
	}
	
	//Crea un map con los tyipos de las variables de Z, a partir del caso de prueba
		public static HashMap<String, String> createZTypesMap(String tcase){
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			//Limpiamos los espacios y doble barras
			tcase = tcase.replaceAll(" ", "");
			tcase = tcase.replaceAll("\\\\\\\\", "");
			
			String lineas[] = tcase.split("\\where");
						
			lineas = lineas[0].split("\\n");
			
			//la primer linea siempre es "\\begin{schema}"
			for (int i = 1; i < lineas.length -1; i++){
				String[] reg = lineas[i].split(":");
				String type = reg[1];
				
				String vars[] = reg[0].split(","); //Lista de variables
				for (int j=0; j < vars.length; j++) {
					map.put(vars[j].replaceAll(" ", ""),type);
				}
			}
			
			return map;
		}
	
	//Determina el SExpr correspondiente. Para eso utiliza el parser para crear el árbol y visitarlo
	public static SExpr sExpr(String exp, Replacement replacement, HashMap<String,String> zValuesMap, HashMap<String,String> zTypesMap) {
		ANTLRInputStream in = new ANTLRInputStream(exp);
		FTCRLLexer lexer = new FTCRLLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		ParseTree tree = parser.sExprRefinement();
		
		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		return visitor.visitSExprRefinement((SExprRefinementContext) tree,replacement,zValuesMap, zTypesMap);
	}

	//Determina si 'value' es un conjunto. Como entrada toma un valor, no una expresion FTCRL.
	public static boolean isSet(String value) {
		//Creo que con chequear el inicio y el final es suficiente, porque una expresión de la forma
		// { ...} ... {...} no debería llegar como argumenta, ya que pide un valor y no una expresion.
		if (value.startsWith("\\{") && value.endsWith("\\}"))
			return true;
		else
			return  false;
	}

	//Determina la clase en Java que representa 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna "A"
	public static String recordType(String refS) {
		return refS.split("[.]", 2)[0];
	}

	//Determina el atributo en Java que se utiliza en 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna ".name"
	public static String recordAtribute(String refS) {
		//Hay que controlarla.
		//Hay que devolver todos los atributos si tiene varios?
		//o solo el primero?
		String[] split = refS.split("[.]", 2);
		if (split.length > 1) //Tiene atributo
			return "." + split[1];
		else
			return "";
	}

	//Determina si es un ARRAY de FTCRL, se utiliza dentro de los AsRefinement
	public static boolean isArray(String text) {
		return text.equals("ARRAY");
	}

	//Determina si es un RECORD de FTCRL, se utiliza dentro de los AsRefinement
	public static boolean isRecord(String text) {
		return text.equals("RECORD");
	}
	
	//  Metodo para la determinacion del tipo de un hijo de una expresion Z.
	public static String getChildType(String type, int pos) {
		//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager utilizada en Setlog
        DefaultMutableTreeNode root = SetLogUtils.toTreeNorm(type);
        
        DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(pos);
        
        while (((String) child.getUserObject()).equals("()")) {
        	child = (DefaultMutableTreeNode) child.getChildAt(0);
        }
        
        //se retorna la impresion del hijo correspondiente
        return printTreeWithParenthesis(child);
	}
	
	//Necesito esta funcion para imprimir el árbol en getChildType(...), la cual agrega parentesis, ya que TreeNorm los elimina
	private static String printTreeWithParenthesis(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return (String) tree.getUserObject();
		else if (tree.getChildCount() == 1)
			return (String) tree.getUserObject()+ "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
		else if (tree.getChildCount() == 2)
			return "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")" + ((String) tree.getUserObject()) + "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(1)) + ")";
		else {//tiene varios hijos, es un CROSS!
			String returnString = "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			int i = 1;
			while (i < tree.getChildCount()) {
				returnString = returnString.concat("\\cross");
				returnString = returnString.concat("(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(i)) + ")");
				i++;
			}
			return returnString;
		}
	}
}
