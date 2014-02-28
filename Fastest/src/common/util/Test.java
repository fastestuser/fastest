package common.util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "~\\langle(\\langle1\\rangle\\mapstostr2)\\rangle";
		ExprIterator it = new ExprIterator(s);
		System.out.println("imprimir expr iterator   " + s);
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
