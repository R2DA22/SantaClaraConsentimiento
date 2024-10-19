package core.domain.sickness;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sickness implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private boolean isSick;
    private String organDescription;
    private String institutionDX;
    private Date sickDate;

    public Sickness(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getSicknessDate(String formatType) {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        if (sickDate == null) {
            return null;
        } else {
            return format.format(sickDate);
        }
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
