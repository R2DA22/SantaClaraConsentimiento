package infrastructure.handlers.document;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.patient.ListDocumentType;
import core.usecase.document.findAll.FindAllDocumentTypeUseCaseInterface;

public class FindAllTypeDocumentHandler implements QueryHandler {

    private FindAllDocumentTypeUseCaseInterface useCase;

    public FindAllTypeDocumentHandler(FindAllDocumentTypeUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public ListDocumentType execute(Query query) throws Exception {
        return useCase.execute();
    }
}
