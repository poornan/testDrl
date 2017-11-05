package main.domain;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public abstract class Rule {
    List<Condition> conditions;
    List<Action> actions;

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Action> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return String.format("{ 'conditions' : %s, 'actions' : %s }",
                Arrays.toString(conditions.toArray()), Arrays.toString(actions.toArray()));
    }

    public interface Action {
        Type getType();
        Object getValue();
    }

    public interface Condition {
        Type getType();
        Object getValue();
    }

}
