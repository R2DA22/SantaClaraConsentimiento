package core.usecase.consent.create;

import core.domain.consent.DentalCovidConsent;

public interface CreateDentalCovidConsentUseCaseInterface {
    void execute(DentalCovidConsent consent) throws Exception;
}
