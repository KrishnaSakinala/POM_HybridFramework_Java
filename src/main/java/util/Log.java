package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	//private static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.Logger.getRootLogger();
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static final void info(String message)
	{
		
		LOGGER.info(message);
	}

}
