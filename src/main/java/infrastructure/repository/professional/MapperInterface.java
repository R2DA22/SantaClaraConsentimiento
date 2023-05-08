package infrastructure.repository.professional;

import core.domain.professional.Professional;

import core.domain.professional.ProfessionalList;
import java.sql.ResultSet;

public interface MapperInterface {

    Professional toDomain(ResultSet resultSet) throws Exception;
    ProfessionalList toDomainList(ResultSet resultSet) throws Exception;
}
