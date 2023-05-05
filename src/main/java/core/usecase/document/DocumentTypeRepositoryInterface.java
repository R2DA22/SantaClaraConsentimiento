package core.usecase.document;

import core.domain.patient.ListDocumentType;


public interface DocumentTypeRepositoryInterface {
    ListDocumentType findAll() throws Exception;
}
