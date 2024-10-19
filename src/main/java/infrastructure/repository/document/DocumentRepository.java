package infrastructure.repository.document;

import core.domain.patient.ListDocumentType;
import core.usecase.document.DocumentTypeRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;

public class DocumentRepository implements DocumentTypeRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ClientDB db;
    private MapperInterface mapper;

    public DocumentRepository(ClientDB sql, MapperInterface mapper) {
        this.db = sql;
        this.mapper=mapper;
    }

    public ListDocumentType findAll() throws Exception {
        ResultSet resultSet= db.getAllDocumentTypes();
        ListDocumentType result=mapper.toDomain(resultSet);
        return result;

    }

}
