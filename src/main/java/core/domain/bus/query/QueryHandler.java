package core.domain.bus.query;

public interface QueryHandler {

    Object execute(Query query) throws Exception;

}
