package infrastructure.repository.area;

import core.domain.area.Area;
import core.domain.area.AreaList;

import java.sql.ResultSet;
import java.util.List;

public interface MapperInterface {

    List<Area> toDomain(ResultSet result) throws Exception;
}
