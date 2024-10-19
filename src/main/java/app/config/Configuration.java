package app.config;

import java.io.FileInputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author diego.ramirez
 */
public class Configuration implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Configuration instance;
    private Properties properties;
    private String applicationPath;
    private String cssPath = "css/";
    private String imagesPath = "imagenes/";
    private String resourcesPath = "resources/";
    private String pathDivisor = "/";
    private final String LOCAL_CONFIGURATION = "configurations_local.properties";
    private final String BETA_CONFIGURATION = "configurations_beta.properties";
    private final String PROD_CONFIGURATION = "configurations_prod.properties";
    private final String OS_NAME = "os.name";
    private final String BETA = "beta";
    private final String PROD = "prod";
    private final String WINDOWS = "win";
    private final String CLASS_EXT = ".class";
    private final String CLASSES = "classes";
    private final String WEB_INF = "WEB-INF";

    private Configuration() {
        try {
            URI u = getClass().getResource(Configuration.class.getSimpleName() + CLASS_EXT).toURI();
            applicationPath = u.getPath().substring(0, u.getPath().indexOf(CLASSES));
            String OS = System.getProperty(OS_NAME).toLowerCase();
            if (OS.contains(WINDOWS)) {
                applicationPath = applicationPath.substring(1);
                applicationPath = applicationPath.replaceAll("/", "\\\\");
                applicationPath = applicationPath.replaceAll("/", "\\\\");
                imagesPath = imagesPath.replaceAll("/", "\\\\");
                cssPath = cssPath.replaceAll("/", "\\\\");
                pathDivisor = pathDivisor.replaceAll("/", "\\\\");
            }
            String propertiesPath = determinatePropertiesPath(applicationPath);
            String part[] = applicationPath.split(WEB_INF);
            applicationPath = part[0] + resourcesPath;
            properties = loadProperties(propertiesPath);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }

    private String determinatePropertiesPath(String realPath) {
        String path = realPath.toLowerCase();
        if (path.contains(BETA)) {
            return realPath + BETA_CONFIGURATION;
        }
        if (path.contains(PROD)) {
            return realPath + PROD_CONFIGURATION;
        }
        return realPath + LOCAL_CONFIGURATION;
    }

    /**
     * @return the instance
     */
    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                instance = new Configuration();
            }
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public Properties loadProperties(String path) throws Exception {
        Properties p = new Properties();
        ResourceBundle bdl = new PropertyResourceBundle(new FileInputStream(path));
        Enumeration keys = bdl.getKeys();
        while (keys.hasMoreElements()) {
            String prop = (String) keys.nextElement();
            String val = bdl.getString(prop);
            p.setProperty(prop, val);
        }
        return p;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public String getCssPath() {
        return cssPath;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public String getPathDivisor() {
        return pathDivisor;
    }
}
