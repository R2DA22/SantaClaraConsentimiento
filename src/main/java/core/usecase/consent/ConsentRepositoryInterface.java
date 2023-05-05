package core.usecase.consent;

import core.domain.area.Area;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.ProcessConsent;
import core.domain.process.Process;
import java.util.List;

public interface ConsentRepositoryInterface {
    void createEmergencyConsent(EmergencyConsent consent) throws Exception;
    void createProcessConsent(ProcessConsent consent) throws Exception;
    void createConsentProcess(List<Process> processes, int consentId) throws Exception;
    void createConsentArea(List<Area> areas, int consentId) throws Exception;
    void createConsentDissents(List<Process> dissents, int consentId) throws Exception;
    Integer findNextId() throws Exception;

    void createCovidConsent(CovidConsent consent) throws Exception;

    void createDentalConsent(DentalConsent consent) throws Exception;

    void createDentalCovidConsent(DentalCovidConsent consent) throws Exception;
}
