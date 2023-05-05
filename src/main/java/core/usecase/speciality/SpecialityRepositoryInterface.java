package core.usecase.speciality;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;

import java.util.List;

public interface SpecialityRepositoryInterface {

    List<Speciality> findAll() throws Exception;
}
