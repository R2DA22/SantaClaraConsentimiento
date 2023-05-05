package core.usecase.vaccine;

import core.domain.vaccine.Vaccine;
import core.domain.vaccine.VaccineList;

import java.util.List;

public interface VaccineRepositoryInterface {

    List<Vaccine> findAll() throws Exception;
}
