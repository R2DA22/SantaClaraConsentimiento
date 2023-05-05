package infrastructure.controllers.patient;


import core.domain.patient.Patient;
import core.usecase.patient.find.FindPatientUseCaseInterface;


public class PatientController   {

    private FindPatientUseCaseInterface useCase;

    public PatientController(FindPatientUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    public Patient getPatient(Integer idType,String id) throws Exception {
        return useCase.execute(idType,id);
    }
}
