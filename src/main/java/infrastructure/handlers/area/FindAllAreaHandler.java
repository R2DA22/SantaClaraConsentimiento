package infrastructure.handlers.area;


import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.area.find.FindAllAreaUseCaseInterface;

public class FindAllAreaHandler implements QueryHandler {

    private FindAllAreaUseCaseInterface useCase;

    public FindAllAreaHandler(FindAllAreaUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
