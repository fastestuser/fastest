package compserver.abstraction.capture.xmlmanagers;

import compserver.abstraction.types.impltypes.*;

/**
 * Provides utilities for interpret and encode values of a DB in XML format
 */
public class DBXMLManager {    

    /**
     * Returns the string with the C Code for capture the output of a database
     * @param implNode the node with the information of type of a variable
     * @param varName the name of the variable under analysis
     * @param fileDescriptor the file descriptor of the file in which we write
     * the captured value in XML format
     * @param returnID the identifier of the return value of fprintf
     * @return the code
     */
	public static String getCaptureCode(String varName, ImplNode implNode, String fileDescriptor, String returnID){
		ImplNodeDB dbNode = (ImplNodeDB) implNode;
		//String dbmsID = dbNode.getDbmsID();
		String connID = dbNode.getConnID();
		String tableName = dbNode.getTableName();
		//List<ImplNodeDBColumn> columns = dbNode.getColumns();

		String captureCode = "";
		//Estoy considerando que va a haber una sola base de datos. SOLUCIONAR!!!
		String xmlCode = "<db>\\n";
		xmlCode += returnID+" = fprintf("+fileDescriptor+",\""+xmlCode+"\");\n"
		+ "if (sql_query(" + connID + ", \"SELECT * FROM " + tableName + "\")) {\n"
		+ "\tfprintf(stderror,\"%s\\n\",mysql_error("+connID+"));\n"
		+ "\tmysql_close("+connID+");\n"
		+ "\texit(0);\n}\n"
		+ "if((res"+varName+" = mysql_store_result("+connID+"))) {\n"
		+ "\tnumRows"+varName+" = (int) mysql_num_rows(res"+varName+");\n"
		+ "\tnumFields"+varName+" = (int) mysql_num_fields(res"+varName+");\n"
		+ "\tfor(i"+varName+" = 0; i"+varName+" < numFields"+varName+"; i"+varName+"++) {\n"
		+ "\t\tcolumn"+varName+" = mysql_fetch_field(res"+varName+");\n"
		+ "\t\t"+returnID+" = fprintf("+fileDescriptor+",\"<column>\\n<columnID>\\n%s\\n</columnID>\\n\",column"+varName+"->name);\n"
		+ "\t\tfor(j"+varName+" = 0 ; j"+varName+" < numRows"+varName+" ; j"+varName+"++) {\n"
		+ "\t\t\tmysql_data_seek(res"+varName+",i"+varName+");\n"
		+ "\t\t\trow"+varName+" = mysql_fetch_row(res"+varName+");\n"
		+ "\t\t\tfor(k"+varName+"=0;k"+varName+"<nroFields"+varName+";k"+varName+"++)\n"
		+ "\t\t\t\t"+returnID+" = fprintf("+fileDescriptor+",\"<columnValue>\\n%s\\n</columnValue>\\n\",row"+varName+"[k]);\n"
		+ "\t\t}\n"
		+ "\t"+returnID+" = fprintf("+fileDescriptor+",\"</column>\\n\");\n"
		+ "\t}\n}";
		return captureCode;
	}
	public static String getDeclarations(ImplNode implNode)
	{
		ImplNodeDB dbNode = (ImplNodeDB) implNode;
		String varName = dbNode.getImplID();
		String declaration = ""
		+ "MYSQL_RES *res"+varName+";\n"
		+ "int numRows"+varName+";\n"
		+ "int numFields"+varName+";\n"
		+ "int i"+varName+";\n"
		+ "int j"+varName+";\n"
		+ "int k"+varName+";\n"
		+ "MYSQL_FIELD *column"+varName+";\n"
		+ "MYSQL_ROW *row"+varName+";\n";
		return declaration;
	}
}