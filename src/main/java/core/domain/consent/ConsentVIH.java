package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;
import core.domain.sickness.Sickness;
import java.util.ArrayList;
import java.util.List;

public class ConsentVIH extends ConsentInterface implements Command {

    public static final String TYPE = "VIH";
    private static final String URL = "consentimiento_VIH.xhtml?faces-redirect=true";
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
            + "                     <td >@Fecha@</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO PARA PRUEBA VIH</td>\n"
            + "                     <td  >VERSION:</td>\n"
            + "                     <td >3</td>\n"
            + "                 </tr>\n"
            + "                 <tr>\n"
            + "                     <td >CODIGO:</td>\n"
            + "                     <td >SBCPM-F-001</td>\n"
            + "                 </tr>        \n"
            + "         </tbody>\n"
            + "     </table>\n"
            + " </header>\n"
            + "\n"
            + " <div class=\"contenido\" style=\"padding-top: 15px;\">\n" +
            "            <strong>Propósito y beneficio de la prueba</strong>\n" +
            "            <p>Esta prueba se usa para precisar si una persona está infectada con el Virus de Inmunodeficiencia Humana (VIH), mediante la determinación de anticuerpos contra el virus. Un anticuerpo es una proteína que los glóbulos blancos fabrican en respuesta a cualquier tipo de infección.</p>\n" +
            "            <p>El propósito de esta prueba es ayudar a los individuos y a los médicos a entender y a tratar de manera más eficaz los síntomas que pueden ser causados por el VIH. Esta prueba ayuda a identificar a las personas infectadas con el virus ya sea porque tienen un antecedente de riesgo (relaciones sexuales penetrativas e indiscriminadas, compartir agujas, transfusiones de sangre, recepción de transplantes o de fluidos corporales como semen, o a través del embarazo en el canal de parto), o porque hay condiciones clínicas que lo ameritan.</p>\n" +
            "            <p>O para el manejo de los accidentes de trabajo por riesgo biológico, se consideran los siguientes propósitos:</p>\n" +
            "            <ul>\n" +
            "               <li>PARA LA FUENTE DE CONTACTO: Determinar que no esté infectada con VIH.</li>\n" +
            "               <li>PARA EL TRABAJADOR ACCIDENTADO: Permitir hacer el seguimiento de laboratorio pos exposición, para el VIH.</li>\n" +
            "            </ul>\n" +
            "            <strong>Interpretación de la prueba</strong>\n" +
            "            <p>El primer paso es examinar la sangre utilizando una prueba presuntiva (ELISA). Si ésta resulta “POSITIVA”, se repite y es necesario realizar una prueba suplementaria o confirmatoria (Western Blot o Inmunofluorescencia). Si ésta prueba se confirma como “Positiva” significa que la persona está infectada con el VIH y que puede transmitir (si no se toman medidas de precaución adecuadas) el virus a otras personas, ya sea a través de contacto sexual o por compartir agujas. Si su resultado es “NEGATIVO” significa que no hay evidencia de laboratorio, hasta ese momento, de que la persona esté infectada por el VIH.</p>\n" +
            "            <strong>Limitaciones de la prueba</strong> \n" +
            "            <p>Las pruebas de laboratorio son bastante confiables. Sin embargo, como en otras pruebas de sangre, algunos resultados pueden ser “FALSOS POSITIVOS”. Un “FALSO POSITIVO” significa que la prueba presuntiva (ELISA) fue “POSITIVA” pero que la prueba confirmatoria (Western Blot o Inmunofluorescencia) fue “NEGATIVA”. En este caso, la prueba presuntiva indicaba presencia de anticuerpos contra el VIH cuando en realidad no los había. También se dan resultados “FALSOS NEGATIVOS”, en los cuales no se detectan anticuerpos contra el VIH en la prueba presuntiva, pero en realidad el virus está presente.</p>\n" +
            "            <p> Es posible que en la prueba confirmatoria se presenten resultados “INDETERMINADOS”; esto significa que no hay seguridad de que la persona esté realmente infectada y se hace necesario repetir el examen en <strong>6 meses.</strong></p>\n" +
            "            <p>La prueba no puede predecir si la persona permanecerá saludable, presentará algunos síntomas, o desarrollará SIDA.\n" +
            "            </p>\n" +
            "            <p>Se requiere de evaluaciones médicas periódicas y exámenes adicionales para ayudar a determinar el riesgo de presentar problemas médicos como resultados de la infección por VIH.\n" +
            "            </p>\n" +
            "            <p>Es importante recordar que si la persona está infectada, a pesar de verse y sentirse sana, puede transmitir el virus a otras personas, si no se toman las medidas de protección adecuadas.\n" +
            "            <p/>\n" +
            "            <center>FICHA PRETEST Y DE NOTIFICACIÓN VIH SIDA</center>\n" +
            "            <p>1. EVENTO A NOTIFICAR:    ASINTOMÁTICO (VIH): @eventoAsintomatico@ CASO SIDA: @eventoSIDA@ MUERTE:@eventoMuerte@</p>\n" +
            "            <p>2. FECHA DE ENTREVISTA O DE CAPACITACIÓN:             DÍA: @Dia@ MES: @Mes@ AÑO: @Anio@</p>\n" +
            "            <p>3. INSTITUCIÓN: <u><i>  Clinica Santa Clara   </i></u> MUNICIPIO: <u><i>  Santa rosa de cabal, Risaralda  </i></u></p>\n" +
            "              <p>4. NOMBRE COMPLETO: <u><i>  @Paciente@  </i></u></p>\n" +
            "            <p>5. IDENTIFICACIÓN: @TipoDoc@:<u><i>  @NroDocumento@  </i></u></p>\n" +
            "            <p>6. EDAD: <u><i>  @Age@  </i></u> FECHA DE NACIMIENTO <u><i>  @bornDate@  </i></u> 7.GENERO: MASCULINO: <u><i>  @GenerM@  </i></u> FEMENINO:<u><i>  @GenerF@  </i></u></p>\n" +
            "            <p>8.  ESTADO CIVIL: <u><i>  @maritalStatus@  </i></u> _9. OCUPACIÓN:        <u><i>  @ocuppation@  </i></u></p>\n" +
            "            <p>10. DIRECCIÓN: <u><i>  @address@  </i></u> MUNICIPIO:<u><i>  @city@  </i></u> TEL: <u><i>  @phoneNumber@  </i></u></p>\n" +
            "            <p>11. ESCOLARIDAD:  NINGUNA:<u><i>  @levelOfStudyNinguna@  </i></u>PRIMARIA:<u><i>  @levelOfStudyPrimaria@  </i></u>SECUNDARIA:<u><i>  @levelOfStudySecundaria@  </i></u>UNIVERSITARIO:<u><i>  @levelOfStudyUniversitario@  </i></u>OTRO:<u><i>  @levelOfStudyOtro@  </i></u></p>\n" +
            "            <p>12. REGIMEN SOCIAL: CONTRIBUTIVO:<u><i>  @SchemeSocialContributivo@  </i></u> SUBSIDIADO: <u><i>  @SchemeSocialSubsidiado@  </i></u> VINCULADO:<u><i>  @SchemeSocialVinculado@  </i></u>OTRO:<u><i>  @SchemeSocialOtro@  </i></u></p>\n" +
            "            <p>13. CAPTACIÓN: REMITIDO: <u><i>  @CatchmentRemitido@  </i></u> ESPONTÁNEO:<u><i>  @CatchmentEspontaneo@  </i></u> HOSPITALIZADO:<u><i>  @CatchmentHospitalizado@  </i></u>CONSULTA EXTERNA: <u><i>  @CatchmentConsultaExterna@  </i></u></p>\n" +
            "            <p>14. CONOCIMIENTO SOBRE EL SIDA:\n" +
            "               SABE DE MANERA CORRECTA Y COMPLETA QUE ES EL SIDA: SI: <u><i>  @knowledgeAboutHIVSi@  </i></u>NO: <u><i>  @knowledgeAboutHIVNo@  </i></u>PARCIALMENTE:<u><i>  @knowledgeAboutHIVParcialmente@  </i></u>\n" +
            "            </p>\n" +
            "            <p>CONOCIMIENTOS SOBRE MODOS DE TRANSMISIÓN: SI <u><i>  @knowledgeAboutMSTSi@  </i></u> NO <u><i>  @knowledgeAboutMSTNo@  </i></u> PREVENCIÓN: SI<u><i>  @preventionSi@  </i></u>NO<u><i>  @preventionNo@  </i></u></p>\n" +
            "            <p>NOTA: SI EL PACIENTE NO TIENE CONOCIMIENTOS CORRECTOS Y COMPLETOS SOBRE LA INFECCIÓN POR EL VIH-SIDA \n" +
            "               EXPLICARLES DE MANERA CLARA Y SENCILLA LOS ASPECTOS MÁS IMPORTANTES.\n" +
            "            </p>\n" +
            "            <p>15. UTILIZA CONDÓN: SI<u><i>  @condomSi@  </i></u>NO<u><i>  @condomNo@  </i></u>FINALIDAD: <u><i>  @condomReason@  </i></u></p>\n" +
            "            <p>16 .FRECUENCIA: SIEMPRE<u><i>  @frecuencySiempre@  </i></u>ALGUNAS VECES: <u><i>  @frecuencyAlgunasVeces@  </i></u>NUNCA:<u><i>  @frecuencyNunca@  </i></u>\n" +
            "               SINO LO UTILIZA POR QUÉ: <u><i>  @notUseCondomReason@  </i></u>\n" +
            "            </p>\n" +
            "            <p>17. TIPO DE RELACIONES SEXUALES:    ESTABLE: <u><i>  @typeOfSexualIntercourseEstable@  </i></u>PROMISCUA: <u><i>  @typeOfSexualIntercoursePromiscua@  </i></u></p>\n" +
            "            <p>18. MECANISMO PROBABLE DE TRANSMISIÓN:\n" +
            "               HETEROSEXUAL: <u><i>  @probableTransmissionMechanismHeterosexual@  </i></u> HOMOSEXUAL:<u><i>  @probableTransmissionMechanismHomosexual@  </i></u> BISEXUAL: <u><i>  @probableTransmissionMechanismBisexual@  </i></u>PERINATAL:<u><i>  @probableTransmissionMechanismPerinatal@  </i></u> PSICOACTIVOS I.VENOSOS:<u><i>  @probableTransmissionMechanismPsicoactivosIntravenosos@  </i></u>\n" +
            "            </p>\n" +
            "            ACCIDENTE DE TRABAJO: <u><i>  @probableTransmissionMechanismAccidentedetrabajo@  </i></u>TRANSFUSIÓN:<u><i>  @probableTransmissionMechanismTransfusion@  </i></u>CUANDO Y DONDE FUE LA TRANSFUSION: <u><i>  @transfusionSite@  </i></u>\n" +
            "            OTRO: <u><i>  @probableTransmissionMechanismOtro@  </i></u>CUAL:<u><i>  @anotherTransmission@  </i></u>DESCONOCIDO:<u><i>  @probableTransmissionMechanismDesconocido@  </i></u>\n" +
            "            </p>\n" +
            "            <center>ENFERMEDADES ASOCIADAS:</center>\n" +
            "            <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n" +
            "               <colgroup span=\"4\" class=\"columns\"></colgroup>\n" +
            "               <tr>\n" +
            "                  <th>ENFERMEDAD</th>\n" +
            "                  <th>SI</th>\n" +
            "                  <th>NO</th>\n" +
            "                  <th>ORGANO COMPR</th>\n" +
            "                  <th>INSTITUCION DX</th>\n" +
            "                  <th>FECHA</th>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td>TUBERCULOSIS</td>\n" +
            "                  <td>@TuberculosisSI@</td>\n" +
            "                  <td>@TuberculosisNO@</td>\n" +
            "                  <td>@TuberculosisOrgan@</td>\n" +
            "                  <td>@TuberculosisIns@</td>\n" +
            "                  <td>@TuberculosisFecha@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td>TOXOPLASMOSIS</td>\n" +
            "                  <td>@ToxoplasmosisSI@</td>\n" +
            "                  <td>@ToxoplasmosisNO@</td>\n" +
            "                  <td>@ToxoplasmosisOrgan@</td>\n" +
            "                 <td>@ToxoplasmosisIns@</td>\n" +
            "                 <td>@ToxoplasmosisFecha@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td>CANDIDIASIS</td>\n" +
            "                  <td>@CandidiasisSI@</td>\n" +
            "                  <td>@CandidiasisNO@</td>\n" +
            "                  <td>@CandidiasisOrgan@</td>\n" +
            "                 <td>@CandidiasisIns@</td>\n" +
            "                 <td>@CandidiasisFecha@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td>CRIPTOCOCOSIS</td>\n" +
            "                  <td>@CriptococosisSI@</td>\n" +
            "                  <td>@CriptococosisNO@</td>\n" +
            "                  <td>@CriptococosisOrgan@</td>\n" +
            "                 <td>@CriptococosisIns@</td>\n" +
            "                 <td>@CriptococosisFecha@</td>\n" +
            "               </tr>\n" +
            "               <tr>\n" +
            "                  <td>OTRAS</td>\n" +
            "                  <td>@OtrasSI@</td>\n" +
            "                  <td>@OtrasNO@</td>\n" +
            "                  <td>@OtrasOrgan@</td>\n" +
            "                 <td>@OtrasIns@</td>\n" +
            "                 <td>@OtrasFecha@</td>\n" +
            "               </tr>\n" +
            "            </table>\n" +
            "            <p>19. QUÉ HARÍA AL RECIBIR EL RESULTADO POSITIVO: <u><i>  @positiveResultReaction@  </i></u></p>\n" +
            "            <p>20. CÓMO SE ENCUENTRA EL PACIENTE DURANTE LA ENTREVISTA: \n" +
            "               TRANQUILO: <u><i>  @moodTranquilo@  </i></u>ANGUSTIADO:<u><i>  @moodAngustiado@  </i></u>AGRESIVO:<u><i>  @moodAgresivo@  </i></u>DEPRIMIDO:<u><i>  @moodDeprimido@  </i></u>OTRA:<u><i>  @moodOtra@  </i></u>\n" +
            "            </p>\n" +
            "            <p>21. DEBE TOMARSE LA MUESTRA PARA EL VIH: SI<u><i>  @testSi@  </i></u>NO:<u><i>  @testNo@  </i></u>POR QUÉ: <u><i>  @testReason@  </i></u></p>\n" +
            "            <p>22. LABORATORIO: VIH:   DÍA: <u><i>  @laboratoryHIVDateDay@  </i></u>MES:<u><i>  @laboratoryHIVDateMonth@  </i></u>AÑO:<u><i>  @laboratoryHIVDateYear@  </i></u>REACTIVO:<u><i>  @laboratoryHIVSi@  </i></u> NO REACTIVO: <u><i>  @laboratoryHIVNo@  </i></u></p>\n" +
            "            <p>CONFIRMATORIA: DÍA: <u><i>  @confirmHIVDateDay@  </i></u>MES:<u><i>  @confirmHIVDateMonth@  </i></u>AÑO:<u><i>  @confirmHIVDateYear@  </i></u>           POSITIVO: <u><i>  @confirmHIVPositivo@  </i></u>NEGATIVO:<u><i>  @confirmHIVNegativo@  </i></u>INDETERMINADO:<u><i>  @confirmHIVIndeterminado@  </i></u> </p>\n" +
            "            <p>23. LOTE PRUEBA RAPIDA UTILIZADA  DÍA: <u><i>  @fastTestDateDay@  </i></u>MES:<u><i>  @fastTestDateMonth@  </i></u>AÑO:<u><i>  @fastTestDateYear@  </i></u></p>\n" +
            "            <p>24. FECHA DE VENCIMIENTO PRUEBA RAPIDA UTILIZADA  DÍA: <u><i>  @fastTestExpirationDateDay@  </i></u>MES:<u><i>  @fastTestExpirationDateMonth@  </i></u>AÑO:<u><i>  @fastTestExpirationDateYear@  </i></u></p>\n" +
            "            <p>LUEGO DE HABER RECIBIDO LA ASESORÍA E INFORMACIÓN CORRESPONDIENTE Y ENTENDIDO SU CONTENIDO INCLUYENDO LAS LIMITACIONES, BENEFICIOS Y RIESGOS DE LA PRUEBA DIAGNOSTICA PARA HIV DISCUTIDO LA FORMA COMO RECIBIRÉ LOS RESULTADOS, AUTORIZO DE MANERA CONSIENTE Y VOLUNTARIA A LA INSTITUCIÓN CLÍNICA SANTA CLARA PARA QUE SE ME REALICE LA PRUEBA.</p>\n" +
            "            <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n" +
            "            <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n" +
            "            <table  >\n" +
            "               <tbody>\n" +
            "                  <tr>\n" +
            "                     <td class=\"td-firma\">\n" +
            "                        <div style=\"float: left; margin-top: 32px\">\n" +
            "                           <p>Firma:</p>\n" +
            "                           <p>@TipoDoc@</p>\n" +
            "                        </div>\n" +
            "                        <div>\n" +
            "                           <span class=\"position-firma\">\n" +
            "                              <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + IMAGE_FORMAT + "\"  width=\"130\" />\n" +
            "                              <div class=\"subrayado\">______________________________</div>\n" +
            "                              <div class=\"subrayado3\"><u><i>   @NroDocumento@  </i></u></div>\n" +
            "                           </span>\n" +
            "                        </div>\n" +
            "                        <div>\n" +
            "                           <span class=\"position-firma2\">\n" +
            "                              <div class=\"subrayado4\" >\n" +
            "                                 <p><u><i>  @NombreEnfermero@  </i></u></p>\n" +
            "                                 <p>Nombre del profesional </p>\n" +
            "                              </div>\n" +
            "                           </span>\n" +
            "                        </div>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </tbody>\n" +
            "            </table>\n" +
            "         </div>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";


