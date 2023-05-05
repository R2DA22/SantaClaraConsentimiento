package core.usecase.guardian.create;

import core.domain.patient.Guardian;
import core.usecase.guardian.GuardianRepositoryInterface;

public class CreateGuardianUseCase implements CreateGuardianUseCaseInterface {

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
