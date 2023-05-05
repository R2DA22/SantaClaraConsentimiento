package infrastructure.handlers.speciality;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.speciality.find.FindAllSpecialityUseCaseInterface;

public class FindAllSpecialityHandler implements QueryHandler {

    private FindAllSpecialityUseCaseInterface useCase;

    public FindAllSpecialityHandler(FindAllSpecialityUseCaseInterface useCase) {
        this.useCase = useCase;
    }
    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
