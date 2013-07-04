package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.setlog.SetLogUtils;

public final class ZVarsFiller {

	private String setlogOutput;
	private HashMap<String,String> zVars;
	private HashMap<String,String> tipos;
	private HashMap<String, String> zNames;
	private int postfijo;
	private HashMap<String, StringPointer> slvars;
	private String getNumber(){
		return String.valueOf(postfijo++);
	}

	
	//cambia los caracteres de setlog [] por langlerangle, etc...
		private String setLogToLatexCharsReplacer(DefaultMutableTreeNode nodo,String exprS) throws Exception{
			if (exprS.equals("ValueNotAssigned") ){
				return exprS;
			}
			
			if(SetLogUtils.esSLVariableSimple(exprS) && slvars.get(exprS) != null && slvars.get(exprS).toString().equals("ValueNotAssigned")){
				return zNames.get(exprS)!=null?zNames.get(exprS):exprS;
			}
			
			ExprIterator expr = new ExprIterator(exprS);

			String ct = nodo.toString();


			if(exprS.startsWith("int(")){
				String aux[] = exprS.substring(4,exprS.length()-1).split(",");
				return aux[0] + " \\upto " + aux[1];
			}
			
			if (ct.equals("()")) 
				return "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprS) + ")";
			
			if (ct.equals("\\pfun")||ct.equals("\\fun")||ct.equals("\\ffun")||ct.equals("\\rel")){
				String salida = "";
				String coma = ct.equals("\\rel")?",":"\\mapsto ";
				ExprIterator exprAux;
				while(expr.hasNext()){
					exprAux = new ExprIterator(expr.next());
					salida += "," + "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprAux.next()) + coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),exprAux.next()) + ")";
				}
				if (!salida.isEmpty())
					return "\\{" + salida.substring(1) + "\\}";
				return "\\emptyset";
			}
			
			if (ct.equals("\\cross")){
				String salida = "";
				String coma = nodo.getChildCount()>2?",":" \\mapsto ";
				int i = 0;
				while(expr.hasNext()){
					salida += coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(i),expr.next());
					i++;
				}
				return "(" + salida.substring(coma.length()) + ")";
			}
			
			if (ct.equals("\\power")){
				String salida = "";
				while(expr.hasNext()){
					salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
				}
				if (!salida.isEmpty())
					return "\\{" + salida.substring(1) + "\\}";
				return "\\emptyset";
			}
			
			if (ct.equals("\\seq")){
				String salida = "";
				while(expr.hasNext())
					salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
				
				if (!salida.isEmpty())
					return "\\langle " + salida.substring(1) + "\\rangle";
				return "\\langle\\rangle";
			}
			
			String tipocompleto = tipos.get(ct);

			if (tipocompleto !=null){
				
				if (tipocompleto.startsWith("SchemaType")){
					ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(ct, tipocompleto);
					ExprIterator varsDecl = SetLogUtils.schemaToVarExprIterator(ct, tipocompleto);
					String c,v,salida="";
					while(expr.hasNext()){
						c = expr.next();
						v = varsDecl.next();
						salida += "," + v + "==" + setLogToLatexCharsReplacer(SetLogUtils.toTreeNorm(tiposDecl.next()),c); 
					}
					if (!salida.isEmpty())
						return "\\lblot " + salida.substring(1) + " \\rblot";
					return "\\lblot\\rblot";
				}

				
				if (tipocompleto.startsWith("EnumerationType"))
					return zNames.get(exprS);

				if (tipocompleto.startsWith("BasicType")){
					String salida = zNames.get(exprS);
					salida = ct.toLowerCase() + (salida!=null?salida:getNumber());
					salida = salida.replace("?","");
					return salida;
				}
			}
			
			return exprS;
		}

		private void setLogToLatexCharsReplacer() throws Exception{
			postfijo=0;
			Iterator<String> it = zVars.keySet().iterator();
			String var,tipo,expr;
			String varn;
			while (it.hasNext()) {  
				var = it.next().toString();
				tipo = tipos.get(var);
				expr = zVars.get(var);
				varn = setLogToLatexCharsReplacer(SetLogUtils.toTree(tipo),expr);
				varn = varn.replace("-", "\\negate ");
				zVars.put(var,varn);
			}
		}
	
	private String getTipoLibre(String elem,HashMap<String,String> tiposLibres){
		Iterator<String> iterator = tiposLibres.keySet().iterator();  
		String key;	String value;
		while (iterator.hasNext()) { 
			key = iterator.next().toString();
			value = tiposLibres.get(key);
			if(value !=null){
				if (value.contains(elem))
					return key;
			}
		}

		return "null";
	}

	private HashMap<String,String> llenarFreeTypes(HashMap<String,String> m){
		HashMap<String,String> s = new HashMap<String,String>();
		Iterator<String> iterator = m.keySet().iterator();
		String key,valor,nomtipo;
		while (iterator.hasNext()) { 
			key = iterator.next().toString();
			valor = m.get(key);
			//EnumerationType:FT:{elem1,elem2}
			if (valor.startsWith("EnumerationType")){
				String[] aux = valor.split(":");
				nomtipo =  aux[1];
				//aux = ((String) (aux[2]).subSequence(1, (aux[2]).length()-1)).split(",");
				s.put(nomtipo, ((String) (aux[2]).subSequence(1, (aux[2]).length()-1)));
			}
		}

		return s;
	}

	private void llenarZVars(ConstantCreator cc){
		//zVars = SL2ZP.getZVars();
		HashMap<String, String> memory = SetLogUtils.invertHashMap(zNames);
		Iterator<String> iterator = zVars.keySet().iterator();  
		String key,valor;
		while (iterator.hasNext()) {  
			key = iterator.next().toString();
			valor = zVars.get(key);
			if (valor == null){
				String tipo = tipos.get(key);
				valor =  cc.getCte(memory.get(key),SetLogUtils.toTreeNorm(tipo));
				zVars.put(key, valor);
			}  
		}
	}

	public void generar() throws Exception{
		//traduccion de SLog a Z
		//setlogOutput = "CONSTR = [],\nINT = int(-10000000000, 10000000000),\nK1 = 2,\nA=X,\nX=Y,";
		ANTLRInputStream input = new ANTLRInputStream(setlogOutput);
		SLog2ZLexer lexer2 = new SLog2ZLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer2);
		SLog2ZParser SL2ZP = new SLog2ZParser(tokens);
		SL2ZP.loadTablas(zVars,tipos, zNames);

		//tambien imprime en pantalla
		SL2ZP.lineas();
		this.slvars = SL2ZP.getSlvars();
		llenarZVars(SL2ZP.getCC());
		setLogToLatexCharsReplacer();
		//System.out.println("\nzVars llenas****************\n");
		//SetLogUtils.printHashMap(zVars);

		//System.out.println("\n FreeTipos ****************\n");
		HashMap<String, String> mapaux = llenarFreeTypes(tipos);
		//SetLogUtils.printHashMap(mapaux);

	}

	public ZVarsFiller(HashMap<String,String> zVars, HashMap<String,String> tipos, HashMap<String,String> zNames,String setlogOutput){
		this.zVars = zVars;
		this.tipos = tipos;
		this.zNames = zNames;
		this.setlogOutput = setlogOutput;
	}
}
