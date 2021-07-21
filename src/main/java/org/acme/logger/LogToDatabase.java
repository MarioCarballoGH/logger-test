package org.acme.logger;

import org.acme.logger.config.AppConfig;
import org.acme.logger.enums.MessageType;
import org.acme.logger.interfaces.ILogger;
import org.acme.logger.utils.Constants;
import org.acme.logger.utils.DatabaseManager;
import org.apache.logging.log4j.util.Strings;

import java.text.DateFormat;
import java.util.Date;

public class LogToDatabase implements ILogger {

    private DatabaseManager databaseManager;

    public LogToDatabase(AppConfig dbParams) {
        this.databaseManager = DatabaseManager.getInstance(dbParams);
    }

    public void logMessage(String messageText) throws Exception {
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        String message = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        this.databaseManager.saveMessage(message, MessageType.MESSAGE.getId());
    }

    public void logWarning(String messageText) throws Exception {
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        String message = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        this.databaseManager.saveMessage(message, MessageType.WARNING.getId());
    }

    public void logError(String messageText) throws Exception {
        if (Strings.isBlank(messageText)) {
            throw new Exception(Constants.MESSAGE_ERROR);
        }
        String message = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        this.databaseManager.saveMessage(message, MessageType.ERROR.getId());
    }

}