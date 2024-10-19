package infrastructure.handlers.configuration;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.configuration.Configuration;
import core.usecase.configurations.find.FindConfiguratiosUseCaseInterface;
import java.io.Serializable;

public class FindConfigurationHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

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
