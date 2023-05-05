package core.domain.configuration;

import core.domain.bus.query.Query;

public class Configuration implements Query {

    private String pathPdfFile;

    public Configuration(String pathPdfFile) {
        this.pathPdfFile = pathPdfFile;
    }

    public String getPathPdfFile() {
        return pathPdfFile;
    }

    public void setPathPdfFile(String pathPdfFile) {
        this.pathPdfFile = pathPdfFile;
    }
}
