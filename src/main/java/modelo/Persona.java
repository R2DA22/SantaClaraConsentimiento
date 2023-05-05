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
public abstract class Persona {

    private Documento tipoDocumento;
    private String nroDocumento;
    private String nombre;
    private String firma;
    
    public Persona() {
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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.getTipoDocumento());
        hash = 79 * hash + Objects.hashCode(this.getNroDocumento());
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.getNroDocumento(), other.getNroDocumento())) {
            return false;
        }
        if (!Objects.equals(this.getTipoDocumento(), other.getTipoDocumento())) {
            return false;
        }
        return true;
    }
}
