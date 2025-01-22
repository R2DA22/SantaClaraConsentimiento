package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;
import core.domain.sickness.Sickness;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.ejb.Local;

public class ConsentVoluntaryDischarge extends ConsentInterface implements Command {

    public static final String TYPE = "VoluntaryDischarge";
    public static final String CODE = "SBCUO-F-037.V1";
    private static final String URL = "consentimiento_retiro_voluntario.xhtml?faces-redirect=true";
    private String FORMAT_DOCUMENT_WITH_GUARDIAN = "<html>\n"
            + "<head>\n"
            + "<title>"+CODE+" Consentimiento Informado de Proc.</title>\n"
            + "<meta charset=\"utf-8\">\n"
            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "</head>\n"
            + "<body>\n"
            + "<div class=\"container\" style=\"float: left;\">\n"
            + "	<header >\n"
            + "		<table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "	        <tbody  class=\"alineacion-center\">\n"
            + "	                <tr >\n"
            + "	                    <td  rowspan=\"3\" >\n"
            + "	                        <img  src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "	                    </td>\n"
            + "                     <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                     <td >FECHA:</td>\n"
            + "                     <td >21/01/2025</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td  rowspan=\"2\" >DECLARACION DE RETIRO VOLUNTARIO</td>\n"
            + "                     <td  >VERSION:</td>\n"
            + "                     <td >2</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td >CODIGO:</td>\n"
            + "                     <td >"+CODE+"</td>\n"
            + "                 </tr>        \n"
            + "         </tbody>\n"
            + "     </table>\n"
            + " </header>\n"
            + "\n"
            + "<div class=\"contenido\" style=\"padding-top: 3px;\">\n" +
            "      IDENTIFICACIÓN\n" +
            "      <div class=\"contenido\" style=\"padding-top: 3px;\">\n" +
            "      <table class=\"no-cell-borders\" style=\"margin-right: auto; width: 100%\">\n" +
            "         <tbody class=\"alineacion-left\">\n" +
            "            <tr>\n" +
            "               <td colspan=\"1\">@TipoDoc@</td>\n" +
            "               <td colspan=\"1\">@NroDocumento@</td>\n" +
            "               <td colspan=\"2\">@Paciente@</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"1\">Tipo Documento</td>\n" +
            "               <td colspan=\"1\">Documento de Identidad</td>\n" +
            "               <td colspan=\"2\">Nombre completo del paciente</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"1\">@Age@</td>\n" +
            "               <td colspan=\"1\">@Gender@</td>\n" +
            "               <td colspan=\"1\">@NroAdmission@</td>\n" +
            "               <td colspan=\"1\">@Fecha@ @Hora@</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"1\">Edad</td>\n" +
            "               <td colspan=\"1\">Sexo</td>\n" +
            "               <td colspan=\"1\">Nro Atención</td>\n" +
            "               <td colspan=\"1\">Fecha</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"4\">CLINICA SANTA CLARA SAS</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"4\">Nombre de la Institución</td>\n" +
            "            </tr>\n" +
            "         </tbody>\n" +
            "      </table>\n" +
            "      <div class=\"contenido\" style=\"padding-top: 3px;\">\n" +
            "      DECLARACIÓN\n" +
            "      <div class=\"contenido\" style=\"padding-top: 3px;\">\n" +
            "         <table style=\"margin-right: auto; width: 100%\">\n" +
            "            <tbody class=\"alineacion-left\">\n" +
            "               <tr>\n" +
            "                  <td colspan=\"1\">EL(LA) SUSCRITO(A)</td>\n" +
            "                  <td colspan=\"3\">@Paciente@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"1\"></td>\n" +
            "                  <td colspan=\"3\">Nombre completo del paciente</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">\n" +
            "                     DECLARA QUE HABIENDO SIDO DEBIDAMENTE INFORMADO(A) SOBRE LOS RIESGOS Y POSIBLES COMPLICACIONES DE SALUD QUE IMPLICA\n" +
            "                     EL RETIRO VOLUNTARIO DE ESTA INSTITUCIÓN.\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">CLINICA SANTA CLARA SAS</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">Nombre de la institución</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">BAJO MI PROPIA RESPONSABILIDAD DECIDO ABANDONARLA Y EN CONSECUENCIA DECLARO QUE NI LA INSTITUCIÓN NI SU PERSONAL\n" +
            "                     SERAN REPONSABLES EN CASO DE COMPLICACIONES.\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"1\">\n                      " +
            "                   <div class=\"container-signature\">\n" +
            "                     <div class=\"right-content,image-cell\">" +
            "                        FIRMADO:\n" +
            "                        <span>\n" +
            "                        <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n" +
            "                        </span>\n" +
            "                     </div>\n" +
            "                     </div>\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"2\">@TipoDocGuardianDescription@ Nro @NroDocumentoGuardian@</td>\n" +
            "                  <td colspan=\"2\">DE: @ExpeditionPlace@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">Observaciones</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">PACIENTE QUIEN DESEA FIRMAR RETIRO VOLUNTARIO ASUMIENDO RESPONSABILIDAD TOTAL POR SU SALUD, SE LE EXPLICAALTO RIESGO DE MUERTE Y COMPLICACIONES, SE LE EXPLICAN CONSECUENCIAS DERIVADAS DE DICHA DECISION QUIEN ENTIEDE Y ACEPTA, FIRMA DE MANERA VOLUNTARIA DOCUMENTO DE RETIRO. SE HACE EGRESO EN EL SISTEMA. EGRESA CON INDICACIONES CLARAS DE SIGNOS DE ALARMA Y DE RECONSULTA LE EXPLICO ADEMAS QUE EL RETIRO VOLUNTARIO ES UN DERECHO DEL PACIENTE Y QUE LA INSTITUCIÓN NO TOMA RETALIACIONES EN RELACIÓN A ESTA DECISIÓN. ADEMÁS LA INSTITUCIÓN QUEDA EXONERADA DE TODA RESPONSABILIDAD CIVIL Y PROFESIONAL EN CASO DE PRESENTARSE COMPLICACIONES, CONSECUENCIAS O SECUELAS DERIVADAS DE ESTA DECISIÓN.</td>\n" +
            "               </tr>\n" +
            "            </tbody>\n" +
            "         </table>\n" +
            "         <table style=\"margin-right: auto; width: 100%\">\n" +
            "            <tbody class=\"alineacion-center\">\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">\n" +
            "                     <div class=\"right-content,image-cell\">\n" +
            "                        <span>\n" +
            "                        <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignatureProfessional@." + IMAGE_FORMAT + "\"  width=\"130\" />\n" +
            "                        </span>\n" +
            "                     </div>\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">\n" +
            "                     @NombreEnfermero@\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">\n" +
            "                     Especialidad: @Speciality@\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td colspan=\"4\">\n" +
            "                     Reg.Medico: @NroDocumentoProfessional@\n" +
            "                  </td>\n" +
            "               </tr>\n" +
            "            </tbody>\n" +
            "         </table>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";


