package core.usecase.consent.create;

import core.domain.Consulta;
import core.domain.area.Area;
import core.domain.consent.DentalConsent;
import core.domain.process.Process;
import core.usecase.consent.ConsentRepositoryInterface;
import core.usecase.process.ProcessRepositoryInterface;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.json.JSONException;

public class CreateDentalConsentUseCase implements CreateDentalConsentUseCaseInterface {

    private ConsentRepositoryInterface repository;
    private ProcessRepositoryInterface processRepository;

    public CreateDentalConsentUseCase(ConsentRepositoryInterface repository, ProcessRepositoryInterface processRepository) {
        this.repository = repository;
        this.processRepository = processRepository;
    }

    @Override
    public void execute(DentalConsent consent) throws Exception {
        repository.createDentalConsent(consent);
    }
}
