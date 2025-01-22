package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;
import core.domain.process.Process;

import java.util.List;

public class ProcessConsent extends ConsentInterface implements Command {

    private static final String TYPE = "PROCEDIMIENTO";
    private static final String URL = "consentimiento_procedimiento.xhtml?faces-redirect=true";
    public static final int COLUMNS_TABLE_PROCESSES = 3;

    public List<Process> processList;

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
            + "	                    <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "	                	<td >FECHA:</td>\n"
            + "	                	<td >30/04/2021</td>\n"
            + "	                </tr>\n"
            + "	                <tr>\n"
            + "	                	<td  rowspan=\"2\" >CONSENTIMIENTO INFORMADO ACEPTACION DE PROCEDIMIENTO</td>\n"
            + "	                	<td  >VERSION:</td>\n"
            + "	                	<td >4</td>\n"
            + "	                </tr>\n"
            + "	                <tr>\n"
            + "	                	<td >CODIGO:</td>\n"
            + "	                	<td >SBCPM-F-001</td>\n"
            + "	                </tr>        \n"
            + "	        </tbody>\n"
            + "	    </table>\n"
            + "	</header>\n"
            + "\n"
            + "	<div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "		<table class=\"with-border\" style=\"width: 100%; \">\n"
            + "	        <tbody class=\"with-border\" class=\"alineacion-left\">\n"
            + "	               \n"
            + "	                <tr>\n"
            + "	                	<td>\n"
            + "	                		<p>Yo <u><i>@Acudiente@</i></u> Por el presente considero que se me realice a mi o a mi </p>\n"
            + "							<p>hij@/familiar <u><i>@Paciente@</i></u></p>\n"
            + "							<p>El procedimiento terapéutico o quirúrgico:</p>\n"
            + "\n"
            + "							<table class=\"tbl-procedimientos with-border\" width=\"100%\">\n"
            + "								<tbody>\n"
            + "@LstProcedimientos@"
            + "								</tbody>\n"
            + "							</table>\n"
            + "							<p>Otro?, cual: @OtroProcedimiento@</p>\n"
            + "\n"
            + "							<p>Se me ha explicado la naturaleza y el objetivo de lo que se me propone, incluyendo riesgos significativos y beneficios:  <u><i>@riesgos@</i></u></p>\n"
            + "							<ul >\n"
            + "								<li> Su estancia en la institución será mínimo 6 horas.</li>\n"
            + "								<li>La instalación de medicamentos vía intravenosa y su mantenimiento es solo responsabilidad del personal asistencial.</li>\n"
            + "								<li>El manipular sin permiso e irresponsablemente las llaves de los equipos de infusión de los medicamentos que se le administre, aumenta el riesgo de que usted presente hipotensión o reacción adversa a estos, por tal motivo solo el personal asistencial lo debe hacer.</li>\n"
            + "								<li>El ingreso de alimentos a la sala de observación menos de 6 horas está prohibido.</li>\n"
            + "							</ul>\n"
            + "							<p>En situación de negación del procedimiento el paciente y/ o acudiente esta consiente de riesgos que implica no llevarlo a cabo.</p>   \n"
            + "\n"
            + "							<p>Estoy satisfecho con esas explicaciones y las he comprendido.\n"
            + "							De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            + "\n"
            + "							<p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "							<table  >\n"
            + "								<tbody>\n"
            + "									<tr>\n"
            + "										<td>\n"
            + "											<p style=\"z-index: 1;position: absolute;\">Santa Rosa de Cabal <u><i>@Dia@</i></u></p>\n"
            + "										</td>\n"
            + "									</tr>\n"
            + "									\n"
            + "									<tr>\n"
            + "										<td class=\"td-firma\">\n"
            + "												<div style=\"float: left; margin-top: 32px\">\n"
            + "													<p>Firma del paciente, padre o tutor</p>\n"
            + "												</div>\n"
            + "												<div>\n"
            + "													<span class=\"position-firma\">\n"
            + "														<div class=\"subrayado2\"> de <u><i>@Mes@</i></u> de <u><i>@Anio@</i></u></div>\n"
            + "														<img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\"   />\n"
            + "														<div class=\"subrayado\">______________________________</div>\n"
            + "													</span>\n"
            + "												</div>\n"
            + "										</td>\n"
            + "									</tr>\n"
            + "									<tr>\n"
            + "										<td>\n"
            + "											<p>Documento tipo y número <u><i>@TipoDoc@ @NroDocumento@</i></u></p>\n"
            + "										</td>\n"
            + "									</tr>\n"
            + "									<tr>\n"
            + "										<td>\n"
            + "											<p>Admisión No.  <u><i>@NroAdmision@</i></u></p>\n"
            + "										</td>\n"
            + "									</tr>\n"
            + "								</tbody>\n"
            + "							</table>\n"
            + "\n"
            + "							<p>Por la presente certifico que he explicado la naturaleza, propósito, beneficios, riesgos y alternativas del procedimiento propuesto, me he ofrecido a contestar cualquier pregunta y he contestado completamente todas las preguntas hechas. Creo que los padres/ tutores/ Encargados/ han comprendido completamente lo que he explicado y contestado.</p>\n"
            + "\n"
            + "							<p>Nombre de quien realiza el procedimiento <u><i>@NombreEnfermero@</i></u> y registro No.<u><i>@NroRegistro@</i></u></p>\n"
            + "	                	</td>\n"
            + "	                </tr>        \n"
            + "	        </tbody>\n"
            + "	    </table>\n"
            + "	</div>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

