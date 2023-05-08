package core.domain.professional;

import core.domain.bus.query.Query;
import core.domain.patient.DocumentType;
import java.util.List;

public class ProfessionalList implements Query {
    private List<Professional> professionals;

    public ProfessionalList() {
    }

    public ProfessionalList(List<Professional> professionals) {
        this.professionals = professionals;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }
}
