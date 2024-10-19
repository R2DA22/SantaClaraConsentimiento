package infrastructure.repository.area;

import core.domain.area.Area;
import core.domain.area.AreaList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaMapper  implements MapperInterface, Serializable {
    private static final long serialVersionUID = 1L;


    public AreaMapper() {
    }

    @Override
    public List<Area> toDomain(ResultSet result)  throws Exception{
        Area area;
        List<Area> list = new ArrayList<>();
        while (result.next()) {
            area = new Area();
            area.setName(result.getString("nombre"));
            area.setId(result.getInt("id_area"));
            list.add(area);
        }
        return list;
    }
}
