package core.usecase.consent;

import core.domain.area.Area;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.ProcessConsent;
import core.domain.process.Process;
import java.util.List;

public interface ConsentRepositoryInterface {
    void createVIHConsent(ConsentVIH consent) throws Exception;
    Integer findNextId() throws Exception;
}
