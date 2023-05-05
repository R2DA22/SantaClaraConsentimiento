package core.usecase.patient.find;

import core.domain.patient.Patient;

public interface FindPatientUseCaseInterface {
    public Patient execute(Integer idType, String id) throws Exception;
}
