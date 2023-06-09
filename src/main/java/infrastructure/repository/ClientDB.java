package infrastructure.repository;


import core.domain.area.Area;
import core.domain.consent.ConsentVIH;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.ProcessConsent;
import core.domain.consent.VIHData;
import core.domain.professional.Professional;
import core.domain.consent.EmergencyConsent;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;

import java.sql.ResultSet;
import java.util.List;


public interface ClientDB {

    ResultSet getAllDocumentTypes() throws Exception;

    ResultSet findPatient(Integer idType, String id) throws Exception;

    void createPatient(Patient patient) throws Exception;

    void updatePatient(Patient patient) throws Exception;

    ResultSet findGuardian(Integer idType, String id) throws Exception;

    void createGuardian(Guardian guardian) throws Exception;

    void updateGuardian(Guardian guardian) throws Exception;

    Integer findNextId() throws Exception;

    ResultSet findConfiguration(String parameterName) throws Exception;

    ResultSet findAllSpeciality() throws Exception;

    ResultSet findAllVaccine() throws Exception;

    ResultSet findAllAreas() throws Exception;

    ResultSet findProcessByArea(String idArea) throws Exception;

    ResultSet createProcess(Process process) throws Exception;

    void createProfessional(Professional professional) throws Exception;

    void updateProfessional(Professional professional) throws Exception;

    ResultSet findProfessional(Integer idType, String id) throws Exception;
    ResultSet findProfessionalBySpeciality(Integer specialityID) throws Exception;
    ResultSet findAllProfessional() throws Exception;

    ResultSet findProcessByName(String name) throws Exception;
    void createVIHConsent(ConsentVIH consent) throws Exception;
    ResultSet findVIHData(VIHData filter) throws Exception;
    ResultSet findSicknessVIHData(int id) throws Exception;

    void updateVIHConsent(int id, String filename) throws Exception;
}
