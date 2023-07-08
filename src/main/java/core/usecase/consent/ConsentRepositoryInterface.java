package core.usecase.consent;

import core.domain.area.Area;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.ProcessConsent;
import core.domain.consent.VIHData;
import core.domain.process.Process;
import core.domain.sickness.Sickness;
import core.domain.sickness.SicknessList;
import infrastructure.repository.consent.ConsentVIHDTO;
import java.sql.ResultSet;
import java.util.List;

public interface ConsentRepositoryInterface {
    void createVIHConsent(ConsentVIH consent) throws Exception;
    Integer findNextId() throws Exception;

    ConsentVIHDTO findVIHData(VIHData filter) throws Exception;
    SicknessList findSicknessVIHData(int id) throws Exception;

    void updateVIHConsent(int id, String filename) throws Exception;
}
