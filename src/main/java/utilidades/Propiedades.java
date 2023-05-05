package utilidades;

import controlador.GestorPropiedades;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * @author carlosp
 */
public class Propiedades {

    private static Propiedades instancia;
    private Properties propiedades;

    private Propiedades() {
        try {
            URI u = getClass().getResource(Propiedades.class.getSimpleName() + ".class").toURI();
            String realPath = u.getPath().substring(0, u.getPath().indexOf("classes"));
            GestorPropiedades gestorPropiedades = new GestorPropiedades();
            try {
                String OS = System.getProperty("os.name").toLowerCase();
                if (OS.contains("win")) {
                    realPath = realPath.substring(1, realPath.length());
                    realPath = realPath.replaceAll("\\/", "\\\\");
                    propiedades = gestorPropiedades.cargarPropiedades(realPath + "configuracion.properties");
                } else {
                    propiedades = gestorPropiedades.cargarPropiedades(realPath + "/configuracion.properties");
                }

            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    /**
     * @return the instancia
     */
    public static Propiedades getInstancia() {
        if (instancia == null) {
            synchronized (Propiedades.class) {
                instancia = new Propiedades();
            }
        }
        return instancia;
    }

    public Properties getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }

}
