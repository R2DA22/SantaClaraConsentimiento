package core.usecase.patient;

import core.domain.patient.Patient;

public interface PatientRepositoryInterface {

    public Patient find(Integer idType, String id) throws Exception;
    public void create(Patient patient) throws Exception ;
    public void update(Patient patient) throws Exception ;


}
