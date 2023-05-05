package core.usecase.process.find;

import core.domain.area.Area;
import core.domain.process.Process;
import core.usecase.process.ProcessRepositoryInterface;

import java.util.List;

public class FindAllProcessByAreaUseCase implements FindProcessByAreaUseCaseInterface{

    private ProcessRepositoryInterface repository;

    public FindAllProcessByAreaUseCase(ProcessRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Process> execute(Area area) throws Exception {
        return repository.findByArea(area.getId().toString());
    }
}
