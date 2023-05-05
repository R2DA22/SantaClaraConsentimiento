package infrastructure.platform;

import core.domain.Consulta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.domain.patient.Guardian;
import core.domain.area.Area;
import core.domain.Consentimiento;
import core.domain.patient.DocumentType;
import core.domain.speciality.Speciality;
import core.domain.patient.Patient;
import core.domain.process.Process;
import core.domain.professional.Professional;
import core.domain.vaccine.Vaccine;
import org.primefaces.json.JSONException;
import utilidades.Constantes;

/**
 * @author diego.ramirez
 */
public class ConfiguracionDAO {

    private final Connection conexion;

    public ConfiguracionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Process> cargarProcedimientos(Area area) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        List<Process> lista = new ArrayList<>();
        try {
            consulta = new Consulta(this.conexion);
            if (area != null) {
                String sql = "SELECT  id_procedimiento,descripcion \n"
                        + "FROM procedimiento where id_area=" + (area.getId() != null ? area.getId() : 0) + " order by id_procedimiento";
                resultSet = consulta.ejecutar(sql);
                Process procedimiento;
                while (resultSet.next()) {
                    procedimiento = new Process();
                    procedimiento.setDescription(resultSet.getString("descripcion"));
                    procedimiento.setIdProcess(resultSet.getInt("id_procedimiento"));
                    lista.add(procedimiento);
                }
                Process otroProcedimiento = new Process();
                otroProcedimiento.setIdProcess(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO));
                otroProcedimiento.setDescription("Otro");
                lista.add(otroProcedimiento);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
        return lista;
    }

