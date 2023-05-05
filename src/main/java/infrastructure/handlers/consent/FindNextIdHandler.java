package infrastructure.handlers.consent;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.consent.find.FindNextIdConsentUseCase;

public class FindNextIdHandler implements QueryHandler {

    private FindNextIdConsentUseCase useCase;

    public FindNextIdHandler(FindNextIdConsentUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
