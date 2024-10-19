package infrastructure.repository.configuration;

import core.domain.configuration.Configuration;
import core.usecase.configurations.ConfigurationsRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;

public class ConfigurationRepository implements ConfigurationsRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ClientDB dataBase;

    private MapperInterface mapper;

    public ConfigurationRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public Configuration find(String param) throws Exception {
        ResultSet result=dataBase.findConfiguration(param);
        return mapper.toDomain(result);
    }
}
