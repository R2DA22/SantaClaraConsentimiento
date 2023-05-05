package core.usecase.speciality.find;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;
import core.usecase.speciality.SpecialityRepositoryInterface;

import java.util.List;

public class FindSpecialityUsesCase implements FindAllSpecialityUseCaseInterface {

    private SpecialityRepositoryInterface repository;

    public FindSpecialityUsesCase(SpecialityRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Speciality> execute() throws Exception {
        return repository.findAll();
    }
}
