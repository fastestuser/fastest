package client.blogic.management.ii.events;

import client.blogic.testing.atcal.ConcreteTCase;
import common.z.AbstractTCase;

/**
 * @author Hache
 * @author Cristian
 */

public class TCaseRefined extends Event_ {
    private final String opName;
    private final AbstractTCase absTCase;
    private final ConcreteTCase concreteTCase;

    public TCaseRefined(String opName, AbstractTCase absTCase, ConcreteTCase concreteTCase) {
        this.opName = opName;
        this.absTCase = absTCase;
        this.concreteTCase = concreteTCase;
        super.setEventName("tCaseRefined");
    }

    public String getOpName() {
        return opName;
    }

    public AbstractTCase getAbstractTCase() {
        return absTCase;
    }

    public ConcreteTCase getConcreteTCase() {
        return concreteTCase;
    }
}
