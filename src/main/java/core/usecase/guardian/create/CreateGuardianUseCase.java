package core.usecase.guardian.create;

import core.domain.patient.Guardian;
import core.usecase.guardian.GuardianRepositoryInterface;
import java.io.Serializable;

public class CreateGuardianUseCase implements CreateGuardianUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private GuardianRepositoryInterface repository;

    public CreateGuardianUseCase(GuardianRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Guardian guardian) throws Exception{
        Guardian guardianRepo=repository.find(guardian.getDocumentType().getId(),guardian.getDocumentNumber());
        if(guardianRepo!=null){
            repository.update(guardian);
            return;
        }
        repository.create(guardian);
    }
}
