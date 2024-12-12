package Com.Comcast.Crm.CampaignsTest;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Opportunities.OpportunitiePage;
import Comcast.Crm.ObjRepo.Opportunities.opporInfoPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateOpportunitieTest  extends BaseUtility{
	
	@Test
		public void CreateOpportTest() throws Throwable {	
		WebDriver driver = null;
		
	   String OppName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

	    HomePage hp = new HomePage(driver);
	    hp.getOpportunitieLink();
	    
	    OpportunitiePage opp= new OpportunitiePage(driver);
	    opp.getCreateOpportunitie().click();
	    
	    opp.getOpportunitieName().sendKeys(OppName);
	    opp.related();
	    opp.type();
	    opporInfoPage oppip= new opporInfoPage(driver);
	    oppip.getHeaderMsg();
	    oppip.viewHeaderMasg(OppName);
	}

}
