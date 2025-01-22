package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;
import java.io.Serializable;

public class ConsentAbandon extends ConsentInterface implements Command {

    public static final String TYPE = "Abandono";
    private static final String URL = "consentimiento_abandono.xhtml?faces-redirect=true";
    private String FORMAT_DOCUMENT = "<html>\n"
            + "<head>\n"
            + "<title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
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
            + "                     <td >SISTEMA DE GESTION INTEGRADO EN CALIDAD</td>\n"
            + "                     <td >FECHA:</td>\n"
            + "                     <td >29/11/2024</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td  rowspan=\"2\" >PROCEDIMIENTO ANTE ABANDONO DEL @Abandono@</td>\n"
            + "                     <td  >VERSION:</td>\n"
            + "                     <td >3</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td >CODIGO:</td>\n"
            + "                     <td >@Code@</td>\n"
            + "                 </tr>        \n"
            + "         </tbody>\n"
            + "     </table>\n"
            + " </header>\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + " <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n" +
            "                <tbody class=\"alineacion-left\">\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\" style=\"text-align:center\">ABANDONO DEL @Abandono@ EN LAS INSTALACIONES DE LA IPS</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\">De acuerdo con la responsabilidad legal del cuidador del @mAbandono@, la IPS, en búsqueda de la proteccion de los derechos del @mAbandono@ dispone que la mejor opcion ante el abandono de 6 horas realizara reporte al Instituto Colombiano de Bienestar Familiar - ICBF para que sea esta entidad la que tome las medidas respectivas y la custodia del @mAbandono@; en caso no lograr el reporte inmediato al ICBF, la IPS, informara inmediatamente a la POLICIA NACIONAL. </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\" style=\"text-align:center\">RETIRO VOLUNTARIO DE UN @Abandono@</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\">En cumplimiento de las normas que rigen la prestacion de los servicios de salud, la ips, de acuerdo a esta responsabilidad, dispone que la facultad del cuidador o acompañante de un @mAbandono@ para retirarlo del servicio de atencion de salud ofertado por la ips, sera reportado inmediatamente al Instituto Colombiano de Bienestar Familiar para que tome las medidas respectivas; en caso de no lograr esta comunicacion inmediatamente se acudirá al denuncio ante la POLICIA NACIONAL </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\"></td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\">SE SOLICITA AL ACOMPAÑANTE PERMANENTE AVISAR AL PERSONAL DE ENFERMERIA SOBRE CUALQUIER NECESIDAD QUE REQUIERA EL @Abandono@</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\"></td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"2\">" +
            "                           <div class=\"container-signature\">\n" +
            "                                <div class=\"left-content\">YO: @NombreAcudiente@ </div>" +
            "                                <div class=\"right-content,image-cell\">\n" +
            "                                    <span class=\"background-image\">\n" +
            "                                       <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n" +
            "                                    </span>\n" +
            "                                </div>\n" +
            "                           </div>\n" +
            "                        </td>\n" +
            "                        <td colspan=\"2\">CON: @TipoDocAcudiente@  @NroDocumentoAcudiente@</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"4\">RECIBI LA NOTIFICCION POR PARTE DEL PERSONAL DE LA IPS SOBRE LOS PROTOCOLOS DE ABANDONO Y RETIRO VOLUNTACION DEL @Abandono@ Y ENTIENDO LAS IMPLICACIONES QUE ATAÑEN</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"2\">NOMBRE @Abandono@: @Nombre@</td>\n" +
            "                        <td colspan=\"2\">CON: @TipoDoc@ @NroDocumento@</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td colspan=\"2\">FECHA: @Fecha@</td>\n" +
            "                        <td colspan=\"2\">HORA: @Hora@</td>\n" +
            "                    </tr>\n" +
            "                </tbody>\n" +
            "            </table>"
            + "      </div>\n"
            + "      </div>\n"
            + "   </body>\n"
            + "</html>";


    public ConsentAbandon(Configuration configuration) {
        super(configuration);
        setTypeConsent(TYPE);
    }

    @Override
    public String dataValidation() {
        if (this.getPatient() == null) {
            return "Ingrese datos del paciente";
        }
        if (this.getPatient().getDocumentNumber() != null
                && !this.getPatient().getDocumentNumber().isEmpty()
                && !this.getPatient().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el paciente";

        }
        if (this.getGuardianData() != null
                && this.getGuardianData().getDocumentNumber() != null
                && this.getGuardianData().getDocumentNumber().isEmpty()
                && !this.getGuardianData().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el acudiente";
        }
        if (this.getPatient() != null
                && this.getPatient().getName() != null
                && this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (this.getGuardianData() != null
                && this.getGuardianData().getName() != null
                && this.getGuardianData().getName().equals("")
                && !this.getGuardianData().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el acudiente";
        }
        if (this.getGuardianData().getDocumentNumber().equals(this.getPatient().getDocumentNumber())
        && this.getGuardianData().getDocumentType().equals(this.getPatient().getDocumentType())){
            return "Los documentos no pueden ser iguales";
        }

        return null;
    }

    @Override
    public String getFormat() {
        String html;
        String abandonOf;
        String codigo;
        if (!this.isGuardian()) {
            abandonOf="ADULTO MAYOR";
            codigo = "SBCUO-F-29";
        } else {
            abandonOf="MENOR DE EDAD";
            codigo = "SBCUO-F-28";
        }
        html = FORMAT_DOCUMENT.replace("@docSignature@", this.getSignatureConsent());
        html = html.replace("@Abandono@", abandonOf);
        html = html.replace("@Code@", codigo);
        html = html.replace("@mAbandono@", abandonOf.toLowerCase());
        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));
        html = html.replace("@Hora@", this.getDate("hh:mm:ss a"));

        html = html.replace("@NroDocumento@", this.getPatient().getDocumentNumber());
        html = html.replace("@NroDocumentoAcudiente@", this.getGuardianData().getDocumentNumber());
        html = html.replace("@TipoDoc@", this.getPatient().getDocumentType().getInitials());
        html = html.replace("@TipoDocAcudiente@", this.getGuardianData().getDocumentType().getInitials());
        html = html.replace("@NombreAcudiente@", this.getGuardianData().getName());
        html = html.replace("@Nombre@", this.getPatient().getName());


        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
