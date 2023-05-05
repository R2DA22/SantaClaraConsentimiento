/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author diego.ramirez
 */
public class Acudiente {
    
    private Documento tipoDocumento;
    private String nroDocumento;
    private String nombre;
    private String apellido;

    public Acudiente() {
        tipoDocumento = new Documento();
    }
    
    

    public Documento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombreCompleto(){
        return (this.nombre+" "+this.apellido).toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 79 * hash + Objects.hashCode(this.nroDocumento);
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
        final Acudiente other = (Acudiente) obj;
        if (!Objects.equals(this.nroDocumento, other.nroDocumento)) {
            return false;
        }
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        return true;
    }
    
    
}
