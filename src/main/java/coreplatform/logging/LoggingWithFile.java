package coreplatform.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingWithFile {

	private static Logger logger = Logger.getLogger("coreplatform.section7.logging");
	
	public static void main(String[] args) {
		logger.log(Level.INFO, "We're logging");
	}
}
