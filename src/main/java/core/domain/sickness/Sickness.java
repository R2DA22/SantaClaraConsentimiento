package core.domain.sickness;

import java.util.Date;

public class Sickness {

    private String name;
    private boolean isSick;
    private String organDescription;
    private String institutionDX;
    private Date sickDate;

    public Sickness(String name) {
        this.name = name;
    }

    public Sickness(String name, boolean isSick, String organDescription, String institutionDX, Date sickDate) {
        this.name = name;
        this.isSick = isSick;
        this.organDescription = organDescription;
        this.institutionDX = institutionDX;
        this.sickDate = sickDate;
    }

    public String getName() {
        return name;
    }

    public boolean isSick() {
        return isSick;
    }

    public String getOrganDescription() {
        return organDescription;
    }

    public String getInstitutionDX() {
        return institutionDX;
    }

    public Date getSickDate() {
        return sickDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void setOrganDescription(String organDescription) {
        this.organDescription = organDescription;
    }

    public void setInstitutionDX(String institutionDX) {
        this.institutionDX = institutionDX;
    }

    public void setSickDate(Date sickDate) {
        this.sickDate = sickDate;
    }
}
