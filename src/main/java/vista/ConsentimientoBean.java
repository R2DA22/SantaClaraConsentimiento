/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestorBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import modelo.Area;
import modelo.Consentimiento;
import modelo.Documento;
import modelo.Especialidad;
import modelo.Paciente;
import modelo.Procedimiento;
import modelo.Profesional;
import modelo.Vacuna;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import utilidades.Constantes;
import utilidades.PdfFile;
import utilidades.Signature;

/**
 *
 * @author diego.ramirez
 */
@ManagedBean(name = "consentimientoBean")
@SessionScoped
public class ConsentimientoBean implements Serializable {

    private Consentimiento consentimiento;
    private GestorBD gestorConfiguracion;
    private List<Procedimiento> lstProcedimiento;
    private List<Procedimiento> lstDesentimientos;
    private List<Documento> lstTipoDocumento;
    private List<Vacuna> lstVacuna;
    private List<Area> lstArea;
    private List<Especialidad> lstEspecialidades;
    private boolean quienDiligencia;

    private String mensajeError;
    private String tipoalerta;
    private String headerMessage;
    private String urlFile;
    private StreamedContent streamedContent;
    private String tipoFormulario;
    private File signature;
    private Procedimiento otroProcedimiento;

    public ConsentimientoBean() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void init() {
        try {
            quienDiligencia = true;
            otroProcedimiento = new Procedimiento(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO));
            consentimiento = new Consentimiento();
            consentimiento.getPaciente().setTipoDocumento(new Documento());
            gestorConfiguracion = new GestorBD();
//            consentimiento.setNroAdmision(1243);
//            consentimiento.setNroRegistro(51243);
//            consentimiento.setNroManilla(461243);
//            consentimiento.getPaciente().setNombre("Diego Alejandro Ramírez Ramírez");
//            consentimiento.getPaciente().setNroDocumento("1112905491");
//            consentimiento.getPaciente().getAcudiente().setNroDocumento("1112778597");
//            consentimiento.getPaciente().getAcudiente().setNombre("Mónica Alejandra Gómez");
//            consentimiento.setProcedimiento(17);
//            consentimiento.setProfesional("Maximiliano Ramírez Gomez");
            cargarTiposDocumentos();
        } catch (Exception ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTiposDocumentos() {
        try {
            lstTipoDocumento = gestorConfiguracion.cargarTiposDocumentos();
        } catch (Exception e) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarEspecialidades() {
        try {
            lstEspecialidades = gestorConfiguracion.cargarEspecialidades();
            if (lstEspecialidades != null && !lstEspecialidades.isEmpty()) {
                consentimiento.getProfesional().setEspecialidad(lstEspecialidades.get(0));
            }
        } catch (Exception e) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarProcedimientos(Area area) {
        try {
            lstProcedimiento = gestorConfiguracion.cargarProcedimientos(area);
        } catch (Exception e) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarAreas() {
        try {
            lstArea = gestorConfiguracion.cargarAreas();
        } catch (Exception e) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarVacunas() {
        try {
            lstVacuna = gestorConfiguracion.cargarVacunas();
        } catch (Exception e) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void construirFirma(String docSignature, String firma) {
        try {
            OutputStream output;
            String dest = Constantes.PATH_IMAGENES_APP + Constantes.NAME_FIRMA + "-" + docSignature + "." + Constantes.IMAGE_FORMAT;
            this.signature = new File(dest);
            output = new FileOutputStream(this.signature);
            Signature.generateSignature(firma, output);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar() {
        if (validarDatos()) {
            if (tipoFormulario.equals("REGISTRO_PROFESIONAL")) {
                consentimiento.getProfesional().setFirma(consentimiento.getFirma());
                if (guardarProfesional() != null) {
                    mostrarAlertaModal("Profesional registrado correctamente", "success");
                } else {
                    mostrarAlertaModal("No se pudo finalizar el registro del profesional", "danger");
                }
            } else if (guardarConsentimientoInformado(tipoFormulario) != null) {
                String docSignature = "", docSignatureProfesional = "";
                if (consentimiento.getPaciente() != null && consentimiento.getPaciente().getAcudiente() != null && !quienDiligencia) {
                    docSignature = consentimiento.getPaciente().getAcudiente().getTipoDocumento().getInicial() + consentimiento.getPaciente().getAcudiente().getNroDocumento();
                } else if (consentimiento.getPaciente() != null) {
                    docSignature = consentimiento.getPaciente().getTipoDocumento().getInicial() + consentimiento.getPaciente().getNroDocumento();
                }
                if (consentimiento.getProfesional() != null) {
                    docSignatureProfesional = consentimiento.getProfesional().getTipoDocumento().getInicial() + consentimiento.getProfesional().getNroDocumento();
                }
                construirFirma(docSignature, consentimiento.getFirma());
                if (consentimiento.getProfesional().getFirma() != null) {
                    construirFirma(docSignatureProfesional, consentimiento.getProfesional().getFirma());
                }
                String formularioHtml = "", tablaProcedimientos = "";
                switch (tipoFormulario) {
                    case "PROCEDIMIENTO":
                        formularioHtml = Constantes.FORMATO_SANTA_CLARA_CONSENTIMIENTO.replace("@docSignature@", docSignature);
                        tablaProcedimientos = construirTablaProcesos(Constantes.CANT_COLUMNAS_TABLA_PROCEDIMIENTOS);
                        break;
                    case "COVID":
                        if (!quienDiligencia) {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_COVID_ACUDIENTE.replace("@docSignature@", docSignature);
                        } else {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_COVID.replace("@docSignature@", docSignature);
                        }
                        break;
                    case "URGENCIAS":
                        if (!quienDiligencia) {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_URGENCIAS_ACUDIENTE.replace("@docSignature@", docSignature);
                        } else {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_URGENCIAS.replace("@docSignature@", docSignature);
                        }
                        break;
                    case "ODONTOLOGIA":
                        tablaProcedimientos = construirTablaAreas(1);
                        if (!quienDiligencia) {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_ODONTOLOGIA_ACUDIENTE.replace("@docSignature@", docSignature).replace("@docSignatureProfessional@", docSignatureProfesional);
                        } else {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_ODONTOLOGIA.replace("@docSignature@", docSignature).replace("@docSignatureProfessional@", docSignatureProfesional);
                        }
                        break;
                    case "ODONTOLOGIA_COVID":
                        if (!quienDiligencia) {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_ODONTOLOGIA_COVID_ACUDIENTE.replace("@docSignature@", docSignature).replace("@docSignatureProfessional@", docSignatureProfesional);
                        } else {
                            formularioHtml = Constantes.FORMATO_SANTA_CLARA_ODONTOLOGIA_COVID.replace("@docSignature@", docSignature).replace("@docSignatureProfessional@", docSignatureProfesional);
                        }
                        break;
                }
                //Diligencio el formulario con los datos digitados por el usuario
                formularioHtml = formularioHtml.replace("@LstProcedimientos@", tablaProcedimientos);
                String formularioDiligenciado = PdfFile.diligenciarFormulario(consentimiento, formularioHtml, tipoFormulario);
                //Genero el pdf
                this.urlFile = PdfFile.generarPDF(consentimiento, formularioDiligenciado, tipoFormulario);
//                    String mensaje = "Se generó PDF " + consentimiento.getPaciente().getNroDocumento() + "_" + consentimiento.getFecha("dd_MM_yyyy_HH_mm") + ".pdf";
//                    String tipo = "success";
                this.tipoalerta = "success";
                RequestContext.getCurrentInstance().update("@(.formSoporte)");
                RequestContext.getCurrentInstance().execute("PF('dlgview-pdf').show()");

//                    mostrarAlertaModal(mensaje, tipo);
            } else {
                mostrarAlertaModal("No se pudo finalizar el registro del documento", "danger");
            }
        }
    }

    public String construirTablaAreas(int columna) {
        int index;
        String cadena = "";
        Double numCeldas = Math.ceil((double) lstArea.size() / (double) columna) * columna;

        cadena = cadena + "<tr>\n";
        cadena = cadena + "<td width=\"20\"></td>\n";
        cadena = cadena + "<td width=\"30\"><center>Área</center></td>\n";
        cadena = cadena + "<td width=\"50\"><center>Detalle del procedimiento</center></td>\n";
        cadena = cadena + "</tr>\n";

        for (int i = 1; i <= numCeldas; i++) {
            index = i - 1;
            if (i % columna == 1) {
                cadena = cadena + "<tr>\n";
            }
            if (lstArea.size() > index) {
                cadena = cadena + "<td width=\"20\">@area" + lstArea.get(index).getId() + "@</td>\n";
                cadena = cadena + "<td>" + lstArea.get(index).getNombre() + "</td>\n";
                cadena = cadena + "<td>";
                if (lstArea.get(index).equals(consentimiento.getArea())) {
                    boolean primerProcedimiento = true;
                    for (Procedimiento procedimiento : consentimiento.getProcedimiento()) {
                        if (procedimiento.getIdProcedimiento()==null || procedimiento.getIdProcedimiento() != Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO)) {
                            cadena = cadena + (primerProcedimiento ? procedimiento.getDescripcion() : " - " + procedimiento.getDescripcion());
                            primerProcedimiento = false;
                        }
                    }
                }
                cadena = cadena + "</td>\n";

            } else {
                cadena = cadena + "<td width=\"20\"></td>\n";
                cadena = cadena + "<td></td>\n";
            }
            if (i % columna == 0) {
                cadena = cadena + "</tr>\n";
            }
        }
        return cadena;
    }

    public String construirTablaProcesos(int columna) {
        int index;
        String cadena = "";
        Double numCeldas = Math.ceil((double) lstProcedimiento.size() / (double) columna) * columna;
        for (int i = 1; i <= numCeldas; i++) {
            index = i - 1;
            if (i % columna == 1) {
                cadena = cadena + "<tr>\n";
            }
            if (lstProcedimiento.size() > index) {
                cadena = cadena + "<td width=\"20\">@Procedimiento" + lstProcedimiento.get(index).getIdProcedimiento() + "@</td>\n";
                cadena = cadena + "<td>" + lstProcedimiento.get(index).getDescripcion() + "</td>\n";
            } else {
                cadena = cadena + "<td width=\"20\"></td>\n";
                cadena = cadena + "<td></td>\n";
            }
            if (i % columna == 0) {
                cadena = cadena + "</tr>\n";
            }
        }
        return cadena;
    }

    public boolean validarDatos() {
        switch (tipoFormulario) {
            case "PROCEDIMIENTO":
                return validarDatosFormProcedimiento();
            case "COVID":
                return validarDatosFormCovid();
            case "URGENCIAS":
                return validarDatosFormUrgencias();
            case "ODONTOLOGIA":
                return validarDatosFormOdontologia();
            case "ODONTOLOGIA_COVID":
                return validarDatosFormOdontologiaCovid();
            case "REGISTRO_PROFESIONAL":
                return validarDatosFormRegistroProfesional();
        }
        return false;
    }

    public boolean validarDatosFormProcedimiento() {
        if (consentimiento.getProcedimiento() == null || consentimiento.getProcedimiento().isEmpty()) {
            mostrarAlertaModal("No ha indicado ningun procedimiento", "warning");
            return false;
        }
        if (consentimiento.getProcedimiento().contains(new Procedimiento(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO)))
                && (consentimiento.getOtroProcedimiento() == null
                || consentimiento.getOtroProcedimiento().equals(""))) {
            mostrarAlertaModal("Ingrese el nombre del procedimiento realizado", "warning");
            return false;
        }
        if (consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNroDocumento() != null
                && consentimiento.getPaciente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNombre() != null
                && consentimiento.getPaciente().getNombre().equals("")
                && !consentimiento.getPaciente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el acudiente", "warning");
            return false;
        }
        if (!isQuienDiligencia()
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNombre() != null
                && consentimiento.getPaciente().getAcudiente().getNombre().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el acudiente", "warning");
            return false;
        }
        if (consentimiento.getProfesional() != null
                && !consentimiento.getProfesional().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el profesional que realiza el procedimiento", "warning");
            return false;
        }
        if (consentimiento.getProfesional().getNroRegistro() != null
                && !consentimiento.getProfesional().getNroRegistro().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un valor númerico correcto en  Nro. registro", "warning");
            return false;
        }
        if (consentimiento.getNroAdmision() != null
                && !consentimiento.getNroAdmision().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un valor númerico correcto en  Nro. admisión", "warning");
            return false;
        }
        //        if (consentimiento.getNroManilla() != null
        //                && !consentimiento.getNroManilla().toString().matches(Constantes.REGEX_DIGITO)) {
        //            mostrarAlertaModal("Ingrese un valor númerico correcto en  Nro. manilla", "warning");
        //            return false;
        //        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        return true;
    }

    public boolean validarDatosFormCovid() {

        if (consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNroDocumento() != null
                && consentimiento.getPaciente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNombre() != null
                && consentimiento.getPaciente().getNombre().equals("")
                && !consentimiento.getPaciente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el acudiente", "warning");
            return false;
        }
        if (!isQuienDiligencia()
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNombre() != null
                && consentimiento.getPaciente().getAcudiente().getNombre().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el acudiente", "warning");
            return false;
        }
        if (consentimiento.getProfesional() != null
                && !consentimiento.getProfesional().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el profesional que realiza el procedimiento", "warning");
            return false;
        }
        if (consentimiento.getEdad() != null
                && !consentimiento.getEdad().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un valor númerico correcto en campo Edad", "warning");
            return false;
        }
        if (consentimiento.getEPS() != null
                && !consentimiento.getEPS().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un valor nombre válido para la EPS", "warning");
            return false;
        }
        if (consentimiento.getTelefono() != null
                && !consentimiento.getTelefono().matches(Constantes.REGEX_TELEFONO)) {
            mostrarAlertaModal("Ingrese un número de telefono válido", "warning");
            return false;
        }
        if (consentimiento.getEmail() != null
                && !consentimiento.getEmail().matches(Constantes.REGEX_EMAIL)) {
            mostrarAlertaModal("Ingrese un correo electronico válido", "warning");
            return false;
        }
        if (consentimiento.getSintomas()
                && !consentimiento.getDescripcionSintomas().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Los sintomas no puede contener simbolos, números ni caracteres especilas", "warning");
            return false;
        }
        if (consentimiento.getSintomas() && (consentimiento.getFechaInicioSintomas("dd-MM-yyyy") == null
                || !consentimiento.getFechaInicioSintomas("dd-MM-yyyy").matches(Constantes.REGEX_FECHA))) {
            mostrarAlertaModal("La fecha de los sintomas tiene formato incorrecto", "warning");
            return false;
        }
        if (consentimiento.getVacunado() && (consentimiento.getFechaVacuna("dd-MM-yyyy") == null
                || !consentimiento.getFechaVacuna("dd-MM-yyyy").matches(Constantes.REGEX_FECHA))) {
            mostrarAlertaModal("La fecha de la vacuna tiene formato incorrecto", "warning");
            return false;
        }
        if (consentimiento.getOcupacion() != null
                && !consentimiento.getOcupacion().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("La ocupación no puede contener simbolos, números ni caracteres especilas", "warning");
            return false;
        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        if (consentimiento.getViajes() && consentimiento.getViajesRealizados() != null
                && !consentimiento.getViajesRealizados().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("El campo viajes no puede tener números ni caracteres especiales", "warning");
            return false;
        }
        return true;
    }

    public boolean validarDatosFormUrgencias() {

        if (consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNroDocumento() != null
                && consentimiento.getPaciente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNombre() != null
                && consentimiento.getPaciente().getNombre().equals("")
                && !consentimiento.getPaciente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el acudiente", "warning");
            return false;
        }
        if (!isQuienDiligencia()
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNombre() != null
                && consentimiento.getPaciente().getAcudiente().getNombre().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el acudiente", "warning");
            return false;
        }

        if (consentimiento.getEPS() != null
                && !consentimiento.getEPS().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un valor nombre válido para la EPS", "warning");
            return false;
        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        return true;
    }

    public boolean validarDatosFormOdontologia() {

        if (consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNroDocumento() != null
                && consentimiento.getPaciente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNombre() != null
                && consentimiento.getPaciente().getNombre().equals("")
                && !consentimiento.getPaciente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el acudiente", "warning");
            return false;
        }
        if (!isQuienDiligencia()
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNombre() != null
                && consentimiento.getPaciente().getAcudiente().getNombre().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el acudiente", "warning");
            return false;
        }

        if (consentimiento.getProfesional().getNroRegistro() != null
                && !consentimiento.getProfesional().getNroRegistro().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un valor válido para la Nro de registro", "warning");
            return false;
        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        return true;
    }

    public boolean validarDatosFormOdontologiaCovid() {

        if (consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNroDocumento() != null
                && consentimiento.getPaciente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getNombre() != null
                && consentimiento.getPaciente().getNombre().equals("")
                && !consentimiento.getPaciente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el paciente", "warning");
            return false;
        }
        if (!isQuienDiligencia() && consentimiento.getPaciente() != null
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento() != null
                && consentimiento.getPaciente().getAcudiente().getNroDocumento().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el acudiente", "warning");
            return false;
        }
        if (!isQuienDiligencia()
                && consentimiento.getPaciente().getAcudiente() != null
                && consentimiento.getPaciente().getAcudiente().getNombre() != null
                && consentimiento.getPaciente().getAcudiente().getNombre().equals("")
                && !consentimiento.getPaciente().getAcudiente().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el acudiente", "warning");
            return false;
        }

        if (consentimiento.getEdad() != null
                && !consentimiento.getEdad().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un número válido para la Edad", "warning");
            return false;
        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        return true;
    }

    public boolean validarDatosFormRegistroProfesional() {

        if (consentimiento.getProfesional() != null
                && consentimiento.getProfesional().getNroDocumento() != null
                && consentimiento.getProfesional().getNroDocumento().equals("")
                && !consentimiento.getProfesional().getNroDocumento().matches(Constantes.REGEX_DOCUMENTO)) {
            mostrarAlertaModal("Ingrese un nro de documento válido para el profesional", "warning");
            return false;
        }
        if (consentimiento.getProfesional() != null
                && consentimiento.getProfesional().getNombre() != null
                && consentimiento.getProfesional().getNombre().equals("")
                && !consentimiento.getProfesional().getNombre().matches(Constantes.REGEX_NOMBRE)) {
            mostrarAlertaModal("Ingrese un nombre válido para el profesional", "warning");
            return false;
        }
        if (consentimiento.getProfesional().getNroRegistro() != null
                && !consentimiento.getProfesional().getNroRegistro().toString().matches(Constantes.REGEX_DIGITO)) {
            mostrarAlertaModal("Ingrese un valor válido para la Nro de registro", "warning");
            return false;
        }
        if (consentimiento.getFirma() == null || consentimiento.getFirma().equals("")) {
            mostrarAlertaModal("Ingrese la firma", "warning");
            return false;
        }
        return true;
    }

    public void mostrarAlertaModal(String mensaje, String tipoAlerta) {
        this.mensajeError = mensaje;
        this.tipoalerta = tipoAlerta;
        switch (tipoalerta) {
            case "info":
                this.headerMessage = "Información";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "<strong>Información</strong>", mensajeError));
                break;
            case "danger":
                this.headerMessage = "Advertencia";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            "<strong>Error</strong>",
//                            mensajeError + "<span type=\"button\" onclick=\"return PF('dlgAyudaModal').show();\"><img src=\"./resources/imagenes/icon-help.png\" style=\"margin: 2px; display:#{ubicacionBean.mensajeError.contains('el botón de ayuda')?'block':'none'}\" width=\"28\"></span>"));
                break;
            case "warning":
                this.headerMessage = "Advertencia";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "<strong>Advertencia</strong>", mensajeError));
                break;
            case "success":
                this.headerMessage = "Exito";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "<strong>Advertencia</strong>", mensajeError));
                break;
            default:
                this.headerMessage = "Información";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "<strong>Información</strong>", mensajeError));
                break;
        }
        RequestContext.getCurrentInstance().execute("mostrarModalAlert(\"" + mensaje + " \", \"" + tipoAlerta + "\")");

    }

    public String guardarConsentimientoInformado(String tipoDocumento) {
        String respuesta;
        try {
            GestorBD gestor = new GestorBD();
            respuesta = gestor.guardarConsentimientoInformado(consentimiento, tipoDocumento);
        } catch (Exception ex) {
            respuesta = null;
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String guardarProfesional() {
        String respuesta;
        try {
            GestorBD gestor = new GestorBD();
            respuesta = gestor.guardarProfesional(consentimiento);
        } catch (Exception ex) {
            respuesta = null;
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public void consultarPaciente() {
        try {
            GestorBD gestor = new GestorBD();
            if (consentimiento.getPaciente() != null
                    && consentimiento.getPaciente().getNroDocumento() != null && !consentimiento.getPaciente().getNroDocumento().equals("")
                    && consentimiento.getPaciente().getTipoDocumento() != null) {
                Paciente paciente = gestor.consultarPaciente(consentimiento.getPaciente().getTipoDocumento().getIdTipoDocumento(), consentimiento.getPaciente().getNroDocumento());
                if (paciente != null) {
                    consentimiento.getPaciente().setNombre(paciente.getNombre());
                } else {
                    consentimiento.getPaciente().setNombre("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarProfesional() {
        try {
            GestorBD gestor = new GestorBD();
            if (consentimiento.getProfesional() != null
                    && consentimiento.getProfesional().getNroDocumento() != null && !consentimiento.getProfesional().getNroDocumento().equals("")
                    && consentimiento.getProfesional().getTipoDocumento() != null) {
                Profesional profesional = gestor.consultarProfesional(consentimiento.getProfesional().getTipoDocumento().getIdTipoDocumento(), consentimiento.getProfesional().getNroDocumento());
                if (profesional != null) {
                    consentimiento.setProfesional(profesional);
                } else {
                    consentimiento.getProfesional().setNombre("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarAcudiente() {
        try {
            GestorBD gestor = new GestorBD();
            if (consentimiento.getPaciente() != null && consentimiento.getPaciente().getTipoDocumento() != null
                    && consentimiento.getPaciente().getAcudiente() != null
                    && consentimiento.getPaciente().getAcudiente().getTipoDocumento() != null) {
                Paciente acudiente = gestor.consultarPaciente(consentimiento.getPaciente().getAcudiente().getTipoDocumento().getIdTipoDocumento(), consentimiento.getPaciente().getAcudiente().getNroDocumento());
                if (acudiente != null) {
                    consentimiento.getPaciente().getAcudiente().setNombre(acudiente.getNombre());
                } else {
                    consentimiento.getPaciente().getAcudiente().setNombre("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void settearMensajeAlert() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (params.get("mensaje") != null && !params.get("mensaje").equals("undefined")) {
            this.mensajeError = params.get("mensaje");
            this.tipoalerta = params.get("tipoalerta");
            switch (tipoalerta) {
                case "info":
                    this.headerMessage = "Información";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "<strong>Información</strong>", mensajeError));
                    break;
                case "danger":
                    this.headerMessage = "Advertencia";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            "<strong>Error</strong>",
//                            mensajeError + "<span type=\"button\" onclick=\"return PF('dlgAyudaModal').show();\"><img src=\"./resources/imagenes/icon-help.png\" style=\"margin: 2px; display:#{ubicacionBean.mensajeError.contains('el botón de ayuda')?'block':'none'}\" width=\"28\"></span>"));
                    break;
                case "warning":
                    this.headerMessage = "Advertencia";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "<strong>Advertencia</strong>", mensajeError));
                    break;
                case "success":
                    this.headerMessage = "Exito";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "<strong>Advertencia</strong>", mensajeError));
                    break;
                default:
                    this.headerMessage = "Información";
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "<strong>Información</strong>", mensajeError));
                    break;
            }
        }
    }

    public String getIdOtro() {
        return Constantes.ID_OTRO_PROCEDIMIENTO;
    }

    public String limpiarCampos() {
        if (tipoalerta.equals("success")) {
            quienDiligencia = true;
            consentimiento = new Consentimiento();
            consentimiento.getPaciente().setTipoDocumento(new Documento());
            if (this.signature != null) {
                this.signature.delete();
            }
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento_procedimiento")) {
                return redirect(1);
            }
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento_covid")) {
                return redirect(2);
            }
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento_urgencias")) {
                return redirect(3);
            }
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento_odontologico")) {
                return redirect(4);
            }
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento_odontologico_covid")) {
                return redirect(5);
            }
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("registro_profesional")) {
                return redirect(6);
            }

//            try {
////                ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ConsentimientoBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return "";
    }

    public void limpiarFormulario() {
        quienDiligencia = true;
        consentimiento = new Consentimiento();
        consentimiento.getPaciente().setTipoDocumento(new Documento());
    }

    public String redirect(Integer opcion) {
        limpiarFormulario();
        switch (opcion) {
            case 1:

                tipoFormulario = "PROCEDIMIENTO";
                cargarProcedimientos(new Area());
                return "consentimiento_procedimiento.xhtml?faces-redirect=true";

            case 2:
                tipoFormulario = "COVID";
                cargarVacunas();
                consentimiento.getProfesional().setNombre("Antonio Jose Sanchez Niñez");
                return "consentimiento_covid.xhtml?faces-redirect=true";

            case 3:
                tipoFormulario = "URGENCIAS";
                return "consentimiento_urgencias.xhtml?faces-redirect=true";
            case 4:
                tipoFormulario = "ODONTOLOGIA";
                cargarAreas();
                cargarProcedimientos(null);
                return "consentimiento_odontologico.xhtml?faces-redirect=true";
            case 5:
                tipoFormulario = "ODONTOLOGIA_COVID";
                return "consentimiento_odontologico_covid.xhtml?faces-redirect=true";
            case 6:
                tipoFormulario = "REGISTRO_PROFESIONAL";
                cargarEspecialidades();
                return "registro_profesional.xhtml?faces-redirect=true";
            default:
                tipoFormulario = "";
                return "index.xhtml?faces-redirect=true";
        }

    }

    public void onCellEdit(CellEditEvent event) {
        Area area = lstArea.get(event.getRowIndex());
        if (event.getNewValue() != null && !event.getNewValue().equals("") && !area.getLstProcedimientos().isEmpty()) {
            if (!consentimiento.getLstArea().contains(area)) {
                consentimiento.getLstArea().add(area);
                area.setSelected(true);
                RequestContext.getCurrentInstance().execute("showIconCheck('frmFormulario:procedimientos:" + event.getRowIndex() + ":column-selected',true,'hidden')");
            }
        } else {
            consentimiento.getLstArea().remove(area);
            area.setSelected(false);
            RequestContext.getCurrentInstance().execute("showIconCheck('frmFormulario:procedimientos:" + event.getRowIndex() + ":column-selected',false,'hidden')");
        }

    }

    public void adicionarDesentimiento() {
        getLstDesentimientos().clear();
        List<Procedimiento> lista = new ArrayList<>();
        for (Procedimiento procedimiento : consentimiento.getProcedimiento()) {
            if (procedimiento.getIdProcedimiento() != Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO)) {
                lista.add(procedimiento);
            }
        }
        getLstDesentimientos().addAll(lista);
    }

    public void adicionarItems() {
        getLstDesentimientos().clear();
        eliminarChipsRepetidos();
        int counterId = consentimiento.getProcedimiento().size();
        List<Procedimiento> lista = new ArrayList<>();
        for (String procedimientoVar : consentimiento.getArea().getLstProcedimientos()) {
            Procedimiento procedure = new Procedimiento(counterId);
            procedure.setDescripcion(procedimientoVar);
            procedure.setArea(consentimiento.getArea());
            lista.add(procedure);
            counterId++;
        }
        adicionarDesentimiento();
        getLstDesentimientos().addAll(lista);
    }

    public void eliminarChipsRepetidos() {
        List<String> lista = new ArrayList<>();
        if (consentimiento.getArea() != null) {
            for (String procedureIterador : consentimiento.getArea().getLstProcedimientos()) {
                if (!lista.contains(procedureIterador.toLowerCase().replaceAll("^\\w", procedureIterador.toUpperCase().substring(0, 1)))) {
                    lista.add(procedureIterador.toLowerCase().replaceAll("^\\w", procedureIterador.toUpperCase().substring(0, 1)));
                }
            }
            consentimiento.getArea().setLstProcedimientos(lista);
        }
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getTipoalerta() {
        if (tipoalerta == null || "".equals(tipoalerta)) {
            return "info";
        }
        return tipoalerta;
    }

    public void setTipoalerta(String tipoalerta) {
        this.tipoalerta = tipoalerta;
    }

    public String getHeaderMessage() {
        return headerMessage;
    }

    public void setHeaderMessage(String headerMessage) {
        this.headerMessage = headerMessage;
    }

    public List<Procedimiento> getLstProcedimiento() {
        return lstProcedimiento;
    }

    public void setLstProcedimiento(List<Procedimiento> lstProcedimiento) {
        this.lstProcedimiento = lstProcedimiento;
    }

    public List<Documento> getLstTipoDocumento() {
        return lstTipoDocumento;
    }

    public void setLstTipoDocumento(List<Documento> lstTipoDocumento) {
        this.lstTipoDocumento = lstTipoDocumento;
    }

    public Consentimiento getConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(Consentimiento consentimiento) {
        this.consentimiento = consentimiento;
    }

    public boolean isQuienDiligencia() {
        return quienDiligencia;
    }

    public void setQuienDiligencia(boolean quienDiligencia) {
        this.quienDiligencia = quienDiligencia;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public StreamedContent getStreamedContent() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                return new DefaultStreamedContent();
            } else {
                if (this.urlFile != null && !this.urlFile.equals("")) {
                    File ruta = new File(this.urlFile.replaceAll("\\\\", "\\\\\\\\"));
                    if (ruta.exists()) {
                        streamedContent = new DefaultStreamedContent(new FileInputStream(ruta), "application/pdf", consentimiento.getPaciente().getNroDocumento() + "_" + consentimiento.getFecha("dd_MM_yyyy_HH_mm") + ".pdf");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
//            UtilidadesSIMA.addErrorMessage("Se ha presentado un error al cargar los archivos! " + ex.toString());
        }
        return streamedContent;
    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public List<Vacuna> getLstVacuna() {
        return lstVacuna;
    }

    public void setLstVacuna(List<Vacuna> lstVacuna) {
        this.lstVacuna = lstVacuna;
    }

    public Procedimiento getOtroProcedimiento() {
        return otroProcedimiento;
    }

    public void setOtroProcedimiento(Procedimiento otroProcedimiento) {
        this.otroProcedimiento = otroProcedimiento;
    }

    public List<Area> getLstArea() {
        return lstArea;
    }

    public void setLstArea(List<Area> lstArea) {
        this.lstArea = lstArea;
    }

    public List<Especialidad> getLstEspecialidades() {
        return lstEspecialidades;
    }

    public void setLstEspecialidades(List<Especialidad> lstEspecialidades) {
        this.lstEspecialidades = lstEspecialidades;
    }

    public List<Procedimiento> getLstDesentimientos() {
        if (lstDesentimientos == null) {
            lstDesentimientos = new ArrayList();
        }
        return lstDesentimientos;
    }

    public void setLstDesentimientos(List<Procedimiento> lstDesentimientos) {
        this.lstDesentimientos = lstDesentimientos;
    }

    public String getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(String tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

}
