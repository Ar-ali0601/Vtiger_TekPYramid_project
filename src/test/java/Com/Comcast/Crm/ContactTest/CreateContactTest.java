package Com.Comcast.Crm.ContactTest;


import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRep.Contact.ContactPage;
import Comcast.Crm.ObjRep.Contact.CreateNewContactPage;
import Comcast.Crm.ObjRep.Contact.contactInfoPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateContactTest extends BaseUtility {

	@Test
	public void createContactTest() throws Throwable {
		
		String lastName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		contactInfoPage cip = new contactInfoPage(driver);


		hp.getContactLink().click();
		
		cp.getCreateNewContact().click();

		cnp.createContactOnly(lastName);
		
		
//		WebElement web = cip.getHeaderMsg();
//		driverLib.waitForElementPresent(web);
		String actHeaderMsg = cip.getHeaderMsg().getText();

		if (actHeaderMsg.contains(lastName)) {
			System.out.println(lastName + " name is verified==PASS");
		} else {
			System.out.println(lastName + " name is not verified==Fail");
		}
	}
	

}
