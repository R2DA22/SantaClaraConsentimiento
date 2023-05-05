package core.usecase.professional.find;

import core.domain.professional.Professional;

public interface FindProfessionalUseCaseInterface {

    Professional execute(Integer idType, String id) throws Exception;
}
