package core.usecase.consent.create;

import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.usecase.consent.ConsentRepositoryInterface;

public class CreateVIHUseCase implements CreateVIHUseCaseInterface {

    private ConsentRepositoryInterface repository;

    public CreateVIHUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(ConsentVIH consent) throws Exception {
        repository.createVIHConsent(consent);
    }
}
