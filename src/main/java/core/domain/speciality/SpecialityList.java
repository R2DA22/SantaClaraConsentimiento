package core.domain.speciality;

import core.domain.bus.query.Query;

import java.util.List;

public class SpecialityList  {

    private List<Speciality> list;

    public SpecialityList(List<Speciality> list) {
        this.list = list;
    }

    public List<Speciality> getList() {
        return list;
    }
}
