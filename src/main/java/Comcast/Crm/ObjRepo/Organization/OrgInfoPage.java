package Comcast.Crm.ObjRepo.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class OrgInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public OrgInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public void viewHeaderMasg(String orgName) {
		//SoftAssert sa= new SoftAssert();
		String actHeader=getHeaderMsg().getText().trim();
		boolean status=actHeader.contains(orgName);
	  Assert.assertEquals(status, true);
	
	} 	

}
