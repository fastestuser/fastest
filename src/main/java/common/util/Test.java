package common.util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "\\langle 1 , 2 \\rangle";
		ExprIterator it = new ExprIterator(s);
		System.out.println("imprimir expr iterator   " + s);
			System.out.println(it.next(1));

	}

}
