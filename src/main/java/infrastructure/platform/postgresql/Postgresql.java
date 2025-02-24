package infrastructure.platform.postgresql;

import core.domain.consent.ConsentVIH;
import core.domain.consent.VIHData;
import core.domain.professional.Professional;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;
import core.domain.sickness.Sickness;
import infrastructure.repository.ClientDB;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Properties;

public class Postgresql extends DataBaseManager implements ClientDB, Serializable {
    private static final long serialVersionUID = 1L;


    public Postgresql(Properties properties) throws Exception {
        super(properties);
    }

    @Override
    public ResultSet getAllDocumentTypes() throws Exception {
        ResultSet resultSet;
        try {
            this.openConnection();
            String sql = "SELECT id_tipo_documento,tipo_documento,inicial FROM tipo_Documento";
            resultSet = this.getConnection().prepareStatement(sql).executeQuery();
            return resultSet;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findPatient(Integer idType, String id) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT extract(year from age(fecha_nacimiento)) edad,*"
                    + " FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=? and documento =?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, idType);
            ps.setString(2, id);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createPatient(Patient patient) throws Exception {
        try {
            this.openConnection();
            String query = "INSERT INTO paciente(id_tipo_documento, documento, nombre, fecha_nacimiento, masculino,estado_civil," +
                    "ciudad,direccion,telefono,escolaridad,esquema_social,ocupacion,email,eps,lugar_expedicion)" +
                    " VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(query);

            ps.setInt(1, patient.getDocumentType().getId());
            ps.setString(2, patient.getDocumentNumber());
            ps.setString(3, patient.getName());
            ps.setObject(4, patient.getBornDate(), Types.DATE);
            ps.setObject(5, patient.isGender(), Types.BOOLEAN);
            ps.setObject(6, patient.getMaritalStatus(), Types.VARCHAR);
            ps.setObject(7, patient.getCity(), Types.VARCHAR);
            ps.setObject(8, patient.getAddress(), Types.VARCHAR);
            ps.setObject(9, patient.getPhoneNumber(), Types.VARCHAR);
            ps.setObject(10, patient.getLevelOfStudy(), Types.VARCHAR);
            ps.setObject(11, patient.getSocialScheme(), Types.VARCHAR);
            ps.setObject(12, patient.getOccupation(), Types.VARCHAR);
            ps.setObject(13, patient.getEmail(), Types.VARCHAR);
            ps.setObject(14, patient.getEps(), Types.VARCHAR);
            ps.setObject(15, patient.getExpeditionPlace(), Types.VARCHAR);
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updatePatient(Patient patient) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE paciente SET " +
                    "fecha_nacimiento=?,nombre=?,masculino=?,estado_civil=?,ciudad=?,direccion=?," +
                    "telefono=?,escolaridad=?,esquema_social=?,ocupacion=?,email=?,eps=?,lugar_expedicion=?"
                    + " WHERE id_tipo_documento=? AND documento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setObject(1, patient.getBornDate(), Types.DATE);
            ps.setString(2, patient.getName());
            ps.setObject(3, patient.isGender(), Types.BOOLEAN);
            ps.setObject(4, patient.getMaritalStatus(), Types.VARCHAR);
            ps.setObject(5, patient.getCity(), Types.VARCHAR);
            ps.setObject(6, patient.getAddress(), Types.VARCHAR);
            ps.setObject(7, patient.getPhoneNumber(), Types.VARCHAR);
            ps.setObject(8, patient.getLevelOfStudy(), Types.VARCHAR);
            ps.setObject(9, patient.getSocialScheme(), Types.VARCHAR);
            ps.setObject(10, patient.getOccupation(), Types.VARCHAR);
            ps.setString(11, patient.getEmail());
            ps.setString(12, patient.getEps());
            ps.setString(13, patient.getExpeditionPlace());

            ps.setInt(14, patient.getIdTypeDocument());
            ps.setString(15, patient.getDocumentNumber());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findGuardian(Integer idType, String id) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT *"
                    + " FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=? and documento =?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, idType);
            ps.setString(2, id);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createGuardian(Guardian guardian) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.paciente(id_tipo_documento, documento, nombre, lugar_expedicion)"
                    + "	VALUES (?,?,?,?);";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, guardian.getIdTypeDocument());
            ps.setString(2, guardian.getDocumentNumber());
            ps.setString(3, guardian.getName());
            ps.setObject(4, guardian.getExpeditionPlace(), Types.VARCHAR);

            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateGuardian(Guardian guardian) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE public.paciente SET nombre=?,lugar_expedicion=?" +
                    " WHERE id_tipo_documento=? AND documento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, guardian.getName());
            ps.setString(2, guardian.getExpeditionPlace());
            ps.setInt(3, guardian.getIdTypeDocument());
            ps.setString(4, guardian.getDocumentNumber());

            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public Integer findNextId() throws Exception {
        try {
            this.openConnection();
            String sql = "select max(id_consentimiento) +1 id from consentimiento";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return result.getInt("id");
            }
        } finally {
            this.closeConnection();
        }
        return null;
    }

    @Override
    public ResultSet findConfiguration(String parameterName) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT valor  FROM configuracion   WHERE parametro =?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, parameterName);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllSpeciality() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT id_especialidad,descripcion FROM especialidad";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllVaccine() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT id_vacuna,nombre FROM vacuna";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllAreas() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT  id_area,nombre FROM area where activo order by id_area";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProcessByArea(String idArea) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT  id_procedimiento,descripcion FROM procedimiento where " +
                    "id_area=? order by id_procedimiento";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, 0);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProcessByName(String name) throws Exception {
        try {
            this.openConnection();
            String sql = "select * from procedimiento where upper(descripcion) =?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet createProcess(Process process) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.procedimiento(descripcion,id_area) " +
                    "VALUES ( ?,?) returning id_procedimiento;";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, process.getDescription());
            ps.setInt(2, process.getArea().getId());
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createProfessional(Professional professional) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.profesional("
                    + "	id_tipo_documento, documento, nombre, nro_registro, firma, id_especialidad)"
                    + "	VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, professional.getDocumentType().getId());
            ps.setString(2, professional.getDocumentNumber());
            ps.setString(3, professional.getName());
            ps.setInt(4, professional.getRegistryNumber());
            ps.setString(5, professional.getSignature());
            ps.setInt(6, professional.getSpecialty().getId());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateProfessional(Professional professional) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "update profesional set nombre=?,firma=?,"
                            + " nro_registro=?,id_especialidad=?"
                            + " where id_tipo_documento=?"
                            + " and documento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, professional.getName());
            ps.setString(2, professional.getSignature());
            ps.setInt(3, professional.getRegistryNumber());
            ps.setInt(4, professional.getSpecialty().getId());
            ps.setInt(5, professional.getDocumentType().getId());
            ps.setString(6, professional.getDocumentNumber());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProfessional(Integer idType, String id) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT * FROM profesional p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " inner join especialidad e using (id_especialidad)"
                    + " WHERE id_tipo_documento=? and documento =?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, idType);
            ps.setString(2, id);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProfessionalBySpeciality(Integer specialityID) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT * FROM profesional p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " inner join especialidad e using (id_especialidad)"
                    + " WHERE id_especialidad=? and p.estado ";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, specialityID);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllProfessional() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT b.*,nombre, documento, nro_registro, firma,c.* \n" +
                    "FROM profesional \n" +
                    "inner join tipo_documento c using (id_tipo_documento)\n" +
                    "inner join especialidad b using (id_especialidad)\n" +
                    "WHERE estado";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createVIHConsent(ConsentVIH consent) throws Exception {
        try {
            this.openConnection();
            this.begin();
            String sql = "INSERT INTO consentimiento(riesgo_beneficio,tratamiento_datos,"
                    + " id_consentimiento,id_tipo_documento, documento, "
                    + "id_tipo_documento_acudiente, documento_acudiente)"
                    + "	VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, consent.getRiskBenefit());
            ps.setBoolean(2, consent.getDataTreatment());
            ps.setInt(3, consent.getId());
            ps.setInt(4, consent.getPatient().getDocumentType().getId());
            ps.setString(5, consent.getPatient().getDocumentNumber());
            ps.setObject(6, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(7, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.executeUpdate();
            createVIHData(consent);
            createSickness(consent.getId(), consent.getSicknessList());
            this.commit();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findVIHData(VIHData filter) throws Exception {
        try {
            this.openConnection();
            String sql = "select * from consentimiento a " +
                    "inner join consentimiento_vih b using (id_consentimiento)" +
                    "inner join profesional c " +
                    "inner join tipo_documento d on (c.id_tipo_documento=d.id_tipo_documento) " +
                    "inner join especialidad e on (c.id_especialidad=e.id_especialidad) " +
                    "on (c.id_tipo_documento=id_tipo_documento_profesional " +
                    "and c.documento=documento_profesional)" +
                    "where a.documento=? and a.id_tipo_documento=? and b.estado='P'";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, filter.getDocumentNumber());
            ps.setInt(2, filter.getDocumentType());
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findSicknessVIHData(int id) throws Exception {
        try {
            this.openConnection();
            String sql = "select * " +
                    "from consentimiento_enfermedad " +
                    "inner join enfermedad using (id_enfermedad)" +
                    "where id_consentimiento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateVIHConsent(int id, String filename) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE consentimiento_vih SET estado='F', filename=? "
                    + "	WHERE id_consentimiento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, filename);
            ps.setInt(2, id);
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    private void createVIHData(ConsentVIH consent) {
        try {
            String sql = "INSERT INTO public.consentimiento_vih(" +
                    "id_consentimiento, evento, captacion, conoce_vih, conoce_mst, " +
                    "conoce_prevencion, usa_condon, motivo, frecuencia, tipo_relacion_sexual, " +
                    "mecanismo_transmision, transfusion_site, reaccion_resultado, " +
                    "estado_paciente, test_obligatorio, motivo_test, estado," +
                    "id_tipo_documento_profesional, documento_profesional, filename, firma)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, consent.getId());
            ps.setString(2, consent.getEvent());
            ps.setString(3, consent.getCatchment());
            ps.setString(4, consent.getKnowledgeAboutHIV());
            ps.setBoolean(5, consent.isKnowledgeAboutMST());
            ps.setBoolean(6, consent.isPrevention());
            ps.setBoolean(7, consent.isUseCondom());
            ps.setString(8, (consent.isUseCondom() ? consent.getUseCondomReason() : consent.getNotUseCondomReason()));
            ps.setString(9, consent.getFrequency());
            ps.setBoolean(10, consent.isTypeOfSexualIntercourse());
            ps.setString(11, consent.getProbableTransmissionMechanism());
            ps.setString(12, consent.getTransfusionSite());
            ps.setString(13, consent.getPositiveResultReaction());
            ps.setString(14, consent.getMood());
            ps.setBoolean(15, consent.isTest());
            ps.setString(16, consent.getTestReason());
            ps.setString(17, "P");
            ps.setInt(18, consent.getProfessional().getDocumentType().getId());
            ps.setString(19, consent.getProfessional().getDocumentNumber());
            ps.setString(20, consent.getFileName());
            ps.setString(21, consent.getSignature());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createSickness(int id, List<Sickness> sicknessList) {
        try {
            for (Sickness sickness : sicknessList) {
                if (sickness.isSick()) {
                    String sql = "INSERT INTO consentimiento_enfermedad(id_consentimiento, id_enfermedad," +
                            "organo_compr,institucion_dx,fecha)"
                            + "	VALUES (?,?,?,?,?)";
                    PreparedStatement ps = this.getConnection().prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setInt(2, sickness.getId());
                    ps.setString(3, sickness.getOrganDescription());
                    ps.setString(4, sickness.getInstitutionDX());
                    ps.setObject(5, sickness.getSickDate(), Types.DATE);

                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

