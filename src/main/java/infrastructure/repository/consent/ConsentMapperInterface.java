package infrastructure.repository.consent;

import core.domain.consent.ConsentVIH;
import core.domain.sickness.SicknessList;
import java.sql.ResultSet;

public interface ConsentMapperInterface {
    SicknessList toSicknessList(ResultSet resultSet);
    ConsentVIHDTO toConsentVIH(ResultSet resultSet);

}
