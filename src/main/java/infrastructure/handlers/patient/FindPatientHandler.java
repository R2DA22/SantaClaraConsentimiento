package infrastructure.handlers.patient;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.patient.Patient;
import core.usecase.patient.find.FindPatientUseCaseInterface;
import java.io.Serializable;

public class FindPatientHandler implements QueryHandler, Serializable {
    private static final long serialVersionUID = 1L;

    private FindPatientUseCaseInterface useCase;

    public FindPatientHandler(FindPatientUseCaseInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Patient execute(Query query) throws Exception {
        Patient patient=(Patient) query;
        return useCase.execute(patient.getDocumentType().getId(),patient.getDocumentNumber());
    }
}
