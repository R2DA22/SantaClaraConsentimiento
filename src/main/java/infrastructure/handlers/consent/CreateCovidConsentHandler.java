package infrastructure.handlers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.consent.CovidConsent;
import core.domain.consent.ProcessConsent;
import core.usecase.consent.create.CreateCovidConsentUseCaseInterface;

public class CreateCovidConsentHandler implements CommandHandler {

    private CreateCovidConsentUseCaseInterface useCase;

    public CreateCovidConsentHandler(CreateCovidConsentUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((CovidConsent) command);
    }
}
