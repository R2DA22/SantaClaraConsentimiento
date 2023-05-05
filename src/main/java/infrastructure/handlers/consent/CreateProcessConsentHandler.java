package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.ProcessConsent;
import core.usecase.consent.create.CreateProcessConsentUseCaseInterface;

public class CreateProcessConsentHandler implements CommandHandler {

    private CreateProcessConsentUseCaseInterface useCase;

    public CreateProcessConsentHandler(CreateProcessConsentUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((ProcessConsent) command);
    }
}
