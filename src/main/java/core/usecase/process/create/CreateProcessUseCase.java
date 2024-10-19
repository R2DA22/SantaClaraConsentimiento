package core.usecase.process.create;

import core.domain.process.Process;
import core.usecase.process.ProcessRepositoryInterface;
import java.io.Serializable;

public class CreateProcessUseCase implements CreateProcessUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ProcessRepositoryInterface repository;

    public CreateProcessUseCase(ProcessRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Process process) throws Exception {
        this.repository.create(process);
    }
}
