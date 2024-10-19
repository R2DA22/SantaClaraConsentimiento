package core.usecase.consent.find;

import core.domain.consent.VIHData;
import core.domain.sickness.SicknessList;
import core.usecase.consent.ConsentRepositoryInterface;
import infrastructure.repository.consent.ConsentVIHDTO;
import java.io.Serializable;

public class FindVIHUseCase implements FindVIHDataUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ConsentRepositoryInterface repository;

    public FindVIHUseCase(ConsentRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public ConsentVIHDTO execute(VIHData filter) throws Exception {
        ConsentVIHDTO consentVIHDTO=repository.findVIHData(filter);
        if (consentVIHDTO.getProfessional()!=null) {
            SicknessList sicknessList = repository.findSicknessVIHData(consentVIHDTO.getId());
            consentVIHDTO.setSicknessList(sicknessList.getSicknesses());
        }
        return consentVIHDTO;
    }
}
