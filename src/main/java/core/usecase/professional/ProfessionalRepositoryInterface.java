package core.usecase.professional;

import core.domain.professional.Professional;

public interface ProfessionalRepositoryInterface {

    void create(Professional professional) throws Exception;
    void update(Professional professional) throws Exception;

    Professional find(Integer idType, String id) throws Exception;
}
