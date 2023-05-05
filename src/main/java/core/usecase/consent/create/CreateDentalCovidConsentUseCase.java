package core.usecase.consent.create;

import core.domain.consent.DentalCovidConsent;
import core.usecase.consent.ConsentRepositoryInterface;

public class CreateDentalCovidConsentUseCase implements CreateDentalCovidConsentUseCaseInterface {

    private ConsentRepositoryInterface repository;

    public CreateDentalCovidConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DentalCovidConsent consent) throws Exception {
        repository.createDentalCovidConsent(consent);
    }
}
