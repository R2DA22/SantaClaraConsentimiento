package core.usecase.patient.find;

import core.domain.patient.Patient;
import core.usecase.patient.PatientRepositoryInterface;
import java.io.Serializable;

public class FindPatientUseCase implements FindPatientUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private PatientRepositoryInterface repository;

    public FindPatientUseCase(PatientRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Patient execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
