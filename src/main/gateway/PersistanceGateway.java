package main.gateway;

import main.domain.AgencyRules;

import java.sql.Timestamp;

/**
 * Created by eananthaneshan on 4/11/17.
 */
public interface PersistanceGateway {
    void persist(AgencyRules rules);
    AgencyRules getRules(String ministryCode, String departmentCode);
    Timestamp getUpdateTimestamp(String ministryCode, String departmentCode);
}
