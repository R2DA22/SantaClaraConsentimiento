package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.DentalCovidConsent;
import core.usecase.consent.create.CreateDentalCovidConsentUseCaseInterface;

public class CreateDentalCovidConsentHandler implements CommandHandler {

    private CreateDentalCovidConsentUseCaseInterface useCase;

    public CreateDentalCovidConsentHandler(CreateDentalCovidConsentUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((DentalCovidConsent) command);
    }
}
