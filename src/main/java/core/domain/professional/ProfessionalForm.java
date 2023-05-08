package core.domain.professional;

import app.config.Configuration;
import core.domain.bus.command.Command;
import core.domain.consent.ConsentInterface;
import utilidades.Constantes;

public class ProfessionalForm extends ConsentInterface implements Command {


    private static final String TYPE = "REGISTRO_PROFESIONAL";
    private static final String URL = "registro_profesional.xhtml?faces-redirect=true";

    public ProfessionalForm(Configuration configuration) {
        super(configuration);
        setTypeConsent(TYPE);
    }

    @Override
    public String dataValidation() {
        if (this.getProfessional() != null
                && this.getProfessional().getDocumentNumber() != null
                && this.getProfessional().getDocumentNumber().equals("")
                && !this.getProfessional().getDocumentNumber().matches(Constantes.REGEX_DOCUMENTO)) {
            return "Ingrese un nro de documento válido para el profesional";
        }
        if (this.getProfessional() != null
                && this.getProfessional().getName() != null
                && this.getProfessional().getName().equals("")
                && !this.getProfessional().getName().matches(Constantes.REGEX_NOMBRE)) {
            return "Ingrese un nombre válido para el profesional";
        }
        if (this.getProfessional().getRegistryNumber() != null
                && !this.getProfessional().getRegistryNumber().toString().matches(Constantes.REGEX_DIGITO)) {
            return "Ingrese un valor válido para la Nro de registro";
        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";
        }
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
