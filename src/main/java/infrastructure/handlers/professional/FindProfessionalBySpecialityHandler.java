package infrastructure.handlers.professional;

import core.domain.bus.query.Query;
import core.domain.bus.query.QueryHandler;
import core.domain.professional.Professional;
import core.domain.speciality.Speciality;
import core.usecase.professional.find.FindProfessionalBySpecialityInterface;
import core.usecase.professional.find.FindProfessionalBySpecialityUseCase;
import core.usecase.professional.find.FindProfessionalUseCaseInterface;

public class FindProfessionalBySpecialityHandler implements QueryHandler {

    private FindProfessionalBySpecialityInterface useCase;

    public FindProfessionalBySpecialityHandler(FindProfessionalBySpecialityInterface useCase) {
        this.useCase = useCase;
    }

    @Override
    public Object execute(Query query) throws Exception {
        Speciality speciality = (Speciality) query;
        return useCase.execute(speciality.getId());
    }
}
