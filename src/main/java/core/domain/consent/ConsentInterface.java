package core.domain.consent;

import app.config.Configuration;
import core.domain.bus.command.Command;
import core.domain.professional.Professional;
import core.domain.sickness.Sickness;
import core.domain.vaccine.Vaccine;
import core.domain.area.Area;
import core.domain.bus.query.Query;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public abstract class ConsentInterface implements Command {

    public static final String IMAGE_FORMAT = "png";
    public String APPLICATION_SERVER;
    public String PATH_IMAGES_APP;
    public String PATH_CSS_APP;
    public static final String NAME_SIGNATURE = "firma";
    public static final String NAME_LOGO = "logo.png";
    public static final String STYLES = "formulario_sbcpm.css";

    public static final String REGEX_DOCUMENT = "^([A-Z]{2})?\\d{6,15}([-\\s]\\d{1})?$";
    public static final String REGEX_NAME = "^[a-zA-ZÀ-ÿ\\s]{1,40}$";
    public static final String REGEX_DIGIT = "^\\d+$";
    public static final String REGEX_CELL_PHONE_NUMBER = "^3([0-9]){9}$";
    public static final String REGEX_EMAIL =
            "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
    public static final String REGEX_DATE = "^\\d{2}-\\d{2}-\\d{4}$";
    public boolean createConsent;
    private Patient patient;
    private String signature;
    private boolean isGuardian;
    private String typeConsent;
    private int id;
    private Boolean dataTreatment;
    private Boolean riskBenefit;
    private Integer braceletNumber;
    private Professional professional;
    private Boolean hadContactCovid;
    private Boolean hasSymptoms;
    private Boolean hadTrips;
    private String descriptionOfSymptoms;
    private Date symptomsStartDate;
    private String tripsMade;
    private Boolean haveWorkInHealth;
    private Boolean isVaccinated;
    private Vaccine vaccine;
    private Integer doseNumber;
    private Date dateVaccine;
    private Area area;
    private Boolean disagree;
    private String anotherProcesses;
    private List<Process> dissents;
    private List<Process> processes;

    private String catchment;
    private String knowledgeAboutHIV;
    private boolean knowledgeAboutMST;
    private boolean prevention;
    private boolean useCondom;
    private String useCondomReason;
    private String frequency;
    private String notUseCondomReason;
    private boolean typeOfSexualIntercourse;
    private String probableTransmissionMechanism;
    private String transfusionSite;
    private String anotherTransmission;
    private String event;
    private String positiveResultReaction;
    private String mood;
    private String anotherMood;
    private boolean test;
    private String testReason;
    private Date laboratoryHIVDate;
    private boolean laboratoryHIV;
    private String confirmHIV;
    private Date confirmHIVDate;
    private Date fastTestDate;
    private Date fastTestExpirationDate;
    private List<Sickness> sicknessList;

    public ConsentInterface(Configuration configuration) {
        this.APPLICATION_SERVER = configuration.getApplicationPath();
        this.PATH_IMAGES_APP = APPLICATION_SERVER + configuration.getImagesPath();
        this.PATH_CSS_APP = APPLICATION_SERVER + configuration.getCssPath();
        this.patient = new Patient();
        professional = new Professional();
        this.signature = "";
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public abstract String dataValidation();

    public abstract String getFormat();

    public abstract String getUrl();

    public String getSignatureConsent() {
        if (this.isGuardian()) {
            return this.getGuardianData().getDocumentType().getInitials() + this.getGuardianData().getDocumentNumber();
        }
        return this.getPatient().getDocumentType().getInitials() + this.getPatient().getDocumentNumber();
    }

    public String getSignatureProfessional() {
        return this.getProfessional().getDocumentType().getInitials() + this.getProfessional().getDocumentNumber();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPathSignature() {
        return PATH_IMAGES_APP + NAME_SIGNATURE + "-" + this.getSignatureConsent() + "." + IMAGE_FORMAT;
    }

    public String getPathSignatureProfessional() {
        return PATH_IMAGES_APP + NAME_SIGNATURE + "-" + this.getSignatureProfessional() + "." + IMAGE_FORMAT;
    }

    public boolean isGuardian() {
        return isGuardian;
    }

    public void setGuardian(boolean guardian) {
        isGuardian = guardian;
    }

    public Guardian getGuardianData() {
        return this.patient.getGuardian();
    }

    public int getIdTypeDocumentGuardian() {
        return getGuardianData().getDocumentType().getId();
    }

    public String getDocumentGuardian() {
        return getGuardianData().getDocumentNumber();
    }

    public String getEPSPatient() {
        return this.patient.getEps();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeConsent() {
        return typeConsent;
    }

    public void setTypeConsent(String typeConsent) {
        this.typeConsent = typeConsent;
    }

    public String getDate(String type) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }

    public String getDateFormat(String type, Date date) {
        if (date == null) {
            return " _ ";
        }
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }

    public Boolean getDataTreatment() {
        if (dataTreatment == null) {
            return false;
        }
        return dataTreatment;
    }

    public void setDataTreatment(Boolean dataTreatment) {
        this.dataTreatment = dataTreatment;
    }

    public Boolean getRiskBenefit() {
        if (riskBenefit == null) {
            return false;
        }
        return riskBenefit;
    }

    public void setRiskBenefit(Boolean riskBenefit) {
        this.riskBenefit = riskBenefit;
    }

    public Integer getBraceletNumber() {
        return braceletNumber;
    }

    public void setBraceletNumber(Integer braceletNumber) {
        this.braceletNumber = braceletNumber;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Boolean getHadContactCovid() {
        return hadContactCovid;
    }

    public void setHadContactCovid(Boolean hadContactCovid) {
        this.hadContactCovid = hadContactCovid;
    }

    public Boolean getHasSymptoms() {
        return hasSymptoms;
    }

    public void setHasSymptoms(Boolean hasSymptoms) {
        this.hasSymptoms = hasSymptoms;
    }

    public Boolean getHadTrips() {
        return hadTrips;
    }

    public void setHadTrips(Boolean hadTrips) {
        this.hadTrips = hadTrips;
    }

    public String getDescriptionOfSymptoms() {
        return descriptionOfSymptoms;
    }

    public void setDescriptionOfSymptoms(String descriptionOfSymptoms) {
        this.descriptionOfSymptoms = descriptionOfSymptoms;
    }

    public Date getSymptomsStartDate() {
        return symptomsStartDate;
    }

    public String getSymptomsStartDate(String formatType) {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        if (symptomsStartDate == null) {
            return null;
        } else {
            return format.format(symptomsStartDate);
        }
    }

    public void setSymptomsStartDate(Date symptomsStartDate) {
        this.symptomsStartDate = symptomsStartDate;
    }

    public String getTripsMade() {
        return tripsMade;
    }

    public void setTripsMade(String tripsMade) {
        this.tripsMade = tripsMade;
    }

    public Boolean getHaveWorkInHealth() {
        return haveWorkInHealth;
    }

    public void setHaveWorkInHealth(Boolean haveWorkInHealth) {
        this.haveWorkInHealth = haveWorkInHealth;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Integer getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Integer doseNumber) {
        this.doseNumber = doseNumber;
    }

    public Date getDateVaccine() {
        return dateVaccine;
    }

    public String getDateVaccine(String formatType) {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        if (dateVaccine == null) {
            return null;
        } else {
            return format.format(dateVaccine);
        }
    }

    public void setDateVaccine(Date dateVaccine) {
        this.dateVaccine = dateVaccine;
    }


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Boolean getDisagree() {
        return disagree;
    }

    public void setDisagree(Boolean disagree) {
        this.disagree = disagree;
    }

    public List<Process> getDissents() {
        if (dissents == null) {
            return new ArrayList<>();
        }
        return dissents;
    }

    public void setDissents(List<Process> dissents) {
        this.dissents = dissents;
    }

    public List<Process> getProcesses() {
        if (processes==null){
            return new ArrayList<>();
        }
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public String getAnotherProcesses() {
        return anotherProcesses;
    }

    public void setAnotherProcesses(String anotherProcesses) {
        this.anotherProcesses = anotherProcesses;
    }

    public String getMonth() {
        // Obtienes el mes actual
        Month mes = LocalDate.now().getMonth();
        // Obtienes el nombre del mes
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        // Convierte a mayúscula la primera letra del nombre.
        String primeraLetra = nombre.substring(0, 1);
        String mayuscula = primeraLetra.toUpperCase();
        String demasLetras = nombre.substring(1, nombre.length());
        nombre = mayuscula + demasLetras;
        return nombre;
    }

    public String getDay() {
        // Obtienes el mes actual
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        // Obtienes el nombre del mes
        String name = day.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        return name;
    }

    public String getCatchment() {
        return catchment;
    }

    public void setCatchment(String catchment) {
        this.catchment = catchment;
    }

    public String getKnowledgeAboutHIV() {
        return knowledgeAboutHIV;
    }

    public void setKnowledgeAboutHIV(String knowledgeAboutHIV) {
        this.knowledgeAboutHIV = knowledgeAboutHIV;
    }

    public boolean isKnowledgeAboutMST() {
        return knowledgeAboutMST;
    }

    public void setKnowledgeAboutMST(boolean knowledgeAboutMST) {
        this.knowledgeAboutMST = knowledgeAboutMST;
    }

    public boolean isPrevention() {
        return prevention;
    }

    public void setPrevention(boolean prevention) {
        this.prevention = prevention;
    }

    public boolean isUseCondom() {
        return useCondom;
    }

    public void setUseCondom(boolean useCondom) {
        this.useCondom = useCondom;
    }

    public String getUseCondomReason() {
        return useCondomReason;
    }

    public void setUseCondomReason(String useCondomReason) {
        this.useCondomReason = useCondomReason;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNotUseCondomReason() {
        return notUseCondomReason;
    }

    public void setNotUseCondomReason(String notUseCondomReason) {
        this.notUseCondomReason = notUseCondomReason;
    }

    public boolean isTypeOfSexualIntercourse() {
        return typeOfSexualIntercourse;
    }

    public void setTypeOfSexualIntercourse(boolean typeOfSexualIntercourse) {
        this.typeOfSexualIntercourse = typeOfSexualIntercourse;
    }

    public String getProbableTransmissionMechanism() {
        return probableTransmissionMechanism;
    }

    public void setProbableTransmissionMechanism(String probableTransmissionMechanism) {
        this.probableTransmissionMechanism = probableTransmissionMechanism;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPositiveResultReaction() {
        return positiveResultReaction;
    }

    public void setPositiveResultReaction(String positiveResultReaction) {
        this.positiveResultReaction = positiveResultReaction;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public Date getLaboratoryHIVDate() {
        return laboratoryHIVDate;
    }

    public void setLaboratoryHIVDate(Date laboratoryHIVDate) {
        this.laboratoryHIVDate = laboratoryHIVDate;
    }

    public boolean isLaboratoryHIV() {
        return laboratoryHIV;
    }

    public void setLaboratoryHIV(boolean laboratoryHIV) {
        this.laboratoryHIV = laboratoryHIV;
    }

    public String getConfirmHIV() {
        return confirmHIV;
    }

    public void setConfirmHIV(String confirmHIV) {
        this.confirmHIV = confirmHIV;
    }

    public Date getConfirmHIVDate() {
        return confirmHIVDate;
    }

    public void setConfirmHIVDate(Date confirmHIVDate) {
        this.confirmHIVDate = confirmHIVDate;
    }

    public Date getFastTestDate() {
        return fastTestDate;
    }

    public void setFastTestDate(Date fastTestDate) {
        this.fastTestDate = fastTestDate;
    }

    public Date getFastTestExpirationDate() {
        return fastTestExpirationDate;
    }

    public void setFastTestExpirationDate(Date fastTestExpirationDate) {
        this.fastTestExpirationDate = fastTestExpirationDate;
    }

    public List<Sickness> getSicknessList() {
        return sicknessList;
    }

    public void setSicknessList(List<Sickness> sicknessList) {
        this.sicknessList = sicknessList;
    }

    public String getTransfusionSite() {
        return transfusionSite;
    }

    public void setTransfusionSite(String transfusionSite) {
        this.transfusionSite = transfusionSite;
    }

    public String getAnotherTransmission() {
        return anotherTransmission;
    }

    public void setAnotherTransmission(String anotherTransmission) {
        this.anotherTransmission = anotherTransmission;
    }

    public String getAnotherMood() {
        return anotherMood;
    }

    public void setAnotherMood(String anotherMood) {
        this.anotherMood = anotherMood;
    }

    public String getTestReason() {
        return testReason;
    }

    public void setTestReason(String testReason) {
        this.testReason = testReason;
    }

    public boolean isCreateConsent() {
        return createConsent;
    }

    public void setCreateConsent(boolean createConsent) {
        this.createConsent = createConsent;
    }
}
