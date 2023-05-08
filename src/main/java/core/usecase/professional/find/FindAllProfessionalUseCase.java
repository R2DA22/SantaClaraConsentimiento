package core.usecase.professional.find;

import core.domain.professional.ProfessionalList;
import core.usecase.professional.ProfessionalRepositoryInterface;

public class FindAllProfessionalUseCase implements FindAllProfessionalUseCaseInterface{
    private ProfessionalRepositoryInterface repository;

    public FindAllProfessionalUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalList execute() throws Exception {
        return repository.findAll();
    }
}
