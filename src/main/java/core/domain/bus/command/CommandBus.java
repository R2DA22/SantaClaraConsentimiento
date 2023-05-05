package core.domain.bus.command;

public interface CommandBus {

    void register(String command, CommandHandler handler);

    void dispatch(Command command) throws Exception;
}
