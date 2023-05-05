package infrastructure.repository.guardian;

import core.domain.patient.Guardian;
import core.usecase.guardian.GuardianRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.sql.ResultSet;

public class GuardianRepository implements GuardianRepositoryInterface {

    private ClientDB db;

    private MapperInterface mapper;

    public GuardianRepository(ClientDB db, MapperInterface mapper) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public Guardian find(Integer idType, String id) throws Exception {
        ResultSet resultSet=db.findPatient(idType,id);
        return mapper.toDomain(resultSet);
    }

    @Override
    public void create(Guardian guardian) throws Exception {
        db.createGuardian( guardian);
    }

    @Override
    public void update(Guardian guardian) throws Exception  {
        db.updateGuardian(guardian);
    }



}
