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

		//--------------------------------------------------------------------------------
		// CONCATENATES the TESTNAME
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("//--------------------------------------------------------------------------------" + "\n");
		ctcString = ctcString.append(
				"// " + testName + "\n");
		ctcString = ctcString.append("//--------------------------------------------------------------------------------" + "\n");
		ctcString = ctcString.append("\n");
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		String preamble = ctc.getPreamble();
		String preambleWithOutPackageAndImports = "";

		BufferedReader preambleReader = new BufferedReader(new StringReader(preamble));

		CharSequence packageChar = new StringBuffer("package");
		CharSequence importChar = new StringBuffer("import");

		String preambleLine;
		try {
			while ((preambleLine = preambleReader.readLine()) != null) {
				if (preambleLine.contains(packageChar) || preambleLine.contains(importChar)) {
					ctcString = ctcString.append(preambleLine);
					ctcString = ctcString.append("\n");
				} else {
					preambleWithOutPackageAndImports =
							preambleWithOutPackageAndImports.concat(preambleLine) + "\n";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// PRINT the TEST CLASS HEADER
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("\n");
		ctcString = ctcString.append("public class ");
		ctcString = ctcString.append(testName);			// SCHEMA NAME
		ctcString = ctcString.append("\n");
		ctcString = ctcString.append("{");
		ctcString = ctcString.append("\n");
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// CONCATENATES the PREAMBLE WITHOUT PACKAGE and IMPORTS
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append(preambleWithOutPackageAndImports);
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// PRINT the RUNTEST CLASS HEADER
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("\n");
		ctcString = ctcString.append("\t");
		ctcString = ctcString.append("public static void main(String[] args)");
		//ctcString = ctcString.append("public static void runTest_");
		//ctcString = ctcString.append(testName);			// SCHEMA NAME
		//ctcString = ctcString.append("_TCASE()");
		ctcString = ctcString.append("\n");
		ctcString = ctcString.append("\t");
		ctcString = ctcString.append("{");
		ctcString = ctcString.append("\n");
		ctcString = ctcString.append("try{\n");
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// CONCATENATES the REFINEMENT TEXT of ALL ASSIGNMENTS
		//--------------------------------------------------------------------------------

		if (ctc.getDeclaraciones()!=null)
			ctcString = ctcString.append(ctc.getDeclaraciones());
		if (ctc.getAsignaciones()!=null)
			ctcString = ctcString.append(ctc.getAsignaciones());

		//        List<TCaseAssignment> assignments = ctc.getAssigments();
		//        Iterator<TCaseAssignment> iterAssignments = assignments.iterator();
		//        TCaseAssignment assignment;
		//        String assignmentRefText;
		//
		//        while (iterAssignments.hasNext()) {
		//            assignment = iterAssignments.next();
		//
		//            assignmentRefText = assignment.getRefText();
		//
		//            // CONCATS the REFIMENT TEXT of ASSIGNMENT
		//            ctcString = ctcString.append(
		//                    "\t\t" // INDENTATION
		//                    + assignmentRefText + "\n" + "\n");
		//        }
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// CONCATS the EPILOGUE
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("\t\t" + "//--------------------------------------------------------------------------------" + "\n");
		ctcString = ctcString.append("\t\t" + "//                                   EPILOGUE" + "\n");
		ctcString = ctcString.append("\t\t" + "//--------------------------------------------------------------------------------" + "\n");

		String epilogue = ctc.getEpilogue();
		BufferedReader epilogueReader = new BufferedReader(new StringReader(epilogue));
		String epilogueLine;

		try {
			while ((epilogueLine = epilogueReader.readLine()) != null) {
				ctcString = ctcString.append("\t\t" // INDENTATION
						+ epilogueLine + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------

		//--------------------------------------------------------------------------------
		// CLOSE the CATCH BLOCK.
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("}\n");
		ctcString = ctcString.append("catch(Exception e){\n");
		ctcString = ctcString.append("\te.printStackTrace(System.out);\n}");
		//--------------------------------------------------------------------------------
		// CLOSE the RUNTEST CLASS.
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("\t");
		ctcString = ctcString.append("}");
		ctcString = ctcString.append("\n");
		//--------------------------------------------------------------------------------


		//--------------------------------------------------------------------------------
		// CLOSE the TEST CLASS.
		//--------------------------------------------------------------------------------
		ctcString = ctcString.append("}");
		//--------------------------------------------------------------------------------

		return ctcString.toString();
	}
}
