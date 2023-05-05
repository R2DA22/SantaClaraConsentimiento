package infrastructure.repository.consent;

import core.domain.area.Area;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.ProcessConsent;
import core.domain.process.Process;
import core.usecase.consent.ConsentRepositoryInterface;
import infrastructure.repository.ClientDB;
import java.util.List;


public class ConsentRepository implements ConsentRepositoryInterface {
    private ClientDB db;

    public ConsentRepository(ClientDB sql) {
        this.db = sql;
    }

    public void createEmergencyConsent(EmergencyConsent consent) throws Exception {
        db.createConsentEmergency(consent);
    }

    @Override
    public void createProcessConsent(ProcessConsent consent) throws Exception {
        db.createConsentProcess(consent);
    }

 @Override
    public void createDentalCovidConsent(DentalCovidConsent consent) throws Exception {
        db.createDentalCovidConsent(consent);
    }

    @Override
    public void createConsentProcess(List<Process> processes, int consentId) throws Exception {
        db.createConsentProcedure(processes, consentId);
    }

    @Override
    public void createConsentArea(List<Area> areas, int consentId) throws Exception {
        db.createConsentArea(areas, consentId);
    }

    @Override
    public void createConsentDissents(List<Process> dissents, int consentId) throws Exception {
        db.createConsentDissent(dissents, consentId);
    }

    @Override
    public Integer findNextId() throws Exception {
        return db.findNextId();
    }

    @Override
    public void createCovidConsent(CovidConsent consent) throws Exception {
        db.createConsentCovid(consent);
    }

    @Override
    public void createDentalConsent(DentalConsent consent) throws Exception {
        db.createDentalConsent(consent);
    }

}
