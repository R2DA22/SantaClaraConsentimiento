package core.usecase.professional.find;

import core.domain.professional.Professional;

public interface FindProfessionalBySpecialityInterface {
    Professional execute(Integer specialityID) throws Exception;
}
