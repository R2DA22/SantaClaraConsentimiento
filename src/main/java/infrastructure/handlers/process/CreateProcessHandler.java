package infrastructure.handlers.process;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.process.Process;
import core.usecase.process.create.CreateProcessUseCaseInterface;

public class CreateProcessHandler implements CommandHandler {

    private CreateProcessUseCaseInterface useCase;

    public CreateProcessHandler(CreateProcessUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((Process) command);
    }
}
