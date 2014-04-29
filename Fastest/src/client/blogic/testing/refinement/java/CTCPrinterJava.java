package client.blogic.testing.refinement.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import client.blogic.testing.refinement.CTCPrinter;
import client.blogic.testing.refinement.ConcreteTCase;

public final class CTCPrinterJava extends CTCPrinter{

	ConcreteTCase ctc; 
	
	public CTCPrinterJava(ConcreteTCase ctc) {
		this.ctc = ctc;
	}

	public String print() {
		StringBuilder ctcString = new StringBuilder();		// EMPTY STRING

		String testName = ctc.getConcreteTCaseName();
		// CONCATENATES the TESTNAME
		ctcString.append("\n//--------------------------------------------------------------------------------" + "\n");
		ctcString.append("// " + testName + "\n");
		ctcString.append("//--------------------------------------------------------------------------------" + "\n");
		ctcString.append("\n");

		if (ctc.hasWarnings()){
			ctcString.append("//*****WARNINGS******\n");
			ctcString.append(ctc.getWarnings());
			ctcString.append("//*******************\n\n");
		}
		
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
		ctcString.append(preambleWithOutPackageAndImports);

		// PRINT the RUNTEST CLASS HEADER
		ctcString.append("\npublic static void main(String[] args)\n{\n\ttry{\n");

		// CONCATENATES the REFINEMENT TEXT of ALL ASSIGNMENTS
		String decl = ctc.getDeclaraciones();
		if (decl != null)
			decl = "\t\t" + decl.replaceAll("\\n", "\n\t\t");
		ctcString.append(decl);
		String assign = ctc.getAsignaciones();
		if (assign != null){
			assign = assign.replaceAll("\\n", "\n\t\t");
			assign = assign.replaceFirst("\\\t\\\t$", "");
		}
		ctcString.append(assign);

		//cocnats the plcode
		String plcode = ctc.getPlCode();
		if (plcode != null)
			plcode = "\t\t" + plcode.replaceAll("\\n", "\n\t\t");
		ctcString.append(plcode);
		String uutline = ctc.getUutLine().replaceFirst("\\\t\\\t$", "");
		//concats the uutline
		ctcString.append(uutline+"\n");
		
		// CONCATS the EPILOGUE
		String epilogue = ctc.getEpilogue();
		if (!epilogue.isEmpty() || !epilogue.equals("")){
			ctcString.append("\t//--------------------------------------------------------------------------------\n");
			ctcString.append("\t//                                   EPILOGUE\n");
			ctcString.append("\t//--------------------------------------------------------------------------------\n");
			epilogue.replaceAll("\\n", "\n\t\t");
			epilogue = "\t\t" + epilogue.replaceAll("\\n", "\n\t\t");
			ctcString.append(epilogue + "\n");
			
		}

		// CLOSE the CATCH BLOCK.
		ctcString.append("\t}\n\tcatch(Exception e){\n\t\te.printStackTrace(System.out);\n\t}");
		// CLOSE the RUNTEST CLASS.
		ctcString.append("\n}\n");
		// CLOSE the TEST CLASS.
		ctcString.append("}");

		//sacar \n de mas
		return ctcString.toString().replaceAll("(\n)+","°").replace("°", "\n");
	}
}
