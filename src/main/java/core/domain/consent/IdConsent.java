package core.domain.consent;

import core.domain.bus.query.Query;

public class IdConsent implements Query {
    private int id;

    public IdConsent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
