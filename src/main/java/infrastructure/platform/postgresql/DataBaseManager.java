package infrastructure.platform.postgresql;


import app.config.Properties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author diego.ramirez
 */
public class DataBaseManager {


    private Connection connection;
    private DataBase dataBase;
    private Statement query;

    public DataBaseManager() throws Exception {
        dataBase = new DataBase(Properties.getInstance().getProperties());
    }

    public void openConnection() throws Exception {
        this.connection = this.dataBase.getConnection();
        this.query = this.connection.createStatement();
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (query != null) {
                query.close();
            }
            connection = null;
            query = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet execute(String sql) throws SQLException {
        return query.executeQuery(sql);
    }


    public int update(String sql) throws SQLException {
        return query.executeUpdate(sql);
    }

    public void begin() throws Exception {
        update(" BEGIN ");
    }

    public void commit() throws Exception {
        update(" COMMIT ");
    }

    public void rollback() throws Exception {
        update(" ROLLBACK ");
    }

    /**
     * @return the conexion
     */
    public Connection getConnection() {
        return connection;
    }

}