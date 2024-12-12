package Com.Comcast.Crm.LeadTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.Generic.FileUtility.ExcelUtility;
import Comcast.Crm.Generic.FileUtility.FileUtility;
import Comcast.Crm.Generic.WebdriverUtility.JavaUtility;
import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;
import Comcast.Crm.ObjRepo.Campaign.CampaignInfoPage;
import Comcast.Crm.ObjRepo.Campaign.CampaignsPage;
import Comcast.Crm.ObjRepo.Campaign.CreatenewCampaignsPage;
import Comcast.Crm.ObjRepo.Lead.CreateNewLeadsPage;
import Comcast.Crm.ObjRepo.Lead.leadsInfoPage;
import Comcast.Crm.ObjRepo.Lead.leadsPage;
import Comcast.Crm.ObjectRepository.HomePage;
import Comcast.Crm.ObjectRepository.LoginPage;

public class CreateLeadTest extends BaseUtility {

	@Test
	public void CreateLead_Test() throws IOException, Throwable {

		// Read common data from property
		String LastName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();
		String CompanyName = exLib.getDataFromExcelFile("Sheet3", 4, 1) + javaLib.getRandomNumber();

		// navigation

		HomePage hp = new HomePage(driver);
		hp.getLeadLink().click();

		leadsPage camp = new leadsPage(driver);
		camp.getCreateLeadsEdt().click();

		CreateNewLeadsPage lnp = new CreateNewLeadsPage(driver);
		lnp.createLead(CompanyName, LastName);

		leadsInfoPage lip = new leadsInfoPage(driver);
		WebElement web = lip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		lip.viewHeaderMsg(CompanyName);

	}

}
