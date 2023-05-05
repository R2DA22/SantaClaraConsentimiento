package core.usecase.consent.find;

import core.usecase.consent.ConsentRepositoryInterface;


public class FindNextIdConsentUseCase implements FindNextIdConsentUseCaseInterface {

    private ConsentRepositoryInterface repository;

    public FindNextIdConsentUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Integer execute() throws Exception{
        return this.repository.findNextId();
    }
}
