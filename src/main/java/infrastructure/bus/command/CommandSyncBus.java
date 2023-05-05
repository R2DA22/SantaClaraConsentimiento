package infrastructure.bus.command;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandBus;
import core.domain.bus.command.CommandHandler;


import java.util.HashMap;
import java.util.Map;

public class CommandSyncBus implements CommandBus {

    private Map<String, CommandHandler> handlers;

    public CommandSyncBus() {
        this.handlers = new HashMap<>();
    }

    @Override
    public void register(String command, CommandHandler handler) {
        handlers.put(command, handler);
    }

    @Override
    public void dispatch(Command command) throws Exception {
        CommandHandler handler = handlers.get(command.getClass().getName());
        if (handler != null) {
            handler.execute(command);
        }
    }
}
