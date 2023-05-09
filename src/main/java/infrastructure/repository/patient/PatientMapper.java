package infrastructure.repository.patient;

import core.domain.patient.DocumentType;
import core.domain.patient.Patient;

import java.sql.ResultSet;

public class PatientMapper implements MapperInterface {

    public PatientMapper() {
    }

    public Patient toDomain(ResultSet resultSet) {
        Patient patient = null;
        try {
            if (resultSet.next()) {
                patient = new Patient();
                patient.setDocumentNumber(resultSet.getString("documento"));
                patient.setName(resultSet.getString("nombre"));
                patient.setAge(resultSet.getInt("edad"));
                patient.setGender(resultSet.getBoolean("masculino"));
                patient.setBornDate(resultSet.getDate("fecha_nacimiento"));
                patient.setMaritalStatus(resultSet.getString("estado_civil"));
                patient.setCity(resultSet.getString("ciudad"));
                patient.setAddress(resultSet.getString("direccion"));
                patient.setPhoneNumber(resultSet.getString("telefono"));
                patient.setLevelOfStudy(resultSet.getString("escolaridad"));
                patient.setSocialScheme(resultSet.getString("esquema_social"));
                patient.setOccupation(resultSet.getString("ocupacion"));
                patient.setEps(resultSet.getString("eps"));
                patient.setEmail(resultSet.getString("email"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_Documento"));
                doc.setInitials(resultSet.getString("inicial"));
                patient.setDocumentType(doc);
            }
        } catch (Exception e) {

        }
        return patient;
    }
}
