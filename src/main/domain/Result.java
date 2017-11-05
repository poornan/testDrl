package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class Result {
    Rule.Condition conditions;
    List<Rule.Action> results = new ArrayList<>();

    public Result(Rule.Condition conditions) {
        this.conditions = conditions;
    }

    public void addResult(Rule.Action result) {
        results.add(result);
    }

    @Override
    public String toString() {
        return String.format("{'condition' = %S, 'result' = %s }", conditions, Arrays.toString(results.toArray()));
    }
}
