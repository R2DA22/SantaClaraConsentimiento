package infrastructure.handlers.professional;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.professional.find.FindAllProfessionalUseCaseInterface;

public class FindAllProfessionalHandler implements QueryHandler {

    private FindAllProfessionalUseCaseInterface useCase;
    public FindAllProfessionalHandler(FindAllProfessionalUseCaseInterface useCase) {
        this.useCase=useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return this.useCase.execute();
    }
}
