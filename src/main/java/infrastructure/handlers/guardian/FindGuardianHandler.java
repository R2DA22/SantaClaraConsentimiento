package infrastructure.handlers.guardian;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.patient.Guardian;
import core.usecase.guardian.find.FindGuardianUseCaseInterface;

public class FindGuardianHandler implements QueryHandler {

    private FindGuardianUseCaseInterface useCase;

    public FindGuardianHandler(FindGuardianUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Guardian execute(Query query) throws Exception {
        Guardian guardian=(Guardian) query;
        return useCase.execute(guardian.getDocumentType().getId(),guardian.getDocumentNumber());
    }
}
