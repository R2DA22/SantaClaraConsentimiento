package core.usecase.professional.create;

import core.domain.professional.Professional;
import core.usecase.professional.ProfessionalRepositoryInterface;
import java.io.Serializable;

public class CreateProfessionalUseCase implements CreateProfessionalUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ProfessionalRepositoryInterface repository;

    public CreateProfessionalUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Professional professional) throws Exception {
        Professional professionalRepo = repository.find(professional.getIdTypeDocument(), professional.getDocumentNumber());
        if (professionalRepo == null) {
            repository.create(professional);
            return;
        }
        repository.update(professional);
    }
}
