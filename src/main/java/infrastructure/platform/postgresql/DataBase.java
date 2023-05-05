package infrastructure.platform.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;

/**
 * @author diego.ramirez
 */
public class DataBase {

    private final Properties properties;

    private final String USER="user";
    private final String PASSWORD="password";
    private final String DRIVER="driver";
    private final String URL_BD="url_db";

    public DataBase(Properties properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String driver = properties.getProperty(DRIVER);
        Class.forName(driver).newInstance();
        this.properties = properties;
    }

    public Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty(USER, properties.getProperty(USER));
        props.setProperty(PASSWORD, properties.getProperty(PASSWORD));
        return DriverManager.getConnection(properties.getProperty(URL_BD),props);
    }

    
}