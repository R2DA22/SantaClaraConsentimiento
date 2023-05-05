package infrastructure.bus.query;


import core.domain.bus.query.Query;
import core.domain.bus.query.QueryBus;
import core.domain.bus.query.QueryHandler;

import java.util.HashMap;
import java.util.Map;

public class QuerySyncBus implements QueryBus {

    private Map<String, QueryHandler> handlers;

    public QuerySyncBus() {
        this.handlers =new HashMap<>();
    }

    @Override
    public void register(String query, QueryHandler handler) {
        handlers.put(query,handler);
    }

    @Override
    public Object dispatch(Query query) throws Exception {
        return handlers.get(query.getClass().getName()).execute(query);
    }
}
