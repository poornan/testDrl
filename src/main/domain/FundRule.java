package main.domain;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class FundRule extends Rule {

    public FundRule(List<Condition> conditions, List<Action> actions) {
        this.conditions = conditions;
        this.actions = actions;
    }

    public FundRule() {
        super();
    }

    public FundRule setConditions(String chartOfAccounts, BigDecimal limit){
        this.conditions = new ArrayList<>();
        conditions.add(new COA(chartOfAccounts));
        conditions.add(new Limit(limit));
        return this;
    }

    public FundRule setActions(String nric, String roleId){
        this.actions = new ArrayList<>();
        actions.add(new NRIC(nric));
        actions.add(new RoleId(roleId));
        return this;
    }

    public class COA implements Condition {
        String chartOfAccounts;

        public COA(String chartOfAccounts) {
            this.chartOfAccounts = chartOfAccounts;

        }

        @Override
        public String toString() {
            return chartOfAccounts;
        }

        @Override
        public Type getType() {
            return chartOfAccounts.getClass();
        }

        @Override
        public Object getValue() {
            return chartOfAccounts;
        }
    }

    public class Limit implements Condition {
        BigDecimal limit;

        public Limit(BigDecimal limit) {
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

    public class NRIC implements Action {
        String nric;

        public NRIC(String nric) {
            this.nric = nric;
        }

        @Override
        public String toString() {
            return nric;
        }

        @Override
        public Type getType() {
            return nric.getClass();
        }

        @Override
        public Object getValue() {
            return nric;
        }
    }

    public class RoleId implements Action {
        String roleId;

        public RoleId(String roleId) {
            this.roleId = roleId;
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
}
