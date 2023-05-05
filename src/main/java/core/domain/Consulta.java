package core.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author carlosp
 */
public class Consulta {

    private Connection conexion;
    private Statement query;

    public Consulta(Connection conexion) throws SQLException {
        this.conexion = conexion;
        query = this.conexion.createStatement();
    }

    public ResultSet ejecutar(String sql) throws SQLException {
        return query.executeQuery(sql);
    }
    


    public int actualizar(String sql) throws SQLException {
        return query.executeUpdate(sql);
    }

    
    public void desconectar() {
        if (query != null) {
            try {
                query.close();
            } catch (SQLException e) {
            }
            query = null;
        }
    }

    
}