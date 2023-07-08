package core.usecase.professional;

import core.domain.patient.ListDocumentType;
import core.domain.professional.Professional;
import core.domain.professional.ProfessionalList;
import java.sql.ResultSet;

public interface ProfessionalRepositoryInterface {

    void create(Professional professional) throws Exception;
    void update(Professional professional) throws Exception;

    Professional find(Integer idType, String id) throws Exception;
    Professional findBySpeciality(Integer specialityID) throws Exception;
    ProfessionalList findAll() throws Exception;
}
