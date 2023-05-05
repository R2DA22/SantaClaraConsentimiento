package infrastructure.platform.controlador;

import infrastructure.platform.ConfiguracionDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import core.domain.area.Area;
import core.domain.Consentimiento;
import core.domain.speciality.Speciality;
import core.domain.process.Process;
import core.domain.professional.Professional;
import core.domain.vaccine.Vaccine;
import infrastructure.platform.postgresql.DataBaseManager;

/**
 * @author diego.ramirez
 */
public class GestorBD extends DataBaseManager {

    public GestorBD() throws Exception {
        super();
    }

    public List<Process> cargarProcedimientos(Area area) throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.cargarProcedimientos(area);
        } finally {
            this.closeConnection();
        }
    }

    public List<Area> cargarAreas() throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.cargarAreas();
        } finally {
            this.closeConnection();
        }
    }


    public List<Speciality> cargarEspecialidades() throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.cargarEspecialidades();
        } finally {
            this.closeConnection();
        }
    }

    public List<Vaccine> cargarVacunas() throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.cargarVacunas();
        } finally {
            this.closeConnection();
        }
    }

    public String cargarConfiguracion(String parametro) throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.cargarConfiguracion(parametro);
        } finally {
            this.closeConnection();
        }
    }

    public String guardarConsentimientoInformado(Consentimiento datos, String tipoFormulario) throws Exception {
        String respuesta = "";
        try {
            this.openConnection();
            begin();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            if (datos.getPaciente().getGuardian().getDocumentType() != null) {
                configuracionDao.guardarAcudiente(datos.getPaciente().getGuardian());
            }
            configuracionDao.guardarPaciente(datos.getPaciente());
            if (datos.getArea() != null) {
                datos.getProcedimiento().addAll(configuracionDao.procesarProcedimientos(datos.getArea().getProcess(), datos.getArea()));
                for (Process desentimiento : datos.getDesentimientos()) {
                    for (Process procedimiento : datos.getProcedimiento()) {
                        if (procedimiento.getDescription().equals(desentimiento.getDescription())) {
                            desentimiento.setIdProcess(procedimiento.getIdProcess());
                        }
                    }
                }
                datos.getDesentimientos();
            }
            configuracionDao.guardarConsentimientoInformado(datos, tipoFormulario);
            commit();
            respuesta = "OK";
        } catch (Exception ex) {
            rollback();
            respuesta = null;
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return respuesta;
    }

    public String guardarProfesional(Consentimiento datos) throws Exception {
        String respuesta = "";
        try {
            this.openConnection();
            begin();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            configuracionDao.guardarProfesional(datos.getProfesional());
            commit();
            respuesta = "OK";
        } catch (Exception ex) {
            rollback();
            respuesta = null;
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return respuesta;
    }



    public Professional consultarProfesional(int tipoDocumento, String documento) throws Exception {
        try {
            this.openConnection();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConnection());
            return configuracionDao.consultarProfesional(tipoDocumento, documento);
        } finally {
            this.closeConnection();
        }
    }

}
