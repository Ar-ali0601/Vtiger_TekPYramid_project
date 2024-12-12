package Com.Comcast.Crm.OrgTest;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Organization.CreateNewOrgPage;
import Comcast.Crm.ObjRepo.Organization.OrgInfoPage;
import Comcast.Crm.ObjRepo.Organization.OrganizationPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateOrg_withPhoneNumbwerTest extends BaseUtility {

    @Test
	public  void  CreateOrgandPhoneNumberTest() throws Throwable {
		
		String orgName = exLib.getDataFromExcelFile("Sheet3", 7, 2) + javaLib.getRandomNumber();
		String phoneNumber = exLib.getDataFromExcelFile("Sheet3", 7, 3) ;
		

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrg().click();

		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrgwithPhone(orgName, phoneNumber);

		OrgInfoPage oip = new OrgInfoPage(driver);
		
		WebElement web = oip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		
		oip.viewHeaderMasg(orgName);

	}
}
