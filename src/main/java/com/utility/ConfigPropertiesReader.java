package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*This method is used to load the properties deom config.properties file
 *@return it returns the Properties prop object 
 */

public class ConfigPropertiesReader {

	private Properties prop;

	public Properties init_properties() {

		prop = new Properties();
		FileInputStream fis;
			try {
				fis = new FileInputStream("./src/test/resources/configuration/config.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		return prop;

	}

}
