package core.usecase.consent.create;

import core.domain.consent.DentalConsent;

public interface CreateDentalConsentUseCaseInterface {

    void execute(DentalConsent consent) throws Exception;

}
