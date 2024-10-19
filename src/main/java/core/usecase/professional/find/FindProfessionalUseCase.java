package core.usecase.professional.find;

import core.domain.professional.Professional;
import core.usecase.professional.ProfessionalRepositoryInterface;
import java.io.Serializable;

public class FindProfessionalUseCase implements FindProfessionalUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ProfessionalRepositoryInterface repository;

    public FindProfessionalUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Professional execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
