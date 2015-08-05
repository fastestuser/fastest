package client.blogic.testing.atcal;

import client.blogic.testing.atcal.parser.AtcalParser;

/**
 * Created by Cristian on 05/08/15.
 */
public class RefinementRule {

    private final AtcalParser.RefinementRuleContext context;      // The parsed rule context

    public RefinementRule(AtcalParser.RefinementRuleContext context) {
        this.context = context;
    }

    public AtcalParser.RefinementRuleContext getContext() {
        return context;
    }
}
