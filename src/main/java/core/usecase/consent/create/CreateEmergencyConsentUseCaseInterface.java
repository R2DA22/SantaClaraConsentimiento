package core.usecase.consent.create;

import core.domain.consent.EmergencyConsent;

public interface CreateEmergencyConsentUseCaseInterface {
    void execute(EmergencyConsent consent) throws Exception;

}
