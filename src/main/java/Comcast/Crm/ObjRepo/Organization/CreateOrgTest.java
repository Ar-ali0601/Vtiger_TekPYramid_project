package Comcast.Crm.ObjRepo.Organization;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRep.Contact.ContactPage;
import Comcast.Crm.ObjRep.Contact.CreateNewContactPage;
import Comcast.Crm.ObjRep.Contact.contactInfoPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class CreateOrgTest extends BaseUtility {

	String OrgName;
	String lastName;

	@Test
	public void crteOrgTest() throws Throwable {
		System.out.println("NAvigatin ORG");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		

		System.out.println("Create ORG");
		OrganizationPage cp = new OrganizationPage(driver);
		cp.getCreateNewOrg().click();

		OrgName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

		System.out.println("N ORG Info");
		CreateNewOrgPage nop = new CreateNewOrgPage(driver);
		nop.createOrg(OrgName);
		System.out.println("Varification ORG");

		OrgInfoPage oip = new OrgInfoPage(driver);
		WebElement web = oip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		oip.viewHeaderMasg(OrgName);
		
	}
	

	@Test
	public void orgWithContact() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrgName = exLib.getDataFromExcelFile("organization", 1, 2) + javaLib.getRandomNumber();
		lastName = exLib.getDataFromExcelFile("contact", 1, 2) + javaLib.getRandomNumber();

		// create org
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrg().click();

		CreateNewOrgPage onp = new CreateNewOrgPage(driver);
		onp.createOrg(OrgName);

		OrgInfoPage oip = new OrgInfoPage(driver);

		WebElement web = oip.getHeaderMsg();
		wdu.waitForElementPresent(web, driver);
		String actHeaderMsg = oip.getHeaderMsg().getText();

		if (actHeaderMsg.contains(OrgName)) {
			System.out.println(OrgName + " name is verified==PASS");
		} else {
			System.out.println(OrgName + " name is not verified==Fail");
		}

		Thread.sleep(2000);

		wdu.refreshPage(driver);
		hp.getContactLink().click();
		// create contact
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createContactOnly(lastName);
		contactInfoPage cip = new contactInfoPage(driver);

		WebElement web1 = cip.getHeaderMsg();
		wdu.waitForElementPresent(web1, driver);
		cip.viewHeaderMasg(lastName);
	}

}
