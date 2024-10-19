package infrastructure.repository.patient;

import core.domain.patient.Patient;
import core.usecase.patient.PatientRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;

public class PatientRepository implements PatientRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ClientDB db;

    private MapperInterface mapper;

    public PatientRepository(ClientDB db, MapperInterface mapper) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public Patient find(Integer idType, String id) throws Exception {
        ResultSet resultSet=db.findPatient(idType,id);
        return mapper.toDomain(resultSet);
    }

    @Override
    public void create(Patient patient) throws Exception {
        db.createPatient(patient);
    }

    @Override
    public void update(Patient patient) throws Exception  {
        db.updatePatient(patient);
    }



}