    public ConsentVoluntaryDischarge(Configuration configuration) {
        super(configuration);
        setTypeConsent(TYPE);
    }

    @Override
    public String dataValidation() {

        if (this.getPatient() != null
                && this.getPatient().getDocumentNumber() != null
                && this.getPatient().getDocumentNumber().equals("")
                && !this.getPatient().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el paciente";

        }
        if (this.getPatient() != null
                && this.getPatient().getName() != null
                && this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (this.getProfessional() != null
                && !this.getProfessional().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el profesional que realiza el procedimiento";

        }
        if (this.getPatient().getAge() != null
                && !this.getPatient().getAge().toString().matches(REGEX_DIGIT)) {
            return "Ingrese un valor númerico correcto en campo Edad";

        }
        if (this.getPatient().getBornDate() != null
                && !this.getPatient().getBornDate("dd-MM-yyyy").matches(REGEX_DATE)) {
            return "La fecha de nacimiento no es valida";

        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";

        }

        return null;
    }

    @Override
    public String getFormat() {
        String html = FORMAT_DOCUMENT_WITH_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());

        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Hora@", this.getDate("hh:mm:ss a"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));
        html = html.replace("@NroDocumento@", this.getPatient().getDocumentNumber());
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replace("@NombreEnfermero@", this.getProfessional().getName());
        html = html.replace("@TipoDoc@", this.getPatient().getDocumentType().getInitials());
        html = html.replace("@TipoDocDescription@", this.getPatient().getDocumentType().getDescription());
        html = html.replace("@NroAdmission@", this.getPatient().getAdmissionNumber());
        LocalDate bornDate = LocalDate.parse(this.getPatient().getBornDate("yyyy-MM-dd"));
        LocalDate actualDate = LocalDate.now();
        Period age = Period.between(bornDate, actualDate);
        html = html.replace("@Age@", age.getYears() + " años " + age.getMonths() + " meses "+ age.getDays() + " días");
        html = html.replace("@Gender@", this.getPatient().isGender() ? "Masculino" : "Femenino");
        html = html.replace("@Speciality@", this.getProfessional().getSpecialty().getDescripcion());
        html = html.replace("@NroRegistro@", this.getProfessional().getRegistryNumber().toString());
        html = html.replace("@TipoDocGuardianDescription@", this.getPatient().getGuardian().getDocumentType().getInitials());
        html = html.replace("@NroDocumentoGuardian@", this.getPatient().getGuardian().getDocumentNumber());
        html = html.replace("@ExpeditionPlace@", this.getPatient().getExpeditionPlace());
        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
