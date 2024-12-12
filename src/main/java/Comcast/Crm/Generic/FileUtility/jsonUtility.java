package Comcast.Crm.Generic.FileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtility {


		public String getDataFromJsonFile(String key) throws Throwable, ParseException {
			FileReader fileR=new FileReader("./src/test/resources/jsonFileReader.json");
			JSONParser parser= new JSONParser();
			Object	obj=parser.parse(fileR);
			JSONObject  map=(JSONObject)obj;
			 String data=(String) map.get(key);
			 return data;
	}

}
