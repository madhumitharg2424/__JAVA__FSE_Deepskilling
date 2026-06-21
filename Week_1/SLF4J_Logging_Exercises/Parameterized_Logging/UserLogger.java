package Week_1.SLF4J_Logging_Exercises.Parameterized_Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLogger {

    private static final Logger logger =
            LoggerFactory.getLogger(UserLogger.class);

    public static void main(String[] args) {

        String username = "Madhu";
        int loginCount = 5;

        logger.info(
                "User {} logged in {} times",
                username,
                loginCount
        );
    }
}