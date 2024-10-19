package core.usecase.consent.create;

import core.domain.consent.ConsentVIH;
import core.usecase.consent.ConsentRepositoryInterface;
import java.io.Serializable;

public class CreateVIHUseCase implements CreateVIHUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ConsentRepositoryInterface repository;

    public CreateVIHUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(ConsentVIH consent) throws Exception {
        if (consent.isCreateConsent()) {
            repository.createVIHConsent(consent);
        }else{
            repository.updateVIHConsent(consent.getId(), consent.getFileName());
        }
    }
}
