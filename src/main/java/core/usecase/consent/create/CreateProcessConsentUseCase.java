package core.usecase.consent.create;

import core.domain.consent.ProcessConsent;
import core.usecase.consent.ConsentRepositoryInterface;

public class CreateProcessConsentUseCase implements CreateProcessConsentUseCaseInterface{

    private final ConsentRepositoryInterface repository;

    public CreateProcessConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(ProcessConsent consent) throws Exception {
        this.repository.createProcessConsent(consent);
        this.repository.createConsentProcess(consent.getProcesses(), consent.getId());
    }
}