    public ProcessConsent(Configuration configuration, List<Process> processes) {
        super(configuration);
        setTypeConsent(TYPE);
        setProcessList(processes);
    }

    @Override
    public String dataValidation() {
        if (this.getProcesses() == null || this.getProcesses().isEmpty()) {
            return "No ha indicado ningun procedimiento";

        }
        if (this.getProcesses().contains(new Process(Integer.parseInt(ID_OTRO_PROCEDIMIENTO)))
                && (this.getAnotherProcesses() == null
                || this.getAnotherProcesses().equals(""))) {
            return "Ingrese el nombre del procedimiento realizado";

        }
        if (this.getPatient() == null) {
            return "Ingrese this del paciente";
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
        if (this.getProfessional() != null
                && !this.getProfessional().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el profesional que realiza el procedimiento";

        }
        if (this.getProfessional().getRegistryNumber() != null
                && !this.getProfessional().getRegistryNumber().toString().matches(REGEX_DIGIT)) {
            return "Ingrese un valor númerico correcto en  Nro. registro";

        }
        if (this.getPatient().getAdmissionNumber() != null
                && !this.getPatient().getAdmissionNumber().matches(REGEX_DIGIT)) {
            return "Ingrese un valor númerico correcto en  Nro. admisión";

        }
        if (this.getSignature() == null || this.getSignature().isEmpty()) {
            return "Ingrese la firma";

        }

        return null;
    }

    @Override
    public String getFormat() {
        String html = FORMAT_DOCUMENT_WITHOUT_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
        String processTable = processTableBuilder();
        html = html.replace("@LstProcedimientos@", processTable);

        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));


        html = html.replace("@TipoDoc@", (isGuardian() ? this.getGuardianData().getDocumentType().getInitials() : this.getPatient().getDocumentType().getInitials()));
        html = html.replace("@NroDocumento@", (isGuardian() ? this.getGuardianData().getDocumentNumber() : this.getPatient().getDocumentNumber()));
        html = html.replace("@Acudiente@", (isGuardian() ? this.getGuardianData().getName() : ""));
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replace("@NroAdmision@", "A" + this.getPatient().getAdmissionNumber());

        html = html.replace("@NombreEnfermero@", this.getProfessional().getName());
        html = html.replace("@NroRegistro@", this.getProfessional().getRegistryNumber().toString());

        html = html.replace("@OtroProcedimiento@", this.getAnotherProcesses() != null ? "<u><i>"
                + this.getAnotherProcesses().toUpperCase() + "</u></i>" : "_______________________________________");
        html = html.replace("@riesgos@", this.getRiskBenefit() ? "<u><i><strong> SI </strong></i></u>" : "<u><i><strong> NO </strong></i></u>");
        html = html.replace("@datosPersonalesSI@", this.getDataTreatment() ? "<u><i>X</i></u>" : "_");
        html = html.replace("@datosPersonalesNO@", this.getDataTreatment() ? "_" : "<u><i>X</i></u>");

        if (this.getProcesses() != null && !this.getProcesses().isEmpty()) {
            for (Process procedure : this.getProcesses()) {
                html = html.replace("@Procedimiento" + procedure.getIdProcess() + "@", "<div align=\"center\">X</div>");
            }
            html = html.replaceAll("@Procedimiento\\d+@", "");
        }
        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }

    private String processTableBuilder() {
        int index;
        StringBuilder table = new StringBuilder();
        double shells =
                Math.ceil((double) getProcessList().size()
                        / (double) ProcessConsent.COLUMNS_TABLE_PROCESSES)
                        * ProcessConsent.COLUMNS_TABLE_PROCESSES;
        for (int i = 1; i <= shells; i++) {
            index = i - 1;
            if (i % ProcessConsent.COLUMNS_TABLE_PROCESSES == 1) {
                table.append("<tr>\n");
            }
            if (getProcessList().size() > index) {
                table.append("<td width=\"20\">@Procedimiento").append(getProcessList().get(index).getIdProcess()).append("@</td>\n");
                table.append("<td>").append(getProcessList().get(index).getDescription()).append("</td>\n");
            } else {
                table.append("<td width=\"20\"></td>\n");
                table.append("<td></td>\n");
            }
            if (i % ProcessConsent.COLUMNS_TABLE_PROCESSES == 0) {
                table.append("</tr>\n");
            }
        }
        return table.toString();
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }
}
