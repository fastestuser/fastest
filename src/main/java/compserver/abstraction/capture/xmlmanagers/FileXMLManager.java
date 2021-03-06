package compserver.abstraction.capture.xmlmanagers;

import compserver.abstraction.types.impltypes.*;

/**
 * Provides utilities for interpret and encode values of a file in XML format
 */
public class FileXMLManager {    

    /**
     * Returns the string with the C Code for capture the output of a file
     * @param implNode the node with the information of type of a variable
     * @param varName the name of the variable under analysis
     * @param fileDescriptor the file descriptor of the file in which we write
     * the captured value in XML format
     * @param returnID the identifier of the return value of fprintf
     * @return the code
     */
	public static String getCaptureCode(String varName, ImplNode implNode, String fileDescriptor, String returnID){
		ImplNodeFile fileNode = (ImplNodeFile) implNode;
		// We obtain the attributes of this node
		String eol = fileNode.getEol();
		String eof = fileNode.getEof();
		String delimiter = fileNode.getDelimiter();
		String structure = fileNode.getStructure();
		String name = fileNode.getName();
		String path = fileNode.getPath();

		String captureCode = "";
		String xmlCode = "<file>\\n"
		+ "<name>\\n"
		+ name+"\\n"
		+ "</name>\\n"
		+ "<path>\\n"
		+ path+"\\n"
		+ "</path>\\n"
		+ "<delimiter>\\n"
		+ delimiter+"\\n"
		+ "</delimiter>\\n"
		+ "<structure>\\n"
		+ structure+"\\n"
		+ "</structure>\\n";
		if(!eol.equals("")){
		xmlCode += "<eol>\\n"
		+ eol+"\\n"
		+ "</eol>\\n";
		}
		if(!eof.equals("")){
		xmlCode += "<eof>\\n"
		+ eol+"\\n"
		+ "</eof>\\n";
		}
		xmlCode += "</file>\\n";
		captureCode += returnID+" = fprintf("+fileDescriptor+",\""+xmlCode+"\");\n";
		return captureCode;
	}
}