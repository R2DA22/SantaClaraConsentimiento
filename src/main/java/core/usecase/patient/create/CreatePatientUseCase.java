package core.usecase.patient.create;

import core.domain.patient.Patient;
import core.usecase.patient.PatientRepositoryInterface;
import java.io.Serializable;

public class CreatePatientUseCase implements CreatePatientUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


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
