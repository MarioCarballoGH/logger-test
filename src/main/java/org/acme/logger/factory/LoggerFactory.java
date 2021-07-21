package org.acme.logger.factory;

import org.acme.logger.LogToConsole;
import org.acme.logger.LogToDatabase;
import org.acme.logger.LogToFile;
import org.acme.logger.config.AppConfig;
import org.acme.logger.interfaces.ILogger;

public class LoggerFactory {

    private LoggerFactory() {
    }

    public static ILogger getLogger(String type) throws Exception {
        if (type.equals("FILE")) {
            return new LogToFile(new AppConfig());
        } else if (type.equals("CONSOLE")) {
            return new LogToConsole();
        } else if (type.equals("DATABASE")) {
            return new LogToDatabase(new AppConfig());
        } else {
            throw new Exception("Logger type not valid");
        }
    }

    public static ILogger getLogger(String type, AppConfig dbParams) throws Exception {
        if (type.equals("FILE")) {
            return new LogToFile(dbParams);
        } else if (type.equals("CONSOLE")) {
            return new LogToConsole();
        } else if (type.equals("DATABASE")) {
            return new LogToDatabase(dbParams);
        } else {
            throw new Exception("Logger type not valid");
        }
    }

}
