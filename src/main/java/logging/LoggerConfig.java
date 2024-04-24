package logging;

import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {
    public static Logger configure(String className) {
        return configure(className, Level.ALL, Level.ALL);
    }
    
    public static Logger configure(String className, Level levelForConsole, Level levelForFile) {

        Logger LOGGER = Logger.getLogger(className);
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(levelForConsole);
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setLevel(levelForFile);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);

        return LOGGER;
    }
}
