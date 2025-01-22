package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;

public class CovidConsent extends ConsentInterface implements Command {

    private static final String TYPE = "COVID";
    private static final String URL = "consentimiento_covid.xhtml?faces-redirect=true";
    private String FORMAT_DOCUMENT_WITHOUT_GUARDIAN = "<html>\n"
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
            + "                     <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                     <td >FECHA:</td>\n"
            + "                     <td >05/11/2024</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO PARA PRUEBA DETECCION DE ANTIGENO PARA COVID-19</td>\n"
            + "                     <td  >VERSION:</td>\n"
            + "                     <td >5</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td >CODIGO:</td>\n"
            + "                     <td >SBCL-F-017</td>\n"
            + "                 </tr>        \n"
            + "         </tbody>\n"
            + "     </table>\n"
            + " </header>\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                        <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                             <tbody  class=\"alineacion-left\">\n"
            + "                                     <tr >\n"
            + "                                         <td colspan=\"4\">DATOS DEL PACIENTE Y/O REPRESENTANTE LEGAL</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">NOMBRES Y APELLIDOS DEL USUARIO: @Paciente@</td>\n"
            + "                                         <td colspan=\"2\">FECHA ATENCION (DD/MM/AAAA): @Fecha@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">DOCUMENTO DE IDENTIDAD: @NroDocumento@</td>\n"
            + "                                         <td colspan=\"2\">OCUPACIÓN: @Ocupacion@</td>\n"
            + "                                     </tr>  \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">NRO TELEFONO: @Telefono@</td>\n"
            + "                                         <td colspan=\"2\">CORREO ELECTRÓNICO: @email@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            +
            "                                         <td colspan=\"1\">TRABAJADOR DE LA SALUD: SI@trabajadorSaludSI@NO@trabajadorSaludNO@</td>\n"
            + "                                         <td colspan=\"1\">EDAD: @edad@</td>\n"
            + "                                         <td colspan=\"2\">EPS: @eps@</td>\n"
            + "                                     </tr>   \n"
            + "                                     <tr>\n"
            +
            "                                         <td colspan=\"2\">HA ESTADO EN CONTACTO CON CASO CONFIRMADO SI @contactoCovidSI@ NO@contactoCovidNO@</td>\n"
            + "                                         <td rowspan=\"2\">SINTOMAS QUE PRESENTA: @sintomas@</td>\n"
            + "                                         <td rowspan=\"2\">FECHA INICIO SINTOMAS (DD/MM/AAAA): @fechaSintomas@</td>\n"
            + "                                     </tr>   \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">VIAJES REALIZADOS: @viajes@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td rowspan=\"2\">¿ESTA USTED VACUNADO?: SI @vacunadoSI@ NO@vacunadoNO@</td>\n"
            + "                                         <td rowspan=\"2\">¿CUANTAS DOSIS?: @dosis@</td>\n"
            + "                                         <td rowspan=\"2\">NOMBRE VACUNA: @nombreVacuna@</td>\n"
            + "                                         <td rowspan=\"2\">FECHA VACUNA(DD/MM/AAAA): @fechaVacuna@</td>\n"
            + "                                     </tr>  \n"
            + "                                     <tr></tr> \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"4\">NOMBRE Y APELLIDOS DEL ACUDIENTE: @Acudiente@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"4\">DOCUMENTO DE IDENTIDAD DEL ACUDIENTE:@NroDocumento2@</td>\n"
            + "                                     </tr>      \n"
            + "                             </tbody>\n"
            + "                        </table>\n"
            +
            "                         <p>La prueba de Antígeno para SARS-CoV-2 Covid-19 tiene la facilidad en su uso y en la implementación en los laboratorios. Se ha demostrado una alta sensibilidad y una muy buena especificidad en las validaciones realizadas en el país. La muestra que se requiere para estas pruebas es a través de hisopado nasofaríngeo.</p>\n"
            + "                           \n"
            + "\n"
            +
            "                         <p><strong>Indicaciones:</strong> Se realizará a personas con síntomas de menos de 11 días, atendidos en el ámbito de urgencias u hospitalización y consulta externa, donde por las condiciones territoriales no se tenga la capacidad para realizar pruebas moleculares RT-PCR. En los  servicios ambulatorios o domiciliarios a personas sintomáticas y grupos de riesgo priorizados. Al contacto asintomático no conviviente con el caso confirmado, dentro de un estudio de cerco epidemiológico. Personas que vivan en zonas rurales dispersas.</p>\n"
            +
            "                         <p><strong>Descripción y Riesgos:</strong> Se tomará la muestra introduciendo un hisopo estéril dentro de una de las dos fosas nasales de la nariz hasta alcanzar la superficie superior de la nasofaringe. Se gira el hisopo en repetidas ocasiones y se retira de la cavidad nasal.<br/>\n"
            +
            "                         Pueden existir síntomas menores algo molestos al momento de la toma de la muestra como dolor local, sangrado escaso y sensación de picazón nasal, náuseas y tos.</p>\n"
            +
            "                         <p><strong>Contraindicaciones para la Toma:</strong> fistulas nasales, pólipos nasales que no permitan la toma, poca colaboración por parte del paciente a la hora del procedimiento.</p>\n"
            +
            "                         <p><strong>Recomendaciones:</strong> Estas serán entregadas por el personal médico, bacteriólogo, enfermería de acuerdo con el resultado obtenido, en caso de que la prueba resulte POSITIVA y al ser la infección por COVID-19 un evento de  interés en salud pública la institución realizara los reportes respectivos a las entidades territoriales de salud para su respectivo seguimiento e investigación de su caso por lo que es importante  que usted al momento de acceder a la toma de este estudio conozca esta información y autorice y consienta  las acciones epidemiológicas derivadas en caso de que el resultado sea positivo.\n"
            +
            "                         Si se llegase a presentar una situación de urgencia durante el procedimiento debe saber que en la institución contamos con personal entrenado e idóneo para brindar una atención segura y oportuna quienes van a definir la necesidad de traslado a una unidad hospitalaria de mayor nivel.\n"
            +
            "                         Dado lo anterior he comprendido con claridad todo lo descrito y se me ha dado la oportunidad de hacer preguntas y todas ellas han sido resueltas de manera oportuna y satisfactoria.</p>\n"
            +
            "                        <p><strong>DOY MI CONSENTIMIENTO</strong> para que el responsable  de la atención  me realice el estudio solicitado, al aceptar la práctica del estudio, la entidad y el responsable de la atención quedaran autorizados para llevar a cabo las conductas y/o procedimientos necesarios para resolver aquellas complicaciones imprevisibles  del estudio que mediante este documento autorizo. Entiendo que puedo revocar este consentimiento en el momento que así lo desee, debiendo informar al equipo responsable de mi cambio de decisión.</p>\n"
            +
            "                        <p><strong>AUTORIZO</strong> para que mi información personal, datos clínicos y/o estudios se utilicen con fines epidemiológicos tratándose de una enfermedad de interés en Salud Publica SI@datosPersonalesSI@ NO@datosPersonalesNO@</p>\n"
            +
            "                        <p><strong>ACEPTO LA REALIZACIÓN DEL EXAMEN Y DECLARO QUE LA DECISIÓN QUE TOMO ES LIBRE Y VOLUNTARIA</strong> SI@riesgoSI@ NO@riesgoNO@</p>\n"
            + "\n"
            + "                         <table  >\n"
            + "                             <tbody>\n"
            + "                                 <tr>\n"
            + "                                     <td class=\"td-firma\">\n"
            + "                                             <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                 <p>Firma:</p>\n"
            + "                                                 <p>@TipoDoc@</p>\n"
            + "                                             </div>\n"
            + "                                             <div>\n"
            + "                                                 <span class=\"position-firma\">\n"
            + "                                                     <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n"
            + "                                                     <div class=\"subrayado\">______________________________</div>\n"
            + "                                                     <div class=\"subrayado3\"><u><i> @NroDocumento@</i></u></div>\n"
            + "                                                 </span>\n"
            + "                                             </div>\n"
            + "                                        <div>\n"
            + "                                         <span class=\"position-firma2\">\n"
            + "                                            <div class=\"subrayado4\" >\n"
            + "                                                 <p><u><i>@NombreEnfermero@</i></u></p>\n"
            + "                                                 <p>Nombre del profesional </p>\n"
            + "                                            </div>\n"
            + "                                        </span>\n"
            + "                                       </div>\n"
            + "                                     </td>\n"
            + "                                 </tr>\n"
            + "                             </tbody>\n"
            + "                         </table>\n"
            + " </div>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

