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
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author diego.ramirez
 */
public class Professional extends Person implements Command, Query, Serializable {
    private static final long serialVersionUID = 1L;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Professional)) {
            return false;
        }
        Professional that = (Professional) o;
        return Objects.equals(getRegistryNumber(), that.getRegistryNumber()) &&
                Objects.equals(getSpecialty(), that.getSpecialty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRegistryNumber(), getSpecialty());
    }
}
