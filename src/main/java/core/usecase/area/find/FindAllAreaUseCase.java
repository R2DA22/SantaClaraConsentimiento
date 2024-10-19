package core.usecase.area.find;

import core.domain.area.Area;
import core.domain.area.AreaList;
import core.usecase.area.AreaRepositoryInterface;

import java.io.Serializable;
import java.util.List;

public class FindAllAreaUseCase implements FindAllAreaUseCaseInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private AreaRepositoryInterface repository;

    public FindAllAreaUseCase(AreaRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Area>  execute() throws Exception {
        return repository.findAll();
    }
}
