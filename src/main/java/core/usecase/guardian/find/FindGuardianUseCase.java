package core.usecase.guardian.find;

import core.domain.patient.Guardian;
import core.usecase.guardian.GuardianRepositoryInterface;
import java.io.Serializable;

public class FindGuardianUseCase implements FindGuardianUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private GuardianRepositoryInterface repository;

    public FindGuardianUseCase(GuardianRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Guardian execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
