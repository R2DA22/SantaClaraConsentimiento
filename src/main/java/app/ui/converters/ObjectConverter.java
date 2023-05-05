/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import core.domain.area.Area;
import core.domain.patient.DocumentType;
import core.domain.speciality.Speciality;
import core.domain.process.Process;
import core.domain.vaccine.Vaccine;

/**
 *
 * @author diego.ramirez
 */
@FacesConverter("objectConverter")
public class ObjectConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                Object objeto = fc.getExternalContext().getApplicationMap().get(value);
                if (objeto instanceof Vaccine) {
                    Vaccine object = (Vaccine) objeto;
                    return object;
                }
                if (objeto instanceof Area) {
                    Area object = (Area) objeto;
                    return object;
                }
                if (objeto instanceof Speciality) {
                    Speciality object = (Speciality) objeto;
                    return object;
                }
                if (objeto instanceof Process) {
                    Process object = (Process) objeto;
                    return object;
                }
                if (objeto instanceof DocumentType) {
                    DocumentType object = (DocumentType) objeto;
                    return object;
                }
                return null;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid object."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            if (object instanceof Vaccine) {
                Vaccine objeto = (Vaccine) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Area) {
                Area objeto = (Area) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Speciality) {
                Speciality objeto = (Speciality) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Process) {
                Process objeto = (Process) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof DocumentType) {
                DocumentType objeto = (DocumentType) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
        }
        return null;
    }
}
