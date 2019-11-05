package util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	//"classpath: ${env}.properties"
	"file: /POM_HybridFramework_Java/src/main/resources/application.properties"
})
public interface MyProperties extends Config{

	String url();
	
	String username();
	
	String password();
	
}
