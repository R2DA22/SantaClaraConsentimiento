package infrastructure.repository.process;

import core.domain.process.Process;
import core.usecase.process.ProcessRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class ProcessRepository implements ProcessRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;


    private ClientDB dataBase;
    private MapperInterface mapper;

    public ProcessRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public List<Process> findByArea(String idArea) throws Exception {
        ResultSet resultSet = dataBase.findProcessByArea(idArea);
        return mapper.toDomainList(resultSet);
    }

    @Override
    public void create(Process process) throws Exception {
        ResultSet resultSet = dataBase.createProcess(process);
        process.setIdProcess(resultSet.getInt("id_procedimiento"));
    }

    @Override
    public Process findByName(String name) throws Exception {
        ResultSet result = dataBase.findProcessByName(name);
        return mapper.toDomain(result);
    }
}
