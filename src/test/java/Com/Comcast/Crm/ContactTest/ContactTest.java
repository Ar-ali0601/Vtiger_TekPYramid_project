package Com.Comcast.Crm.ContactTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRep.Contact.ContactPage;
import Comcast.Crm.ObjRep.Contact.CreateNewContactPage;
import Comcast.Crm.ObjRep.Contact.contactInfoPage;
import Comcast.Crm.ObjRepo.Organization.CreateNewOrgPage;
import Comcast.Crm.ObjRepo.Organization.OrgInfoPage;
import Comcast.Crm.ObjRepo.Organization.OrganizationPage;
import Comcast.Crm.ObjRepo.Organization.orgLookupPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class ContactTest  extends BaseUtility{
	
	@Test
	public void createContactTest() throws Throwable {
		
		String lastName = exLib.getDataFromExcelFile("Sheet3", 4, 2) + javaLib.getRandomNumber();
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
 
	@Test
	public  void CreateContactwithOrgTest() throws Throwable {
		
		// Read common data from property
		String orgName = exLib.getDataFromExcelFile("Sheet3",1, 2) + javaLib.getRandomNumber();
		String ContactlastName = exLib.getDataFromExcelFile("contact",1, 2) + javaLib.getRandomNumber();
		// all POM
		HomePage hp = new HomePage(driver);
		OrgInfoPage oip = new OrgInfoPage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		orgLookupPage olp=new orgLookupPage(driver);
		contactInfoPage cip = new contactInfoPage(driver);

		// login app
		
		hp.getOrganizationLink().click();
		op.getCreateNewOrg().click();
		cnop.createOrg(orgName);
       
		WebElement web = oip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		oip.viewHeaderMasg(orgName);
		
		// navigation
              hp.getContactLink().click();			
		
		cp.getCreateNewContact().click();
         cncp.getContactNameEdt().sendKeys(ContactlastName);
	     
       cncp.createContactOrg(driver, ContactlastName, wdu, orgName);
      		
		
        cncp.getSaveBtn().click();
	        cip.viewHeaderMasg(ContactlastName);
		 


	String actHeaderMsg =driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if (actHeaderMsg.contains(orgName)) {
			System.out.println(orgName + " name is verified==PASS");
		} else {
			System.out.println(orgName + " name is not verified==Fail");
		}
	
	}
	// support Date
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
		cip.viewHeaderMasg(ContactlastName);
		
		
	}

}
