package core.usecase.professional.find;

import core.domain.professional.Professional;
import core.usecase.professional.ProfessionalRepositoryInterface;

public class FindProfessionalUseCase implements FindProfessionalUseCaseInterface{

    private ProfessionalRepositoryInterface repository;

    public FindProfessionalUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Professional execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
