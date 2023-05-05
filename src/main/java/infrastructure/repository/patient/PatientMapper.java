package infrastructure.repository.patient;

import core.domain.patient.DocumentType;
import core.domain.patient.Patient;

import java.sql.ResultSet;

public class PatientMapper implements MapperInterface{

    public PatientMapper() {
    }

    public Patient toDomain(ResultSet resultSet){
        Patient patient=null;
        try{
            if (resultSet.next()) {
                patient= new Patient();
                patient.setDocumentNumber(resultSet.getString("documento"));
                patient.setName(resultSet.getString("nombre"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_Documento"));
                doc.setInitials(resultSet.getString("inicial"));
                patient.setDocumentType(doc);
            }
        }catch (Exception e){

        }
        return patient;
    }
}
