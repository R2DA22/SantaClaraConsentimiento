package infrastructure.repository.professional;

import core.domain.patient.ListDocumentType;
import core.domain.professional.Professional;
import core.domain.professional.ProfessionalList;
import core.usecase.professional.ProfessionalRepositoryInterface;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.ResultSet;

public class ProfessionalRepository implements ProfessionalRepositoryInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private ClientDB dataBase;
    private MapperInterface mapper;

    public ProfessionalRepository(ClientDB dataBase, MapperInterface mapper) {
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public void create(Professional professional) throws Exception {
        dataBase.createProfessional(professional);
    }

    @Override
    public void update(Professional professional) throws Exception {
        dataBase.updateProfessional(professional);
    }

    @Override
    public Professional find(Integer idType, String id) throws Exception {
        ResultSet resultSet = dataBase.findProfessional(idType, id);
        return mapper.toDomain(resultSet);
    }

    @Override
    public Professional findBySpeciality(Integer SpecialityID) throws Exception {
        ResultSet resultSet = dataBase.findProfessionalBySpeciality(SpecialityID);
        return mapper.toDomain(resultSet);
    }

    @Override
    public ProfessionalList findAll() throws Exception {
        ResultSet resultSet = dataBase.findAllProfessional();
        ProfessionalList result = mapper.toDomainList(resultSet);
        return result;

    }
}
