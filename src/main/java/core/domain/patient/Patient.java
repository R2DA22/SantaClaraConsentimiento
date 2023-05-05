/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.domain.patient;

/**
 * @author diego.ramirez
 */
public class Patient extends Person {

    private Guardian guardian;

    private String eps;
    private String admissionNumber;
    private String socialScheme;

    public Patient() {
        super();
        guardian = new Guardian();
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getSocialScheme() {
        return socialScheme;
    }

    public void setSocialScheme(String socialScheme) {
        this.socialScheme = socialScheme;
    }
}
