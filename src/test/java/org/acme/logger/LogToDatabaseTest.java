package org.acme.logger;

import org.acme.logger.config.AppConfig;
import org.acme.logger.enums.MessageType;
import org.acme.logger.factory.LoggerFactory;
import org.acme.logger.interfaces.ILogger;
import org.acme.logger.utils.DatabaseManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LogToDatabaseTest {

    @Test
    public void testDatabaseManager_BDConnectionValid() throws Exception {
        DatabaseManager bdManager = DatabaseManager.getInstance(new AppConfig());
        try {
            assertTrue(bdManager.getConnection().isValid(0));
        } catch (SQLException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testDatabaseManager_insertMessage() {
        try {
            DatabaseManager bdManager = DatabaseManager.getInstance(new AppConfig());
            bdManager.createLogTable();
            bdManager.saveMessage("Test message DB", MessageType.MESSAGE.getId());
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testLoggerDatabase_addLog() {
        try {
            ILogger logger = LoggerFactory.getLogger("DATABASE");
            logger.logMessage("Test message DB - Message Info");
            logger.logWarning("Test message DB - Message Warning");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}
