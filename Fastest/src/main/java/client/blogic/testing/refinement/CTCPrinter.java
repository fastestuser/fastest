package client.blogic.testing.refinement;

import client.blogic.testing.refinement.java.CTCPrinterJava;
import client.blogic.testing.atcal.ConcreteTCase;

public abstract class CTCPrinter {
	/**
	 * This function obtains from a ConcreteTCase object the source code related
	 * in the corresponding languaje
	 * @param testName The name of this test case
	 * @param ctc The ConcreteTCase object that contains all the information for this test case
	 * return the source code
	 */
	public abstract String print();
	
	public static CTCPrinter getPrinter(ConcreteTCase ctc){
		return new CTCPrinterJava(ctc);
	}
}
