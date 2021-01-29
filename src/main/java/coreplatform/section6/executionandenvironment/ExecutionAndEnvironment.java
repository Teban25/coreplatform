package coreplatform.section6.executionandenvironment;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ExecutionAndEnvironment {

	/**
	 * Java ****.class "Hello" "there" "world"
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("<------------------App Execution and environment------------------------>");
		if (args.length < 1) {
			System.out.println("No arguments privded");
		} else {
			for (String word : args) {
				System.out.println(word);
			}
		}
		
		// Using getEnv or getProperty into the System
		String rootSys = System.getenv("SystemRoot");
		String userName = System.getProperty("user.name");
		
		System.out.println(rootSys);
		System.out.println(userName);
		
		Properties props = loadPropertiesFromRoot();
		System.out.println(props.getProperty("name"));
		
		Properties propsFromResource = loadPropertiesFromClassResource();
		System.out.println(propsFromResource.getProperty("lastname"));
	}
	
	private static Properties loadPropertiesFromRoot() throws IOException {
		Properties props = new Properties();
		Path propFile = Paths.get("example.properties");
		
		try(Reader reader = Files.newBufferedReader(propFile)) {
			props.load(reader);
		}
		
		return props;
	}
	
	private static Properties loadPropertiesFromClassResource() throws IOException {
		Properties props = new Properties();
		
		try(InputStream inputStream = ExecutionAndEnvironment.class.getResourceAsStream("resources.properties")) {
			props.load(inputStream);
		}
		
		return props;
	}
}
