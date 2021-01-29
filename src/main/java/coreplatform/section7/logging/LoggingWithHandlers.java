package coreplatform.section7.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingWithHandlers {

	private static Logger logger = Logger.getLogger(LoggingWithHandlers.class.getPackage().getName());
	
	public static void main(String[] args) throws SecurityException, IOException {
		FileHandler fileHandler = new FileHandler("%h/myapp_%g.log",1000,4);
		
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		
		logger.log(Level.INFO, "This is a test message for logging");
	}
}
