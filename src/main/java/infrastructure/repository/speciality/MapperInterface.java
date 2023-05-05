package infrastructure.repository.speciality;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;

import java.sql.ResultSet;
import java.util.List;

public interface MapperInterface {

    List<Speciality> toDomain(ResultSet resultSet) throws Exception;
}
