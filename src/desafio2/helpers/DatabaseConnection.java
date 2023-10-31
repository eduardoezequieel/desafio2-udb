package desafio2.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Eduardo
 */
public class DatabaseConnection {
    private Connection connection;
    private String database = "jdbc:mysql://localhost:3306/mediateca";
    private String user = "root";
    private String password = "";
    
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(database, user, password);
        } catch (Exception e) {
            System.out.println("No hay conexión");
            System.err.println(e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
