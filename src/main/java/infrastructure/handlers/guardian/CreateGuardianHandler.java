package infrastructure.handlers.guardian;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.patient.Guardian;
import core.usecase.guardian.create.CreateGuardianUseCaseInterface;

public class CreateGuardianHandler implements CommandHandler {

    private CreateGuardianUseCaseInterface useCase;

    public CreateGuardianHandler(CreateGuardianUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((Guardian) command);
    }
}
