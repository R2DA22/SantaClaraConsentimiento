package infrastructure.controllers.documentType;

import core.domain.patient.DocumentType;
import core.usecase.document.findAll.FindAllDocumentTypeUseCaseInterface;

import java.util.List;

public class DocumentTypeController {

    private FindAllDocumentTypeUseCaseInterface useCase;

    public DocumentTypeController(FindAllDocumentTypeUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    public List<DocumentType> getAllDocumentType() throws Exception {
        return null; //useCase.execute();
    }


}
