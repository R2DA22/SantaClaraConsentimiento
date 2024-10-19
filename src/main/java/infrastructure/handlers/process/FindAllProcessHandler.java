package infrastructure.handlers.process;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.process.Process;
import core.usecase.process.find.FindProcessByAreaUseCaseInterface;
import java.io.Serializable;

public class FindAllProcessHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;


    private FindProcessByAreaUseCaseInterface useCase;

    public FindAllProcessHandler(FindProcessByAreaUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        Process process=(Process) query;
        return useCase.execute(process.getArea());
    }
}
