package controlador;

import bd.ConfiguracionDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Area;
import modelo.Consentimiento;
import modelo.Documento;
import modelo.Especialidad;
import modelo.Paciente;
import modelo.Procedimiento;
import modelo.Profesional;
import modelo.Vacuna;

/**
 * @author carlosj
 */
public class GestorBD extends Gestor {

    public GestorBD() throws Exception {
        super();
    }

    public List<Procedimiento> cargarProcedimientos(Area area) throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarProcedimientos(area);
        } finally {
            this.cerrarConexion();
        }
    }

    public List<Area> cargarAreas() throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarAreas();
        } finally {
            this.cerrarConexion();
        }
    }

    public List<Documento> cargarTiposDocumentos() throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarTiposDocumentos();
        } finally {
            this.cerrarConexion();
        }
    }

    public List<Especialidad> cargarEspecialidades() throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarEspecialidades();
        } finally {
            this.cerrarConexion();
        }
    }

    public List<Vacuna> cargarVacunas() throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarVacunas();
        } finally {
            this.cerrarConexion();
        }
    }

    public String cargarConfiguracion(String parametro) throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.cargarConfiguracion(parametro);
        } finally {
            this.cerrarConexion();
        }
    }

    public String guardarConsentimientoInformado(Consentimiento datos, String tipoFormulario) throws Exception {
        String respuesta = "";
        try {
            this.abrirConexion();
            inicioTransaccion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            if (datos.getPaciente().getAcudiente().getTipoDocumento() != null) {
                configuracionDao.guardarAcudiente(datos.getPaciente().getAcudiente());
            }
            configuracionDao.guardarPaciente(datos.getPaciente());
//            if (datos.getLstArea()!=null) {
//                 datos.getProcedimiento().addAll(configuracionDao.procesarProcedimientos(datos.getArea().getLstProcedimientos(), datos.getArea()));
//                datos.getDesentimientos().forEach((Procedimiento desentimiento) -> {
//                    datos.getProcedimiento().stream().filter((procedimiento) -> (procedimiento.getDescripcion().equals(desentimiento.getDescripcion()))).forEachOrdered((procedimiento) -> {
//                        desentimiento.setIdProcedimiento(procedimiento.getIdProcedimiento());
//                    });
//                });
//                datos.getDesentimientos();
//            }
            if (datos.getArea() != null) {
                datos.getProcedimiento().addAll(configuracionDao.procesarProcedimientos(datos.getArea().getLstProcedimientos(), datos.getArea()));
                for (Procedimiento desentimiento : datos.getDesentimientos()) {
                    for (Procedimiento procedimiento : datos.getProcedimiento()) {
                        if (procedimiento.getDescripcion().equals(desentimiento.getDescripcion())) {
                            desentimiento.setIdProcedimiento(procedimiento.getIdProcedimiento());
                            break;
                        }
                    }
                }
                //datos.getDesentimientos();
            }
            configuracionDao.guardarConsentimientoInformado(datos, tipoFormulario);
            finTransaccion();
            respuesta = "OK";
        } catch (Exception ex) {
            devolverTransaccion();
            respuesta = null;
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public String guardarProfesional(Consentimiento datos) throws Exception {
        String respuesta = "";
        try {
            this.abrirConexion();
            inicioTransaccion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            configuracionDao.guardarProfesional(datos.getProfesional());
            finTransaccion();
            respuesta = "OK";
        } catch (Exception ex) {
            devolverTransaccion();
            respuesta = null;
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public Paciente consultarPaciente(int tipoDocumento, String documento) throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.consultarPaciente(tipoDocumento, documento);
        } finally {
            this.cerrarConexion();
        }
    }

    public Profesional consultarProfesional(int tipoDocumento, String documento) throws Exception {
        try {
            this.abrirConexion();
            ConfiguracionDAO configuracionDao = new ConfiguracionDAO(this.getConexion());
            return configuracionDao.consultarProfesional(tipoDocumento, documento);
        } finally {
            this.cerrarConexion();
        }
    }

}
