package client.blogic.testing.refinamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CTCPrinter {
	/**
	 * This function obtains from a ConcreteTCase object the source code related
	 * in the corresponding languaje
	 * @param testName The name of this test case
	 * @param ctc The ConcreteTCase object that contains all the information for this test case
	 * return the source code
	 */
	public static String printCTC(String testName, ConcreteTCase ctc) {
		String targetLanguaje = ctc.getLanguaje();
		//		if(targetLanguaje.equals("C"))
		//			return printCTCC(testName,ctc);
		//else 
		if(targetLanguaje.equals("Java")) // Ver consistencia may/min
			return printCTCJava(testName, ctc);
		return null;
	}

	public static String printCTCJava(String testName, ConcreteTCase ctc) {
		StringBuilder ctcString = new StringBuilder();		// EMPTY STRING

		// CONCATENATES the TESTNAME
		ctcString.append("//--------------------------------------------------------------------------------" + "\n");
		ctcString.append("// " + testName + "\n");
		ctcString.append("//--------------------------------------------------------------------------------" + "\n");
		ctcString.append("\n");

		String preamble = ctc.getPreamble();
		String preambleWithOutPackageAndImports = "";

		BufferedReader preambleReader = new BufferedReader(new StringReader(preamble));

		CharSequence packageChar = new StringBuffer("package");
		CharSequence importChar = new StringBuffer("import");

		String preambleLine;
		try {
			while ((preambleLine = preambleReader.readLine()) != null) {
				if (preambleLine.contains(packageChar) || preambleLine.contains(importChar)) 
					ctcString.append(preambleLine + "\n");
				else 
					preambleWithOutPackageAndImports = preambleWithOutPackageAndImports.concat(preambleLine + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// PRINT the TEST CLASS HEADER
		ctcString.append("\npublic class " + testName + "\n{\n");
		
		// CONCATENATES the PREAMBLE WITHOUT PACKAGE and IMPORTS
		ctcString = ctcString.append(preambleWithOutPackageAndImports);
		
		// PRINT the RUNTEST CLASS HEADER
		ctcString = ctcString.append("\npublic static void main(String[] args)\n{\ntry{\n");
		
		// CONCATENATES the REFINEMENT TEXT of ALL ASSIGNMENTS
		if (ctc.getDeclaraciones()!=null) ctcString.append(ctc.getDeclaraciones());
		if (ctc.getAsignaciones()!=null)  ctcString.append(ctc.getAsignaciones());
		
		// CONCATS the EPILOGUE
		String epilogue = ctc.getEpilogue();
		if (!epilogue.isEmpty() || !epilogue.equals("")){
			ctcString = ctcString.append("//--------------------------------------------------------------------------------\n");
			ctcString = ctcString.append("//                                   EPILOGUE\n");
			ctcString = ctcString.append("//--------------------------------------------------------------------------------\n");
			ctcString.append(epilogue + "\n");
		}
		
		// CLOSE the CATCH BLOCK.
		ctcString = ctcString.append("}\ncatch(Exception e){\n\te.printStackTrace(System.out);\n\t}");
		// CLOSE the RUNTEST CLASS.
		ctcString = ctcString.append("\n}\n");
		// CLOSE the TEST CLASS.
		ctcString = ctcString.append("}");

		return ctcString.toString();
	}
}
