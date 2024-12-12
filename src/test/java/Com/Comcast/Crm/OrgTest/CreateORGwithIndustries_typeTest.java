package Com.Comcast.Crm.OrgTest;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Organization.CreateNewOrgPage;
import Comcast.Crm.ObjRepo.Organization.OrgInfoPage;
import Comcast.Crm.ObjRepo.Organization.OrganizationPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateORGwithIndustries_typeTest extends BaseUtility {
	
	String OrgName;

	@Test
	public  void CreateORGIndustriesAndTypeTest() throws  Throwable {
		
		
		String orgName = exLib.getDataFromExcelFile("Sheet3", 4, 2) + javaLib.getRandomNumber();
		String Industry = exLib.getDataFromExcelFile("Sheet3", 4, 3) ;
		String Type = exLib.getDataFromExcelFile("Sheet3", 4, 4) ;


		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrg().click();

		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		//cnop.createOrgwithPhone(orgName, phoneNumber);
          cnop.createOrg(orgName, Industry, Type); 
		OrgInfoPage oip = new OrgInfoPage(driver);
		
		WebElement web = oip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		oip.viewHeaderMasg(orgName);

	}

}
