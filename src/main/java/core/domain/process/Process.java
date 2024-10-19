package core.domain.process;

import core.domain.area.Area;
import core.domain.bus.command.Command;
import core.domain.bus.query.Query;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brahyam.pineda
 */
public class Process implements Serializable, Command, Query {
    private static final long serialVersionUID = 1L;


    private Integer idProcess;
    private String description;
    private Area area;
    private boolean isDisagree;
    

    public Process() {
        
    }
    public Process(Integer idProcess) {
        this.idProcess =idProcess;
    }

    public Integer getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(Integer idProcess) {
        this.idProcess = idProcess;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isDisagree() {
        return isDisagree;
    }

    public void setDisagree(boolean disagree) {
        this.isDisagree = disagree;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idProcess);
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
        final Process other = (Process) obj;
        if (!Objects.equals(this.idProcess, other.idProcess)) {
            return false;
        }
        return true;
    }

   
    
   
    

}
