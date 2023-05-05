package infrastructure.repository.patient;

import core.domain.patient.Patient;

import java.sql.ResultSet;

public interface MapperInterface {

    public Patient toDomain(ResultSet resultSet) throws Exception;
}
