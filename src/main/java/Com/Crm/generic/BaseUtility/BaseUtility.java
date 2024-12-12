package Com.Crm.generic.BaseUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Comcast.Crm.Generic.FileUtility.ExcelUtility;
import Comcast.Crm.Generic.FileUtility.FileUtility;
import Comcast.Crm.Generic.WebdriverUtility.JavaUtility;
import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;
import Comcast.Crm.GenericDatabaseUtility.DataBaseUtility;
import Comcast.Crm.ObjectRepository.HomePage;
import Comcast.Crm.ObjectRepository.LoginPage;

public class BaseUtility {
	
	public	DataBaseUtility db= new DataBaseUtility();
	public  ExcelUtility exLib= new ExcelUtility();
	public  FileUtility proLib= new FileUtility();
	public  JavaUtility javaLib= new JavaUtility();
    public 	WebDriverUtility wdu = new WebDriverUtility();
    public WebDriver driver = null;
    public static  WebDriver sdriver; // ListenerImpClass  changes


	@BeforeSuite
	public void DataBaseConnection() throws Throwable {
		System.out.println("Connect_Data_Base ");
		db.getDbConnection();

		
	}
  //@Parameters ("BROWSER")
	@BeforeClass
	public void LauanchBrowser() throws Throwable {
		System.out.println("Launch Browser");
		String Browser=proLib.getDataFromPropertiesFile("Browser");
	
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		//sdriver=driver;   // ListenerImpClass 
	}

	@BeforeMethod
	   public void Login() throws Throwable {
		System.out.println("Login Page");
		wdu.maximizedwebPage(driver);
		String URL=proLib.getDataFromPropertiesFile("Url");
		String USERNAME=proLib.getDataFromPropertiesFile("UserName");
		String PASSWORD=proLib.getDataFromPropertiesFile("Password");
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	}

	@AfterMethod
	public void LogOutPage() {
		System.out.println("LogOut_Page");
   HomePage hp= new HomePage(driver);
   hp.logOut();
		
	}
   @AfterClass
	public void CloseBrowser() {
		System.out.println("Close_Browser");
		driver.quit();
	}
	@AfterSuite
	public void CloseDataBaseConnection() {
		System.out.println("Close Data BAse");
      db.CloseDbConnection();
	}


}
