package Com.Comcast.Crm.ContactTest;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRep.Contact.ContactPage;
import Comcast.Crm.ObjRep.Contact.CreateNewContactPage;
import Comcast.Crm.ObjRep.Contact.contactInfoPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateContactwithSupportDateTest extends BaseUtility {
	
	
	@Test
	public void CreateContactSupportDateTest() throws IOException, Throwable {
		String ContactlastName = exLib.getDataFromExcelFile("contact",1, 2) + javaLib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		ContactPage cp= new ContactPage(driver);
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		contactInfoPage cip= new contactInfoPage(driver);

		
		hp.getContactLink().click();
		Thread.sleep(2000);
		cp.getCreateNewContact().click();
		
		cncp.createContact(ContactlastName,javaLib);
		String actHeader=cip.getHeaderMsg().getText();
		
		if(actHeader.contains(ContactlastName)) {
			System.out.println(ContactlastName+" varification Pass ");
		}else {
			System.out.println(ContactlastName +" Varification fail");
		}
		
	}

}
