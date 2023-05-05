package core.usecase.configurations.find;

import core.domain.configuration.Configuration;
import core.usecase.configurations.ConfigurationsRepositoryInterface;


public class FindConfigurationUseCase implements FindConfiguratiosUseCaseInterface {

    private ConfigurationsRepositoryInterface repository;

    public FindConfigurationUseCase(ConfigurationsRepositoryInterface repository) {
        this.repository = repository;
    }


    @Override
    public Configuration execute(String param) throws Exception {
        return this.repository.find(param);
    }
}
