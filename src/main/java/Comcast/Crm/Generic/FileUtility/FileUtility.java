package Comcast.Crm.Generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {

		FileInputStream file= new FileInputStream("./src/test/resources/CommonData01.properties");
		Properties property= new Properties();
		property.load(file);
		String value=property.getProperty(key);
		 return value;
	}
}
