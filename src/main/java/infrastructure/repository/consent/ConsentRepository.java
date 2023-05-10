package infrastructure.repository.consent;

import core.domain.consent.ConsentVIH;
import core.domain.consent.VIHData;
import core.domain.sickness.SicknessList;
import core.usecase.consent.ConsentRepositoryInterface;
import infrastructure.repository.ClientDB;
import java.sql.ResultSet;


public class ConsentRepository implements ConsentRepositoryInterface {
    private ClientDB db;
    private ConsentMapperInterface mapper;

    public ConsentRepository(ClientDB sql,ConsentMapperInterface mapper ) {
        this.mapper=mapper;
        this.db = sql;
    }

    @Override
    public void createVIHConsent(ConsentVIH consent) throws Exception {
        db.createVIHConsent(consent);
    }

    @Override
    public Integer findNextId() throws Exception {
        return db.findNextId();
    }

    @Override
    public ConsentVIHDTO findVIHData(VIHData filter) throws Exception {
        ResultSet resultSet=db.findVIHData(filter);
        return mapper.toConsentVIH(resultSet);
    }

    @Override
    public SicknessList findSicknessVIHData(int id) throws Exception {
        ResultSet resultSet=db.findSicknessVIHData(id);
        return mapper.toSicknessList(resultSet);
    }

    @Override
    public void updateVIHConsent(int id) throws Exception {
        db.updateVIHConsent(id);
    }
}
