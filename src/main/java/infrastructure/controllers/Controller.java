package infrastructure.controllers;

import core.domain.bus.command.Command;
import core.domain.bus.command.CommandBus;
import core.domain.bus.query.Query;
import core.domain.bus.query.QueryBus;
import java.io.Serializable;

public class Controller implements Serializable {
    private static final long serialVersionUID = 1L;

    private CommandBus commandBus;
    private QueryBus queryBus;

    public Controller(CommandBus commandBus, QueryBus querybus) {
        this.commandBus = commandBus;
        this.queryBus = querybus;
    }

    public void dispatchCommand(Command command) throws Exception{
        commandBus.dispatch(command);

    }
    public Object dispatchQuery(Query query) throws Exception{
       return queryBus.dispatch(query);
    }


}
