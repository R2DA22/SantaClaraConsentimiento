package infrastructure.repository.process;

import core.domain.process.Process;

import java.sql.ResultSet;
import java.util.List;

public interface MapperInterface {

    List<Process> toDomainList(ResultSet resultSet) throws Exception;

    Process toDomain(ResultSet resultSet) throws Exception;
}
