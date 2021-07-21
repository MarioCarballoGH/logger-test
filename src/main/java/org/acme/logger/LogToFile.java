package org.acme.logger;

import org.acme.logger.config.AppConfig;
import org.acme.logger.interfaces.ILogger;
import org.acme.logger.utils.Constants;
import org.acme.logger.utils.FileManager;
import org.apache.logging.log4j.util.Strings;

import java.util.logging.Level;

public class LogToFile implements ILogger {

    private FileManager fileManager;

    public LogToFile(AppConfig dbParams) throws Exception {
        this.fileManager = new FileManager(dbParams);
        logger.addHandler(this.fileManager.getFileHandler());
    }

    @Override
    public void logMessage(String messageText) throws Exception{
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        logger.log(Level.INFO, messageText);
    }

    @Override
    public void logWarning(String messageText) throws Exception{
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        logger.log(Level.WARNING, messageText);
    }

    @Override
    public void logError(String messageText) throws Exception{
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        logger.log(Level.SEVERE, messageText);
    }
}
