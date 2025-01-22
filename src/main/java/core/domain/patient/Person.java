/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.domain.patient;

import core.domain.bus.command.Command;
import core.domain.bus.query.Query;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author diego.ramirez
 */
public abstract class Person implements Command, Query, Serializable {

    private static final long serialVersionUID = 1L;


    private DocumentType documentType;
    private String documentNumber;
    private String expeditionPlace;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String occupation;
    private String email;
    private String signature;
    private Date bornDate;
    private boolean gender;
    private String maritalStatus;
    private String address;
    private String city;
    private String levelOfStudy;
    private String AnotherLevelOfStudy;
    private String AnotherSocialScheme;


    public Person() {
        documentType = new DocumentType();
    }

    public boolean isEmptyPerson() {
        return this.getDocumentNumber() == null
                || this.getDocumentNumber().isEmpty()
                || this.getDocumentType() == null;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Integer getIdTypeDocument() {
        return documentType.getId();
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.getDocumentType());
        hash = 79 * hash + Objects.hashCode(this.getDocumentNumber());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.getDocumentNumber(), other.getDocumentNumber())) {
            return false;
        }
        return Objects.equals(this.getDocumentType(), other.getDocumentType());
    }

    public Date getBornDate() {
        return bornDate;
    }

    public String getBornDate(String type) {
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(bornDate);
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAnotherLevelOfStudy() {
        return AnotherLevelOfStudy;
    }

    public void setAnotherLevelOfStudy(String anotherLevelOfStudy) {
        AnotherLevelOfStudy = anotherLevelOfStudy;
    }

    public String getAnotherSocialScheme() {
        return AnotherSocialScheme;
    }

    public void setAnotherSocialScheme(String anotherSocialScheme) {
        AnotherSocialScheme = anotherSocialScheme;
    }

    public String getExpeditionPlace() {
        return expeditionPlace;
    }

    public void setExpeditionPlace(String expeditionPlace) {
        this.expeditionPlace = expeditionPlace;
    }
}
