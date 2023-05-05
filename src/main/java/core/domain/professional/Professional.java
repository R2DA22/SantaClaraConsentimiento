/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain.professional;

import core.domain.bus.command.Command;
import core.domain.bus.query.Query;
import core.domain.speciality.Speciality;
import core.domain.patient.Person;

/**
 *
 * @author diego.ramirez
 */
public class Professional extends Person implements Command, Query {
    
    private Integer registryNumber;
    private Speciality specialty;

    public Professional() {
        super();
    }

    public Integer getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(Integer registryNumber) {
        this.registryNumber = registryNumber;
    }

    public Speciality getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Speciality specialty) {
        this.specialty = specialty;
    }
    
    
    
}
