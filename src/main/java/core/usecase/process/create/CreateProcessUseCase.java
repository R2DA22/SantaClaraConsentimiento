package core.usecase.process.create;

import core.domain.process.Process;
import core.usecase.process.ProcessRepositoryInterface;

public class CreateProcessUseCase implements CreateProcessUseCaseInterface{

    private ProcessRepositoryInterface repository;

    public CreateProcessUseCase(ProcessRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Process process) throws Exception {
        this.repository.create(process);
    }
}
