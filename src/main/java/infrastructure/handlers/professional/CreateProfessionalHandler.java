package infrastructure.handlers.professional;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.professional.Professional;
import core.usecase.professional.create.CreateProfessionalUseCaseInterface;

public class CreateProfessionalHandler implements CommandHandler {

    private CreateProfessionalUseCaseInterface useCase;

    public CreateProfessionalHandler(CreateProfessionalUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((Professional) command);
    }
}
