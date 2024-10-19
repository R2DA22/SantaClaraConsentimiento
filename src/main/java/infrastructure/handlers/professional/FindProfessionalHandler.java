package infrastructure.handlers.professional;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.professional.Professional;
import core.usecase.professional.find.FindProfessionalUseCaseInterface;
import java.io.Serializable;

public class FindProfessionalHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindProfessionalUseCaseInterface useCase;

    public FindProfessionalHandler(FindProfessionalUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        Professional professional=(Professional) query;
        return useCase.execute(professional.getIdTypeDocument(),professional.getDocumentNumber());
    }
}
