package core.domain.consent;

import core.domain.bus.query.Query;
import core.domain.patient.DocumentType;

public class VIHData implements Query {
    private int documentType;
    private String documentNumber;

    public VIHData(int documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public int getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
