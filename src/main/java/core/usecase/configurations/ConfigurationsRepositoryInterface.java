package core.usecase.configurations;

import core.domain.configuration.Configuration;
import infrastructure.repository.ClientDB;

public interface ConfigurationsRepositoryInterface {

   Configuration find(String param) throws Exception;

}
