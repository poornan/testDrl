package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class AgencyRulesImpl implements AgencyRules {

    MinDep minDep;
    List<Rule> rules = new ArrayList<Rule>();

    public AgencyRulesImpl(MinDep minDep) {
        this.minDep = minDep;
    }

    @Override
    public MinDep getMinDep() {
        return minDep;
    }

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public String toString() {
        return String.format("{'min_dep' = '%s', 'rules' = %s }", minDep, Arrays.toString(rules.toArray()));
    }
}
