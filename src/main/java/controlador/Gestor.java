package controlador;


import utilidades.Propiedades;
import java.sql.Connection;

/**
 * @author carlosp
 */
public abstract class Gestor {

    private BaseDatos bd;
    public Connection conexion;
    
    public Gestor() throws Exception {
        bd = new BaseDatos(Propiedades.getInstancia().getPropiedades());
    }

    public void abrirConexion() throws Exception {
        conexion = bd.getConexion();
    }

    public void cerrarConexion() throws Exception {
        if (getConexion() != null) {
            getConexion().close();
        }
        conexion = null;
    }

    public void inicioTransaccion() throws Exception {
        bd.ejecutar(getConexion(), " BEGIN ");
    }

    public void finTransaccion() throws Exception {
        bd.ejecutar(getConexion(), " COMMIT ");
    }

    public void devolverTransaccion() throws Exception {
        bd.ejecutar(getConexion(), " ROLLBACK ");
    }

    /**
     * @return the bd
     */
    public BaseDatos getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(BaseDatos bd) {
        this.bd = bd;
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }
    
}