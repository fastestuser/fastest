package client.blogic.management.ii.events;

import client.blogic.testing.atcal.RefinementRule;
import common.z.AbstractTCase;

import java.util.Collection;

/**
 * Represents the implicit invocation event that must be announced when
 * a set of abstract test cases need to be refined.
 *
 * @author Hache
 */
public class RefineAbsTCasesRequested extends Event_ {

    private Collection<AbstractTCase> absTCasesColl;
    private String opName;
    private String targetLanguage;
    private RefinementRule refinementRule;

    /**
     * Creates instances of RefineAbsTCasesRequested.
     */
    public RefineAbsTCasesRequested(String opName, Collection<AbstractTCase> set, String targetLanguage, RefinementRule refinementRule) {
        this.absTCasesColl = set;
        this.opName = opName;
        this.targetLanguage = targetLanguage;
        this.refinementRule = refinementRule;
        super.setEventName("refineAbsTCasesRequested");
    }

    public String getOpName() {
        return opName;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public Collection<AbstractTCase> getAbsTCasesColl() {
        return absTCasesColl;
    }

    public RefinementRule getRefinementRule() {
        return refinementRule;
    }
}
