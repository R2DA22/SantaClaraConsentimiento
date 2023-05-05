package core.usecase.consent.create;

import core.domain.consent.ProcessConsent;

public interface CreateProcessConsentUseCaseInterface {

    void execute(ProcessConsent consent) throws Exception;

}
