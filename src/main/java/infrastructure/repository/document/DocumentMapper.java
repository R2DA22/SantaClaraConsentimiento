package infrastructure.repository.document;

import core.domain.patient.DocumentType;
import core.domain.patient.ListDocumentType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocumentMapper implements MapperInterface {

    public DocumentMapper() {
    }

    @Override
    public ListDocumentType toDomain(ResultSet resultSet) {
        List<DocumentType> list=new ArrayList<>();
        try {
            while (resultSet.next()) {
                DocumentType documentType = new DocumentType();
                documentType.setInitials(resultSet.getString("inicial"));
                documentType.setDescription(resultSet.getString("tipo_documento"));
                documentType.setId(resultSet.getInt("id_tipo_documento"));
                list.add(documentType);
            }
        } catch ( Exception e){

        }
        return new ListDocumentType(list);
    }
}
