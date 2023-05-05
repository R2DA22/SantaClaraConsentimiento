package core.domain.bus.query;

public interface QueryBus {

     void register(String command, QueryHandler handler);

     Object dispatch(Query command) throws Exception;
}
