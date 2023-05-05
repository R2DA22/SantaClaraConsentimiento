package controlador;

import utilidades.Propiedades;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author carlosf
 */
public class BaseDatos {

    private final Properties propiedades;

    public BaseDatos(Properties propiedades) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = propiedades.getProperty("controlador");
        Class.forName(controlador).newInstance();
        this.propiedades = propiedades;
    }

    public Connection getConexion() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user",propiedades.getProperty("usuario"));
        props.setProperty("password",propiedades.getProperty("clave"));
        if(Propiedades.getInstancia().getPropiedades().getProperty("verLogJdbc").toUpperCase().equals("SI"))
            props.setProperty("loglevel","2");               
        return java.sql.DriverManager.getConnection(propiedades.getProperty("urlbd"),props);
    }

    public void ejecutar(Connection conexion, String sql) throws SQLException {
        Statement consulta = conexion.createStatement();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (consulta != null) {
                consulta.close();
            }
        }
    }
    
}