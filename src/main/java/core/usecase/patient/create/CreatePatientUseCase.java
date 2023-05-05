package core.usecase.patient.create;

import core.domain.patient.Patient;
import core.usecase.patient.PatientRepositoryInterface;

public class CreatePatientUseCase implements CreatePatientUseCaseInterface {

    private PatientRepositoryInterface repository;

    public CreatePatientUseCase(PatientRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Patient patient) throws Exception{
        Patient patientRepo=repository.find(patient.getDocumentType().getId(),patient.getDocumentNumber());
        if(patientRepo!=null){
            repository.update(patient);
            return;
        }
        repository.create(patient);
    }
}
