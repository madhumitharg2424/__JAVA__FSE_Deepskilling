package Week_1.SLF4J_Logging_Exercises.Logging_Error_Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String[] args) {

        logger.info("Application Started");

        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage());
        }

        logger.info("Application Finished");
    }
}
