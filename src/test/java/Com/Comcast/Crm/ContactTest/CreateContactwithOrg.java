package Com.Comcast.Crm.ContactTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.Generic.FileUtility.ExcelUtility;
import Comcast.Crm.Generic.FileUtility.FileUtility;
import Comcast.Crm.Generic.WebdriverUtility.JavaUtility;
import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;
import Comcast.Crm.ObjRep.Contact.ContactPage;
import Comcast.Crm.ObjRep.Contact.CreateNewContactPage;
import Comcast.Crm.ObjRep.Contact.contactInfoPage;
import Comcast.Crm.ObjRepo.Organization.CreateNewOrgPage;
import Comcast.Crm.ObjRepo.Organization.OrgInfoPage;
import Comcast.Crm.ObjRepo.Organization.OrganizationPage;
import Comcast.Crm.ObjRepo.Organization.orgLookupPage;
import Comcast.Crm.ObjectRepository.HomePage;
import Comcast.Crm.ObjectRepository.LoginPage;

public class CreateContactwithOrg extends BaseUtility {


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
		
		oip.viewHeaderMasg(orgName);
		
//		
	
	}
}
