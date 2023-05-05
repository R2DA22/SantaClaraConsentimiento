package core.usecase.document.findAll;

import core.domain.patient.ListDocumentType;
import core.usecase.document.DocumentTypeRepositoryInterface;


public class FindAllDocumentTypesUseCase implements FindAllDocumentTypeUseCaseInterface {

    private DocumentTypeRepositoryInterface repository;

    public FindAllDocumentTypesUseCase(DocumentTypeRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public ListDocumentType execute() throws Exception {
        return this.repository.findAll();
    }
}
