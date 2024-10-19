package infrastructure.handlers.vaccine;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.vaccine.find.FindAllVaccineUseCaseInterface;
import java.io.Serializable;


public class FindAllVaccineHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;


    private FindAllVaccineUseCaseInterface useCase;

    public FindAllVaccineHandler(FindAllVaccineUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return useCase.execute();
    }
}
