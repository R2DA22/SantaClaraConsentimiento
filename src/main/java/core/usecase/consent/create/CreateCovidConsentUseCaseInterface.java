package core.usecase.consent.create;

import core.domain.consent.CovidConsent;

public interface CreateCovidConsentUseCaseInterface {

    void execute(CovidConsent consent) throws Exception;

}
