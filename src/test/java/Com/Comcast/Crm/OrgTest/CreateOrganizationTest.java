package Com.Comcast.Crm.OrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Comcast.Crm.Generic.FileUtility.ExcelUtility;
import Comcast.Crm.Generic.FileUtility.FileUtility;
import Comcast.Crm.Generic.WebdriverUtility.JavaUtility;

public class CreateOrganizationTest   {
	
	public static void main(String[] args) throws Throwable {
		// create Object 
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		//jsonUtility  jsoLib= new jsonUtility();
		JavaUtility  jLib=new JavaUtility();
		
		// read  common data from property file 
		
		  String Browser= fLib.getDataFromPropertiesFile("browser");
		  String Url=fLib.getDataFromPropertiesFile("Url");
		  String UserName=fLib.getDataFromPropertiesFile("UserName");
		  String Password=fLib.getDataFromPropertiesFile("Password");

		   
		// read common data from Json file
		   
//		   jsoLib.getDataFromJsonFile(null);
//		   jsoLib.getDataFromJsonFile(null);
//		   jsoLib.getDataFromJsonFile(null);
//		   jsoLib.getDataFromJsonFile(null);

		//generate the random number
		  int ran= jLib.getRandomNumber();
		   jLib.getSystemDate();
		   jLib.getRequiredDate(0);
		//read testScript data from excel file 
//		   eLib.getDataFromExcelFile(null, 0, 0);
//		   eLib.getRowCount(null, 0, 0);
//		   eLib.getCellCount(null, 0, 0);
//		   
		   

			WebDriver driver= null;

			if(Browser.equals("chrome")) {
				driver= new ChromeDriver();
			}else if(Browser.equals("firefox")) {
					driver= new FirefoxDriver();
				}else if(Browser.equals("edge")) {
					driver= new EdgeDriver();
				}else {
					driver =new ChromeDriver();
				}

		 	
			// read the data from excel file
	        FileInputStream file = new FileInputStream("./src/test/resources/TP_TestScript.xlsx");
			
			Workbook wb=WorkbookFactory.create(file);
			Sheet sheet=wb.getSheet("Sheet1");
			Row row =sheet.getRow(1);
			Cell cell=row.getCell(2);
		    String data=	cell.getStringCellValue()+ran;
		  
		//	step :1 login to app
			driver.get(Url);	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			
			driver.findElement(By.name("user_name")).sendKeys(UserName);
			driver.findElement(By.name("user_password")).sendKeys(Password);
	        Thread.sleep(2000);
			driver.findElement(By.id("submitButton")).click();
			
			// step 2 navigate the org module
			driver.findElement(By.linkText("Organizations")).click();
			
			//step 3 click on create  org button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
			
			// step 4: enter the detaile  and create new org
			
		      driver.findElement(By.name("accountname")).sendKeys(data);


		      driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		      
		      //step 5 : Logout 
		      
		      Actions action = new Actions(driver) ;
		      WebElement move=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		      action.moveToElement(move);
		     // driver.findElement(By.linkText("SignOut")).click();
		      
		      driver.quit();
		      
				


		   
		
		
		
	}

}
