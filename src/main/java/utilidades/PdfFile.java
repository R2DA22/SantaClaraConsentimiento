/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import core.domain.Consentimiento;
import core.domain.process.Process;

/**
 *
 * @author diego.ramirez
 */
public class PdfFile {

    public PdfFile() {
    }

    public static void createPDF(String pathPdf, String HTML) {
        PdfWriter writer = null;
        try {
            ConverterProperties converterProperties = new ConverterProperties();
            writer = new PdfWriter(new File(pathPdf));
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.LETTER);

            HtmlConverter.convertToPdf(HTML, pdfDocument, converterProperties);
        } catch (Exception ex) {
            Logger.getLogger(PdfFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Objects.requireNonNull(writer).close();
            } catch (IOException ex) {
                Logger.getLogger(PdfFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String diligenciarFormulario(Consentimiento datos, String formatoHtml) {
        formatoHtml = formatoHtml.replace("@Fecha@", datos.getFecha("dd/MM/yyyy"));
        if (datos.getProfesional() != null && datos.getProfesional().getName() != null) {
            formatoHtml = formatoHtml.replace("@NombreEnfermero@", datos.getProfesional().getName());
        }
        if (datos.getProfesional().getRegistryNumber() != null) {
            formatoHtml = formatoHtml.replace("@NroRegistro@", datos.getProfesional().getRegistryNumber().toString());
        }
        if (datos.getNroAdmision() != null) {
            formatoHtml = formatoHtml.replace("@NroAdmision@", "A" + datos.getNroAdmision().toString());
        }
        if (datos.getEmail() != null) {
            formatoHtml = formatoHtml.replace("@email@", datos.getEmail());
        }
//        formatoHtml = formatoHtml.replace("@NroManilla@", datos.getNroManilla().toString());
        formatoHtml = formatoHtml.replace("@Dia@", datos.getNombreDia() + " " + datos.getFecha("dd"));
        formatoHtml = formatoHtml.replace("@Mes@", datos.getNombreMes());
        formatoHtml = formatoHtml.replace("@Anio@", datos.getFecha("yyyy"));
        if (datos.getPaciente() != null && datos.getPaciente().getGuardian() != null && datos.getPaciente().getGuardian().getDocumentNumber() != null) {
            formatoHtml = formatoHtml.replace("@TipoDoc@", datos.getPaciente().getGuardian().getDocumentType().getInitials());
            formatoHtml = formatoHtml.replace("@NroDocumento@", datos.getPaciente().getGuardian().getDocumentNumber());
            formatoHtml = formatoHtml.replace("@TipoDoc2@", datos.getPaciente().getDocumentType().getInitials());
            formatoHtml = formatoHtml.replace("@NroDocumento2@", datos.getPaciente().getDocumentNumber());
            formatoHtml = formatoHtml.replace("@Acudiente@", datos.getPaciente().getGuardian().getName());
        } else {
            formatoHtml = formatoHtml.replace("@TipoDoc@", datos.getPaciente().getDocumentType().getInitials());
            formatoHtml = formatoHtml.replace("@NroDocumento@", datos.getPaciente().getDocumentNumber());
            formatoHtml = formatoHtml.replace("@TipoDoc2@", "");
            formatoHtml = formatoHtml.replace("@NroDocumento2@", "");
            formatoHtml = formatoHtml.replace("@Acudiente@", "");
        }
        if (datos.getPaciente() != null) {
            formatoHtml = formatoHtml.replace("@Paciente@", datos.getPaciente().getName());
        } else {
            formatoHtml = formatoHtml.replace("@Paciente@", "____________________________________");
        }
        formatoHtml = formatoHtml.replace("@OtroProcedimiento@", datos.getOtroProcedimiento() != null ? "<u><i>" + datos.getOtroProcedimiento().toUpperCase() + "</u></i>" : "_______________________________________");//provisional
        formatoHtml = formatoHtml.replace("@riesgos@", datos.getRiesgoBeneficio() ? "<u><i><strong> SI </strong></i></u>" : "<u><i><strong> NO </strong></i></u>");
        formatoHtml = formatoHtml.replace("@datosPersonalesSI@", datos.getTratamientoDatos() ? "<u><i>X</i></u>" : "_");
        formatoHtml = formatoHtml.replace("@datosPersonalesNO@", datos.getTratamientoDatos() ? "_" : "<u><i>X</i></u>");

        if (datos.getProcedimiento() != null && !datos.getProcedimiento().isEmpty()) {
            for (Process procedure : datos.getProcedimiento()) {
                formatoHtml = formatoHtml.replace("@Procedimiento" + procedure.getIdProcess() + "@", "<div align=\"center\">X</div>");
            }
            formatoHtml = formatoHtml.replaceAll("@Procedimiento\\d+@", "");
        }
        if (datos.getArea() != null) {
            formatoHtml = formatoHtml.replace("@area" + datos.getArea().getId() + "@", "<div align=\"center\">X</div>");
            formatoHtml = formatoHtml.replaceAll("@area\\d+@", "");
        }
        if (datos.getDisiente()) {
            String desentimientos = "";
            for (Process desentimiento : datos.getDesentimientos()) {
                desentimientos = desentimientos + (desentimientos.equals("") ? desentimiento.getDescription() : ", " + desentimiento.getDescription());
            }
            formatoHtml = formatoHtml.replace("@desentimientos@", desentimientos);
            formatoHtml = formatoHtml.replace("@displayFirma@", "block");
        } else {
            formatoHtml = formatoHtml.replace("@displayFirma@", "none");
            formatoHtml = formatoHtml.replace("@desentimientos@", "");
        }
        if (datos.getOcupacion() != null) {
            formatoHtml = formatoHtml.replaceAll("@Ocupacion@", datos.getOcupacion());
        }
        if (datos.getTelefono() != null) {
            formatoHtml = formatoHtml.replaceAll("@Telefono@", datos.getTelefono());
        }
        if (datos.getEPS() != null) {
            formatoHtml = formatoHtml.replaceAll("@eps@", datos.getEPS());
        }
        if (datos.getEdad() != null) {
            formatoHtml = formatoHtml.replaceAll("@edad@", datos.getEdad().toString());
        }

        if (datos.getViajesRealizados() != null) {
            formatoHtml = formatoHtml.replaceAll("@viajes@", datos.getViajesRealizados());
        }
        if (datos.getVacunado() != null) {
            if (datos.getVacunado()) {
                formatoHtml = formatoHtml.replaceAll("@nombreVacuna@", datos.getVacuna().getName());
                formatoHtml = formatoHtml.replaceAll("@fechaVacuna@", datos.getFechaVacuna("dd/MM/yyyy"));
            } else {
                formatoHtml = formatoHtml.replaceAll("@nombreVacuna@", "");
                formatoHtml = formatoHtml.replaceAll("@fechaVacuna@", "");
            }
            formatoHtml = formatoHtml.replace("@vacunadoNO@", datos.getVacunado() ? "_" : "<u><i>X</i></u>");
            formatoHtml = formatoHtml.replace("@vacunadoSI@", datos.getVacunado() ? "<u><i>X</i></u>" : "_");
        }
        if (datos.getContactoCovid() != null) {
            if (datos.getContactoCovid()) {
                if (datos.getSintomas() != null) {
                    formatoHtml = formatoHtml.replaceAll("@sintomas@", datos.getDescripcionSintomas());
                }
                if (datos.getFechaInicioSintomas() != null) {
                    formatoHtml = formatoHtml.replaceAll("@fechaSintomas@", datos.getFechaInicioSintomas("dd/MM/yyyy"));
                }
            } else {
                formatoHtml = formatoHtml.replaceAll("@sintomas@", "");
                formatoHtml = formatoHtml.replaceAll("@fechaSintomas@", "");
            }
            formatoHtml = formatoHtml.replace("@contactoCovidSI@", datos.getContactoCovid() ? "<u><i>X</i></u>" : "_");
            formatoHtml = formatoHtml.replace("@contactoCovid@", datos.getContactoCovid() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");
            formatoHtml = formatoHtml.replace("@contactoCovidNO@", datos.getContactoCovid() ? "_" : "<u><i>X</i></u>");
        }
        if (datos.getTrabajadorSalud() != null) {
            formatoHtml = formatoHtml.replace("@trabajadorSaludSI@", datos.getTrabajadorSalud() ? "<u><i>X</i></u>" : "_");
            formatoHtml = formatoHtml.replace("@trabajadorSaludNO@", !datos.getTrabajadorSalud() ? "<u><i>X</i></u>" : "_");
        }
        if (datos.getVacunado()) {
            formatoHtml = formatoHtml.replace("@dosis@", (datos.getNroDosis()!= null && datos.getNroDosis()>0 )? "<u><i>"+datos.getNroDosis()+"</i></u>" : "_");
        } else {
            formatoHtml = formatoHtml.replace("@dosis@", "_");
        }
        if (datos.getProfesional() != null && datos.getProfesional().getDocumentNumber() != null) {
            formatoHtml = formatoHtml.replace("@NroDocumentoProfesional@", datos.getProfesional().getDocumentNumber());
            formatoHtml = formatoHtml.replace("@TipoDocProfesional@", datos.getProfesional().getDocumentType().getInitials());
        }
        formatoHtml = formatoHtml.replace("@riesgoSI@", datos.getRiesgoBeneficio() ? "<u><i>X</i></u>" : "_");
        formatoHtml = formatoHtml.replace("@riesgoNO@", !datos.getRiesgoBeneficio() ? "<u><i>X</i></u>" : "_");
        formatoHtml = formatoHtml.replace("@viajo@", datos.getViajes() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");
        formatoHtml = formatoHtml.replace("@tieneSintomas@", datos.getSintomas() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");

        return formatoHtml;
    }
}
