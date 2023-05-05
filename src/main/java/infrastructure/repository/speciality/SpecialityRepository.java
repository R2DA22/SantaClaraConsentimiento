package infrastructure.repository.speciality;

import core.domain.speciality.Speciality;
import core.domain.speciality.SpecialityList;
import core.usecase.speciality.SpecialityRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.sql.ResultSet;
import java.util.List;

public class SpecialityRepository implements SpecialityRepositoryInterface {

    private ClientDB dataBase;
    private MapperInterface mapper;

    public SpecialityRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public List<Speciality> findAll() throws Exception {
        ResultSet resultSet=dataBase.findAllSpeciality();
        return mapper.toDomain(resultSet);
    }
}
