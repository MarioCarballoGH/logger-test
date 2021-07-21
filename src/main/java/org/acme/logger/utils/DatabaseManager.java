package org.acme.logger.utils;

import org.acme.logger.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager implements Serializable {

    private String userName;
    private String password;
    private String url;
    private static DatabaseManager INSTANCE = null;

    @Autowired
    private Environment env;

    private DatabaseManager(AppConfig dbParams) {
        this.userName = dbParams.getUserName();
        this.password = dbParams.getPassword();
        this.url = dbParams.getUrl();
    }

    public static DatabaseManager getInstance(AppConfig dbParams) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(dbParams);
        }
        return INSTANCE;
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new Exception("Connection DB error", e);
        }
        return connection;
    }

    public Statement getStatment(Connection connection) throws Exception {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new Exception("Statement error.", e);
        }
    }

    public void createLogTable() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = getStatment(connection);
            statement.executeUpdate("create table IF NOT EXISTS Logs(messageText varchar(255), type int)");
        } catch (SQLException e) {
            throw new Exception("Create log table BD error.", e);
        } finally {
            //close
        }
    }

    public void saveMessage(String message, int messageType) throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute("INSERT INTO Logs(messageText, type) VALUES('" + message + "', " + String.valueOf(messageType) + ")");
        } catch (SQLException e) {
            throw new Exception("Insert error.", e);
        } finally {
        }
    }


}
