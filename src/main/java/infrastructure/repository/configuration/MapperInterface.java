package infrastructure.repository.configuration;

import core.domain.configuration.Configuration;
import java.sql.ResultSet;

public interface MapperInterface {

    Configuration toDomain(ResultSet resultSet) throws Exception;

}
