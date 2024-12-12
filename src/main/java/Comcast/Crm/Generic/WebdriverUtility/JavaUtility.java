package Comcast.Crm.Generic.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class JavaUtility {
	
	public int getRandomNumber() {
		Random r= new Random();
	int randomnum=	r.nextInt(1000);
	return randomnum;
		
	}
	// system d  date YYYY MM DD
	public String getSystemDate() {
		  Date dateObj = new  Date();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-DD");
	     String date=sdf.format(dateObj);
		return date;
	}
	
	//required date YYYY MM DD
	public String getRequiredDate(int days) {
		
		  
		SimpleDateFormat sim= new SimpleDateFormat("YYYY-MM-DD");
	      Calendar cal = sim.getCalendar();
	      cal.add(Calendar.DAY_OF_MONTH,days);
	     String endDate= sim.format(cal.getTime());
	     return endDate;
	}
}
