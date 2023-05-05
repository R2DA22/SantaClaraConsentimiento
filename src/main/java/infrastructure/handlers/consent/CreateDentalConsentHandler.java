package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.DentalConsent;
import core.usecase.consent.create.CreateDentalConsentUseCaseInterface;

public class CreateDentalConsentHandler implements CommandHandler {

    private CreateDentalConsentUseCaseInterface useCase;

    public CreateDentalConsentHandler(CreateDentalConsentUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((DentalConsent) command);
    }
}
