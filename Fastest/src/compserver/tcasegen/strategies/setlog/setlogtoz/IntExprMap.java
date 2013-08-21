package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import compserver.tcasegen.strategies.setlog.SetLogUtils;


/*Mapeador de naturales a expresion, por cada numero natural da una expresion y biceversa*/
public final class IntExprMap {
	private HashMap<String, String> tipos;

	private int numFromFreeType(String tipo,String elem){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		for(int i=0;i<aux.length;i++){
			if (aux[i].equals(elem))
				return i+1;
		}
		return 0;
	}

	private int numFromUptoType(String tipo,String elem){
		String aux[] = tipo.split("\\\\upto");
		return new Integer(elem) - new Integer(aux[0]) + 1;
	}

	private int cardOfFreeType(String tipo){
		String aux[] = tipo.split(":");
		aux = aux[2].split(",");
		return aux.length;
	}

	// devuelve la cardinalidad del tipo finito, por ahora solo formado por tipos libres.
	// si el numero es mayor al maximo del int devuelve 0.
	private int cardinalidadTipoFinito(DefaultMutableTreeNode nodo){
		String ct = nodo.toString();
		int c=0;

		if (ct.equals("\\power")){
			c = cardinalidadTipoFinito((DefaultMutableTreeNode) nodo.getChildAt(0));
			c = (2<<(c-1));
		}
		else if(ct.equals("\\cross")){
			c = cardinalidadTipoFinito((DefaultMutableTreeNode) nodo.getChildAt(0));
			c = c * cardinalidadTipoFinito((DefaultMutableTreeNode) nodo.getChildAt(1));
		}
		else
			c = cardOfFreeType(tipos.get(ct));
		return c;
	}

	//devuelve el elemento en la pos i del tipo libre de izq a derecha
	private  String elemFromFreeType(String tipo, int i){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		return aux[i-1];
	}

	private String elemFromUptoType(String tipo, int i){
		String aux[] = tipo.split("\\\\upto");
		return String.valueOf(new Integer(aux[0]) +i -1 );
	}

	private  class Par{
		int x,y;
		public String toString(){
			return "(" + x + "," + y + ")";
		}
	}	

	public  class Tuple{
		int size;
		int[] cardinality;
		int[] value;

		public Tuple(int size){
			this.size = size;
			this.cardinality = new int[size];
			this.value = new int[size];
		}

		public void setCardinality(int pos, int cardinality) {
			this.cardinality[pos] = cardinality;
		}

		public int getCardinality(int pos) {
			return this.cardinality[pos];
		}

		public void setValue(int pos, int value) {
			this.value[pos] = value;
		}

		public int getValue(int pos) {
			return this.value[pos];
		}
	}

	private  Par parFromInt(int card2, int num){
		Par p = new Par();
		if(card2>0){
			p.y = num % card2;
			p.x = num / card2 + ((p.y >0)?1:0);
			p.y = ((p.y ==0)?card2:p.y);
			return p;
		}
		p.x = 1; 
		p.y = num;
		return p;
	}

	private int intFromPar(int x, int y, int card){
		return card*(x-1) + y;
	}

	public  Tuple tupleFromInt(Tuple tuple, int num){

		int dim = 0;
		int size = tuple.size;
		int totalCardinality = 1;

		if (num == 1) {
			tuple.setValue(0, 1);
			dim++;
		} else {
			while (num > totalCardinality) { //Si no me alcanza con las dimensiones usadas

				int value = num / totalCardinality; //Calculo cuanto me falta
				if (num % totalCardinality > 0) //Si no da justo agrego 1
					value++;
				value = value % tuple.getCardinality(dim); //El resto es el valor

				if (value == 0) //Si el resto es 0, entonces entra justo (uso la cardinalidad)
					tuple.setValue(dim, tuple.getCardinality(dim));
				else
					tuple.setValue(dim, value);

				totalCardinality *= tuple.getCardinality(dim);
				dim++;
			}

		}
		while (dim < size) { //El resto se llena en 0, es un valor invalido, pero se usa para no calcular la dimension total
			tuple.setValue(dim, 0);
			dim++;
		}

		return tuple;
	}

	public int intFromTuple(Tuple tuple){

		int dim = 1;
		int num = tuple.getValue(0); //La primera dimension suma derecho, el resto se calcula
		int size = tuple.size;
		int totalCardinality = tuple.getCardinality(0);

		//Buscamos la ultima dimension que no tiene 0
		while ((dim < size) && (tuple.getValue(dim)) != 0){
			int value = tuple.getValue(dim);
			value--;

			value *= totalCardinality;
			num += value;

			totalCardinality *= tuple.getCardinality(dim);
			dim++;
		}

		return num;
	}

