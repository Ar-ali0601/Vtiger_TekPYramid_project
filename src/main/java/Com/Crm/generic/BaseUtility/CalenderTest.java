package Com.Crm.generic.BaseUtility;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Comcast.Crm.ObjRepo.Organization.CreateNewOrgPage;
import Comcast.Crm.ObjRepo.Organization.OrgInfoPage;
import Comcast.Crm.ObjRepo.Organization.OrganizationPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CalenderTest  extends BaseUtility {
	@Test
	public void ct() throws Throwable  {
	HomePage hp = new HomePage(driver);
	hp.getCalendarLink().click();

	System.out.println("Create ORG");
	OrganizationPage cp = new OrganizationPage(driver);
	cp.getCreateNewOrg().click();

	String MeetName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

	System.out.println("N ORG Info");
	CreateNewOrgPage nop = new CreateNewOrgPage(driver);
	nop.createOrg(MeetName);
	System.out.println("Varification ORG");

	OrgInfoPage oip = new OrgInfoPage(driver);
	WebElement web = oip.getHeaderMsg();
	wdu.waitForElementPresent(web, driver);
	String actHeaderMsg = oip.getHeaderMsg().getText();

	if (actHeaderMsg.contains(MeetName)) {
		System.out.println(MeetName + " name is verified==PASS");
	} else {
		System.out.println(MeetName + " name is not verified==Fail");
	}

	}
}
