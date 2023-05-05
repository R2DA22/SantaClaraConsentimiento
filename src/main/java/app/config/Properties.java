package app.config;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author diego.ramirez
 */
public class Properties {

    private static Properties instance;
    private java.util.Properties properties;

    private final String CONFIGURATION_PROPERTIES="configurations.properties";
    private final String OS_NAME="os.name";
    private final String WINDOWS="win";
    private final String CLASS_EXT=".class";
    private final String CLASSES="classes";

    private Properties() {
        try {
            URI u = getClass().getResource(Properties.class.getSimpleName() + CLASS_EXT).toURI();
            String realPath = u.getPath().substring(0, u.getPath().indexOf(CLASSES));
            String propertiesPath;
            try {
                String OS = System.getProperty(OS_NAME).toLowerCase();
                if (OS.contains(WINDOWS)) {
                    realPath = realPath.substring(1);
                    realPath = realPath.replaceAll("/", "\\\\");
                    propertiesPath=realPath + CONFIGURATION_PROPERTIES;
                } else {
                    propertiesPath=realPath +CONFIGURATION_PROPERTIES;
                }
                properties = loadProperties(propertiesPath);
            } catch (Exception ignored) {
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }

    /**
     * @return the instance
     */
    public static Properties getInstance() {
        if (instance == null) {
            synchronized (Properties.class) {
                instance = new Properties();
            }
        }
        return instance;
    }

    public java.util.Properties getProperties() {
        return properties;
    }

    public void setProperties(java.util.Properties properties) {
        this.properties = properties;
    }

    public java.util.Properties loadProperties(String path) throws Exception {
        java.util.Properties p = new java.util.Properties();
        ResourceBundle bdl = new PropertyResourceBundle(new FileInputStream(path));
        Enumeration keys = bdl.getKeys();
        while (keys.hasMoreElements()) {
            String prop = (String) keys.nextElement();
            String val = bdl.getString(prop);
            p.setProperty(prop, val);
        }
        return p;
    }

}
