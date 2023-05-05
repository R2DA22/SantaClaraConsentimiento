package core.domain.bus.command;

public interface CommandHandler {

    void execute(Command command) throws Exception;

}
