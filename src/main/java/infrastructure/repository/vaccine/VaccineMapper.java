package infrastructure.repository.vaccine;

import core.domain.vaccine.Vaccine;
import core.domain.vaccine.VaccineList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VaccineMapper implements MapperInterface, Serializable {
    private static final long serialVersionUID = 1L;

    public VaccineMapper() {
    }

    @Override
    public List<Vaccine> toDomain(ResultSet resultSet) throws Exception {
        List<Vaccine> list = new ArrayList();
        Vaccine vaccine;
        while (resultSet.next()) {
            vaccine = new Vaccine();
            vaccine.setId(resultSet.getInt("id_vacuna"));
            vaccine.setName(resultSet.getString("nombre"));
            list.add(vaccine);
        }
        return list;
    }
}
