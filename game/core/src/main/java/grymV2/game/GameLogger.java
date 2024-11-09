package grymV2.game;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;

/**
 * GameLogger
 */
public class GameLogger {
    public static void error(Class<?> c, String msg) {
        log(c, Level.ERROR, msg);
    }

    public static void warn(Class<?> c, String msg) {
        log(c, Level.WARN, msg);
    }

    public static void info(Class<?> c, String msg) {
        log(c, Level.INFO, msg);
    }

    public static void debug(Class<?> c, String msg) {
        log(c, Level.DEBUG, msg);
    }

    private static void log(Class<?> c, Level level, String msg) {
        Logger logger = LogManager.getLogger(c);
        logger.log(level, msg);
    }
}
