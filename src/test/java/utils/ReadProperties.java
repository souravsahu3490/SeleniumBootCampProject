package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	File file;
	FileInputStream fis;
	Properties properties;

	public ReadProperties() {
		loadProperties();
	}

	public void loadProperties() {
		try {
			
			file = new File("resources//config.properties");
			fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readProperty(String key) {
		return properties.getProperty(key);
	}

}
