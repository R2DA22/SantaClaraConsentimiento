package core.domain.vaccine;

import java.util.List;

public class VaccineList {

    private List<Vaccine> list;

    public VaccineList(List<Vaccine> list) {
        this.list = list;
    }

    public List<Vaccine> getList() {
        return list;
    }
}
