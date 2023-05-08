package core.usecase.professional.find;

import core.domain.professional.Professional;
import core.domain.professional.ProfessionalList;

public interface FindAllProfessionalUseCaseInterface {
    ProfessionalList execute() throws Exception;

}
