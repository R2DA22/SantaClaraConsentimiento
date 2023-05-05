/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain;

import core.domain.area.Area;
import core.domain.professional.Professional;
import core.domain.patient.Patient;
import core.domain.process.Process;
import core.domain.vaccine.Vaccine;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author diego.ramirez
 */
public class Consentimiento {

    private List<Process> procedimiento;
    private Boolean riesgoBeneficio;
    private Boolean tratamientoDatos;
    private String firma;
    private String otroProcedimiento;
    private Integer nroAdmision;
    private Integer nroManilla;
    private Patient paciente;
    private Professional profesional;
    private Boolean contactoCovid;
    private Boolean sintomas;
    private Boolean viajes;
    private String descripcionSintomas;
    private Date fechaInicioSintomas;
    private String viajesRealizados;
    private String ocupacion;
    private String telefono;
    private Integer edad;
    private Boolean trabajadorSalud;
    private Boolean vacunado;
    private String EPS;
    private Vaccine vacuna;
    private Integer nroDosis;
    private Date fechaVacuna;
    private String email;
    private List<Area> lstArea;
    private Area area;
    private Boolean disiente;
    private List<Process> desentimientos;

    public Consentimiento() {
        paciente = new Patient();
        profesional = new Professional();
        tratamientoDatos = true;
        riesgoBeneficio = true;
        trabajadorSalud = false;
        contactoCovid = false;
        viajes = false;
        sintomas = false;
        vacunado = false;
        disiente = false;
        nroDosis = 0;
        vacuna = null;
        Calendar fecha = new GregorianCalendar();
        fechaInicioSintomas = fecha.getTime();
        fechaVacuna = fecha.getTime();
        procedimiento = new ArrayList<>();
        desentimientos = new ArrayList<>();
        lstArea = new ArrayList<>();

    }

    public List<Process> getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(List<Process> procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Boolean getRiesgoBeneficio() {
        return riesgoBeneficio;
    }

    public void setRiesgoBeneficio(Boolean riesgoBeneficio) {
        if (riesgoBeneficio != null) {
            this.riesgoBeneficio = riesgoBeneficio;
        }
    }

    public Boolean getTratamientoDatos() {
        return tratamientoDatos;
    }

    public void setTratamientoDatos(Boolean tratamientoDatos) {
        if (tratamientoDatos != null) {
            this.tratamientoDatos = tratamientoDatos;
        }
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getOtroProcedimiento() {
        return otroProcedimiento;
    }

    public void setOtroProcedimiento(String otroProcedimiento) {
        this.otroProcedimiento = otroProcedimiento;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public Integer getNroAdmision() {
        return nroAdmision;
    }

    public void setNroAdmision(Integer nroAdmision) {
        this.nroAdmision = nroAdmision;
    }

    public Integer getNroManilla() {
        return nroManilla;
    }

    public void setNroManilla(Integer nroManilla) {
        this.nroManilla = nroManilla;
    }

    public String getFecha(String tipoFormato) {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat(tipoFormato);
        return formato.format(fecha);
    }

    public String getNombreMes() {
        // Obtienes el mes actual
        Month mes = LocalDate.now().getMonth();
        // Obtienes el nombre del mes
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        // Convierte a mayúscula la primera letra del nombre.
        String primeraLetra = nombre.substring(0, 1);
        String mayuscula = primeraLetra.toUpperCase();
        String demasLetras = nombre.substring(1, nombre.length());
        nombre = mayuscula + demasLetras;
        return nombre;
    }

    public String getNombreDia() {
        // Obtienes el mes actual
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        // Obtienes el nombre del mes
        String name = day.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        return name;
    }

    public Professional getProfesional() {
        return profesional;
    }

    public void setProfesional(Professional profesional) {
        this.profesional = profesional;
    }

    public Boolean getSintomas() {
        return sintomas;
    }

    public void setSintomas(Boolean sintomas) {
        if (sintomas != null) {
            this.sintomas = sintomas;
        }
    }

    public Boolean getViajes() {
        return viajes;
    }

    public void setViajes(Boolean viajes) {
        if (viajes != null) {
            this.viajes = viajes;
        }
    }

    public Boolean getContactoCovid() {
        return contactoCovid;
    }

    public void setContactoCovid(Boolean contactoCovid) {
        if (contactoCovid != null) {
            this.contactoCovid = contactoCovid;
        }
    }

    public String getDescripcionSintomas() {
        if (!getSintomas()) {
            return "";
        }
        return descripcionSintomas;
    }

    public void setDescripcionSintomas(String sintomas) {
        this.descripcionSintomas = sintomas;
    }

    public Date getFechaInicioSintomas() {
        return fechaInicioSintomas;
    }

    public void setFechaInicioSintomas(Date fechaInicioSintomas) {
        this.fechaInicioSintomas = fechaInicioSintomas;
    }

    public String getViajesRealizados() {
        if (!getViajes()) {
            return "";
        }
        return viajesRealizados;
    }

    public void setViajesRealizados(String viajesRealizados) {
        this.viajesRealizados = viajesRealizados;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getTrabajadorSalud() {
        return trabajadorSalud;
    }

    public void setTrabajadorSalud(Boolean trabajadorSalud) {
        if (trabajadorSalud != null) {
            this.trabajadorSalud = trabajadorSalud;
        }
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public Boolean getVacunado() {
        return vacunado;
    }

    public void setVacunado(Boolean vacunado) {
        if (vacunado != null) {
            this.vacunado = vacunado;
        }
    }

    public Boolean getDisiente() {
        return disiente;
    }

    public void setDisiente(Boolean disiente) {
        if (disiente != null) {
            this.disiente = disiente;
        }
    }

    public Vaccine getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vaccine vacuna) {
        this.vacuna = vacuna;
    }

    public Integer getNroDosis() {
        return nroDosis;
    }

    public void setNroDosis(Integer nroDosis) {
        if (nroDosis != null) {
            this.nroDosis = nroDosis;
        }
    }

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getFechaVacuna(String tipoFormato) {
        SimpleDateFormat formato = new SimpleDateFormat(tipoFormato);
        if (fechaVacuna == null) {
            return null;
        } else {
            return formato.format(fechaVacuna);
        }
    }

    public String getFechaInicioSintomas(String tipoFormato) {
        SimpleDateFormat formato = new SimpleDateFormat(tipoFormato);
        if (fechaInicioSintomas == null) {
            return null;
        } else {
            return formato.format(fechaInicioSintomas);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Area> getLstArea() {
        return lstArea;
    }

    public void setLstArea(List<Area> lstArea) {
        this.lstArea = lstArea;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Process> getDesentimientos() {
        return desentimientos;
    }

    public void setDesentimientos(List<Process> desentimientos) {
        this.desentimientos = desentimientos;
    }

}