    private String FORMAT_DOCUMENT_WITH_GUARDIAN = "<html>\n"
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
            + "                     <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                     <td >FECHA:</td>\n"
            + "                     <td >05/11/2024</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO PARA PRUEBA DETECCION DE ANTIGENO PARA COVID-19</td>\n"
            + "                     <td  >VERSION:</td>\n"
            + "                     <td >5</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td >CODIGO:</td>\n"
            + "                     <td >SBCL-F-017</td>\n"
            + "                 </tr>        \n"
            + "         </tbody>\n"
            + "     </table>\n"
            + " </header>\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                        <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                             <tbody  class=\"alineacion-left\">\n"
            + "                                     <tr >\n"
            + "                                         <td colspan=\"4\">DATOS DEL PACIENTE Y/O REPRESENTANTE LEGAL</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">NOMBRES Y APELLIDOS DEL USUARIO: @Paciente@</td>\n"
            + "                                         <td colspan=\"2\">FECHA ATENCION (DD/MM/AAAA): @Fecha@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">DOCUMENTO DE IDENTIDAD: @NroDocumento2@</td>\n"
            + "                                         <td colspan=\"2\">OCUPACIÓN: @Ocupacion@</td>\n"
            + "                                     </tr>  \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">NRO TELEFONO: @Telefono@</td>\n"
            + "                                         <td colspan=\"2\">CORREO ELECTRÓNICO: @email@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            +
            "                                         <td colspan=\"1\">TRABAJADOR DE LA SALUD: SI <u><i>@trabajadorSaludSI@</i></u> NO<u><i>@trabajadorSaludNO@</i></u></td>\n"
            + "                                         <td colspan=\"1\">EDAD: @edad@</td>\n"
            + "                                         <td colspan=\"2\">EPS: @eps@</td>\n"
            + "                                     </tr>   \n"
            + "                                     <tr>\n"
            +
            "                                         <td colspan=\"2\">HA ESTADO EN CONTACTO CON CASO CONFIRMADO SI <u><i>@contactoCovidSI@</i></u> NO<u><i>@contactoCovidNO@</i></u></td>\n"
            + "                                         <td rowspan=\"2\">SINTOMAS QUE PRESENTA: @sintomas@</td>\n"
            + "                                         <td rowspan=\"2\">FECHA INICIO SINTOMAS (DD/MM/AAAA): @fechaSintomas@</td>\n"
            + "                                     </tr>   \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"2\">VIAJES REALIZADOS: @viajes@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td rowspan=\"2\">¿ESTA USTEN VACUNADO?: SI @vacunadoSI@ NO@vacunadoNO@</td>\n"
            + "                                         <td rowspan=\"2\">¿CUANTAS DOSIS?: 1@dosis1@ 2@dosis2@</td>\n"
            + "                                         <td rowspan=\"2\">NOMBRE VACUNA: @nombreVacuna@</td>\n"
            + "                                         <td rowspan=\"2\">FECHA VACUNA(DD/MM/AAAA): @fechaVacuna@</td>\n"
            + "                                     </tr>  \n"
            + "                                     <tr></tr> \n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"4\">NOMBRE Y APELLIDOS DEL ACUDIENTE: @Acudiente@</td>\n"
            + "                                     </tr>\n"
            + "                                     <tr>\n"
            + "                                         <td colspan=\"4\">DOCUMENTO DE IDENTIDAD DEL ACUDIENTE:@NroDocumento@</td>\n"
            + "                                     </tr>      \n"
            + "                             </tbody>\n"
            + "                        </table>\n"
            +
            "                         <p>La prueba de Antígeno para SARS-CoV-2 Covid-19 tiene la facilidad en su uso y en la implementación en los laboratorios. Se ha demostrado una alta sensibilidad y una muy buena especificidad en las validaciones realizadas en el país. La muestra que se requiere para estas pruebas es a través de hisopado nasofaríngeo.</p>\n"
            + "                           \n"
            + "\n"
            +
            "                         <p><strong>Indicaciones:</strong> Se realizará a personas con síntomas de menos de 11 días, atendidos en el ámbito de urgencias u hospitalización y consulta externa, donde por las condiciones territoriales no se tenga la capacidad para realizar pruebas moleculares RT-PCR. En los  servicios ambulatorios o domiciliarios a personas sintomáticas y grupos de riesgo priorizados. Al contacto asintomático no conviviente con el caso confirmado, dentro de un estudio de cerco epidemiológico. Personas que vivan en zonas rurales dispersas.</p>\n"
            +
            "                         <p><strong>Descripción y Riesgos:</strong> Se tomará la muestra introduciendo un hisopo estéril dentro de una de las dos fosas nasales de la nariz hasta alcanzar la superficie superior de la nasofaringe. Se gira el hisopo en repetidas ocasiones y se retira de la cavidad nasal.<br/>\n"
            +
            "                         Pueden existir síntomas menores algo molestos al momento de la toma de la muestra como dolor local, sangrado escaso y sensación de picazón nasal, náuseas y tos.</p>\n"
            +
            "                         <p><strong>Contraindicaciones para la Toma:</strong> fistulas nasales, pólipos nasales que no permitan la toma, poca colaboración por parte del paciente a la hora del procedimiento.</p>\n"
            +
            "                         <p><strong>Recomendaciones:</strong> Estas serán entregadas por el personal médico, bacteriólogo, enfermería de acuerdo con el resultado obtenido, en caso de que la prueba resulte POSITIVA y al ser la infección por COVID-19 un evento de  interés en salud pública la institución realizara los reportes respectivos a las entidades territoriales de salud para su respectivo seguimiento e investigación de su caso por lo que es importante  que usted al momento de acceder a la toma de este estudio conozca esta información y autorice y consienta  las acciones epidemiológicas derivadas en caso de que el resultado sea positivo.\n"
            +
            "                         Si se llegase a presentar una situación de urgencia durante el procedimiento debe saber que en la institución contamos con personal entrenado e idóneo para brindar una atención segura y oportuna quienes van a definir la necesidad de traslado a una unidad hospitalaria de mayor nivel.\n"
            +
            "                         Dado lo anterior he comprendido con claridad todo lo descrito y se me ha dado la oportunidad de hacer preguntas y todas ellas han sido resueltas de manera oportuna y satisfactoria.</p>\n"
            +
            "                        <p><strong>DOY MI CONSENTIMIENTO</strong> para que el responsable  de la atención  me realice el estudio solicitado, al aceptar la práctica del estudio, la entidad y el responsable de la atención quedaran autorizados para llevar a cabo las conductas y/o procedimientos necesarios para resolver aquellas complicaciones imprevisibles  del estudio que mediante este documento autorizo. Entiendo que puedo revocar este consentimiento en el momento que así lo desee, debiendo informar al equipo responsable de mi cambio de decisión.</p>\n"
            +
            "                        <p><strong>AUTORIZO</strong> para que mi información personal, datos clínicos y/o estudios se utilicen con fines epidemiológicos tratándose de una enfermedad de interés en Salud Publica SI<u><i>@datosPersonalesSI@</i></u> NO<u><i>@datosPersonalesNO@</i></u></p>\n"
            +
            "                        <p><strong>ACEPTO LA REALIZACIÓN DEL EXAMEN Y DECLARO QUE LA DECISIÓN QUE TOMO ES LIBRE Y VOLUNTARIA</strong> SI<u><i>@riesgoSI@</i></u> NO<u><i>@riesgoNO@</i></u></p>\n"
            + "\n"
            + "                         <table  >\n"
            + "                             <tbody>\n"
            + "                                 <tr>\n"
            + "                                     <td class=\"td-firma\">\n"
            + "                                             <div style=\"float: left; margin-top: 32px\">\n"
            + "                                                 <p>Firma:</p>\n"
            + "                                                 <p>@TipoDoc@</p>\n"
            + "                                             </div>\n"
            + "                                             <div>\n"
            + "                                                 <span class=\"position-firma\">\n"
            + "                                                     <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n"
            + "                                                     <div class=\"subrayado\">______________________________</div>\n"
            + "                                                     <div class=\"subrayado3\"><u><i> @NroDocumento@</i></u></div>\n"
            + "                                                 </span>\n"
            + "                                             </div>\n"
            + "                                        <div>\n"
            + "                                         <span class=\"position-firma2\">\n"
            + "                                            <div class=\"subrayado4\" >\n"
            + "                                                 <p><u><i>@NombreEnfermero@</i></u></p>\n"
            + "                                                 <p>Nombre del profesional </p>\n"
            + "                                            </div>\n"
            + "                                        </span>\n"
            + "                                       </div>\n"
            + "                                     </td>\n"
            + "                                 </tr>\n"
            + "                             </tbody>\n"
            + "                         </table>\n"
            + " </div>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

