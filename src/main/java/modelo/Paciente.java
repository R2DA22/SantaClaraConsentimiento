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
public class Paciente extends Persona{

    private Acudiente acudiente;
   
    public Paciente() {
        super();
        acudiente= new Acudiente();
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

}
