package infrastructure.handlers.document;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.patient.ListDocumentType;
import core.usecase.document.findAll.FindAllDocumentTypeUseCaseInterface;
import java.io.Serializable;

public class FindAllTypeDocumentHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindAllDocumentTypeUseCaseInterface useCase;

    public FindAllTypeDocumentHandler(FindAllDocumentTypeUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public ListDocumentType execute(Query query) throws Exception {
        return useCase.execute();
    }
}
