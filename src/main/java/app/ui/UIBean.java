/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.ui;

import app.config.Environment;
import core.domain.*;
import core.domain.area.Area;
import core.domain.bus.command.Command;
import core.domain.configuration.Configuration;
import core.domain.consent.ConsentInterface;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.IdConsent;
import core.domain.consent.ProcessConsent;
import core.domain.professional.Professional;
import core.domain.patient.*;
import core.domain.process.Process;
import core.domain.professional.ProfessionalForm;
import core.domain.speciality.Speciality;
import core.domain.vaccine.Vaccine;
import infrastructure.controllers.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import utilidades.Constantes;
import utilidades.PdfFile;
import core.domain.signature.Signature;

/**
 * @author diego.ramirez
 */
@ManagedBean(name = "uiBean")
@SessionScoped
public class UIBean implements Serializable {
    private final static String WARNING = "warning";
    private final static String PATH_PDF = "PATH_SAVE_PDF_FILES";

    private Patient patient;
    private boolean isGuardian;
    private List<DocumentType> listDocumentTypes;
    private Environment environment;
    private ConsentInterface consent;
    private Controller controller;
    private List<Speciality> specialities;

    private List<Process> processes;
    private List<Process> dissents;
    private List<Vaccine> vaccines;
    private List<Area> areas;

    private String AlertType;
    private String headerMessage;
    private String urlFile;
    private StreamedContent streamedContent;
    private String typeConsent;
    private File signature;
    private Process anotherProcess;
    private String errorMessage;


    public UIBean() {
    }


