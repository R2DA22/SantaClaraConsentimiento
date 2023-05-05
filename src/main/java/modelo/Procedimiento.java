package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brahyam.pineda
 */
public class Procedimiento implements Serializable {

    private Integer idProcedimiento;
    private String descripcion;
    private Area area;
    private boolean desiente;
    

    public Procedimiento() {
        
    }
    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento=idProcedimiento;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isDesiente() {
        return desiente;
    }

    public void setDesiente(boolean desiente) {
        this.desiente = desiente;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idProcedimiento);
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
        final Procedimiento other = (Procedimiento) obj;
        if (!Objects.equals(this.idProcedimiento, other.idProcedimiento)) {
            return false;
        }
        return true;
    }

   
    
   
    

}
