package client.blogic.testing.refinement.java;

import java.io.FileNotFoundException;

import client.blogic.testing.refinement.FTCRLtoCodeVisitor;
import client.blogic.testing.refinement.RefinementTable;

public final class RefinementJavaTable extends RefinementTable{

	public RefinementJavaTable(String t, String c, String p, String f, 	FTCRLtoCodeVisitor ftcrl) throws FileNotFoundException {
		super(t, c, p, f, ftcrl);
	}

	public void openTable(FTCRLtoCodeVisitor ftcrl) {
		ftcrl.printDeclaration("Statement " + stmt + " = init." + c + ".createStatement()");
		ftcrl.printDeclaration(stmt + ".executeUpdate(\"delete " + t + "\")");
	}
	
}
