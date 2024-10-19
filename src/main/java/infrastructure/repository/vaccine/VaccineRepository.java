package infrastructure.repository.vaccine;

import core.domain.vaccine.Vaccine;
import core.domain.vaccine.VaccineList;
import core.usecase.vaccine.VaccineRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class VaccineRepository implements VaccineRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ClientDB dataBase;
    private MapperInterface mapper;

    public VaccineRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public List<Vaccine> findAll() throws Exception {
        ResultSet resultSet=dataBase.findAllVaccine();
        return mapper.toDomain(resultSet);
    }
}
