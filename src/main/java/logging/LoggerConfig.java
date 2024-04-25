package logging;

import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {

    private static Level levelForConsole = Level.ALL;
    private static Level levelForFile = Level.ALL;

    public static Logger configure(String className) {
        return configure(className, levelForConsole, levelForFile);
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

    public static void setLevelForConsole(Level levelForConsole) {
        LoggerConfig.levelForConsole = levelForConsole;
    }

    public static void setLevelForFile(Level levelForFile) {
        LoggerConfig.levelForFile = levelForFile;
    }
}
