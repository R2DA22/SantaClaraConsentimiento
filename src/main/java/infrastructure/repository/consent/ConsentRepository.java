package infrastructure.repository.consent;

import core.domain.area.Area;
import core.domain.consent.ConsentVIH;
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

    @Override
    public void createVIHConsent(ConsentVIH consent) throws Exception {
        db.createVIHConsent(consent);
    }

    @Override
    public Integer findNextId() throws Exception {
        return db.findNextId();
    }
}
