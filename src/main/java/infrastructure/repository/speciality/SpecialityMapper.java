package infrastructure.repository.speciality;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialityMapper implements MapperInterface, Serializable {
    private static final long serialVersionUID = 1L;


    public SpecialityMapper() {
    }

    @Override
    public List<Speciality> toDomain(ResultSet resultSet) throws Exception {
        List<Speciality> list = new ArrayList();
        while (resultSet.next()) {
            list.add(new Speciality(resultSet.getString("descripcion"), resultSet.getInt("id_especialidad")));
        }
        return list;
    }
}
