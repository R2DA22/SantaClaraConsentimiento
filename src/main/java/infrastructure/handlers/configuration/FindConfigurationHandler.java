package infrastructure.handlers.configuration;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.configuration.Configuration;
import core.usecase.configurations.find.FindConfiguratiosUseCaseInterface;

public class FindConfigurationHandler implements QueryHandler {

    private FindConfiguratiosUseCaseInterface useCase;

    public FindConfigurationHandler(FindConfiguratiosUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        Configuration configuration=(Configuration) query;
        return useCase.execute(configuration.getPathPdfFile());
    }
}
