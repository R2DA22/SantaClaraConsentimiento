package core.usecase.patient.create;

import core.domain.patient.Patient;

public interface CreatePatientUseCaseInterface {

     void execute(Patient patient) throws Exception;
}
