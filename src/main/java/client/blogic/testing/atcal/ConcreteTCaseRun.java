package client.blogic.testing.atcal;

import net.sourceforge.czt.z.ast.AxPara;

/**
 * An instance of this class represents the abstracted results of the execution of a concrete test case.
 *
 * @author Cristian Rosa
 */
public class ConcreteTCaseRun {

    /**
     * The Z schema with the results of the execution.
     */
    private final AxPara resultsSchema;

    /**
     * Creates a new concrete test case run instance
     *
     * @param resultsSchema the abstracted results
     */
    public ConcreteTCaseRun(AxPara resultsSchema) {
        this.resultsSchema = resultsSchema;
    }

    /**
     * Gets the Z schema with the results of the execution.
     *
     * @return a Z schema
     */
    public AxPara getResultsSchema() {
        return resultsSchema;
    }

    @Override
    public String toString() {
        return "ConcreteTCaseRun{" +
                "resultsSchema=" + resultsSchema +
                '}';
    }
}
