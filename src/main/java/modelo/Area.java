/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author diego.ramirez
 */
public class Area {
    
    private Integer id;
    private String nombre;
    private List<String> lstProcedimientos;
    private boolean selected;
    
    public Area() {
        lstProcedimientos= new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getLstProcedimientos() {
        if(lstProcedimientos==null){
            lstProcedimientos= new ArrayList();
        }
        return lstProcedimientos;
    }

    public void setLstProcedimientos(List<String> lstProcedimientos) {
        this.lstProcedimientos = lstProcedimientos;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nombre);
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
        final Area other = (Area) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
