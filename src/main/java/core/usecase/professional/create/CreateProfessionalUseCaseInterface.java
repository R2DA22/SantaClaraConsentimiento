package core.usecase.professional.create;

import core.domain.professional.Professional;

public interface CreateProfessionalUseCaseInterface {

    void execute(Professional professinal) throws Exception;
}
