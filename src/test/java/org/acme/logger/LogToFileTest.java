package org.acme.logger;

import org.acme.logger.factory.LoggerFactory;
import org.acme.logger.interfaces.ILogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogToFileTest {

    @Test
    public void testLoggerFile_addMultipleMessage() throws Exception {
        ILogger logger = LoggerFactory.getLogger("FILE");
        logger.logMessage("File Test - Message Info");
        logger.logWarning("File Test - Message Warning");
        assertEquals(true, logger instanceof LogToFile);
    }

}
