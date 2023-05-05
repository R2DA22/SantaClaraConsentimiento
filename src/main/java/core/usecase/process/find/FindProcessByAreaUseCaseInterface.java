package core.usecase.process.find;

import core.domain.area.Area;
import core.domain.process.Process;

import java.util.List;

public interface FindProcessByAreaUseCaseInterface {

    List<Process> execute(Area idArea) throws Exception;
}
