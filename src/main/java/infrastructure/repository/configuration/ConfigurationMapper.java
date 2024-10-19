package infrastructure.repository.configuration;

import core.domain.configuration.Configuration;
import infrastructure.repository.configuration.MapperInterface;

import java.io.Serializable;
import java.sql.ResultSet;

public class ConfigurationMapper implements MapperInterface, Serializable {
    private static final long serialVersionUID = 1L;


    public ConfigurationMapper() {
    }

    @Override
    public Configuration toDomain(ResultSet resultSet) {
        Configuration config;
        try {
            if (resultSet.next()) {
                config = new Configuration(resultSet.getString("valor"));
                return config;
            }
        } catch ( Exception e){

        }
        return null;
    }
}
