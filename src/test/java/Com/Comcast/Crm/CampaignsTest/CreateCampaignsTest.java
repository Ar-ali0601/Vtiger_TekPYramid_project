package Com.Comcast.Crm.CampaignsTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Campaign.CampaignInfoPage;
import Comcast.Crm.ObjRepo.Campaign.CampaignsPage;
import Comcast.Crm.ObjRepo.Campaign.CreatenewCampaignsPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateCampaignsTest extends BaseUtility {

	@Test
	public void CreateCampaignTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		CampaignsPage camp = new CampaignsPage(driver);
		CreatenewCampaignsPage cnp = new CreatenewCampaignsPage(driver);
		CampaignInfoPage camip = new CampaignInfoPage(driver);

		String CampaignName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

		wdu.moveToEelment(driver, hp.getMore());
		WebElement ele = hp.getelement();
		wdu.moveToEelment(driver, ele);
		hp.getCompaignsLink().click();

		camp.getCreateCampaignEdt().click();

		cnp.createCampaign(CampaignName);

		WebElement web = camip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		camip.viewHeaderMsg(CampaignName);

//		 //Reusable Methods
//		 ExcelUtility exLib= new ExcelUtility();
//		 FileUtility proLib= new FileUtility();
//		 JavaUtility javaLib= new JavaUtility();
//		 WebDriverUtility driverLib= new WebDriverUtility();
//		
//			
//			// Common Data
//		
//	    String Browser=  proLib.getDataFromPropertiesFile("Browser");
//		String Url= proLib.getDataFromPropertiesFile("Url");		
//		String UserName=  proLib.getDataFromPropertiesFile("UserName");
//		String Password=  proLib.getDataFromPropertiesFile("Password");
//		
//		String CampaignName=	exLib.getDataFromExcelFile("Sheet3",1,2);
//
//		// FileInputStream file = new FileInputStream("./src/test/resources/TestCaseVTiger.xlsx");
//			
//		    WebDriver driver=null;
//
////			Workbook wb=WorkbookFactory.create(file);
////			Sheet sheet=wb.getSheet("Sheet3");
////			Row row =sheet.getRow(1);
////			Cell cell=row.getCell(2);
////		    	cell.getStringCellValue();
//		  
//
//			if(Browser.equals("chrome")) {
//				driver= new ChromeDriver();
//			}else if(Browser.equals("firefox")) {
//					driver= new FirefoxDriver();
//				}else if(Browser.equals("edge")) {
//					driver= new EdgeDriver();
//				}else {
//					driver =new ChromeDriver();
//				}
//			
//			driver.get(Url);	
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
//			
//			driver.findElement(By.name("user_name")).sendKeys(UserName);
//			driver.findElement(By.name("user_password")).sendKeys(Password);
//	        Thread.sleep(2000);
//			driver.findElement(By.id("submitButton")).click();
//			
//			WebElement ele=driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]"));
//			driverLib.moveToEelment(ele);
////			Actions action=new Actions(driver);
////			action.moveToElement(ele).perform();
//			driver.findElement(By.name("Campaigns")).click();
//			driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
//			driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"T\"]")).click();
//			Thread.sleep(2000);
//			WebElement s =driver.findElement(By.name("assigned_group_id"));
//			driverLib.selectIndex(s, 2);
////			Select select = new Select(s);
////			select.selectByIndex(2);
//			WebElement s2=driver.findElement(By.name("campaigntype"));
//			Select select2 = new Select(s2);
//			select2.selectByIndex(4);
//			WebElement s3=driver.findElement(By.name("campaignstatus"));
//			Select select3 = new Select(s3);
//			select3.selectByIndex(2);
//			Thread.sleep(2000);
//		    driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
//		     String headerInfo= driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();

//            if(headerInfo.contains(CampaignName)) {
//		    	  System.out.println(CampaignName+" :- is create ==Pass");
//		      }else {
//		    	  System.out.println(CampaignName+" : - is create == Fail");
//		      }
//
//             verify header orgName info excepted result
//		      
//		      String actOrgName=  driver.findElement(By.id("dtlview_Campaign Name")).getText();
//		      if(actOrgName.equals(CampaignName)) {
//		    	  System.out.println(CampaignName+" :- is create ==Pass");
//		      }else {
//		    	  System.out.println(CampaignName+" : - is create == Fail");
//		      }

	}
}
