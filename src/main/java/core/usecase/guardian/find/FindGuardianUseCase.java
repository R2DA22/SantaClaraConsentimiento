package core.usecase.guardian.find;

import core.domain.patient.Guardian;
import core.usecase.guardian.GuardianRepositoryInterface;

public class FindGuardianUseCase implements FindGuardianUseCaseInterface {

    private GuardianRepositoryInterface repository;

    public FindGuardianUseCase(GuardianRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Guardian execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
