package infrastructure.repository.guardian;

import core.domain.patient.DocumentType;
import core.domain.patient.Guardian;

import java.sql.ResultSet;

public class GuardianMapper implements MapperInterface {

    public GuardianMapper() {
    }

    public Guardian toDomain(ResultSet resultSet){
        Guardian guardian=null;
        try{
            if (resultSet.next()) {
                guardian= new Guardian();
                guardian.setDocumentNumber(resultSet.getString("documento"));
                guardian.setName(resultSet.getString("nombre"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_Documento"));
                doc.setInitials(resultSet.getString("inicial"));
                guardian.setDocumentType(doc);
            }
        }catch (Exception e){

        }
        return guardian;
    }
}
