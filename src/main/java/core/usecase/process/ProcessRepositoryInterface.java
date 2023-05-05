package core.usecase.process;


import core.domain.process.Process;

import java.util.List;

public interface ProcessRepositoryInterface {
    List<Process> findByArea(String idArea) throws Exception;

    void create(Process process) throws Exception;

    Process findByName(String name)throws Exception;
}
