package core.domain.consent;

import core.domain.bus.command.Command;

public class EmergencyConsent extends ConsentInterface implements Command {

    private static final String TYPE = "URGENCIAS";
    private static final String URL = "consentimiento_urgencias.xhtml?faces-redirect=true";
    private static final String FORMAT_DOCUMENT_WITHOUT_GUARDIAN = "<html>\n"
            + "<head>\n"
            + "<title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "<meta charset=\"utf-8\">\n"
            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "</head>\n"
            + "<body>\n"
            + "<div class=\"container\" style=\"float: left;\">\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "     <table class=\"with-border\" style=\"width: 100%; \">\n"
            + "         <tbody class=\"with-border\" class=\"alineacion-left\">\n"
            + "                \n"
            + "                 <tr>\n"
            + "                     <td style=\"border-bottom:none;\">\n"
            + "                        <div>\n"
            + "                             <p>Yo <u><i>@Paciente@</u></i>, con número de identificación <u><i>@NroDocumento@</u></i>, ingreso al servicio de <strong>URGENCIAS</strong> siendo usuario de <u><i>@eps@</u></i>, en la fecha <u><i>@Fecha@</u></i>,\n"
            + "                             de esta manera manifesto que se me brindará atención en la clinica Santa Clara Ltda. </p>\n"
            + "                        </div>\n"
            + "                        <div>\n"
            + "                            <span class=\"position-firma\">\n"
            + "                                <img  src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n"
            + "                                <div class=\"subrayado\">______________________________</div>\n"
            + "                                <p>Firma del usuario o acudiente</p>\n"
            + "                            </span>\n"
            + "                        </div>\n"
            + "                        <div style=\"float: right;\">\n"
            + "                           <img   src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "                        </div>\n"
            + "                     </td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                    <td style=\"border-top:none;\">\n"
            + "                        <div style=\"margin-left:8px;\">"
            + "                             AFFA-F-005.V1"
            + "                        </div>"
            + "                    </td>\n"
            + "                 </tr>\n"
            + "         </tbody>\n"
            + "     </table>"
            + " </div>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

    private static final String FORMAT_DOCUMENT_WITH_GUARDIAN = "<html>\n"
            + "<head>\n"
            + "<title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "<meta charset=\"utf-8\">\n"
            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "</head>\n"
            + "<body>\n"
            + "<div class=\"container\" style=\"float: left;\">\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "     <table class=\"with-border\" style=\"width: 100%; \">\n"
            + "         <tbody class=\"with-border\" class=\"alineacion-left\">\n"
            + "                \n"
            + "                 <tr>\n"
            + "                     <td style=\"border-bottom:none;\">\n"
            + "                        <div>\n"
            + "                             <p>Yo <u><i>@Acudiente@</u></i>, con número de identificación <u><i>@NroDocumento@</u></i>, autorizo el ingreso al servicio de <strong>URGENCIAS</strong> del menor <u><i>@Paciente@</u></i> con número de identificación <u><i>@NroDocumento2@</u></i>, siendo usuario de <u><i>@eps@</u></i>, en la fecha <u><i>@Fecha@</u></i>,\n"
            + "                             de esta manera manifesto que se le brindará atención en la clinica Santa Clara Ltda. </p>\n"
            + "                        </div>\n"
            + "                        <div>\n"
            + "                            <span class=\"position-firma\">\n"
            + "                                <img  src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n"
            + "                                <div class=\"subrayado\">______________________________</div>\n"
            + "                                <p>Firma del usuario o acudiente</p>\n"
            + "                            </span>\n"
            + "                        </div>\n"
            + "                        <div style=\"float: right;\">\n"
            + "                           <img   src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "                        </div>\n"
            + "                     </td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                    <td style=\"border-top:none;\">\n"
            + "                        <div style=\"margin-left:8px;\">"
            + "                             AFFA-F-005.V1"
            + "                        </div>"
            + "                    </td>\n"
            + "                 </tr>\n"
            + "         </tbody>\n"
            + "     </table>"
            + " </div>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

    public EmergencyConsent() {
        setTypeConsent(TYPE);
        setDocumentFormatWithGuardian(FORMAT_DOCUMENT_WITH_GUARDIAN);
        setDocumentFormatWithoutGuardian(FORMAT_DOCUMENT_WITHOUT_GUARDIAN);
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
        if (this.getPatient().getName() != null
                && !this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (this.isGuardian() && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getDocumentNumber() != null
                && this.getPatient().getGuardian().getDocumentNumber().isEmpty()
                && !this.getPatient().getGuardian().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el acudiente";

        }
        if (this.isGuardian()
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getName() != null
                && !this.getPatient().getGuardian().getName().isEmpty()
                && !this.getPatient().getGuardian().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el acudiente";

        }

        if (this.getPatient().getEps() != null
                && !this.getPatient().getEps().matches(REGEX_NAME)) {
            return "Ingrese un valor nombre válido para la EPS";

        }
        if (this.getSignature() == null || this.getSignature().isEmpty()) {
            return "Ingrese la firma";

        }
        return null;
    }

    public String getFormat() {
        String html;
        if (this.isGuardian()) {
            html = FORMAT_DOCUMENT_WITH_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
        } else {
            html = FORMAT_DOCUMENT_WITHOUT_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
        }
        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));

        html = html.replace("@NroDocumento@", (isGuardian() ? this.getGuardianData().getDocumentNumber() : this.getPatient().getDocumentNumber()));
        html = html.replace("@NroDocumento2@", (isGuardian() ? this.getPatient().getDocumentNumber() : ""));
        html = html.replace("@Acudiente@", (isGuardian() ? this.getGuardianData().getName() : ""));

        html = html.replace("@Paciente@", this.getPatient().getName());

        html = html.replaceAll("@eps@", this.getEPSPatient());

        return html;

    }

    public String getUrl() {
        return URL;
    }




}
