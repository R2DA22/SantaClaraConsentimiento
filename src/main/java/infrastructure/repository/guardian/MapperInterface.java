package infrastructure.repository.guardian;

import core.domain.patient.Guardian;

import java.sql.ResultSet;

public interface MapperInterface {

    public Guardian toDomain(ResultSet resultSet);
}
