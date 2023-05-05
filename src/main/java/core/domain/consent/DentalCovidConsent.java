package core.domain.consent;

import core.domain.bus.command.Command;
import utilidades.Constantes;

public class DentalCovidConsent extends ConsentInterface implements Command {

    private static final String TYPE = "ODONTOLOGIA_COVID";
    private static final String URL = "consentimiento_odontologico_covid.xhtml?faces-redirect=true";


    private static final String FORMAT_DOCUMENT_WITHOUT_GUARDIAN = "<html>\n"
            + "            <head>\n"
            + "            <title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "            <meta charset=\"utf-8\">\n"
            + "            <link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "            </head>\n"
            + "            <body>\n"
            + "            <div class=\"container\" style=\"float: left;\">\n"
            + "            	<header >\n"
            + "            		<table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "            	        <tbody  class=\"alineacion-center\">\n"
            + "            	                <tr >\n"
            + "            	                    <td  rowspan=\"3\" >\n"
            + "            	                        <img  src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "            	                    </td>\n"
            + "                                 <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                                 <td >FECHA:</td>\n"
            + "                                 <td >@Fecha@</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            +
            "                                 <td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO GENERAL PARA TRATAMIENTO ODONTOLÓGICO EN EL MARCO DE LA PANDEMIA COVID-19</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCPM-F-001</td>\n"
            + "                             </tr>        \n"
            + "                     </tbody>\n"
            + "                 </table>\n"
            + "             </header>\n"
            + "            \n"
            + "             <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                                    <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                                         <tbody  class=\"alineacion-left\">\n"
            + "                                                 <tr >\n"
            +
            "                                                     <td colspan=\"4\">DATOS DEL PACIENTE,ACUDIENTE Y/O REPRESENTANTE LEGAL</td>\n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                     <td colspan=\"2\">NOMBRES Y APELLIDOS DEL USUARIO: </td>\n"
            +
            "                                                     <td colspan=\"2\">@Paciente@</td>                                            \n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                     <td colspan=\"2\">NOMBRES Y APELLIDOS DEL ACUDIENTE:</td>\n"
            + "                                                     <td colspan=\"2\">@Acudiente@</td>\n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                    <td colspan=\"1\">EDAD: @edad@</td>\n"
            + "                                                    <td colspan=\"2\">DOCUMENTO DE IDENTIDAD: @NroDocumento@</td>\n"
            + "                                                    <td colspan=\"1\">FECHA ATENCION (DD/MM/AAAA): @Fecha@</td> \n"
            + "                                                 </tr>                                                     \n"
            + "                                                 <tr></tr> \n"
            + "                                         </tbody>\n"
            + "                                    </table>\n"
            +
            "                                     <p>Actuando en calidad de paciente o acudiente por medio del presente documento manifiesto:</p>\n"
            + "                                       \n"
            + "            \n"
            +
            "                                     <p>Que por voluntad propia y debidamente informado (a) consiento recibir tratamiento odontológico de emergencia/urgencia a ser realizado durante la Pandemia de COVID-19.\n"
            +
            "                                     Entiendo que el virus COVID-19 tiene un periodo largo de incubación durante el cual sus portadores pueden estar asintomáticos, siendo altamente contagioso. Entiendo que, al momento, debido a las limitaciones para la realización de pruebas virales, es imposible determinar quién es portador de virus y quien no.\n"
            +
            "                                     Los procedimientos odontológicos pueden generar aerosoles que permiten la diseminación de la enfermedad. La naturaleza ultrafina del aerosol que producen los equipos le permite permanecer suspendido en el aire por minutos o hasta horas, lo cual puede transmitir el virus COVID-19.</p>\n"
            + "                                     <ul>\n"
            +
            "                                          <li>Entiendo que, a pesar del seguimiento de normas de bioseguridad en el consultorio odontológico, debido a la presencia de otros pacientes, a las características del virus y del procedimiento odontológico, existe un riesgo elevado de contraer el virus por el solo hecho de permanecer en el consultorio @riesgos@</li>\n"
            +
            "                                          <li>Confirmo que no presento, ni he presentado en los últimos 14 días, ninguno de los síntomas de COVID-19 de la siguiente lista: fiebre, dificultad respiratoria, tos seca, secreción nasal, dolor de garganta @tieneSintomas@ </li>\n"
            +
            "                                          <li>Declaro que no he estado en contacto con alguna persona con confirmación de COVID-19 o con cuadro respiratorio agudo en los últimos 14 días @contactoCovid@ </li>\n"
            +
            "                                          <li>Entiendo que viajar por transporte aéreo incrementa significativamente el riesgo de contraer y transmitir el virus COVID-19. Constato que no he realizado viajes por transporte aéreo en los últimos 14 días @viajo@</li>\n"
            +
            "                                          <li>Entiendo que organismos internacionales de salud recomiendan en distanciamiento social de mínimo 2 metros, lo cual es imposible durante el tratamiento odontológico @riesgos@ . </li>\n"
            + "                                     </ul>\n"
            +
            "                                    <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            +
            "                                    <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "            \n"
            + "                                     <table  >\n"
            + "                                         <tbody>\n"
            + "                                             <tr>\n"
            + "                                                 <td class=\"td-firma\">\n"
            + "                                                         <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                             <p>Firma del usuario o acudiente:</p>\n"
            + "                                                             <p>Idetificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                                         </div>\n"
            + "                                                         <div>\n"
            + "                                                             <span class=\"position-firma\">\n"
            + "                                                                 <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP +
            NAME_SIGNATURE + "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                                 <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                                 <div class=\"subrayado3\"><u><i>@TipoDoc@ @NroDocumento@</i></u></div>\n"
            + "                                                             </span>\n"
            + "                                                         </div>\n"
            + "                                                    \n"
            + "                                                 </td>\n"
            + "                                             </tr>\n"
            + "                                             <tr>\n"
            + "                                                 <td class=\"td-firma\">\n"
            + "                                                         <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                             <p>Firma odontólogo tratante:</p>\n"
            +
            "                                                             <p>Identificación:<u><i>@TipoDocProfesional@  @NroDocumentoProfesional@</i></u></p>\n"
            + "                                                         </div>\n"
            + "                                                         <div>\n"
            + "                                                             <span class=\"position-firma\">\n"
            + "                                                                 <img class=\"img-firma-profesional\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                                 <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                                 <div class=\"subrayado3\"><u><i>@TipoDocProfesional@  @NroDocumentoProfesional@</i></u> Registro: <u><i>@NroRegistro@</i></u></div>\n"
            + "                                                             </span>\n"
            + "                                                         </div>\n"
            + "                                                    \n"
            + "                                                 </td>\n"
            + "                                             </tr>\n"
            + "                                         </tbody>\n"
            + "                                     </table>\n"
            + "             </div>\n"
            + "            </div>\n"
            + "            </body>\n"
            + "            </html>";
    public static final String FORMAT_DOCUMENT_WITH_GUARDIAN = "<html>\n"
            + "            <head>\n"
            + "            <title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "            <meta charset=\"utf-8\">\n"
            + "            <link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "            </head>\n"
            + "            <body>\n"
            + "            <div class=\"container\" style=\"float: left;\">\n"
            + "            	<header >\n"
            + "            		<table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "            	        <tbody  class=\"alineacion-center\">\n"
            + "            	                <tr >\n"
            + "            	                    <td  rowspan=\"3\" >\n"
            + "            	                        <img  src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "            	                    </td>\n"
            + "                                 <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                                 <td >FECHA:</td>\n"
            + "                                 <td >@Fecha@</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            +
            "                                 <td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO GENERAL PARA TRATAMIENTO ODONTOLÓGICO EN EL MARCO DE LA PANDEMIA COVID-19</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCPM-F-001</td>\n"
            + "                             </tr>        \n"
            + "                     </tbody>\n"
            + "                 </table>\n"
            + "             </header>\n"
            + "            \n"
            + "             <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                                    <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                                         <tbody  class=\"alineacion-left\">\n"
            + "                                                 <tr >\n"
            +
            "                                                     <td colspan=\"4\">DATOS DEL PACIENTE,ACUDIENTE Y/O REPRESENTANTE LEGAL</td>\n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                     <td colspan=\"2\">NOMBRES Y APELLIDOS DEL USUARIO: </td>\n"
            +
            "                                                     <td colspan=\"2\">@Paciente@</td>                                            \n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                     <td colspan=\"2\">NOMBRES Y APELLIDOS DEL ACUDIENTE:</td>\n"
            + "                                                     <td colspan=\"2\">@Acudiente@</td>\n"
            + "                                                 </tr>\n"
            + "                                                 <tr>\n"
            + "                                                    <td colspan=\"1\">EDAD: @edad@</td>\n"
            + "                                                    <td colspan=\"2\">DOCUMENTO DE IDENTIDAD: @NroDocumento2@</td>\n"
            + "                                                    <td colspan=\"1\">FECHA ATENCION (DD/MM/AAAA): @Fecha@</td> \n"
            + "                                                 </tr>                                                     \n"
            + "                                                 <tr></tr> \n"
            + "                                         </tbody>\n"
            + "                                    </table>\n"
            +
            "                                     <p>Actuando en calidad de paciente o acudiente por medio del presente documento manifiesto:</p>\n"
            + "                                       \n"
            + "            \n"
            +
            "                                     <p>Que por voluntad propia y debidamente informado (a) consiento recibir tratamiento odontológico de emergencia/urgencia a ser realizado durante la Pandemia de COVID-19.\n"
            +
            "                                     Entiendo que el virus COVID-19 tiene un periodo largo de incubación durante el cual sus portadores pueden estar asintomáticos, siendo altamente contagioso. Entiendo que, al momento, debido a las limitaciones para la realización de pruebas virales, es imposible determinar quién es portador de virus y quien no.\n"
            +
            "                                     Los procedimientos odontológicos pueden generar aerosoles que permiten la diseminación de la enfermedad. La naturaleza ultrafina del aerosol que producen los equipos le permite permanecer suspendido en el aire por minutos o hasta horas, lo cual puede transmitir el virus COVID-19.</p>\n"
            + "                                     <ul>\n"
            +
            "                                          <li>Entiendo que, a pesar del seguimiento de normas de bioseguridad en el consultorio odontológico, debido a la presencia de otros pacientes, a las características del virus y del procedimiento odontológico, existe un riesgo elevado de contraer el virus por el solo hecho de permanecer en el consultorio @riesgos@</li>\n"
            +
            "                                          <li>Confirmo que no presento, ni he presentado en los últimos 14 días, ninguno de los síntomas de COVID-19 de la siguiente lista: fiebre, dificultad respiratoria, tos seca, secreción nasal, dolor de garganta @tieneSintomas@ </li>\n"
            +
            "                                          <li>Declaro que no he estado en contacto con alguna persona con confirmación de COVID-19 o con cuadro respiratorio agudo en los últimos 14 días @contactoCovid@ </li>\n"
            +
            "                                          <li>Entiendo que viajar por transporte aéreo incrementa significativamente el riesgo de contraer y transmitir el virus COVID-19. Constato que no he realizado viajes por transporte aéreo en los últimos 14 días @viajo@</li>\n"
            +
            "                                          <li>Entiendo que organismos internacionales de salud recomiendan en distanciamiento social de mínimo 2 metros, lo cual es imposible durante el tratamiento odontológico @riesgos@ . </li>\n"
            + "                                     </ul>\n"
            +
            "                                    <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            +
            "                                    <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "            \n"
            + "                                     <table  >\n"
            + "                                         <tbody>\n"
            + "                                             <tr>\n"
            + "                                                 <td class=\"td-firma\">\n"
            + "                                                         <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                             <p>Firma del usuario o acudiente:</p>\n"
            + "                                                             <p>Idetificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                                         </div>\n"
            + "                                                         <div>\n"
            + "                                                             <span class=\"position-firma\">\n"
            + "                                                                 <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP +
            NAME_SIGNATURE + "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                                 <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                                 <div class=\"subrayado3\"><u><i>@TipoDoc@ @NroDocumento@</i></u></div>\n"
            + "                                                             </span>\n"
            + "                                                         </div>\n"
            + "                                                    \n"
            + "                                                 </td>\n"
            + "                                             </tr>\n"
            + "                                             <tr>\n"
            + "                                                 <td class=\"td-firma\">\n"
            + "                                                         <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                             <p>Firma odontólogo tratante:</p>\n"
            +
            "                                                             <p>Identificación:<u><i>@TipoDocProfesional@  @NroDocumentoProfesional@</i></u></p>\n"
            + "                                                         </div>\n"
            + "                                                         <div>\n"
            + "                                                             <span class=\"position-firma\">\n"
            + "                                                                 <img class=\"img-firma-profesional\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                                 <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                                 <div class=\"subrayado3\"><u><i>@TipoDocProfesional@  @NroDocumentoProfesional@</i></u> Registro: <u><i>@NroRegistro@</i></u></div>\n"
            + "                                                             </span>\n"
            + "                                                         </div>\n"
            + "                                                    \n"
            + "                                                 </td>\n"
            + "                                             </tr>\n"
            + "                                         </tbody>\n"
            + "                                     </table>\n"
            + "             </div>\n"
            + "            </div>\n"
            + "            </body>\n"
            + "            </html>";

