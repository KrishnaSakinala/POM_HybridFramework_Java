package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
	
	//private static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.Logger.getRootLogger();
	private static Logger LOGGER = LogManager.getLogger("nopCommerce");
	
	public void info(String message)
	{
		LOGGER.info(message);
	}

}
