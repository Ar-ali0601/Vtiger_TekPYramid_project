package Com.Comcast.Crm.TroubleTickeTest;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Trouble_Ticket.createNewtroubleTicketPage;
import Comcast.Crm.ObjRepo.Trouble_Ticket.troubleTicketInfoPage;
import Comcast.Crm.ObjRepo.Trouble_Ticket.troubleTicketPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateTroubleTicketwithCONTACTTest extends BaseUtility {

	@Test
	public void CreateTroubleTicketCONTACTTest() throws Throwable {
		String titleName = exLib.getDataFromExcelFile("contact", 1, 2) + javaLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getTroubleTicketLink().click();

		troubleTicketPage ttp = new troubleTicketPage(driver);
		ttp.getCreatetroubleTicket().click();

		createNewtroubleTicketPage cnttp = new createNewtroubleTicketPage(driver);
		cnttp.getTicketTitleEdt().sendKeys(titleName);
		cnttp.getRadioBtnGroup().click();
		cnttp.addcontactDetail(driver, titleName);
       Thread.sleep(2000);
       
       
		troubleTicketInfoPage ttip = new troubleTicketInfoPage(driver);
		

		WebElement web = ttip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		ttip.viewHeaderMasg(titleName);

		
	}
}
