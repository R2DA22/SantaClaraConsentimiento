package core.usecase.area.find;

import core.domain.area.Area;
import core.domain.area.AreaList;
import java.util.List;


public interface FindAllAreaUseCaseInterface {
    List<Area> execute() throws Exception;
}