    @PostConstruct
    public void init() {
        try {
            isGuardian = false;
            environment = new Environment();
            controller = environment.getController();
            getAllDocumentsType();
            this.urlFile = ((Configuration) controller.dispatchQuery(new Configuration(PATH_PDF))).getPathPdfFile();
            anotherProcess = new Process(Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO));
        } catch (Exception ex) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getAllDocumentsType() {
        try {
            ListDocumentType result = (ListDocumentType) controller.dispatchQuery(new DocumentType());
            listDocumentTypes = result.getDocumentTypes();
        } catch (Exception e) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void findPatient() {
        try {
            if (consent.getPatient() != null && !consent.getPatient().isEmptyPerson()) {
                Patient patientDomain = (Patient) controller.dispatchQuery(consent.getPatient());
                if (patientDomain != null) {
                    consent.getPatient().setName(patientDomain.getName());
                } else {
                    consent.getPatient().setName("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findGuardian() {
        try {
            if (consent.getPatient() != null
                    && !consent.getPatient().getGuardian().isEmptyPerson()) {
                Guardian guardian = (Guardian) controller.dispatchQuery(consent.getPatient().getGuardian());
                if (guardian != null) {
                    consent.getPatient().getGuardian().setName(guardian.getName());
                } else {
                    consent.getPatient().getGuardian().setName("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveConsent() {
        String msgValidation = consent.dataValidation();
        if (msgValidation != null) {
            showAlertModal(msgValidation, WARNING);
            return;
        }
        if (consent.isGuardian()) {
            createGuardian();
        }
        createPatient();
        createConsent();

        Signature signatureConsent = new Signature(consent.getPathSignature(), consent.getSignature());
        signatureConsent.create();

        String html = consent.getFormat();
        PdfFile.createPDF(this.urlFile + consent.getPatient().getDocumentNumber() + " " + consent.getDate("dd_MM_yyyy_HH_mm") + ".pdf",
                html);

        this.AlertType = "success";
        RequestContext.getCurrentInstance().update("@(.formSoporte)");
        RequestContext.getCurrentInstance().execute("PF('dlgview-pdf').show()");
    }

    public void createConsent() {
        try {
            int nextId = (int) controller.dispatchQuery(new IdConsent());
            consent.setId(nextId);
            controller.dispatchCommand(consent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createPatient() {
        try {

            controller.dispatchCommand(consent.getPatient());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createGuardian() {
        try {
            controller.dispatchCommand(consent.getPatient().getGuardian());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findAllSpeciality() {
        try {
            specialities = (List<Speciality>) controller.dispatchQuery(new Speciality());

            if (specialities != null && !specialities.isEmpty()) {
                consent.getProfessional().setSpecialty(specialities.get(0));
            }
        } catch (Exception e) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void findAllProcess(Area area) {
        try {
            Process process = new Process();
            process.setArea(area);
            processes = (List<Process>) controller.dispatchQuery(process);
        } catch (Exception e) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void findAllAreas() {
        try {
            areas = (List<Area>) controller.dispatchQuery(new Area());
        } catch (Exception e) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void findAllVaccine() {
        try {
            vaccines = (List<Vaccine>) controller.dispatchQuery(new Vaccine());
        } catch (Exception e) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public void saveProfessional() {
        String msgValidation = consent.dataValidation();
        if (msgValidation != null) {
            showAlertModal(msgValidation, WARNING);
            return;
        }
        consent.getProfessional().setSignature(consent.getSignature());
        try {
            controller.dispatchCommand(consent.getProfessional());
            showAlertModal("Profesional registrado correctamente", "success");
        } catch (Exception ex) {
            showAlertModal("No se pudo finalizar el registro del profesional", "danger");
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void showAlertModal(String message, String typeAlert) {
        this.errorMessage = message;
        this.AlertType = typeAlert;
        switch (AlertType) {
            case "info":
                this.headerMessage = "Información";
                break;
            case "danger":
                this.headerMessage = "Advertencia";

                break;
            case "warning":
                this.headerMessage = "Advertencia";
                break;
            case "success":
                this.headerMessage = "Exito";
                break;
            default:
                this.headerMessage = "Información";
                break;
        }
        RequestContext.getCurrentInstance().execute("mostrarModalAlert(\"" + message + " \", \"" + typeAlert + "\")");

    }


    public void findProfessional() {
        try {
            if (consent.getProfessional() != null
                    && consent.getProfessional().getDocumentNumber() != null && !consent.getProfessional().getDocumentNumber().equals("")
                    && consent.getProfessional().getDocumentType() != null) {
                Professional professional = (Professional) controller.dispatchQuery(consent.getProfessional());
                if (professional != null) {
                    consent.setProfessional(professional);
                } else {
                    consent.getProfessional().setName("");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cleanFields() {
        if (AlertType.equals("success")) {
            isGuardian = false;
            reBuildConsent();

            consent.getPatient().setDocumentType(new DocumentType());
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
                consent = new EmergencyConsent();
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
            if (((HttpServletRequest) ec.getRequest()).getRequestURI().contains("consentimiento-VIH")) {
                return redirect(7);
            }
        }
        return "";
    }

    private void reBuildConsent() {
        if (consent instanceof EmergencyConsent) {
            consent = new EmergencyConsent();
        }
        if (consent instanceof DentalConsent) {
            consent = new DentalConsent(areas);
        }
        if (consent instanceof DentalCovidConsent) {
            consent = new DentalCovidConsent();
        }
        if (consent instanceof CovidConsent) {
            consent = new CovidConsent();
        }
        if (consent instanceof ProfessionalForm) {
            consent = new ProfessionalForm();
        }
    }

    public void clearForm() {
        isGuardian = false;
        reBuildConsent();
        consent.getPatient().setDocumentType(new DocumentType());
    }

    public String redirect(Integer option) {
        if (consent != null) {
            clearForm();
        }
        switch (option) {
            case 1:
                findAllProcess(new Area(0));
                consent = new ProcessConsent(processes);
                break;
            case 2:
                consent = new CovidConsent();
                findAllVaccine();
                consent.getProfessional().setName("Antonio Jose Sanchez Niñez");
                break;
            case 3:
                consent = new EmergencyConsent();
                break;
            case 4:
                findAllAreas();
                consent = new DentalConsent(areas);
                findAllProcess(null);
                break;
            case 5:
                consent = new DentalCovidConsent();
                break;
            case 6:
                consent = new ProfessionalForm();
                findAllSpeciality();
                break;
            case 7:
                consent = new ConsentVIH();
                break;
            default:
                typeConsent = "";
                return "index.xhtml?faces-redirect=true";
        }
        return consent.getUrl();

    }


    public void addDissent() {
        getDissents().clear();
        List<Process> list = new ArrayList<>();
        for (Process process : consent.getProcesses()) {
            if (process.getIdProcess() != Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO)) {
                list.add(process);
            }
        }
        getDissents().addAll(list);
    }

    public void addItems() {
        getDissents().clear();
        deleteDuplicatesChips();
        int counterId = consent.getProcesses().size();
        List<Process> list = new ArrayList<>();
        for (String process : consent.getArea().getProcess()) {
            Process procedure = new Process(counterId);
            procedure.setDescription(process);
            procedure.setArea(consent.getArea());
            list.add(procedure);
            counterId++;
        }
        addDissent();
        getDissents().addAll(list);
    }

    public void deleteDuplicatesChips() {
        List<String> list = new ArrayList<>();
        if (consent.getArea() != null) {
            for (String processIterator : consent.getArea().getProcess()) {
                if (!list.contains(processIterator.toLowerCase().replaceAll("^\\w", processIterator.toUpperCase().substring(0, 1)))) {
                    list.add(processIterator.toLowerCase().replaceAll("^\\w", processIterator.toUpperCase().substring(0, 1)));
                }
            }
            consent.getArea().setProcess(list);
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAlertType() {
        if (AlertType == null || "".equals(AlertType)) {
            return "info";
        }
        return AlertType;
    }

    public void setAlertType(String alertType) {
        this.AlertType = alertType;
    }

    public String getHeaderMessage() {
        return headerMessage;
    }

    public void setHeaderMessage(String headerMessage) {
        this.headerMessage = headerMessage;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public List<DocumentType> getListDocumentTypes() {
        return listDocumentTypes;
    }

    public void setListDocumentTypes(List<DocumentType> listDocumentTypes) {
        this.listDocumentTypes = listDocumentTypes;
    }

    public boolean isGuardian() {
        return isGuardian;
    }

    public void setGuardian(boolean guardian) {
        this.isGuardian = guardian;
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
                        streamedContent = new DefaultStreamedContent(new FileInputStream(ruta), "application/pdf",
                                consent.getPatient().getDocumentNumber() + "_" + consent.getDate("dd_MM_yyyy_HH_mm") +
                                        ".pdf");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
        }
        return streamedContent;
    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public Process getAnotherProcess() {
        return anotherProcess;
    }

    public void setAnotherProcess(Process anotherProcess) {
        this.anotherProcess = anotherProcess;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public List<Process> getDissents() {
        if (dissents == null) {
            dissents = new ArrayList();
        }
        return dissents;
    }

    public void setDissents(List<Process> dissents) {
        this.dissents = dissents;
    }

    public String getTypeConsent() {
        return consent.getTypeConsent();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ConsentInterface getConsent() {
        return consent;
    }

    public void setConsent(ConsentInterface consent) {
        this.consent = consent;
    }
}
