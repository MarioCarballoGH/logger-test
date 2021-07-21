package org.acme.logger;

import org.acme.logger.interfaces.ILogger;
import org.acme.logger.utils.ConsoleManager;
import org.acme.logger.utils.Constants;
import org.apache.logging.log4j.util.Strings;

import java.util.logging.Level;

public class LogToConsole implements ILogger {

    private ConsoleManager consoleManager;

    public LogToConsole() {
        this.consoleManager = ConsoleManager.getInstance();
        logger.addHandler(this.consoleManager.getConsoleHandler());
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
