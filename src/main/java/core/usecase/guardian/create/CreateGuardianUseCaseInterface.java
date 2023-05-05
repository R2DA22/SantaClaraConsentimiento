package core.usecase.guardian.create;

import core.domain.patient.Guardian;

public interface CreateGuardianUseCaseInterface {

    public void execute(Guardian guardian) throws Exception;
}
