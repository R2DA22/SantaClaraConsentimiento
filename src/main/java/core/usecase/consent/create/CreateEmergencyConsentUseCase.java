package core.usecase.consent.create;

import core.domain.consent.EmergencyConsent;
import core.usecase.consent.ConsentRepositoryInterface;


public class CreateEmergencyConsentUseCase implements CreateEmergencyConsentUseCaseInterface {

    private ConsentRepositoryInterface repository;

    public CreateEmergencyConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(EmergencyConsent consent) throws Exception{
        this.repository.createEmergencyConsent(consent);
    }
}
