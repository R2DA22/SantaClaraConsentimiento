package core.usecase.guardian.find;

import core.domain.patient.Guardian;

public interface FindGuardianUseCaseInterface {
    Guardian execute(Integer idType, String id) throws Exception;
}
