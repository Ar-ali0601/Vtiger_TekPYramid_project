package Comcast.Crm.ObjRep.Contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Crm.generic.BaseUtility.BaseUtility;

public class ContactPage extends BaseUtility {
	

	public  ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath  ="//img[@alt=\"Create Contact...\"]")
	private WebElement createNewContact;
	
//	@FindBy(xpath =  "//img[contains(@onclick , 'return window.open')]")
//	private WebElement contactwithOrg;

	public WebElement getCreateNewContact() {
		return createNewContact;
	}


}
