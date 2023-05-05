package infrastructure.repository.professional;

import core.domain.professional.Professional;

import java.sql.ResultSet;

public interface MapperInterface {

    Professional toDomain(ResultSet resultSet) throws Exception;
}
