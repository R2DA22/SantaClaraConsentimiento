/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain.area;

import core.domain.bus.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author diego.ramirez
 */
public class Area implements Query {
    
    private Integer id;
    private String name;
    private List<String> process;
    private boolean selected;
    
    public Area() {
        process = new ArrayList<>();
    }
    public Area(Integer id) {
        this.id=id;
        process = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProcess() {
        if(process ==null){
            process = new ArrayList();
        }
        return process;
    }

    public void setProcess(List<String> process) {
        this.process = process;
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
        hash = 19 * hash + Objects.hashCode(this.name);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area{" + "id=" + id + ", nombre=" + name + '}';
    }
    
    
    
}
