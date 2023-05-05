package core.domain.patient;

import java.util.List;

public class ListDocumentType {

    private List<DocumentType> documentTypes;

    public ListDocumentType(List<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }

    public List<DocumentType> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
