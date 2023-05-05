package infrastructure.controllers.guardian;


import core.domain.patient.Guardian;
import core.usecase.guardian.find.FindGuardianUseCaseInterface;


public class GuardianController {

    private FindGuardianUseCaseInterface useCase;

    public GuardianController(FindGuardianUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    public Guardian findGuardian(Integer idType, String id) throws Exception {
        return useCase.execute(idType,id);
    }
}
