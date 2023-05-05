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

import java.sql.ResultSet;
import java.util.List;

public class Postgresql extends DataBaseManager implements ClientDB {

    public Postgresql() throws Exception {
        super();
    }

    @Override
    public ResultSet getAllDocumentTypes() throws Exception {
        ResultSet resultSet;
        try {
            this.openConnection();
            String sql = "SELECT id_tipo_documento,tipo_documento,inicial FROM tipo_Documento";
            resultSet = this.execute(sql);
            return resultSet;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findPatient(Integer idType, String id) throws Exception {
        ResultSet resultSet;
        try {
            this.openConnection();
            String sql = "SELECT * FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=" + idType + " and documento ='" + id + "'";
            resultSet = this.execute(sql);
            return resultSet;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createPatient(Patient patient) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.paciente(id_tipo_documento, documento, nombre)"
                    + "	VALUES (" + patient.getDocumentType().getId() + "," + " '" + patient.getDocumentNumber() + "',"
                    + "'" + patient.getName() + "');";
            this.update(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updatePatient(Patient patient) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE public.paciente SET nombre='" + patient.getName() + "'"
                    + " WHERE id_tipo_documento=" + patient.getDocumentType().getId() + " "
                    + " AND documento='" + patient.getDocumentNumber() + "'";
            this.update(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findGuardian(Integer idType, String id) throws Exception {
        ResultSet resultSet;
        try {
            this.openConnection();
            String sql = "SELECT * FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=" + idType + " and documento ='" + id + "'";
            resultSet = this.execute(sql);
            return resultSet;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createGuardian(Guardian guardian) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.paciente(id_tipo_documento, documento, nombre)"
                    + "	VALUES (" + guardian.getDocumentType().getId() + ","
                    + " '" + guardian.getDocumentNumber() + "',"
                    + "'" + guardian.getName() + "');";
            this.update(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateGuardian(Guardian guardian) throws Exception {
        try {
            this.openConnection();
            String sql = "UPDATE public.paciente SET nombre='"
                    + guardian.getName() + "'" + " WHERE id_tipo_documento="
                    + guardian.getDocumentType().getId() + " " + " AND documento='"
                    + guardian.getDocumentNumber() + "'";
            this.update(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public Integer findNextId() throws Exception {
        try {
            this.openConnection();
            String sql = "select max(id_consentimiento) +1 id from public.consentimiento";
            ResultSet result = this.execute(sql);
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
            String sql = "SELECT valor  FROM configuracion   WHERE parametro ='" + parameterName + "'";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllSpeciality() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT id_especialidad,descripcion FROM especialidad";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllVaccine() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT id_vacuna,nombre FROM vacuna";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findAllAreas() throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT  id_area,nombre FROM area where activo order by id_area";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProcessByArea(String idArea) throws Exception {
        try {
            this.openConnection();
            String sql = "SELECT  id_procedimiento,descripcion FROM procedimiento where " +
                    "id_area=" + (idArea != null ? idArea : 0) + " order by id_procedimiento";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet findProcessByName(String name) throws Exception {
        try {
            this.openConnection();
            String sql = "select * from procedimiento where upper(descripcion) ='" + name.toUpperCase() + "'";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ResultSet createProcess(Process process) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.procedimiento(descripcion,id_area) " +
                    "VALUES ( '" + process.getDescription() + "'," + process.getArea().getId() + ") returning id_procedimiento;";
            return this.execute(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void createProfessional(Professional professional) throws Exception {
        try {
            this.openConnection();
            String sql = "INSERT INTO public.profesional(\n"
                    + "	id_tipo_documento, documento, nombre,nro_registro,firma,id_especialidad)\n"
                    + "	VALUES (" + professional.getDocumentType().getId() + ","
                    + " '" + professional.getDocumentNumber() + "',"
                    + "'" + professional.getName() + "'," + professional.getRegistryNumber() + ",'"
                    + professional.getSignature() + "'," + professional.getSpecialty().getId() + ")";
            this.update(sql);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateProfessional(Professional professional) throws Exception {
        try {
            this.openConnection();
            String sql =
                    "update public.profesional set nombre='" + professional.getName() + "',firma='" + professional.getSignature() + "',"
                            + " nro_registro=" + professional.getRegistryNumber() + ",id_especialidad= " +
                            professional.getSpecialty().getId()
                            + " where id_tipo_documento=" + professional.getDocumentType().getId() + " "
                            + " and documento='" + professional.getDocumentNumber() + "'";
            this.update(sql);
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
                    + " WHERE id_tipo_documento=" + idType + " and documento ='" + id + "'";
            return this.execute(sql);
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
                            + "	VALUES (false,false," + consent.getId() + ","
                            + "'" + consent.getTypeConsent()
                            + "'," + consent.getPatient().getDocumentType().getId() + ","
                            + "'" + consent.getPatient().getDocumentNumber()
                            + "'," + (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : "null")
                            + "," + (consent.isGuardian() ? "'" + consent.getDocumentGuardian() + "'" : "null")
                            + "," + "'" + consent.getEPSPatient() + "'" + ");";
            this.update(sql);
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
                            + "	VALUES (" + consent.getRiskBenefit() + "," + consent.getDataTreatment() + "," + consent.getId() + ","
                            + "'" + consent.getTypeConsent() + "'"
                            + "," + consent.getPatient().getDocumentType().getId() + ","
                            + "'" + consent.getPatient().getDocumentNumber() + "'"
                            + "," + (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : "null")
                            + "," + (consent.isGuardian() ? "'" + consent.getDocumentGuardian() + "'" : "null")
                            + "," + consent.getProfessional().getRegistryNumber()
                            + "," + consent.getPatient().getAdmissionNumber()
                            + ",'" + consent.getAnotherProcesses() + "'"
                            + ");";
            this.update(sql);
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
                            " nro_dosis"
                            + " )"
                            + "	VALUES (" + consent.getRiskBenefit() + "," + consent.getDataTreatment() + "," + consent.getId() + ","
                            + "'" + consent.getTypeConsent() + "'"
                            + "," + consent.getPatient().getDocumentType().getId() + ","
                            + "'" + consent.getPatient().getDocumentNumber() + "'"
                            + "," + (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : "null")
                            + "," + (consent.isGuardian() ? "'" + consent.getDocumentGuardian() + "'" : "null")
                            + ",'" + consent.getEPSPatient() + "'"
                            + ",'" + consent.getPatient().getPhoneNumber() + "'"
                            + ",'" + consent.getPatient().getEmail() + "'"
                            + ",'" + consent.getPatient().getAge() + "'"
                            + ",'" + consent.getPatient().getOccupation() + "'"
                            + "," + consent.getHadContactCovid()
                            + "," + consent.getHaveWorkInHealth()
                            + "," + (consent.getHasSymptoms() ? "'" + consent.getDescriptionOfSymptoms() + "'" : "null")
                            + "," + consent.getHasSymptoms()
                            + "," + (consent.getHasSymptoms() ? "'" + consent.getSymptomsStartDate("yyyy-MM-dd") + "'" : "null")
                            + "," + (consent.getHadTrips() ? "'" + consent.getTripsMade() + "'" : "null")
                            + "," + consent.getHadTrips()
                            + "," + (consent.getVaccinated() ? "'" + consent.getDateVaccine("yyyy-MM-dd") + "'" : "null")
                            + "," + (consent.getVaccinated() ? consent.getVaccine().getId() : "null")
                            + "," + (consent.getVaccinated() ? consent.getDoseNumber() : "null")
                            + ");";
            this.update(sql);
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
                            + " )"
                            + "	VALUES (" + consent.getRiskBenefit() + "," + consent.getDataTreatment() + "," + consent.getId() + ","
                            + "'" + consent.getTypeConsent() + "'"
                            + "," + consent.getPatient().getDocumentType().getId() + ","
                            + "'" + consent.getPatient().getDocumentNumber() + "'"
                            + "," + (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : "null")
                            + "," + (consent.isGuardian() ? "'" + consent.getDocumentGuardian() + "'" : "null")
                            + "," + consent.getProfessional().getRegistryNumber()
                            + ");";
            this.update(sql);
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
                            + "	VALUES (" + consent.getRiskBenefit() + "," + consent.getDataTreatment() + "," + consent.getId() + ","
                            + "'" + consent.getTypeConsent() + "'"
                            + "," + consent.getPatient().getDocumentType().getId() + ","
                            + "'" + consent.getPatient().getDocumentNumber() + "'"
                            + "," + (consent.isGuardian() ? consent.getIdTypeDocumentGuardian() : "null")
                            + "," + (consent.isGuardian() ? "'" + consent.getDocumentGuardian() + "'" : "null")
                            + ",'" + consent.getPatient().getAge() + "'"
                            + "," + consent.getHadContactCovid()
                            + "," + consent.getHasSymptoms()
                            + "," + consent.getHadTrips()
                            + ");";
            this.update(sql);
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
                        "values (" + consentId + "," + procedure.getIdProcess() + ")";
                this.update(sql);
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
                        "values (" + consentId + "," + area.getId() + ")";
                this.update(sql);
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
                        "values (" + consentId + "," + dissent.getIdProcess() + ")";
                this.update(sql);
            }
        } finally {
            this.closeConnection();
        }
    }


}
