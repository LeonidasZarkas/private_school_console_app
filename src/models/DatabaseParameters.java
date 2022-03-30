package models;

public class DatabaseParameters {
    private String dbms;
    private String host;
    private String hostPort;
    private String database;
    private String userName;
    private String password;

    public DatabaseParameters() {
        dbms = "mysql";
        host = "localhost";
        hostPort = "3306";
        database = "private_school";
        userName = "root";
        password = "root";
    }

    public DatabaseParameters(String dbms, String host, String hostPort, String database, String userName, String password) {
        this.dbms = dbms;
        this.host = host;
        this.hostPort = hostPort;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }
    
    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatabaseParameters{dbms=").append(dbms);
        sb.append(", host=").append(host);
        sb.append(", hostPort=").append(hostPort);
        sb.append(", database=").append(database);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
}