    public DentalCovidConsent() {
        setTypeConsent(TYPE);
        setDocumentFormatWithGuardian(FORMAT_DOCUMENT_WITH_GUARDIAN);
        setDocumentFormatWithoutGuardian(FORMAT_DOCUMENT_WITHOUT_GUARDIAN);
    }

    @Override
    public String dataValidation() {
        if (this.getPatient() != null
                && this.getPatient().getDocumentNumber() != null
                && this.getPatient().getDocumentNumber().equals("")
                && !this.getPatient().getDocumentNumber().matches(Constantes.REGEX_DOCUMENTO)) {
            return "Ingrese un nro de documento válido para el paciente";

        }
        if (this.getPatient() != null
                && this.getPatient().getName() != null
                && this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(Constantes.REGEX_NOMBRE)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (isGuardian() && this.getPatient() != null
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getDocumentNumber() != null
                && this.getPatient().getGuardian().getDocumentNumber().equals("")
                && !this.getPatient().getGuardian().getDocumentNumber().matches(Constantes.REGEX_DOCUMENTO)) {
            return "Ingrese un nro de documento válido para el acudiente";

        }
        if (isGuardian()
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getName() != null
                && this.getPatient().getGuardian().getName().equals("")
                && !this.getPatient().getGuardian().getName().matches(Constantes.REGEX_NOMBRE)) {
            return "Ingrese un nombre válido para el acudiente";

        }

        if (this.getPatient().getAge() != null
                && !this.getPatient().getAge().toString().matches(Constantes.REGEX_DIGITO)) {
            return "Ingrese un número válido para la Edad";

        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";

        }
        return null;
    }

    @Override
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
        html = html.replace("@TipoDoc@",
                (isGuardian() ? this.getGuardianData().getDocumentType().getInitials() : this.getPatient().getDocumentType().getInitials()));
        html = html.replace("@NroDocumento@",
                (isGuardian() ? this.getGuardianData().getDocumentNumber() : this.getPatient().getDocumentNumber()));
        html = html.replace("@NroDocumento2@", (isGuardian() ? this.getPatient().getDocumentNumber() : ""));
        html = html.replace("@Acudiente@", (isGuardian() ? this.getGuardianData().getName() : ""));
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replace("@datosPersonalesSI@", this.getDataTreatment() ? "<u><i>X</i></u>" : "_");
        html = html.replace("@datosPersonalesNO@", this.getDataTreatment() ? "_" : "<u><i>X</i></u>");
        html = html.replace("@NroRegistro@", this.getProfessional().getRegistryNumber().toString());
        html = html.replace("@riesgos@", this.getRiskBenefit() ? "<u><i><strong> SI </strong></i></u>" : "<u><i><strong> NO </strong></i></u>");
        html = html.replaceAll("@edad@", this.getPatient().getAge().toString());

        if (this.getHadContactCovid() != null) {
            html = html.replace("@contactoCovid@", this.getHadContactCovid() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");
        }

        if (this.getProfessional() != null && this.getProfessional().getDocumentNumber() != null) {
            html = html.replace("@NroDocumentoProfesional@", this.getProfessional().getDocumentNumber());
            html = html.replace("@TipoDocProfesional@", this.getProfessional().getDocumentType().getInitials());
        }
        html = html.replace("@viajo@", this.getHadTrips() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");
        html = html.replace("@tieneSintomas@", this.getHasSymptoms() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");

        return html;
    }
    @Override
    public String getUrl() {
        return URL;
    }
}