    public List<Area> cargarAreas() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        List<Area> lista = new ArrayList<>();
        try {
            consulta = new Consulta(this.conexion);
            String sql = "SELECT  id_area,nombre \n"
                    + "FROM area where activo order by id_area";
            resultSet = consulta.ejecutar(sql);
            Area area;
            while (resultSet.next()) {
                area = new Area();
                area.setName(resultSet.getString("nombre"));
                area.setId(resultSet.getInt("id_area"));
                lista.add(area);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
        return lista;
    }


    public List<Speciality> cargarEspecialidades() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            List<Speciality> lista = new ArrayList();
            String sql = "SELECT id_especialidad,descripcion FROM especialidad";
            resultSet = consulta.ejecutar(sql);
            while (resultSet.next()) {
               
                lista.add(new Speciality(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
    }

    public List<Vaccine> cargarVacunas() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            List<Vaccine> lista = new ArrayList();
            String sql = "SELECT id_vacuna,nombre FROM vacuna";
            resultSet = consulta.ejecutar(sql);
            Vaccine vacuna;
            while (resultSet.next()) {
                vacuna = new Vaccine();
                vacuna.setId(resultSet.getInt("id_vacuna"));
                vacuna.setName(resultSet.getString("nombre"));
                lista.add(vacuna);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
    }

    public String cargarConfiguracion(String parametro) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            String sql = "SELECT valor  FROM configuracion   WHERE parametro ='" + parametro + "'";
            resultSet = consulta.ejecutar(sql);
            while (resultSet.next()) {
                valor = resultSet.getString("valor");
            }
            return valor;
        } catch (JSONException e) {
            return null;
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
    }

    public void guardarConsentimientoInformado(Consentimiento datos, String tipoFormulario) throws SQLException {
        Consulta consulta = null;
        try {

            consulta = new Consulta(this.conexion);
            String sql = "INSERT INTO public.consentimiento(\n"
                    + "	id_tipo_documento, documento, riesgo_beneficio, tratamiento_datos, "
                    + "     nro_admision,nro_registro, otro_procedimiento, id_tipo_documento_acudiente, documento_acudiente,"
                    + "     edad,eps,sintomas,ocupacion,telefono,contacto_covid,trabajo_salud,viajes_realizados,fecha_inicio_covid,"
                    + "     id_vacuna,fecha_vacuna,nro_dosis,email,tipo_formulario,tiene_sintomas,viajes,desiente)\n"
                    + "	VALUES (" + datos.getPaciente().getDocumentType().getId() + ","
                    + " '" + datos.getPaciente().getDocumentNumber() + "',"
                    + (datos.getRiesgoBeneficio() ? "true" : "false") + ", " + (datos.getTratamientoDatos() ? "true" : "false") + ","
                    + (datos.getNroAdmision() != null ? datos.getNroAdmision() : "null") + ","
                    + (datos.getProfesional().getRegistryNumber() != null ? datos.getProfesional().getRegistryNumber() : "null") + ","
                    + (datos.getProcedimiento() != null && datos.getProcedimiento().contains(new Process(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO))) ? "'" + datos.getOtroProcedimiento() + "'" : "null") + ", "
                    + (datos.getPaciente().getGuardian() != null && datos.getPaciente().getGuardian().getDocumentType() != null ? datos.getPaciente().getGuardian().getDocumentType().getId() : "null") + ","
                    + (datos.getPaciente().getGuardian() != null && datos.getPaciente().getGuardian().getDocumentNumber() != null ? "'" + datos.getPaciente().getGuardian().getDocumentNumber() + "'" : "null") + ","
                    + (datos.getEdad() != null ? datos.getEdad() : "null") + ","
                    + (datos.getEPS() != null ? "'" + datos.getEPS() + "'" : "null") + ","
                    + (datos.getDescripcionSintomas() != null ? "'" + datos.getDescripcionSintomas() + "'" : "null") + ","
                    + (datos.getOcupacion() != null ? "'" + datos.getOcupacion() + "'" : "null") + ","
                    + (datos.getTelefono() != null ? "'" + datos.getTelefono() + "'" : "null") + ","
                    + (datos.getContactoCovid() != null ? datos.getContactoCovid() : "null") + ","
                    + (datos.getTrabajadorSalud() != null ? datos.getTrabajadorSalud() : "null") + ","
                    + (datos.getViajesRealizados() != null ? "'" + datos.getViajesRealizados() + "'" : "null") + ","
                    + (datos.getFechaInicioSintomas() != null ? "'" + datos.getFechaInicioSintomas("yyyy-MM-dd") + "'" : "null") + ","
                    + (datos.getVacuna() != null ? datos.getVacuna().getId() : "null") + ","
                    + (datos.getFechaVacuna() != null ? "'" + datos.getFechaVacuna("yyyy-MM-dd") + "'" : "null") + ","
                    + ((datos.getNroDosis() != null && datos.getNroDosis()>0)? datos.getNroDosis() : "null") + ","
                    + (datos.getEmail() != null ? "'" + datos.getEmail() + "'" : "null") + ","
                    + "'" + tipoFormulario + "',"
                    + (datos.getSintomas() != null ? datos.getSintomas() : "null") + ","
                    + (datos.getViajes() != null ? datos.getViajes() : "null")+ ","
                    + (datos.getDisiente()!= null ? datos.getDisiente(): "null")
                    + ") returning id_consentimiento;";
            ResultSet resultado = consulta.ejecutar(sql);

            if (resultado.next()) {
                for (Process procedure : datos.getProcedimiento()) {
                    sql = "Insert into public.consentimiento_procedimiento(id_consentimiento,id_procedimiento) values (" + resultado.getInt("id_consentimiento") + "," + procedure.getIdProcess() + ")";
                    consulta.actualizar(sql);
                }
                for (Area area : datos.getLstArea()) {
                    sql = "Insert into public.consentimiento_area(id_consentimiento,id_area) values (" + resultado.getInt("id_consentimiento") + "," + area.getId() + ")";
                    consulta.actualizar(sql);
                }
                for (Process desentimiento : datos.getDesentimientos()) {
                    sql = "Insert into public.consentimiento_desentimiento(id_consentimiento,id_procedimiento) values (" + resultado.getInt("id_consentimiento") + "," + desentimiento.getIdProcess() + ")";
                    consulta.actualizar(sql);
                }
            }
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public String guardarPaciente(Patient paciente) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarPaciente(paciente.getDocumentType().getId(), paciente.getDocumentNumber()) == null) {
                String sql = "INSERT INTO public.paciente(\n"
                        + "	id_tipo_documento, documento, nombre)\n"
                        + "	VALUES (" + paciente.getDocumentType().getId() + ","
                        + " '" + paciente.getDocumentNumber() + "',"
                        + "'" + paciente.getName() + "');";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.paciente set nombre='" + paciente.getName() + "'"
                        + " where id_tipo_documento=" + paciente.getDocumentType().getId() + " "
                        + " and documento='" + paciente.getDocumentNumber() + "'";
                consulta.actualizar(sql);
            }
            return valor;
        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }
    
    public String guardarProfesional(Professional profesional) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarProfesional(profesional.getDocumentType().getId(), profesional.getDocumentNumber()) == null) {
                String sql = "INSERT INTO public.profesional(\n"
                        + "	id_tipo_documento, documento, nombre,nro_registro,firma,id_especialidad)\n"
                        + "	VALUES (" + profesional.getDocumentType().getId() + ","
                        + " '" + profesional.getDocumentNumber() + "',"
                        + "'" + profesional.getName() + "'," + profesional.getRegistryNumber()+ ",'" + profesional.getSignature()+ "',"+profesional.getSpecialty().getId()+");";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.profesional set nombre='" + profesional.getName() + "',firma='"+ profesional.getSignature()+ "',"
                        + " nro_registro="+profesional.getRegistryNumber()+",id_especialidad= "+profesional.getSpecialty().getId()
                        + " where id_tipo_documento=" + profesional.getDocumentType().getId() + " "
                        + " and documento='" + profesional.getDocumentNumber() + "'";
                consulta.actualizar(sql);
            }
            return valor;
        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public String guardarAcudiente(Guardian acudiente) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarPaciente(acudiente.getDocumentType().getId(), acudiente.getDocumentNumber()) == null) {
                String sql = "INSERT INTO public.paciente(\n"
                        + "	id_tipo_documento, documento, nombre)\n"
                        + "	VALUES (" + acudiente.getDocumentType().getId() + ","
                        + " '" + acudiente.getDocumentNumber() + "',"
                        + "'" + acudiente.getName() + "');";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.paciente set nombre='" + acudiente.getName() + "'"
                        + " where id_tipo_documento=" + acudiente.getDocumentType().getId() + " "
                        + " and documento='" + acudiente.getDocumentNumber() + "'";
                consulta.actualizar(sql);
            }
            return valor;
        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public Process guardarProcedimiento(Process procedimiento) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        ResultSet result;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            String sql = "INSERT INTO public.procedimiento(descripcion,id_area)\n"
                    + "	VALUES ("
                    + "'" + procedimiento.getDescription() + "'," + procedimiento.getArea().getId() + ") returning id_procedimiento;";
            result = consulta.ejecutar(sql);
            if (result.next()) {
                procedimiento.setIdProcess(result.getInt("id_procedimiento"));
            }

        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
        return procedimiento;
    }

    public List<Process> procesarProcedimientos(List<String> procList, Area area) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        Process procedimiento;
        List<Process> lstProcedimiento = new ArrayList();
        try {
            consulta = new Consulta(this.conexion);
            for (String nombreProcedimiento : procList) {
                procedimiento = consultarProcedimiento(nombreProcedimiento);
                if (procedimiento == null) {
                    procedimiento = new Process();
                    procedimiento.setArea(area);
                    procedimiento.setDescription(nombreProcedimiento.toLowerCase().replaceAll("^\\w",nombreProcedimiento.toUpperCase().substring(0,1)));
                    guardarProcedimiento(procedimiento);
                }
                lstProcedimiento.add(procedimiento);
            }
        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
        return lstProcedimiento;
    }

    public Process consultarProcedimiento(String nombre) throws SQLException {
        Consulta consulta = null;
        Process procedimiento = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "select * from procedimiento where upper(descripcion) ='" + nombre.toUpperCase() + "'";
            ResultSet result = consulta.ejecutar(sql);
            if (result.next()) {
                procedimiento = new Process(result.getInt("id_procedimiento"));
                procedimiento.setDescription(result.getString("descripcion"));
            }
        } catch (JSONException e) {
            return null;
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
        return procedimiento;
    }

    public Patient consultarPaciente(Integer tipoDocumento, String documento) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "SELECT * FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=" + tipoDocumento + " and documento ='" + documento + "'";
            resultSet = consulta.ejecutar(sql);
            Patient paciente = null;
            while (resultSet.next()) {
                paciente = new Patient();
                paciente.setDocumentNumber(resultSet.getString("documento"));
                paciente.setName(resultSet.getString("nombre"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_Documento"));
                doc.setInitials(resultSet.getString("inicial"));
                paciente.setDocumentType(doc);
            }
            return paciente;
        } catch (JSONException e) {
            return null;
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
    }

    public Professional consultarProfesional(Integer tipoDocumento, String documento) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "SELECT * FROM profesional p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " inner join especialidad e using (id_especialidad)"
                    + " WHERE id_tipo_documento=" + tipoDocumento + " and documento ='" + documento + "'";
            resultSet = consulta.ejecutar(sql);
            Professional profesional = null;
            while (resultSet.next()) {
                profesional = new Professional();
                profesional.setDocumentNumber(resultSet.getString("documento"));
                profesional.setName(resultSet.getString("nombre"));
                profesional.setRegistryNumber(resultSet.getInt("nro_registro"));
                profesional.setSpecialty(new Speciality(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
                profesional.setSignature(resultSet.getString("firma"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_Documento"));
                doc.setInitials(resultSet.getString("inicial"));
                profesional.setDocumentType(doc);
            }
            return profesional;
        } catch (JSONException e) {
            return null;
        } finally {
            if (resultSet != null && consulta != null) {
                resultSet.close();
                consulta.desconectar();
            }
        }
    }

}
