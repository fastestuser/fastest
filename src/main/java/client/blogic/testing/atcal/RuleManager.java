package client.blogic.testing.atcal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by cristian on 05/08/15.
 */
public class RuleManager implements Iterable<RefinementRule> {

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

    public boolean isEmpty() {
        return rules.isEmpty();
    }

    @Override
    public Iterator<RefinementRule> iterator() {
        return rules.values().iterator();
    }

    @Override
    public void forEach(Consumer<? super RefinementRule> action) {
        rules.values().forEach(action);
    }

    @Override
    public Spliterator<RefinementRule> spliterator() {
        return rules.values().spliterator();
    }
}
