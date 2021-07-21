package org.acme.logger.utils;

import org.acme.logger.config.AppConfig;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

public class FileManager implements Serializable {

    private final String fileFullname;
    public  FileManager (AppConfig dbParams) {
        this.fileFullname = dbParams.getLogFileFolder();
    }

    public File getLogFile() throws Exception {
        File logFile = new File(fileFullname);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new Exception("Error creating new log file.", e);
            }
        }
        return logFile;
    }

    public FileHandler getFileHandler() throws Exception {
            getLogFile();
            return new FileHandler(fileFullname);
    }

}
