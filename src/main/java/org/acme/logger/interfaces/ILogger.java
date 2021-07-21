package org.acme.logger.interfaces;

import java.util.logging.Logger;

public interface ILogger {

    public static final Logger logger = Logger.getLogger("ILogger");

    public void logMessage(String messageText) throws Exception;
    public void logWarning(String messageText) throws Exception;
    public void logError(String messageText) throws Exception;

}
