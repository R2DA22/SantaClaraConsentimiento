package infrastructure.controllers.consent;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandBus;
import infrastructure.controllers.Controller;

public class ConsentController extends Controller {

    public ConsentController(CommandBus commandBus) {
        super(commandBus,null);
    }

    public void execute(Command command) throws Exception {
        this.dispatchCommand(command);
    }
}