    public CovidConsent(Configuration configuration) {
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
        if (isGuardian() && this.getPatient() != null
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getDocumentNumber() != null
                && this.getPatient().getGuardian().getDocumentNumber().equals("")
                && !this.getPatient().getGuardian().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el acudiente";

        }
        if (isGuardian()
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getName() != null
                && this.getPatient().getGuardian().getName().equals("")
                && !this.getPatient().getGuardian().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el acudiente";

        }
        if (this.getProfessional() != null
                && !this.getProfessional().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el profesional que realiza el procedimiento";

        }
        if (this.getPatient().getAge() != null
                && !this.getPatient().getAge().toString().matches(REGEX_DIGIT)) {
            return "Ingrese un valor númerico correcto en campo Edad";

        }
        if (this.getEPSPatient() != null
                && !this.getEPSPatient().matches(REGEX_NAME)) {
            return "Ingrese un valor nombre válido para la EPS";

        }
        if (this.getPatient().getPhoneNumber() != null
                && !this.getPatient().getPhoneNumber().matches(REGEX_CELL_PHONE_NUMBER)) {
            return "Ingrese un número de telefono válido";

        }
        if (this.getPatient().getEmail() != null
                && !this.getPatient().getEmail().matches(REGEX_EMAIL)) {
            return "Ingrese un correo electronico válido";

        }
        if (this.getHasSymptoms()
                && !this.getDescriptionOfSymptoms().matches(REGEX_NAME)) {
            return "Los sintomas no puede contener simbolos, números ni caracteres especilas";

        }
        if (this.getHasSymptoms() && (this.getSymptomsStartDate("dd-MM-yyyy") == null
                || !this.getSymptomsStartDate("dd-MM-yyyy").matches(REGEX_DATE))) {
            return "La fecha de los sintomas tiene formato incorrecto";

        }
        if (this.getVaccinated() && (this.getDateVaccine("dd-MM-yyyy") == null
                || !this.getDateVaccine("dd-MM-yyyy").matches(REGEX_DATE))) {
            return "La fecha de la vacuna tiene formato incorrecto";

        }
        if (this.getPatient().getOccupation() != null
                && !this.getPatient().getOccupation().matches(REGEX_NAME)) {
            return "La ocupación no puede contener simbolos, números ni caracteres especilas";

        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";

        }
        if (this.getHadTrips() && this.getTripsMade() != null
                && !this.getTripsMade().matches(REGEX_NAME)) {
            return "El campo viajes no puede tener números ni caracteres especiales";

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
        html = html.replace("@NroDocumento@",
                (isGuardian() ? this.getGuardianData().getDocumentNumber() : this.getPatient().getDocumentNumber()));
        html = html.replace("@NroDocumento2@", (isGuardian() ? this.getPatient().getDocumentNumber() : ""));
        html = html.replace("@Acudiente@", (isGuardian() ? this.getGuardianData().getName() : ""));
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replaceAll("@eps@", this.getEPSPatient());
        html = html.replace("@NombreEnfermero@", this.getProfessional().getName());
        html = html.replace("@email@", this.getPatient().getEmail());
        html = html.replace("@datosPersonalesSI@", this.getDataTreatment() ? "<u><i>X</i></u>" : "_");
        html = html.replace("@datosPersonalesNO@", this.getDataTreatment() ? "_" : "<u><i>X</i></u>");


        html = html.replaceAll("@Ocupacion@", this.getPatient().getOccupation());

        html = html.replaceAll("@Telefono@", this.getPatient().getPhoneNumber());

        html = html.replaceAll("@eps@", this.getEPSPatient());

        html = html.replaceAll("@edad@", this.getPatient().getAge().toString());

        html = html.replaceAll("@viajes@", this.getHadTrips() ? this.getTripsMade() : "");

        if (this.getVaccinated() != null) {
            if (this.getVaccinated()) {
                html = html.replaceAll("@nombreVacuna@", this.getVaccine().getName());
                html = html.replaceAll("@fechaVacuna@", this.getDateVaccine("dd/MM/yyyy"));
            } else {
                html = html.replaceAll("@nombreVacuna@", "");
                html = html.replaceAll("@fechaVacuna@", "");
            }
            html = html.replace("@vacunadoNO@", this.getVaccinated() ? "_" : "<u><i>X</i></u>");
            html = html.replace("@vacunadoSI@", this.getVaccinated() ? "<u><i>X</i></u>" : "_");
        }
        if (this.getHadContactCovid() != null) {
            if (this.getHadContactCovid()) {
                if (this.getHasSymptoms() != null) {
                    html = html.replaceAll("@sintomas@", this.getDescriptionOfSymptoms());
                }
                html = html.replaceAll("@fechaSintomas@",
                        this.getSymptomsStartDate() != null ? this.getSymptomsStartDate("dd/MM/yyyy") : "");

            } else {
                html = html.replaceAll("@sintomas@", "");
                html = html.replaceAll("@fechaSintomas@", "");
            }
            html = html.replace("@contactoCovidSI@", this.getHadContactCovid() ? "<u><i>X</i></u>" : "_");
            html = html.replace("@contactoCovid@",
                    this.getHadContactCovid() ? "<u><i><strong>SI</strong></i></u>" : "<u><i><strong>NO</strong></i></u>");
            html = html.replace("@contactoCovidNO@", this.getHadContactCovid() ? "_" : "<u><i>X</i></u>");
        }
        if (this.getHaveWorkInHealth() != null) {
            html = html.replace("@trabajadorSaludSI@", this.getHaveWorkInHealth() ? "<u><i>X</i></u>" : "_");
            html = html.replace("@trabajadorSaludNO@", !this.getHaveWorkInHealth() ? "<u><i>X</i></u>" : "_");
        }
        if (this.getVaccinated()) {
            html = html.replace("@dosis@",
                    (this.getDoseNumber() != null && this.getDoseNumber() > 0) ? "<u><i>" + this.getDoseNumber() + "</i></u>" : "_");
        } else {
            html = html.replace("@dosis@", "_");
        }
        html = html.replace("@riesgoSI@", this.getRiskBenefit() ? "<u><i>X</i></u>" : "_");
        html = html.replace("@riesgoNO@", !this.getRiskBenefit() ? "<u><i>X</i></u>" : "_");

        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
