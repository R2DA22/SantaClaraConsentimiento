package core.domain.sickness;

import java.util.List;

public class SicknessList {
    private List<Sickness> sicknesses;

    public SicknessList(List<Sickness> documentTypes) {
        this.sicknesses = documentTypes;
    }

    public List<Sickness> getSicknesses() {
        return sicknesses;
    }
}
