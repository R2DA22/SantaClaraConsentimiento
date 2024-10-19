package core.usecase.process.find;

import core.domain.area.Area;
import core.domain.process.Process;
import core.usecase.process.ProcessRepositoryInterface;

import java.io.Serializable;
import java.util.List;

public class FindAllProcessByAreaUseCase implements FindProcessByAreaUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ProcessRepositoryInterface repository;

    public FindAllProcessByAreaUseCase(ProcessRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Process> execute(Area area) throws Exception {
        return repository.findByArea(area.getId().toString());
    }
}
