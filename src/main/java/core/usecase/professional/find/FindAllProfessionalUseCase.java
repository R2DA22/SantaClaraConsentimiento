package core.usecase.professional.find;

import core.domain.professional.ProfessionalList;
import core.usecase.professional.ProfessionalRepositoryInterface;
import java.io.Serializable;

public class FindAllProfessionalUseCase implements FindAllProfessionalUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ProfessionalRepositoryInterface repository;

    public FindAllProfessionalUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalList execute() throws Exception {
        return repository.findAll();
    }
}
