package core.usecase.vaccine.find;

import core.domain.vaccine.Vaccine;
import core.usecase.vaccine.VaccineRepositoryInterface;

import java.io.Serializable;
import java.util.List;

public class FindAllVaccineUseCase implements FindAllVaccineUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private VaccineRepositoryInterface repository;

    public FindAllVaccineUseCase(VaccineRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Vaccine> execute() throws Exception {
        return repository.findAll();
    }
}
