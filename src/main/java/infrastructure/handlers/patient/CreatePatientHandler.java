package infrastructure.handlers.patient;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandHandler;
import core.domain.patient.Patient;
import core.usecase.patient.create.CreatePatientUseCaseInterface;

public class CreatePatientHandler implements CommandHandler {

    private CreatePatientUseCaseInterface useCase;

    public CreatePatientHandler(CreatePatientUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(Command command) throws Exception {
        useCase.execute((Patient) command);
    }
}
