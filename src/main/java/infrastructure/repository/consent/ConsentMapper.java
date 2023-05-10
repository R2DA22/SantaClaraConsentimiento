package infrastructure.repository.consent;

import app.config.Configuration;
import core.domain.consent.ConsentVIH;
import core.domain.patient.DocumentType;
import core.domain.patient.Guardian;
import core.domain.patient.ListDocumentType;
import core.domain.patient.Patient;
import core.domain.professional.Professional;
import core.domain.sickness.Sickness;
import core.domain.sickness.SicknessList;
import core.domain.speciality.Speciality;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsentMapper implements ConsentMapperInterface {
    @Override
    public SicknessList toSicknessList(ResultSet resultSet) {
        List<Sickness> list=new ArrayList<>();
        try {
            while (resultSet.next()) {
                Sickness sickness = new Sickness(
                        resultSet.getInt("id_enfermedad"),
                        resultSet.getString("descripcion")
                );
                sickness.setSickDate(resultSet.getDate("fecha"));
                sickness.setInstitutionDX(resultSet.getString("institucion_dx"));
                sickness.setOrganDescription(resultSet.getString("organo_compr"));
                list.add(sickness);
            }
        } catch ( Exception e){

        }
        return new SicknessList(list);
    }

    @Override
    public ConsentVIHDTO toConsentVIH(ResultSet resultSet) {
        ConsentVIHDTO consent = new ConsentVIHDTO();
        try {
            if (resultSet.next()) {
                consent.setId(resultSet.getInt("id_consentimiento"));
                consent.setRiskBenefit(resultSet.getBoolean("riesgo_beneficio"));
                consent.setDataTreatment(resultSet.getBoolean("tratamiento_datos"));
                Professional professional = new Professional();
                professional.setDocumentNumber(resultSet.getString("documento_profesional"));
                professional.setName(resultSet.getString("nombre"));
                professional.setRegistryNumber(resultSet.getInt("nro_registro"));
                professional.setSpecialty(new Speciality(resultSet.getString("descripcion"),resultSet.getInt("id_especialidad")));
                professional.setSignature(resultSet.getString("firma"));
                DocumentType doc = new DocumentType();
                doc.setDescription(resultSet.getString("tipo_documento"));
                doc.setId(resultSet.getInt("id_tipo_documento_profesional"));
                doc.setInitials(resultSet.getString("inicial"));
                professional.setDocumentType(doc);
                consent.setProfessional(professional);
                consent.setCatchment(resultSet.getString("captacion"));
                consent.setKnowledgeAboutHIV(resultSet.getString("conoce_vih"));
                consent.setKnowledgeAboutMST(resultSet.getBoolean("conoce_mst"));
                consent.setPrevention(resultSet.getBoolean("conoce_prevencion"));
                consent.setUseCondom(resultSet.getBoolean("usa_condon"));
                if (consent.isUseCondom()){
                    consent.setUseCondomReason(resultSet.getString("motivo"));
                }else{
                    consent.setNotUseCondomReason(resultSet.getString("motivo"));
                }
                consent.setFrequency(resultSet.getString("frecuencia"));
                consent.setTypeOfSexualIntercourse(resultSet.getBoolean("tipo_relacion_sexual"));
                consent.setProbableTransmissionMechanism(resultSet.getString("mecanismo_transmision"));
                consent.setTransfusionSite(resultSet.getString("transfusion_site"));
                consent.setAnotherTransmission(resultSet.getString("mecanismo_transmision"));
                consent.setEvent(resultSet.getString("evento"));
                consent.setPositiveResultReaction(resultSet.getString("reaccion_resultado"));
                consent.setMood(resultSet.getString("estado_paciente"));
                consent.setAnotherMood(resultSet.getString("estado_paciente"));
                consent.setTest(resultSet.getBoolean("test_obligatorio"));
                consent.setTestReason(resultSet.getString("motivo_test"));
            }
        } catch ( Exception e){

        }
        return consent;
    }
}
