package main.Interactor;

import main.domain.AgencyRules;
import main.domain.MinDep;
import main.domain.Result;

import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public interface RuleEngine {
    void createRule(AgencyRules rules);
    AgencyRules readRules(MinDep minDep);
    List<AgencyRules> readAllRules(MinDep minDep);
    List<String> getAllAgencies();
    Result processRules();
}
