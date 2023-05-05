package core.usecase.vaccine.find;

import core.domain.vaccine.Vaccine;

import java.util.List;

public interface FindAllVaccineUseCaseInterface {

    List<Vaccine> execute() throws Exception;
}