    public ConsentVIH(Configuration configuration) {
        super(configuration);
        setTypeConsent(TYPE);
        List<Sickness> sickness = new ArrayList<>();
        sickness.add(new Sickness(1, "Tuberculosis"));
        sickness.add(new Sickness(2, "Toxoplasmosis"));
        sickness.add(new Sickness(3, "Candidiasis"));
        sickness.add(new Sickness(4, "Criptococosis"));
        sickness.add(new Sickness(5, "Otras"));
        setSicknessList(sickness);
        setEvent("Asintomatico (VIH)");
        setKnowledgeAboutHIV("Si");
        setConfirmHIV("Negativo");
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
        if (this.getPatient().getPhoneNumber() != null
                && !this.getPatient().getPhoneNumber().matches(REGEX_CELL_PHONE_NUMBER)) {
            return "Ingrese un número de telefono válido";

        }
        if (this.getPatient().getOccupation() != null
                && !this.getPatient().getOccupation().matches(REGEX_NAME)) {
            return "Ingrese una ocupacion valida";

        }
        if (this.getPatient().getBornDate() != null
                && !this.getPatient().getBornDate("dd-MM-yyyy").matches(REGEX_DATE)) {
            return "La fecha de nacimiento no es valida";

        }
        if (this.getPatient().getCity() != null
                && !this.getPatient().getCity().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el municipio";

        }
        if (this.getPatient().getAddress() == null
                || this.getPatient().getAddress().isEmpty()) {
            return "Ingrese por favor una dirección";

        }
        if ((!this.isUseCondom() && (this.getNotUseCondomReason() == null
                || this.getNotUseCondomReason().isEmpty()))) {
            return "Ingrese la razón por la que el paciente no usa condón";

        }
        if ((this.isUseCondom() && (this.getUseCondomReason() == null
                || this.getUseCondomReason().isEmpty()))) {
            return "Ingrese la razón por la que el paciente usa condón";

        }
        if (this.getPositiveResultReaction() == null
                || this.getPositiveResultReaction().isEmpty()) {
            return "Ingrese la reacción al recibir un resultado positivo ";

        }
        if (this.getTestReason() == null
                || this.getTestReason().isEmpty()) {
            return "Ingrese un motivo  por el cual debe el paciente tomar el test VIH";

        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";

        }

        return null;
    }

