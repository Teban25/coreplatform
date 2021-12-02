package coreplatform.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingWithManager {

	private static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String[] args) {
		logger.setLevel(Level.FINE);
		logger.log(Level.SEVERE, "Uh oh!!");
		logger.log(Level.INFO, "Just so you know");
		logger.log(Level.FINE, "Hey developer dude");
		logger.log(Level.FINEST, "You're special");
		
		logger.info("Nice example about info");
		
		String[] loggerObjects = new String[]{"wed", "2", "Fri"};
		logger.log(Level.INFO, "{0} is my favorite","Java");
		logger.log(Level.INFO, "{0} is {1} days from {2}", loggerObjects);
	}
}
