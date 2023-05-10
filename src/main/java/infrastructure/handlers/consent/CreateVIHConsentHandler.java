package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.usecase.consent.create.CreateVIHUseCaseInterface;

public class CreateVIHConsentHandler implements CommandHandler {

    private CreateVIHUseCaseInterface useCase;

    public CreateVIHConsentHandler(CreateVIHUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((ConsentVIH) command);
    }
}
