package org.acme.logger.utils;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

public class ConsoleManager implements Serializable {

    private static ConsoleManager INSTANCE = null;

    private ConsoleManager() {
    }

    public static ConsoleManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConsoleManager();
        }
        return INSTANCE;
    }

    public ConsoleHandler getConsoleHandler() {
        return new ConsoleHandler();
    }

}