package infrastructure.repository.consent;

import core.domain.patient.Patient;
import core.domain.professional.Professional;
import core.domain.sickness.Sickness;
import java.util.Date;
import java.util.List;

public class ConsentVIHDTO {

    private int id;
    private Boolean dataTreatment;
    private Boolean riskBenefit;
    private Professional professional;
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
    private String filename;
    private String signature;
    private List<Sickness> sicknessList;

    public ConsentVIHDTO() {
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

    public String getAnotherMood() {
        return anotherMood;
    }

    public void setAnotherMood(String anotherMood) {
        this.anotherMood = anotherMood;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getTestReason() {
        return testReason;
    }

    public void setTestReason(String testReason) {
        this.testReason = testReason;
    }

    public List<Sickness> getSicknessList() {
        return sicknessList;
    }

    public void setSicknessList(List<Sickness> sicknessList) {
        this.sicknessList = sicknessList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getDataTreatment() {
        return dataTreatment;
    }

    public void setDataTreatment(Boolean dataTreatment) {
        this.dataTreatment = dataTreatment;
    }

    public Boolean getRiskBenefit() {
        return riskBenefit;
    }

    public void setRiskBenefit(Boolean riskBenefit) {
        this.riskBenefit = riskBenefit;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
