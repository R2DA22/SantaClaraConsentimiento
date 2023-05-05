package bd;

import modelo.Consulta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Acudiente;
import modelo.Area;
import modelo.Consentimiento;
import modelo.Documento;
import modelo.Especialidad;
import modelo.Paciente;
import modelo.Procedimiento;
import modelo.Profesional;
import modelo.Vacuna;
import org.primefaces.json.JSONException;
import utilidades.Constantes;

/**
 * @author carlosj
 */
public class ConfiguracionDAO {

    private final Connection conexion;

    public ConfiguracionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Procedimiento> cargarProcedimientos(Area area) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        List<Procedimiento> lista = new ArrayList<>();
        try {
            consulta = new Consulta(this.conexion);
            if (area != null) {
                String sql = "SELECT  id_procedimiento,descripcion \n"
                        + "FROM procedimiento where id_area=" + (area.getId() != null ? area.getId() : 0) + " order by id_procedimiento";
                resultSet = consulta.ejecutar(sql);
                Procedimiento procedimiento;
                while (resultSet.next()) {
                    procedimiento = new Procedimiento();
                    procedimiento.setDescripcion(resultSet.getString("descripcion"));
                    procedimiento.setIdProcedimiento(resultSet.getInt("id_procedimiento"));
                    lista.add(procedimiento);
                }
                Procedimiento otroProcedimiento = new Procedimiento();
                otroProcedimiento.setIdProcedimiento(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO));
                otroProcedimiento.setDescripcion("Otro");
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
                area.setNombre(resultSet.getString("nombre"));
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

    public List<Documento> cargarTiposDocumentos() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            List<Documento> lista = new ArrayList();
            String sql = "SELECT id_tipo_documento,tipo_documento,inicial FROM tipo_Documento";
            resultSet = consulta.ejecutar(sql);
            Documento documento;
            while (resultSet.next()) {
                documento = new Documento();
                documento.setInicial(resultSet.getString("inicial"));
                documento.setDescripcion(resultSet.getString("tipo_documento"));
                documento.setIdTipoDocumento(resultSet.getInt("id_tipo_documento"));
                lista.add(documento);
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
    
    public List<Especialidad> cargarEspecialidades() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            List<Especialidad> lista = new ArrayList();
            String sql = "SELECT id_especialidad,descripcion FROM especialidad";
            resultSet = consulta.ejecutar(sql);
            while (resultSet.next()) {
               
                lista.add(new Especialidad(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
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

    public List<Vacuna> cargarVacunas() throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            List<Vacuna> lista = new ArrayList();
            String sql = "SELECT id_vacuna,nombre FROM vacuna";
            resultSet = consulta.ejecutar(sql);
            Vacuna vacuna;
            while (resultSet.next()) {
                vacuna = new Vacuna();
                vacuna.setId(resultSet.getInt("id_vacuna"));
                vacuna.setNombre(resultSet.getString("nombre"));
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
                    + "	VALUES (" + datos.getPaciente().getTipoDocumento().getIdTipoDocumento() + ","
                    + " '" + datos.getPaciente().getNroDocumento() + "',"
                    + (datos.getRiesgoBeneficio() ? "true" : "false") + ", " + (datos.getTratamientoDatos() ? "true" : "false") + ","
                    + (datos.getNroAdmision() != null ? datos.getNroAdmision() : "null") + ","
                    + (datos.getProfesional().getNroRegistro() != null ? datos.getProfesional().getNroRegistro() : "null") + ","
                    + (datos.getProcedimiento() != null && datos.getProcedimiento().contains(new Procedimiento(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO))) ? "'" + datos.getOtroProcedimiento() + "'" : "null") + ", "
                    + (datos.getPaciente().getAcudiente() != null && datos.getPaciente().getAcudiente().getTipoDocumento() != null ? datos.getPaciente().getAcudiente().getTipoDocumento().getIdTipoDocumento() : "null") + ","
                    + (datos.getPaciente().getAcudiente() != null && datos.getPaciente().getAcudiente().getNroDocumento() != null ? "'" + datos.getPaciente().getAcudiente().getNroDocumento() + "'" : "null") + ","
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
                /*for (Procedimiento procedure : datos.getProcedimiento()) {
                    sql = "Insert into public.consentimiento_procedimiento(id_consentimiento,id_procedimiento) values (" + resultado.getInt("id_consentimiento") + "," + procedure.getIdProcedimiento() + ")";
                    consulta.actualizar(sql);
                }*/
                for (Area area : datos.getLstArea()) {
                    sql = "Insert into public.consentimiento_area(id_consentimiento,id_area) values (" + resultado.getInt("id_consentimiento") + "," + area.getId() + ")";
                    consulta.actualizar(sql);
                }
               /* for (Procedimiento desentimiento : datos.getDesentimientos()) {
                    sql = "Insert into public.consentimiento_desentimiento(id_consentimiento,id_procedimiento) values (" + resultado.getInt("id_consentimiento") + "," + desentimiento.getIdProcedimiento() + ")";
                    consulta.actualizar(sql);
                }*/
            }
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public String guardarPaciente(Paciente paciente) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarPaciente(paciente.getTipoDocumento().getIdTipoDocumento(), paciente.getNroDocumento()) == null) {
                String sql = "INSERT INTO public.paciente(\n"
                        + "	id_tipo_documento, documento, nombre)\n"
                        + "	VALUES (" + paciente.getTipoDocumento().getIdTipoDocumento() + ","
                        + " '" + paciente.getNroDocumento() + "',"
                        + "'" + paciente.getNombre() + "');";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.paciente set nombre='" + paciente.getNombre() + "'"
                        + " where id_tipo_documento=" + paciente.getTipoDocumento().getIdTipoDocumento() + " "
                        + " and documento='" + paciente.getNroDocumento() + "'";
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
    
    public String guardarProfesional(Profesional profesional) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarProfesional(profesional.getTipoDocumento().getIdTipoDocumento(), profesional.getNroDocumento()) == null) {
                String sql = "INSERT INTO public.profesional(\n"
                        + "	id_tipo_documento, documento, nombre,nro_registro,firma,id_especialidad)\n"
                        + "	VALUES (" + profesional.getTipoDocumento().getIdTipoDocumento() + ","
                        + " '" + profesional.getNroDocumento() + "',"
                        + "'" + profesional.getNombre() + "'," + profesional.getNroRegistro()+ ",'" + profesional.getFirma()+ "',"+profesional.getEspecialidad().getId()+");";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.profesional set nombre='" + profesional.getNombre() + "',firma='"+ profesional.getFirma()+ "',"
                        + " nro_registro="+profesional.getNroRegistro()+",id_especialidad= "+profesional.getEspecialidad().getId()
                        + " where id_tipo_documento=" + profesional.getTipoDocumento().getIdTipoDocumento() + " "
                        + " and documento='" + profesional.getNroDocumento() + "'";
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

    public String guardarAcudiente(Acudiente acudiente) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            if (consultarPaciente(acudiente.getTipoDocumento().getIdTipoDocumento(), acudiente.getNroDocumento()) == null) {
                String sql = "INSERT INTO public.paciente(\n"
                        + "	id_tipo_documento, documento, nombre)\n"
                        + "	VALUES (" + acudiente.getTipoDocumento().getIdTipoDocumento() + ","
                        + " '" + acudiente.getNroDocumento() + "',"
                        + "'" + acudiente.getNombre() + "');";
                consulta.actualizar(sql);
            } else {
                String sql = "update public.paciente set nombre='" + acudiente.getNombre() + "'"
                        + " where id_tipo_documento=" + acudiente.getTipoDocumento().getIdTipoDocumento() + " "
                        + " and documento='" + acudiente.getNroDocumento() + "'";
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

    public Procedimiento guardarProcedimiento(Procedimiento procedimiento) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        ResultSet result;
        try {
            consulta = new Consulta(this.conexion);
            String valor = "";
            String sql = "INSERT INTO public.procedimiento(descripcion,id_area)\n"
                    + "	VALUES ("
                    + "'" + procedimiento.getDescripcion() + "'," + procedimiento.getArea().getId() + ") returning id_procedimiento;";
            result = consulta.ejecutar(sql);
            if (result.next()) {
                procedimiento.setIdProcedimiento(result.getInt("id_procedimiento"));
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

    public List<Procedimiento> procesarProcedimientos(List<String> procList, Area area) throws IOException, SQLException, ClassNotFoundException {
        Consulta consulta = null;
        Procedimiento procedimiento;
        List<Procedimiento> lstProcedimiento = new ArrayList();
        try {
            consulta = new Consulta(this.conexion);
            for (String nombreProcedimiento : procList) {
                procedimiento = consultarProcedimiento(nombreProcedimiento);
                if (procedimiento == null) {
                    procedimiento = new Procedimiento();
                    procedimiento.setArea(area);
                    procedimiento.setDescripcion(nombreProcedimiento.toLowerCase().replaceAll("^\\w",nombreProcedimiento.toUpperCase().substring(0,1)));
                    //guardarProcedimiento(procedimiento);
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

    public Procedimiento consultarProcedimiento(String nombre) throws SQLException {
        Consulta consulta = null;
        Procedimiento procedimiento = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "select * from procedimiento where upper(descripcion) ='" + nombre.toUpperCase() + "'";
            ResultSet result = consulta.ejecutar(sql);
            if (result.next()) {
                procedimiento = new Procedimiento(result.getInt("id_procedimiento"));
                procedimiento.setDescripcion(result.getString("descripcion"));
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

    public Paciente consultarPaciente(Integer tipoDocumento, String documento) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "SELECT * FROM paciente p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " WHERE id_tipo_documento=" + tipoDocumento + " and documento ='" + documento + "'";
            resultSet = consulta.ejecutar(sql);
            Paciente paciente = null;
            while (resultSet.next()) {
                paciente = new Paciente();
                paciente.setNroDocumento(resultSet.getString("documento"));
                paciente.setNombre(resultSet.getString("nombre"));
                Documento doc = new Documento();
                doc.setDescripcion(resultSet.getString("tipo_documento"));
                doc.setIdTipoDocumento(resultSet.getInt("id_tipo_Documento"));
                doc.setInicial(resultSet.getString("inicial"));
                paciente.setTipoDocumento(doc);
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

    public Profesional consultarProfesional(Integer tipoDocumento, String documento) throws IOException, SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            String sql = "SELECT * FROM profesional p  "
                    + " inner join tipo_Documento t using (id_tipo_Documento)"
                    + " inner join especialidad e using (id_especialidad)"
                    + " WHERE id_tipo_documento=" + tipoDocumento + " and documento ='" + documento + "'";
            resultSet = consulta.ejecutar(sql);
            Profesional profesional = null;
            while (resultSet.next()) {
                profesional = new Profesional();
                profesional.setNroDocumento(resultSet.getString("documento"));
                profesional.setNombre(resultSet.getString("nombre"));
                profesional.setNroRegistro(resultSet.getInt("nro_registro"));
                profesional.setEspecialidad(new Especialidad(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
                profesional.setFirma(resultSet.getString("firma"));
                Documento doc = new Documento();
                doc.setDescripcion(resultSet.getString("tipo_documento"));
                doc.setIdTipoDocumento(resultSet.getInt("id_tipo_Documento"));
                doc.setInicial(resultSet.getString("inicial"));
                profesional.setTipoDocumento(doc);
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
