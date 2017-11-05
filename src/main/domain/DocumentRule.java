package main.domain;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class DocumentRule extends Rule {

    public DocumentRule(List<Condition> conditions, List<Action> actions) {
        this.conditions = conditions;
        this.actions = actions;
    }

    public DocumentRule() {

    }

    public DocumentRule setConditions(String documentType, BigDecimal limit) {
        this.conditions = new ArrayList<>();
        conditions.add(new DocumentType(documentType));
        conditions.add(new Limit(limit));
        return this;
    }

    public DocumentRule setActions(String ruleId, String roleId) {
        this.actions = new ArrayList<>();
        actions.add(new RuleId(ruleId));
        actions.add(new RoleId(roleId));
        return this;
    }

    class DocumentType implements Condition {
        String documentType;

        DocumentType(String documentType) {
            this.documentType = documentType;
        }

        @Override
        public String toString() {
            return documentType.toString();
        }

        @Override
        public Type getType() {
            return documentType.getClass();
        }

        @Override
        public Object getValue() {
            return documentType;
        }
    }

    class Limit implements Condition {
        String documentType;
        BigDecimal limit;

        Limit(BigDecimal limit) {
            this.limit = limit;
        }

        @Override
        public String toString() {
            return limit.toString();
        }

        @Override
        public Type getType() {
            return limit.getClass();
        }

        @Override
        public Object getValue() {
            return limit;
        }
    }

    class RoleId implements Action {
        String roleId;

        RoleId(String ruleId) {
            this.roleId = ruleId;
        }

        @Override
        public String toString() {
            return roleId;
        }

        @Override
        public Type getType() {
            return roleId.getClass();
        }

        @Override
        public Object getValue() {
            return roleId;
        }
    }

    class RuleId implements Action {
        String ruleId;

        RuleId(String ruleId) {
            this.ruleId = ruleId;
        }

        @Override
        public String toString() {
            return ruleId;
        }

        @Override
        public Type getType() {
            return ruleId.getClass();
        }

        @Override
        public Object getValue() {
            return ruleId;
        }
    }
}
