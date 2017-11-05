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
public class FundRule extends Rule {

    public FundRule(FundConditions conditions, FundActions actions) {
        this.conditions = conditions;
        this.actions = actions;
    }

    public FundRule() {
        super();
    }

    public static FundConditions createConditions(String chartOfAccount, BigDecimal limit) {
        return new FundConditions(chartOfAccount, limit);
    }

    public static FundActions createActions(String nric, String roleId) {
        return new FundActions(nric, roleId);
    }

    public FundRule setConditions(String chartOfAccount, BigDecimal limit) {
        conditions = new FundConditions(chartOfAccount, limit);
        return this;
    }

    public FundRule setActions(String nric, String roleId) {
        actions = new FundActions(nric, roleId);
        return this;
    }

    static public class FundConditions implements Condition {
        String chartOfAccounts;
        BigDecimal limit;

        public FundConditions(String chartOfAccounts, BigDecimal limit) {
            this.chartOfAccounts = chartOfAccounts;
            this.limit = limit;
        }

        @Override
        public String toString() {
            return String.format("['COA'='%s','limit'='%s']", chartOfAccounts, limit);
        }

        public String getChartOfAccounts() {
            return chartOfAccounts;
        }

        public BigDecimal getLimit() {
            return limit;
        }

        @Override
        public List<Map<Object, Type>> getConditionElements() {
            List<Map<Object, Type>> a = new ArrayList<>();
            Map<Object,Type> b = new HashMap<>();
            b.put(chartOfAccounts,String.class);
            b.put(limit,BigDecimal.class);
            a.add(b);
            return a;
        }
    }

    static public class FundActions implements Action {
        String nric;
        String roleId;

        public FundActions(String nric, String roleId) {
            this.nric = nric;
            this.roleId = roleId;
        }

        @Override
        public String toString() {
            return String.format("['NRIC'='%s','Role Id'='%s']", nric, roleId);
        }

        public String getNric() {
            return nric;
        }

        public String getRoleId() {
            return roleId;
        }

        @Override
        public List<Map<Object, Type>> getActionElements() {
            List<Map<Object, Type>> a = new ArrayList<>();
            Map<Object,Type> b = new HashMap<>();
            b.put(nric,String.class);
            b.put(roleId,String.class);
            a.add(b);
            return a;
        }
    }
}
