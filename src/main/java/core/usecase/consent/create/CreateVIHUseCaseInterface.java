package core.usecase.consent.create;

import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;

public interface CreateVIHUseCaseInterface {
    void execute(ConsentVIH consent) throws Exception;
}
