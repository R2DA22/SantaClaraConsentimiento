
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdConfig;

import utilidades.Propiedades;
import java.sql.ResultSet;
import java.sql.SQLException;

//~--- classes ----------------------------------------------------------------
/**
 *
 * @author tech toys
 */
public  abstract class GestorBD {

    /**
     * Field description
     */
    protected BaseDatos bd;

    /**
     * Field description
     */
    private String CLAVE = "sita";

    /**
     * Field description
     */
    private String clave;

    /**
     * Field description
     */
    protected ResultSet resultSet;

    /**
     * Field description
     */
    protected String sql;

    /**
     * Field description
     */
    private String USUARIO = "sita";

    /**
     * Field description
     */
    private String usuario;

    //~--- constructors -------------------------------------------------------
    /**
     * Constructs ...
     *
     */
    public GestorBD() {
        this.usuario = USUARIO;
        this.clave = CLAVE;

    }

    /**
     * Constructs ...
     *
     *
     * @param usuario
     * @param clave
     */
    public GestorBD(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;

        try {
            bd = new BaseDatos(Propiedades.getInstancia().getPropiedades());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    //~--- get methods --------------------------------------------------------
    /**
     * @return the bd
     */
    public BaseDatos getBd() {
        return bd;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    //~--- set methods --------------------------------------------------------
    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
