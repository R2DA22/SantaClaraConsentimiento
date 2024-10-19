package infrastructure.handlers.area;


import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.area.find.FindAllAreaUseCaseInterface;
import java.io.Serializable;

public class FindAllAreaHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindAllAreaUseCaseInterface useCase;

    public FindAllAreaHandler(FindAllAreaUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
