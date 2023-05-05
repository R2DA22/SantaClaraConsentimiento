package core.usecase.speciality.find;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;

import java.util.List;

public interface FindAllSpecialityUseCaseInterface {

    List<Speciality> execute() throws Exception;
}
