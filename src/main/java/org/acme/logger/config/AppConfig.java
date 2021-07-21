package org.acme.logger.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {

    private String logFileFolder;
    private String url;
    private String userName;
    private String password;

    public AppConfig() {
        this.logFileFolder = "./data/logFile.txt";
        this.url = "jdbc:h2:./data/default";
        this.userName = "sa";
        this.password = "sa";
    }

    public String getLogFileFolder() {
        return logFileFolder;
    }

    public void setLogFileFolder(String logFileFolder) {
        this.logFileFolder = logFileFolder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
