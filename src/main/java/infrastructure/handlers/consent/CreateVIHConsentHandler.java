package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.usecase.consent.create.CreateVIHUseCaseInterface;
import java.io.Serializable;

public class CreateVIHConsentHandler implements CommandHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private CreateVIHUseCaseInterface useCase;

    public CreateVIHConsentHandler(CreateVIHUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((ConsentVIH) command);
    }
}
