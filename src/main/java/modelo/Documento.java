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
public class Documento {
    
    private Integer idTipoDocumento;
    private String  descripcion;
    private String  inicial;

    public Documento() {
        idTipoDocumento=1;
        descripcion="CEDULA DE CIUDADANIA";
        inicial="CC";
    }
    
    

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idTipoDocumento);
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
        final Documento other = (Documento) obj;
        if (!Objects.equals(this.idTipoDocumento, other.idTipoDocumento)) {
            return false;
        }
        return true;
    }
    
    
}
