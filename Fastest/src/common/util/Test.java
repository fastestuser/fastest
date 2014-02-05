package common.util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "{1,\\langle 2,3 \\rangle,(2,3)}";
		ExprIterator it = new ExprIterator(s);
		System.out.println("imprimir expr iterator   " + s);
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
