
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdConfig;

//import ips.modelo.AuditoriaRegistro;
//~--- JDK imports ------------------------------------------------------------
import utilidades.Propiedades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//~--- classes ----------------------------------------------------------------
/**
 *
 * @author carlosf
 */
public class BaseDatos {

    /**
     * Field description
     */
    private Connection conexion;

    /**
     * Field description
     */
    private Statement query;

    /**
     * Field description
     */
    private String url = "";
    private Properties propiedades;

    //~--- constructors -------------------------------------------------------
    /**
     * Constructs ...
     *
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public BaseDatos() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = "org.postgresql.Driver";
        Class.forName(controlador).newInstance();
    }
    public BaseDatos(Properties propiedades) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = propiedades.getProperty("controlador");
        Class.forName(controlador).newInstance();
        this.propiedades = propiedades;
    }

    //~--- methods ------------------------------------------------------------
    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public int actualizar(String sql) throws SQLException {
        int totalRegistros = 0;

        totalRegistros = query.executeUpdate(sql);
        return totalRegistros;
    }

    /**
     * Method description
     *
     *
     * @param sql
     * @param colnames
     *
     * @return
     *
     * @throws SQLException
     */
    public int actualizar(String sql, String[] colnames) throws SQLException {
        int totalRegistros = 0;

        totalRegistros = query.executeUpdate(sql, colnames);
        return totalRegistros;
    }

    /**
     * Method description
     *
     *
     * @param usr
     * @param pwd
     *
     * @throws SQLException
     */
    public void conectar(String usr, String pwd) throws SQLException {

//      url = "jdbc:postgresql://" + SERVIDOR + ":" + PUERTO + "/" + BD;
        //url = "jdbc:postgresql://10.1.1.196:5430/dbsa";
       // url = "jdbc:postgresql://10.1.1.194:5432/dbsa";
      // url = "jdbc:postgresql://10.1.1.197:5432/dbsa";

       //url = "jdbc:postgresql://10.1.1.194:6432/dbsa";
        //pruebas vieja
        // url = "jdbc:postgresql://10.1.1.84:4489/dbsa";
        // url = "jdbc:postgresql://192.168.56.101:5432/dbcaf";
        propiedades=Propiedades.getInstancia().getPropiedades();
        usr=propiedades.getProperty("usuario");
        pwd=propiedades.getProperty("clave");
        url=propiedades.getProperty("urlbd");
        conexion = java.sql.DriverManager.getConnection(url, usr, pwd);
//        AuditoriaRegistro.setActivo(true);
//        AuditoriaRegistro.setUltimaActualizacion(new Date(new java.util.Date().getTime()));
//        AuditoriaRegistro.setUsuarioActualiza(usr);
        query = conexion.createStatement();
        this.conexion = conexion;
    }

    /**
     * Se obtiene la conexion actual
     * @return 
     */
    public Connection getConexion () {
        return this.conexion;
    }

    /**
     * Method description
     *
     */
    public void desconectar() {
        if (query != null) {
            try {
                query.close();
            } catch (SQLException e) {
            }

            query = null;
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
            }

            conexion = null;
        }
    }

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public ResultSet ejecutar(String sql,int ind,int rows) throws SQLException {        
        query.setFetchSize(rows);
        query.setMaxRows(rows);
        return query.executeQuery(sql);
    }
    public ResultSet ejecutar(String sql) throws SQLException {
        return query.executeQuery(sql);
    }

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conexion.prepareStatement(sql);
    }
}
