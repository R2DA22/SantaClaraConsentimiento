package infrastructure.handlers.professional;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.usecase.professional.find.FindAllProfessionalUseCaseInterface;
import java.io.Serializable;

public class FindAllProfessionalHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindAllProfessionalUseCaseInterface useCase;
    public FindAllProfessionalHandler(FindAllProfessionalUseCaseInterface useCase) {
        this.useCase=useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        return this.useCase.execute();
    }
}
