package Com.Comcast.Crm.CampaignsTest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Campaign.CampaignInfoPage;
import Comcast.Crm.ObjRepo.Campaign.CampaignsPage;
import Comcast.Crm.ObjRepo.Campaign.CreatenewCampaignsPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CampaignTest extends BaseUtility {
	
	
	@Test
	public void createCampaignTest() throws Throwable {
		String CampaignName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		wdu.moveToEelment(driver, hp.getMore());
		
	
		WebElement ele=hp.getelement();
		wdu.moveToEelment(driver, ele);
		hp.getCompaignsLink().click();
		Assert.fail();
		CampaignsPage camp = new CampaignsPage(driver);
		camp.getCreateCampaignEdt().click();
		
		CreatenewCampaignsPage cnp = new CreatenewCampaignsPage(driver);
		cnp.createCampaign(CampaignName);
		
		CampaignInfoPage camip = new CampaignInfoPage(driver);
		camip.viewHeaderMsg(CampaignName);

	}

}
