package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.setlog.SetLogUtils;

public final class ZVarsFiller {

	private String setlogOutput;
	private HashMap<String,String> zVars;
	private HashMap<String,String> tipos;
	private HashMap<String, String> zNames;

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

	private void llenarZVars(){
		//zVars = SL2ZP.getZVars();
		HashMap<String, String> memory = SetLogUtils.invertHashMap(zNames);
		Iterator<String> iterator = zVars.keySet().iterator();  
		String key,valor;
		ConstantCreator cc = new ConstantCreator(tipos,null,null); 
		while (iterator.hasNext()) {  
			key = iterator.next().toString();
			valor = zVars.get(key);
			if (valor == null){
				String tipo = tipos.get(key);
				valor =  cc.getCte(memory.get(key),SetLogUtils.toTree(tipo));
				zVars.put(key, valor);
			}  
		}
	}

	public void generar(){
		//traduccion de SLog a Z
		//setlogOutput = "CONSTR = [],\nINT = int(-10000000000, 10000000000),\nK1 = 2,\nA=X,\nX=Y,";
		ANTLRInputStream input = new ANTLRInputStream(setlogOutput);
		SLog2ZLexer lexer2 = new SLog2ZLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer2);
		SLog2ZParser SL2ZP = new SLog2ZParser(tokens);
		SL2ZP.loadTablas(zVars,tipos, zNames);

		//tambien imprime en pantalla
		SL2ZP.lineas();
		llenarZVars();
		System.out.println("\nzVars llenas****************\n");
		SetLogUtils.printHashMap(zVars);

		System.out.println("\n FreeTipos ****************\n");
		HashMap<String, String> mapaux = llenarFreeTypes(tipos);
		SetLogUtils.printHashMap(mapaux);

		String ssss = getTipoLibre("xxx1",mapaux);
		System.out.println("tipo de xxx1++++++++" + ssss);

	}

	public ZVarsFiller(HashMap<String,String> zVars, HashMap<String,String> tipos, HashMap<String,String> zNames,String setlogOutput){
		this.zVars = zVars;
		this.tipos = tipos;
		this.zNames = zNames;
		this.setlogOutput = setlogOutput;
	}
}
