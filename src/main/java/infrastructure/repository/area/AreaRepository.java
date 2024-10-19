package infrastructure.repository.area;

import core.domain.area.Area;
import core.usecase.area.AreaRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class AreaRepository implements AreaRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ClientDB dataBase;

    private MapperInterface mapper;

    public AreaRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public List<Area> findAll() throws Exception {
        ResultSet result=dataBase.findAllAreas();
        return mapper.toDomain(result);
    }
}
