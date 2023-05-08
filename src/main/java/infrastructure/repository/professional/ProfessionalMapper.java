package infrastructure.repository.professional;

import core.domain.patient.DocumentType;
import core.domain.patient.ListDocumentType;
import core.domain.patient.Patient;
import core.domain.professional.Professional;
import core.domain.professional.ProfessionalList;
import core.domain.speciality.Speciality;
import infrastructure.repository.professional.MapperInterface;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalMapper implements MapperInterface {

    public ProfessionalMapper() {
    }

    @Override
    public Professional toDomain(ResultSet resultSet) throws Exception{
        Professional professional;
        while (resultSet.next()) {
            professional = new Professional();
            professional.setDocumentNumber(resultSet.getString("documento"));
            professional.setName(resultSet.getString("nombre"));
            professional.setRegistryNumber(resultSet.getInt("nro_registro"));
            professional.setSpecialty(new Speciality(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
            professional.setSignature(resultSet.getString("firma"));
            DocumentType doc = new DocumentType();
            doc.setDescription(resultSet.getString("tipo_documento"));
            doc.setId(resultSet.getInt("id_tipo_Documento"));
            doc.setInitials(resultSet.getString("inicial"));
            professional.setDocumentType(doc);
            return professional;
        }
        return null;
    }

    @Override
    public ProfessionalList toDomainList(ResultSet resultSet)  {
        List<Professional> list=new ArrayList<>();
        try {
            while (resultSet.next()) {
                Professional professional = new Professional();
                professional.setRegistryNumber(resultSet.getInt("nro_registro"));
                professional.setName(resultSet.getString("nombre"));
                professional.setDocumentNumber(resultSet.getString("documento"));
                professional.setSignature(resultSet.getString("firma"));
                list.add(professional);
            }
        } catch ( Exception e){

        }
        return new ProfessionalList(list);
    }
}
