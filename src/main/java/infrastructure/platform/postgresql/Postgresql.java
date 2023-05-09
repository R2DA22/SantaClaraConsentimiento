package infrastructure.platform.postgresql;

import core.domain.area.Area;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.ProcessConsent;
import core.domain.professional.Professional;
import core.domain.consent.EmergencyConsent;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;
import infrastructure.repository.ClientDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;
import java.util.Properties;

public class Postgresql extends DataBaseManager implements ClientDB {

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
                    "ciudad,direccion,telefono,escolaridad,esquema_social,ocupacion,email,eps)" +
                    " VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.getConnection().prepareStatement(query);

            ps.setInt(1, patient.getDocumentType().getId());
            ps.setString(2, patient.getDocumentNumber());
            ps.setString(3, patient.getName());
            ps.setObject(4, patient.getBornDate(), Types.DATE);
            ps.setObject(5, patient.isGender(), Types.BOOLEAN);
            ps.setObject(6, patient.getMaritalStatus(), Types.BOOLEAN);
            ps.setObject(7, patient.getCity(), Types.VARCHAR);
            ps.setObject(8, patient.getAddress(), Types.VARCHAR);
            ps.setObject(9, patient.getPhoneNumber(), Types.VARCHAR);
            ps.setObject(10, patient.getLevelOfStudy(), Types.VARCHAR);
            ps.setObject(11, patient.getSocialScheme(), Types.VARCHAR);
            ps.setObject(12, patient.getOccupation(), Types.VARCHAR);
            ps.setObject(13, patient.getEmail(), Types.VARCHAR);
            ps.setObject(14, patient.getEps(), Types.VARCHAR);
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
                    "telefono=?,escolaridad=?,esquema_social=?,ocupacion=?,email=?,eps=?"
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

