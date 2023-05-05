package infrastructure.repository.document;

import core.domain.patient.ListDocumentType;

import java.sql.ResultSet;

public interface MapperInterface {

     ListDocumentType toDomain(ResultSet resultSet);
}
