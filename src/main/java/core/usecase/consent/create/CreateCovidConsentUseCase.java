package core.usecase.consent.create;

import core.domain.consent.CovidConsent;
import core.usecase.consent.ConsentRepositoryInterface;

public class CreateCovidConsentUseCase implements  CreateCovidConsentUseCaseInterface{

    private ConsentRepositoryInterface repository;

    public CreateCovidConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(CovidConsent consent) throws Exception {
        repository.createCovidConsent(consent);
    }
}
