package infrastructure.handlers.consent;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.consent.VIHData;
import core.usecase.consent.find.FindVIHDataUseCaseInterface;
import java.io.Serializable;

public class FindVIHDataHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindVIHDataUseCaseInterface useCase;

    public FindVIHDataHandler(FindVIHDataUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute((VIHData) query);
    }
}
