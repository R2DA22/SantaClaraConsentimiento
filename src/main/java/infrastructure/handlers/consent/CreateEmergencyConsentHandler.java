package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.EmergencyConsent;
import core.usecase.consent.create.CreateEmergencyConsentUseCaseInterface;

public class CreateEmergencyConsentHandler implements CommandHandler {

    private CreateEmergencyConsentUseCaseInterface useCase;

    public CreateEmergencyConsentHandler(CreateEmergencyConsentUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((EmergencyConsent) command);
    }
}
