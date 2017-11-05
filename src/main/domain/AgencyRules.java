package main.domain;

import java.util.List;

/**
 * Created by eananthaneshan on 5/11/17.
 */
public interface AgencyRules {
    MinDep getMinDep();

    List<Rule> getRules();

    void setRules(List<Rule> rules);

    void addRule(Rule rule);
}
