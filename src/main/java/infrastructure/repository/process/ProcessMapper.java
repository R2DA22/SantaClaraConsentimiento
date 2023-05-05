package infrastructure.repository.process;

import core.domain.Consulta;
import core.domain.process.Process;
import utilidades.Constantes;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcessMapper implements MapperInterface {

    public ProcessMapper() {
    }

    @Override
    public List<Process> toDomainList(ResultSet resultSet) throws Exception {
        List<Process> list = new ArrayList<>();
        Process process;
        while (resultSet.next()) {
            process = new Process();
            process.setDescription(resultSet.getString("descripcion"));
            process.setIdProcess(resultSet.getInt("id_procedimiento"));
            list.add(process);
        }
        Process anotherProcess = new Process();
        anotherProcess.setIdProcess(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO));
        anotherProcess.setDescription("Otro");
        list.add(anotherProcess);
        return list;
    }

    @Override
    public Process toDomain(ResultSet result) throws Exception {
        if (result.next()) {
            Process process = new Process(result.getInt("id_procedimiento"));
            process.setDescription(result.getString("descripcion"));
            return process;
        }
        return null;
    }
}
