package infrastructure.handlers.consent;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.consent.find.FindNextIdConsentUseCase;
import java.io.Serializable;

public class FindNextIdHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindNextIdConsentUseCase useCase;

    public FindNextIdHandler(FindNextIdConsentUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
