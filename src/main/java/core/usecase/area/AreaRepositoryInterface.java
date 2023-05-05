package core.usecase.area;

import core.domain.area.Area;
import core.domain.area.AreaList;
import java.util.List;


public interface AreaRepositoryInterface {

    List<Area> findAll() throws Exception;
}
