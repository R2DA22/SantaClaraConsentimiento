package core.usecase.patient.find;

import core.domain.patient.Patient;
import core.usecase.patient.PatientRepositoryInterface;

public class FindPatientUseCase implements FindPatientUseCaseInterface {

    private PatientRepositoryInterface repository;

    public FindPatientUseCase(PatientRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Patient execute(Integer idType, String id) throws Exception {
        return repository.find(idType,id);
    }
}