            ps.setInt(13, patient.getIdTypeDocument());
            ps.setString(14, patient.getDocumentNumber());
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
            String sql = "INSERT INTO public.paciente(id_tipo_documento, documento, nombre)"
                    + "	VALUES (?,?,?);";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(1, guardian.getIdTypeDocument());
            ps.setString(2, guardian.getDocumentNumber());
            ps.setString(3, guardian.getName());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateGuardian(Guardian guardian) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE public.paciente SET nombre=?" +
                    " WHERE id_tipo_documento=? AND documento=?";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setInt(2, guardian.getIdTypeDocument());
            ps.setString(3, guardian.getDocumentNumber());
            ps.setString(1, guardian.getName());
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
    public ResultSet findAllProfessional() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT nombre, documento, nro_registro, firma FROM profesional "
                    + " WHERE estado";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } finally {
            this.closeConnection();
        }
    }


    @Override
    public void createConsentEmergency(EmergencyConsent consent) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "INSERT INTO public.consentimiento(riesgo_beneficio,tratamiento_datos,"
                            + " id_consentimiento,tipo_formulario,id_tipo_documento, documento, "
                            + "id_tipo_documento_acudiente, documento_acudiente,eps)"
                            + "	VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setBoolean(2, false);
            ps.setInt(3, consent.getId());
            ps.setString(4, consent.getTypeConsent());
            ps.setInt(5, consent.getPatient().getDocumentType().getId());
            ps.setString(6, consent.getPatient().getDocumentNumber());
            ps.setObject(7, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(8, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.setString(9, consent.getEPSPatient());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createConsentProcess(ProcessConsent consent) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "INSERT INTO public.consentimiento(riesgo_beneficio,tratamiento_datos,"
                            + " id_consentimiento,tipo_formulario,id_tipo_documento, documento, "
                            + "id_tipo_documento_acudiente, documento_acudiente,nro_admision,"
                            + " nro_registro, otro_procedimiento)"
                            + "	VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, consent.getRiskBenefit());
            ps.setBoolean(2, consent.getDataTreatment());
            ps.setInt(3, consent.getId());
            ps.setString(4, consent.getTypeConsent());
            ps.setInt(5, consent.getPatient().getDocumentType().getId());
            ps.setString(6, consent.getPatient().getDocumentNumber());
            ps.setObject(7, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(8, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.setInt(9, consent.getProfessional().getRegistryNumber());
            ps.setString(10, consent.getPatient().getAdmissionNumber());
            ps.setString(11, consent.getAnotherProcesses());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }


    @Override
    public void createConsentCovid(CovidConsent consent) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "INSERT INTO public.consentimiento(riesgo_beneficio,tratamiento_datos,"
                            + " id_consentimiento,tipo_formulario,id_tipo_documento, documento, "
                            + "id_tipo_documento_acudiente, documento_acudiente,"
                            + "eps, telefono, email, edad, ocupacion, contacto_covid, trabajo_salud, sintomas," +
                            " tiene_sintomas, fecha_inicio_covid, viajes_realizados, viajes, fecha_vacuna, id_vacuna," +
                            " nro_dosis)	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, consent.getRiskBenefit());
            ps.setBoolean(2, consent.getDataTreatment());
            ps.setInt(3, consent.getId());
            ps.setString(4, consent.getTypeConsent());
            ps.setInt(5, consent.getPatient().getDocumentType().getId());
            ps.setString(6, consent.getPatient().getDocumentNumber());
            ps.setObject(7, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(8, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.setString(9, consent.getEPSPatient());
            ps.setString(10, consent.getPatient().getPhoneNumber());
            ps.setString(11, consent.getPatient().getEmail());
            ps.setInt(12, consent.getPatient().getAge());
            ps.setString(13, consent.getPatient().getOccupation());
            ps.setBoolean(14, consent.getHadContactCovid());
            ps.setBoolean(15, consent.getHaveWorkInHealth());
            ps.setObject(16, (consent.getHasSymptoms() ? consent.getDescriptionOfSymptoms() : null), Types.VARCHAR);
            ps.setBoolean(17, consent.getHasSymptoms());
            ps.setObject(18, (consent.getHasSymptoms() ? consent.getSymptomsStartDate("yyyy-MM-dd") : null), Types.VARCHAR);
            ps.setObject(19, (consent.getHadTrips() ? consent.getTripsMade() : null), Types.VARCHAR);
            ps.setBoolean(20, consent.getHadTrips());
            ps.setObject(21, (consent.getVaccinated() ? consent.getDateVaccine("yyyy-MM-dd") : null), Types.DATE);
            ps.setObject(22, (consent.getVaccinated() ? consent.getVaccine().getId() : null), Types.INTEGER);
            ps.setObject(23, (consent.getVaccinated() ? consent.getDoseNumber() : null), Types.INTEGER);
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void createDentalConsent(DentalConsent consent) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "INSERT INTO public.consentimiento(riesgo_beneficio,tratamiento_datos,"
                            + " id_consentimiento,tipo_formulario,id_tipo_documento, documento, "
                            + "id_tipo_documento_acudiente, documento_acudiente,"
                            + "nro_registro"
                            + " ) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, consent.getRiskBenefit());
            ps.setBoolean(2, consent.getDataTreatment());
            ps.setInt(3, consent.getId());
            ps.setString(4, consent.getTypeConsent());
            ps.setInt(5, consent.getPatient().getDocumentType().getId());
            ps.setString(6, consent.getPatient().getDocumentNumber());
            ps.setObject(7, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(8, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.setInt(9, consent.getProfessional().getRegistryNumber());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createDentalCovidConsent(DentalCovidConsent consent) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.consentimiento(riesgo_beneficio,tratamiento_datos,"
                    + " id_consentimiento,tipo_formulario,id_tipo_documento, documento, "
                    + "id_tipo_documento_acudiente, documento_acudiente,"
                    + "eps, contacto_covid," +
                    " tiene_sintomas, viajes)"
                    + "	VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setBoolean(1, consent.getRiskBenefit());
            ps.setBoolean(2, consent.getDataTreatment());
            ps.setInt(3, consent.getId());
            ps.setString(4, consent.getTypeConsent());
            ps.setInt(5, consent.getPatient().getDocumentType().getId());
            ps.setString(6, consent.getPatient().getDocumentNumber());
            ps.setObject(7, (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : null), Types.INTEGER);
            ps.setObject(8, (consent.isGuardian() ? consent.getDocumentGuardian() : null), Types.VARCHAR);
            ps.setInt(9, consent.getPatient().getAge());
            ps.setBoolean(10, consent.getHadContactCovid());
            ps.setBoolean(11, consent.getHasSymptoms());
            ps.setBoolean(12, consent.getHadTrips());
            ps.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createConsentProcedure(List<Process> processes, int consentId) throws Exception {
        try {
            this.openConnection();
            for (Process procedure : processes) {
                String sql = "Insert into public.consentimiento_procedimiento(id_consentimiento,id_procedimiento) " +
                        "values (?,?)";
                PreparedStatement ps = this.getConnection().prepareStatement(sql);
                ps.setInt(1, consentId);
                ps.setInt(2, procedure.getIdProcess());
                ps.executeUpdate();
            }
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createConsentArea(List<Area> areas, int consentId) throws Exception {
        try {
            this.openConnection();
            for (Area area : areas) {
                String sql = "Insert into public.consentimiento_area(id_consentimiento,id_area) " +
                        "values (?,?)";
                PreparedStatement ps = this.getConnection().prepareStatement(sql);
                ps.setInt(1, consentId);
                ps.setInt(2, area.getId());
                ps.executeUpdate();
            }
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createConsentDissent(List<Process> dissents, int consentId) throws Exception {
        try {
            this.openConnection();
            for (Process dissent : dissents) {
                String sql = "Insert into public.consentimiento_desentimiento(id_consentimiento,id_procedimiento) " +
                        "values (?,?)";
                PreparedStatement ps = this.getConnection().prepareStatement(sql);
                ps.setInt(1, consentId);
                ps.setInt(2, dissent.getIdProcess());
            }
        } finally {
            this.closeConnection();
        }
    }


}
