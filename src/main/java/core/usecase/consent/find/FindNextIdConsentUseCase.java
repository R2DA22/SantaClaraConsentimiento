package core.usecase.consent.find;

import core.usecase.consent.ConsentRepositoryInterface;
import java.io.Serializable;


public class FindNextIdConsentUseCase implements FindNextIdConsentUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ConsentRepositoryInterface repository;

    public FindNextIdConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Integer execute() throws Exception{
        return this.repository.findNextId();
    }
}
