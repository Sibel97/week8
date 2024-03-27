package com.sparta.shh.logging;

import java.io.IOException;
import java.util.logging.*;

public class app
{
    public static final Logger logger = Logger.getLogger(app.class.getName());
    public static void main(String[] args) {

        logger.setLevel(Level.ALL);

        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IllegalArgumentException | SecurityException | IOException e) {
            e.printStackTrace();                        // <- For demonstration purposes only!
        }

//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.FINE);
//        CustomFormatter cf = new CustomFormatter();
//        consoleHandler.setFormatter(cf);
//        logger.addHandler(consoleHandler);

        //Highest
        logger.log(Level.SEVERE, "SEVERE is a message level indicating a potential problem");
        logger.log(Level.WARNING, "WARNING is a message level indicating a potential problem");
        logger.log(Level.INFO, " INFO is a message level for informational messages");
        logger.log(Level.CONFIG, " CONFIG is a message level for static config messages");
        logger.log(Level.FINE, "FINE is a message level providing tracking information");
        logger.log(Level.FINER, "FINER is a message level indicates a fairly detailed tracing message");
        logger.log(Level.FINEST, "FINEST is a message level indicates a highly detailed tracing message");
        //Lowest

    }
}
