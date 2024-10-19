package core.usecase.configurations.find;

import core.domain.configuration.Configuration;
import core.usecase.configurations.ConfigurationsRepositoryInterface;
import java.io.Serializable;


public class FindConfigurationUseCase implements FindConfiguratiosUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ConfigurationsRepositoryInterface repository;

    public FindConfigurationUseCase(ConfigurationsRepositoryInterface repository) {
        this.repository = repository;
    }


    @Override
    public Configuration execute(String param) throws Exception {
        return this.repository.find(param);
    }
}
