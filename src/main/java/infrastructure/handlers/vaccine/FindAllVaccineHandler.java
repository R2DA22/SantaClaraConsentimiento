package infrastructure.handlers.vaccine;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.vaccine.find.FindAllVaccineUseCaseInterface;


public class FindAllVaccineHandler implements QueryHandler {

    private FindAllVaccineUseCaseInterface useCase;

    public FindAllVaccineHandler(FindAllVaccineUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
