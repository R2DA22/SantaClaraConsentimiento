/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Area;
import modelo.Documento;
import modelo.Especialidad;
import modelo.Procedimiento;
import modelo.Vacuna;

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
                if (objeto instanceof Vacuna) {
                    Vacuna object = (Vacuna) objeto;
                    return object;
                }
                if (objeto instanceof Area) {
                    Area object = (Area) objeto;
                    return object;
                }
                if (objeto instanceof Especialidad) {
                    Especialidad object = (Especialidad) objeto;
                    return object;
                }
                if (objeto instanceof Procedimiento) {
                    Procedimiento object = (Procedimiento) objeto;
                    return object;
                }
                if (objeto instanceof Documento) {
                    Documento object = (Documento) objeto;
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
            if (object instanceof Vacuna) {
                Vacuna objeto = (Vacuna) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Area) {
                Area objeto = (Area) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Especialidad) {
                Especialidad objeto = (Especialidad) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Procedimiento) {
                Procedimiento objeto = (Procedimiento) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            if (object instanceof Documento) {
                Documento objeto = (Documento) object;
                fc.getExternalContext().getApplicationMap().put(objeto.toString(), object);
                return objeto.toString();
            }
            return null;
        } else {
            return null;
        }
    }
}
