package core.usecase.document.findAll;

import core.domain.patient.ListDocumentType;
import core.usecase.document.DocumentTypeRepositoryInterface;
import java.io.Serializable;


public class FindAllDocumentTypesUseCase implements FindAllDocumentTypeUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private DocumentTypeRepositoryInterface repository;

    public FindAllDocumentTypesUseCase(DocumentTypeRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public ListDocumentType execute() throws Exception {
        return this.repository.findAll();
    }
}
