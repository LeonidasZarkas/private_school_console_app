package services;

import models.DatabaseParameters;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    
    public Connection getConnection(DatabaseParameters dbParameters) throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParameters.getUserName());
        connectionProps.put("password", dbParameters.getPassword());
        String dbms = dbParameters.getDbms();
        String dbName = dbParameters.getDatabase();

        if (dbms.equals("mysql")) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:" + dbms + "://"
                        + dbParameters.getHost() + ":" + dbParameters.getHostPort() + "/" + dbName,
                        connectionProps);
            } catch (ClassNotFoundException e) {
                System.out.println("No suitable driver was found!");
            }
        } else {
            System.out.println("No suitable database was found!");
        }
        
        return conn;
    }
    
}
