package core.usecase.process.create;

import core.domain.process.Process;
import core.domain.professional.Professional;

public interface CreateProcessUseCaseInterface {

    void execute(Process process) throws Exception;
}
