package core.usecase.configurations.find;

import core.domain.configuration.Configuration;

public interface FindConfiguratiosUseCaseInterface {
    Configuration execute(String param) throws Exception;
}
