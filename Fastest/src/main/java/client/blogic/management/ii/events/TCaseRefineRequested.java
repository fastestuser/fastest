package client.blogic.management.ii.events;

import client.blogic.testing.atcal.RefinementRule;
import common.z.AbstractTCase;

/**
 * Created by Cristian on 05/08/15.
 */

/**
 * An instance of this class represents a refine request of an abstract test case into a programming language using
 * a given refinement rule.
 */
public class TCaseRefineRequested extends Event_ {

    private final String opName;
    private final AbstractTCase abstractTCase;
    private final String targetLanguage;
    private final RefinementRule refinementRule;

    public TCaseRefineRequested
            (String opName, AbstractTCase abstractTCase, String targetLanguage, RefinementRule refinementRule) {
        this.opName = opName;
        this.abstractTCase = abstractTCase;
        this.targetLanguage = targetLanguage;
        this.refinementRule = refinementRule;
        super.setEventName("tCaseRefineRequested");
    }

    /**
     * Gets the name of the operation associated to the refine request.
     *
     * @return the name of the operation
     */
    public String getOpName() {
        return opName;
    }

    /**
     * Gets the abstract test case associated to the refine request.
     *
     * @return the abstract test case
     */
    public AbstractTCase getAbstractTCase() {
        return abstractTCase;
    }

    /**
     * Gets the target language of the refine request.
     *
     * @return the target language
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * Gets the refinement rule file of the refine request.
     *
     * @return the refinement rule file
     */
    public RefinementRule getRefinementRule() {
        return refinementRule;
    }
}

