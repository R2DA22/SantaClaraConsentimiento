package infrastructure.repository.speciality;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialityMapper implements MapperInterface {

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
