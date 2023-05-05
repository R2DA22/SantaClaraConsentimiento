package infrastructure.repository.vaccine;

import core.domain.vaccine.Vaccine;
import core.domain.vaccine.VaccineList;

import java.sql.ResultSet;
import java.util.List;

public interface MapperInterface {
    List<Vaccine> toDomain(ResultSet resultSet)throws Exception;
}
