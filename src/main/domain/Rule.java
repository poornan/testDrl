package main.domain;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public abstract class Rule {
    Condition conditions;
    Action actions;

    public interface Action {
        List<Map<Object,Type>> getActionElements();
    }

    public interface Condition {
        List<Map<Object,Type>> getConditionElements();
    }

    public Condition getConditions() {
        return conditions;
    }

    public Action getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return String.format("{ 'conditions' : %s, 'actions' : %s }", conditions, actions);
    }

}
