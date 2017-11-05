package test;

import main.domain.*;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public class MainTest {
    @Test
    public void test() {
        DocumentRule documentRule = new DocumentRule()
        .setConditions("00-8023", new BigDecimal("12433546"))
        .setActions("test", "id");
        AgencyRules agencyRules = new AgencyRulesImpl(new MinDep("TsS_423"));
        agencyRules.addRule(documentRule);

        FundRule fundRule = new FundRule()
                .setConditions("*/*/*", new BigDecimal("1234123124"))
                .setActions("G3172", "id");
        AgencyRules agencyRules1 = new AgencyRulesImpl(new MinDep("TrS_231"));
        agencyRules1.addRule(fundRule);
        System.out.println(agencyRules1.getRules().get(0).getActions().get(0).getValue());

    }

    @Test(expected = MinDep.InvalidMinistryCode.class)
    public void testminException(){
        new MinDep("rS_231");
    }

    @Test(expected = MinDep.InvalidDepartmentCode.class)
    public void testDepException(){
        new MinDep("TrS_2031");
    }
}
