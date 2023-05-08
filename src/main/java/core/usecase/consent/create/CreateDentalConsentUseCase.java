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
        repository.createConsentProcess(consent.getProcesses(), consent.getId());
        List<Area> areas = new ArrayList<>();
        areas.add(consent.getArea());
        consent.getProcesses().addAll(processProcesses(consent.getArea().getProcess(), consent.getArea()));
        for (Process dissent : consent.getDissents()) {
            for (Process process : consent.getProcesses()) {
                if (process.getDescription().equals(dissent.getDescription())) {
                    dissent.setIdProcess(process.getIdProcess());
                }
            }
        }
        repository.createConsentArea(areas, consent.getId());
    }

    private List<Process> processProcesses(List<String> procList, Area area) throws Exception {
        Consulta consulta = null;
        Process process;
        List<Process> processList = new ArrayList();
        try {
            for (String nameProcess : procList) {
                process = processRepository.findByName(nameProcess);
                if (process == null) {
                    process = new Process();
                    process.setArea(area);
                    process.setDescription(nameProcess.toLowerCase().replaceAll("^\\w", nameProcess.toUpperCase().substring(0, 1)));
                }
                processList.add(process);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
        return processList;
    }
}
