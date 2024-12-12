package Com.Crm.Vtiger.InvoiceTest;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class A  {
	
	@Test
	public void json() throws Throwable, ParseException {
		FileReader reader= new FileReader("");
		JSONParser parser= new JSONParser();
		  Object obj=parser.parse(reader);
		 JSONObject map=(JSONObject)obj;
		 System.out.println(map.get("url"));

		
	}

}
