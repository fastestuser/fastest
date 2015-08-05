package client.blogic.testing.atcal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by cristian on 05/08/15.
 */
public class RuleManager {

    private final HashMap<String, RefinementRule> rules;

    public static RuleManager getInstance() {
        return RuleManagerHolder.instance;
    }

    private RuleManager() {
        rules = Maps.newHashMap();
    }

    private static final class RuleManagerHolder {
        static final RuleManager instance = new RuleManager();
    }

    public void addRule(String name, RefinementRule rule) {
        rules.put(name, rule);
    }

    public RefinementRule getRule(String name) {
        return rules.get(name);
    }

}
