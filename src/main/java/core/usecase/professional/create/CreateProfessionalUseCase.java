package core.usecase.professional.create;

import core.domain.professional.Professional;
import core.usecase.professional.ProfessionalRepositoryInterface;

public class CreateProfessionalUseCase implements CreateProfessionalUseCaseInterface {

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
