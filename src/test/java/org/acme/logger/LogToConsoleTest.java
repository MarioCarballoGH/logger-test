package org.acme.logger;

import org.acme.logger.factory.LoggerFactory;
import org.acme.logger.interfaces.ILogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogToConsoleTest {


    @Test
    public void testLoggerConsole_addMultipleMessage() throws Exception {
        ILogger logger = LoggerFactory.getLogger("CONSOLE");
        logger.logMessage("Console Test - Message Info");
        logger.logWarning("Console Test - Message Warning");
        logger.logError("Console Test - Message Error");
        assertEquals(true, logger instanceof LogToConsole);
    }

}
