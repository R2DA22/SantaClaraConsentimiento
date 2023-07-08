package core.usecase.professional.find;

import core.domain.professional.Professional;
import core.usecase.professional.ProfessionalRepositoryInterface;

public class FindProfessionalBySpecialityUseCase implements FindProfessionalBySpecialityInterface{

    private ProfessionalRepositoryInterface repository;

    public FindProfessionalBySpecialityUseCase(ProfessionalRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Professional execute(Integer specialityID) throws Exception {
        return repository.findBySpeciality(specialityID);
    }
}
