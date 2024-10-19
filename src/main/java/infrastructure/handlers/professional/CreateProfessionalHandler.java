package infrastructure.handlers.professional;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.professional.Professional;
import core.usecase.professional.create.CreateProfessionalUseCaseInterface;
import java.io.Serializable;

public class CreateProfessionalHandler implements CommandHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private CreateProfessionalUseCaseInterface useCase;

    public CreateProfessionalHandler(CreateProfessionalUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((Professional) command);
    }
}
