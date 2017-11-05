package main.domain;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class DocumentRule extends Rule {

    public DocumentRule(DocumentConditions conditions, DocumentActions actions) {
        this.conditions = conditions;
        this.actions = actions;
    }

    public DocumentRule() {
    }

    public static DocumentConditions createConditions(String documentType, BigDecimal limit) {
        return new DocumentConditions(documentType, limit);
    }

    public static DocumentActions createActions(String ruleId, String roleId) {
        return new DocumentActions(ruleId, roleId);
    }

    public DocumentRule setConditions(String documentType, BigDecimal limit) {
        conditions = new DocumentConditions(documentType, limit);
        return this;
    }

    public DocumentRule setActions(String ruleId, String roleId) {
        actions = new DocumentActions(ruleId, roleId);
        return this;
    }

    static class DocumentConditions implements Condition {
        String documentType;
        BigDecimal limit;

        DocumentConditions(String documentType, BigDecimal limit) {
            this.documentType = documentType;
            this.limit = limit;
        }

        @Override
        public String toString() {
            return String.format("['documentType'='%s','limit'='%s']", documentType, limit);
        }

        @Override
        public List<Map<Object, Type>> getConditionElements() {
            List<Map<Object, Type>> a = new ArrayList<>();
            Map<Object,Type> b = new HashMap<>();
            b.put(documentType,String.class);
            b.put(limit,BigDecimal.class);
            a.add(b);
            return a;
        }
    }

    static class DocumentActions implements Action {
        String ruleId;
        String roleId;

        DocumentActions(String ruleId, String roleId) {
            this.ruleId = ruleId;
            this.roleId = roleId;
        }

        @Override
        public String toString() {
            return String.format("['ruleId'='%s','roleId'='%s']", ruleId, roleId);
        }

        @Override
        public List<Map<Object, Type>> getActionElements() {
            List<Map<Object, Type>> a = new ArrayList<>();
            Map<Object,Type> b = new HashMap<>();
            b.put(ruleId,String.class);
            b.put(roleId,String.class);
            a.add(b);
            return a;
        }
    }
}