    @Override
    public String getFormat() {
        String html = FORMAT_DOCUMENT_WITHOUT_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());

        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));
        html = html.replace("@NroDocumento@", this.getPatient().getDocumentNumber());
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replace("@NombreEnfermero@", this.getProfessional().getName());
        html = html.replace("@datosPersonalesSI@", this.getDataTreatment() ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@datosPersonalesNO@", this.getDataTreatment() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@eventoAsintomatico@", !"Asintomatico (VIH)".equals(this.getEvent()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@eventoSIDA@", !"Caso SIDA".equals(this.getEvent()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@eventoMuerte@", !"Muerte".equals(this.getEvent()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@TipoDoc@", this.getPatient().getDocumentType().getInitials());
        html = html.replace("@Age@", this.getPatient().getAge().toString());
        html = html.replace("@bornDate@", this.getPatient().getBornDate("dd/MM/yyyy"));
        html = html.replace("@GenerM@", this.getPatient().isGender() ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@GenerF@", !this.getPatient().isGender() ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@maritalStatus@", "<u><i>  " + this.getPatient().getMaritalStatus() + "  </i></u>");
        html = html.replace("@ocuppation@", "<u><i>  " + this.getPatient().getOccupation() + "  </i></u>");
        html = html.replace("@city@", "<u><i>  " + this.getPatient().getCity() + "  </i></u>");
        html = html.replace("@phoneNumber@", "<u><i>  " + this.getPatient().getPhoneNumber() + "  </i></u>");
        html = html.replace("@address@", "<u><i>  " + this.getPatient().getAddress() + "  </i></u>");
        html = html.replace("@levelOfStudyNinguna@",
                !"Ninguna".equals(this.getPatient().getLevelOfStudy()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@levelOfStudyPrimaria@",
                !"Primaria".equals(this.getPatient().getLevelOfStudy()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@levelOfStudySecundaria@",
                !"Secundaria".equals(this.getPatient().getLevelOfStudy()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@levelOfStudyUniversitario@",
                !"Universitario".equals(this.getPatient().getLevelOfStudy()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@levelOfStudyOtro@", !"Otro".equals(this.getPatient().getLevelOfStudy()) ? " _ " :
                "<u><i> " + this.getPatient().getAnotherLevelOfStudy() + "  </i></u>");
        html = html.replace("@SchemeSocialContributivo@",
                !"Contributivo".equals(this.getPatient().getSocialScheme()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@SchemeSocialSubsidiado@",
                !"Subsidiado".equals(this.getPatient().getSocialScheme()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@SchemeSocialVinculado@",
                !"Vinculado".equals(this.getPatient().getSocialScheme()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@SchemeSocialOtro@", !"Otro".equals(this.getPatient().getSocialScheme()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@CatchmentRemitido@", !"Remitido".equals(this.getCatchment()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@CatchmentEspontaneo@", !"Espontaneo".equals(this.getCatchment()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@CatchmentHospitalizado@", !"Hospitalizado".equals(this.getCatchment()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@CatchmentConsultaExterna@", !"Consulta externa".equals(this.getCatchment()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@knowledgeAboutHIVParcialmente@",
                !"Parcialmente".equals(this.getKnowledgeAboutHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@knowledgeAboutHIVSi@", !"Si".equals(this.getKnowledgeAboutHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@knowledgeAboutHIVNo@", !"No".equals(this.getKnowledgeAboutHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@knowledgeAboutMSTSi@", !this.isKnowledgeAboutMST() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@knowledgeAboutMSTNo@", this.isKnowledgeAboutMST() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@preventionSi@", !this.isPrevention() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@preventionNo@", this.isPrevention() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@condomSi@", !this.isUseCondom() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@condomNo@", this.isUseCondom() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@condomReason@", this.isUseCondom() ? "<u><i>  " + this.getUseCondomReason() + "  </i></u>" : " _ ");
        html = html.replace("@frecuencySiempre@",
                ("Siempre".equals(this.getFrequency()) && this.isUseCondom()) ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@frecuencyAlgunasVeces@",
                ("Algunas Veces".equals(this.getFrequency()) && this.isUseCondom()) ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@frecuencyNunca@", !this.isUseCondom() ? "<u><i>  X  </i></u>" : " _ ");
        html = html.replace("@notUseCondomReason@", !this.isUseCondom() ? "<u><i>  " + this.getNotUseCondomReason() + "  </i></u>" : " _ ");
        html = html.replace("@typeOfSexualIntercourseEstable@", !this.isTypeOfSexualIntercourse() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@typeOfSexualIntercoursePromiscua@", this.isTypeOfSexualIntercourse() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismHeterosexual@",
                !"Heterosexual".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismHomosexual@",
                !"Homosexual".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismBisexual@",
                !"Bisexual".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismPerinatal@",
                !"Perinatal".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismPsicoactivosIntravenosos@",
                !"Psicoactivos Intravenosos".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismAccidentedetrabajo@",
                !"Accidente de trabajo".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismTransfusion@",
                !"Transfusion".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismOtro@",
                !"Otro".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@probableTransmissionMechanismDesconocido@",
                !"Desconocido".equals(this.getProbableTransmissionMechanism()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@transfusionSite@", "Transfusion".equals(this.getProbableTransmissionMechanism()) ?
                "<u><i>  " + this.getTransfusionSite() + "  </i></u>" : " _ ");
        html = html.replace("@anotherTransmission@", "Otro".equals(this.getProbableTransmissionMechanism()) ?
                "<u><i>  " + this.getAnotherTransmission() + "  </i></u>" : " _ ");
        for (Sickness sickness :
                this.getSicknessList()) {
            html = html.replace("@" + sickness.getName() + "SI@", !sickness.isSick() ? "" : "<u><i>  X  </i></u>");
            html = html.replace("@" + sickness.getName() + "NO@", sickness.isSick() ? "" : "<u><i>  X  </i></u>");
            html = html.replace("@" + sickness.getName() + "Organ@",
                    sickness.getOrganDescription() == null || sickness.getOrganDescription().isEmpty() ? "" :
                            sickness.getOrganDescription());
            html = html.replace("@" + sickness.getName() + "Ins@",
                    sickness.getInstitutionDX() == null || sickness.getInstitutionDX().isEmpty() ? "" : sickness.getInstitutionDX());
            html = html.replace("@" + sickness.getName() + "Fecha@",
                    sickness.getSickDate() == null ? "" : this.getDateFormat("dd-MM-yyyy", sickness.getSickDate()));
        }
        html = html.replace("@positiveResultReaction@", "<u><i>  " + this.getPositiveResultReaction() + "  </i></u>");
        html = html.replace("@moodTranquilo@", !"Tranquilo".equals(this.getMood()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@moodAngustiado@", !"Angustiado".equals(this.getMood()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@moodAgresivo@", !"Agresivo".equals(this.getMood()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@moodDeprimido@", !"Deprimido".equals(this.getMood()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@moodOtra@", !"Otra".equals(this.getMood()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@testSi@", !this.isTest() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@testNo@", this.isTest() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@testReason@", "<u><i>  " + this.getTestReason() + "  </i></u>");
        html = html.replace("@laboratoryHIVDateDay@", "<u><i>  " + this.getDateFormat("dd", this.getLaboratoryHIVDate()) + "  </i></u>");
        html = html.replace("@laboratoryHIVDateMonth@", "<u><i>  " + this.getDateFormat("MM", this.getLaboratoryHIVDate()) + "  </i></u>");
        html = html.replace("@laboratoryHIVDateYear@", "<u><i>  " + this.getDateFormat("yyyy", this.getLaboratoryHIVDate()) + "  </i></u>");
        html = html.replace("@confirmHIVDateDay@", "<u><i>  " + this.getDateFormat("dd", this.getConfirmHIVDate()) + "  </i></u>");
        html = html.replace("@confirmHIVDateMonth@", "<u><i>  " + this.getDateFormat("MM", this.getConfirmHIVDate()) + "  </i></u>");
        html = html.replace("@confirmHIVDateYear@", "<u><i>  " + this.getDateFormat("yyyy", this.getConfirmHIVDate()) + "  </i></u>");
        html = html.replace("@laboratoryHIVSi@", !this.isLaboratoryHIV() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@laboratoryHIVNo@", this.isLaboratoryHIV() ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@confirmHIVPositivo@", !"Positivo".equals(this.getConfirmHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@confirmHIVNegativo@", !"Negativo".equals(this.getConfirmHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@confirmHIVIndeterminado@", !"Indeterminado".equals(this.getConfirmHIV()) ? " _ " : "<u><i>  X  </i></u>");
        html = html.replace("@fastTestExpirationDateDay@",
                "<u><i>  " + this.getDateFormat("dd", this.getFastTestExpirationDate()) + "  </i></u>");
        html = html.replace("@fastTestExpirationDateMonth@",
                "<u><i>  " + this.getDateFormat("MM", this.getFastTestExpirationDate()) + "  </i></u>");
        html = html.replace("@fastTestExpirationDateYear@",
                "<u><i>  " + this.getDateFormat("yyyy", this.getFastTestExpirationDate()) + "  </i></u>");
        html = html.replace("@fastTestDateDay@", "<u><i>  " + this.getDateFormat("dd", this.getFastTestDate()) + "  </i></u>");
        html = html.replace("@fastTestDateMonth@", "<u><i>  " + this.getDateFormat("MM", this.getFastTestDate()) + "  </i></u>");
        html = html.replace("@fastTestDateYear@", "<u><i>  " + this.getDateFormat("yyyy", this.getFastTestDate()) + "  </i></u>");
        html = html.replace("@NombreEnfermero@", this.getProfessional().getName());
        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