	//devuelve la posicion de los bits encendidos de la representacion binaria del entero,
	private  int[] posEncendidas(int n){
		int[] palabra = new int[Integer.SIZE];
		int res,resto,i,ni;
		res = n>>1;
		resto = n&1;
		i = 0;ni=1;
		while(res > 0 ){
			if(resto == 1){
				palabra[i] = ni;
				i++;
			}
			resto = res&1;
			res = res>>1;ni++;
		}
		palabra[i++] = ni*resto;
		return palabra;
	}



	/* Dado un numero natural y un tipo devuelve una expresion terminal del tipo */
	private  String f(DefaultMutableTreeNode nodo, int num){
		String salida = "";
		String ct = nodo.toString();
		DefaultMutableTreeNode hijoIzq = null;
		if(!nodo.isLeaf())
			hijoIzq = (DefaultMutableTreeNode) nodo.getChildAt(0);
		if ( ct.equals("\\power") || ct.equals("\\seq")){
			String p1,p2;
			p1 = ct.charAt(1) == 'p'?"{":"[";
			p2 = ct.charAt(1) == 'p'?"}":"]";
			String ctHijo;
			int n[]=posEncendidas(num);
			int numi,i;
			i=0;
			numi= n[i];
			int aux;
			while(numi!=0){
				ctHijo = hijoIzq.toString();
				//numi - 1 es el numero decimal que representa la constante
				//el cual es la posicion del bit encendido - 1
				aux = (ctHijo.equals("\\power")||ctHijo.equals("\\seq"))? numi-1 : numi;
				salida += ","  + f(hijoIzq,aux);
				i++;
				numi = n[i];
			}
			if(!salida.isEmpty())
				salida = p1 + salida.substring(1) + p2;
			else
				salida = p1 + p2;
		}else if(ct.equals("\\cross")){
			DefaultMutableTreeNode hijoDer = (DefaultMutableTreeNode) nodo.getChildAt(1);
			//Tipo t2 = (Tipo) ((DefaultMutableTreeNode) nodo.getChildAt(1)).getUserObject();
			int c = cardinalidadTipoFinito(hijoDer);
			//int c2 =t2.cardinalidad;
			if (num ==0)
				salida = "[]";
			else{
				Par p = parFromInt(c,num);

				String ctaux = hijoIzq.toString();
				p.x = (ctaux.equals("\\power")||ctaux.equals("\\seq"))? p.x-1 : p.x;
				ctaux = hijoDer.toString();
				p.y = (ctaux.equals("\\power")||ctaux.equals("\\seq"))? p.y-1 : p.y;

				salida = "["+f(hijoIzq,p.x) + "," + f(hijoDer,p.y) +"]";
			}

		}else if (ct.contains("upto")) {
			salida = elemFromUptoType(ct,num);

		} else if(tipos.get(ct).startsWith("SchemaType:")) {
			String tipoCompleto = tipos.get(ct);
			ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(tipoCompleto);
			int tiposCant = tiposDecl.cardinalidad();
			Tuple tuple = new Tuple(tiposCant);

			for(int i = 0; i < tiposCant; i++) {
				String tipo = tiposDecl.next();
				DefaultMutableTreeNode node = SetLogUtils.toTreeNorm(tipo);
				tuple.setCardinality(i, cardinalidadTipoFinito(node));
			}
			//Elegimos los valores de los elementos
			tuple = tupleFromInt(tuple,num);

			tiposDecl.reiniciar();
			for(int i = 0; i < tiposCant; i++) {
				String tipo = tiposDecl.next();
				DefaultMutableTreeNode node = SetLogUtils.toTreeNorm(tipo);
				int aux;
				String nodeType = node.toString();
				//numi - 1 es el numero decimal que representa la constante
				//el cual es la posicion del bit encendido - 1
				aux = (nodeType.equals("\\power")||nodeType.equals("\\seq"))? 1 : 0;

				int nodeValue = tuple.getValue(i);
				if (nodeValue == 0) //No se necesito calcular su valor, lo pongo en 1
					nodeValue = 1;

				salida += ","  + f(node,nodeValue-aux);
			}

			if(!salida.isEmpty())
				salida = "[" + salida.substring(1) + "]";
			else
				salida = "[" + "]";

		} else/*tipo libre*/ {
			String tipo = tipos.get(ct);
			salida = elemFromFreeType(tipo,num);	
		}
		return salida;
	}
	/* Dado un tipo y una expresion terminal, devuelve un numero natural
	 * Ej.{a,b,c}  
	 * 	   0 0 0  | 0 1 0 1 ... 1   
	 *     0 0 1  | 0 0 1 1 ... 1
	 *     0 1 0  | 0 0 0 0 ... 1
	 *     0 1 1  | 0 0 0 0 ... 1 
	 *     1 0 0  | 0 0 0 0 ... 1
	 *     1 0 1  | 0 0 0 0 ... 1
	 *     1 1 0  | 0 0 0 0 ... 1
	 *     1 1 1  | 0 0 0 0 ....1 
	 *     los valores del lado izquiero del "|" son todos los valores posibles para una variable del tipo {a,b,c}
	 *     los del lado derecho para \power {a,b,c} y asi 
	 *     retorna -1 si no es cte*/
	private  int f(DefaultMutableTreeNode nodo, String expr){
		int salida = -1;
		String ct = nodo.toString();
		DefaultMutableTreeNode hijoIzq = null;
		if(!nodo.isLeaf())
			hijoIzq = (DefaultMutableTreeNode) nodo.getChildAt(0);


		if(ct.equals("\\power")||ct.equals("\\seq")){
			String ctHijo;
			ExprIterator elems = new ExprIterator(expr);
			String elem;
			int posbit;
			int ac = 0;
			int aux;
			while(elems.hasNext()){
				elem = elems.next();
				posbit = f((DefaultMutableTreeNode)nodo.getChildAt(0),elem);
				if (posbit == -1)
					return -1;
				//crea el numero a partir de las posiciones de los bit encendidos los cuales
				//pertenecen a cada elemento del conjunto
				ctHijo = hijoIzq.toString();
				aux = (ctHijo.equals("\\power")||ctHijo.equals("\\seq"))? posbit : posbit-1;
				ac |= 1<<aux; //acumula bits, cad auno corresponde a un elemento presente.
			}
			salida = ac;
		}else if(ct.equals("\\cross")){
			DefaultMutableTreeNode hijoDer = (DefaultMutableTreeNode) nodo.getChildAt(1);
			ExprIterator elems = new ExprIterator(expr);
			String s1 = elems.next();
			String s2 = elems.next();

			int f1 = f(hijoIzq,s1);
			if (f1 == -1)
				return -1;
			int f2 = f(hijoDer,s2);
			if(f2 == -1)
				return -1;

			String ctaux = hijoIzq.toString();
			f1 = (ctaux.equals("\\power")||ctaux.equals("\\seq"))? f1+1 : f1;
			ctaux = hijoDer.toString();
			f2 = (ctaux.equals("\\power")||ctaux.equals("\\seq"))? f2+1 : f2;

			return intFromPar( f1 , f2, cardinalidadTipoFinito(hijoDer));

		} else if(ct.contains("upto")){
			salida = numFromUptoType(ct,expr);
			salida = (salida == 0)?-1:salida;

		} else if(tipos.get(ct).startsWith("SchemaType:")) {

			String tipoCompleto = tipos.get(ct);
			ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(tipoCompleto);
			int tiposCant = tiposDecl.cardinalidad();
			Tuple tuple = new Tuple(tiposCant);
			ExprIterator elems = new ExprIterator(expr);

			for(int i = 0; i < tiposCant; i++) {
				String tipo = tiposDecl.next();
				DefaultMutableTreeNode node = SetLogUtils.toTreeNorm(tipo);
				tuple.setCardinality(i, cardinalidadTipoFinito(node));
				int fNode = f(node, elems.next());
				if (fNode == -1) //Error
					return -1;

				String ctaux = node.toString();
				fNode = (ctaux.equals("\\power")||ctaux.equals("\\seq"))? fNode+1 : fNode; //Normalizamos
				tuple.setValue(i, fNode);
			}

			return intFromTuple(tuple);

		} else/*tipo libre*/ {
			salida = numFromFreeType(tipos.get(ct),expr);
			salida = (salida == 0)?-1:salida;
		}
		return salida;
	}

	//Devuelve una expresion termino cte del tipo
	//modifica el nodo, lo normaliza ej: si es A \pfun B -> \power (A \cross B)
	public String toExpr(DefaultMutableTreeNode nodo,int num){
		return f(nodo,num);
	}

	//Devuelve un numero natural que corresponde a un valor terminal del tipo 
	//modifica el nodo, lo normaliza ej: si es A \pfun B -> \power (A \cross B)
	public int toNum(DefaultMutableTreeNode nodo,String expr){
		//expr = expr.replaceAll("\\s+",""); 
		return f(nodo,expr);
	}

	//es una biyeccion entre naturales y expresiones terminales ctes dado un tipo.
	public IntExprMap(HashMap<String,String> tipos){
		this.tipos = tipos;
	}
}
