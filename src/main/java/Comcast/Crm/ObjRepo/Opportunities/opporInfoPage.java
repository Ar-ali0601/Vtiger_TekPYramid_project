package Comcast.Crm.ObjRepo.Opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class opporInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public  opporInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public void viewHeaderMasg(String opportunitName) {
		String actHeader=getHeaderMsg().getText().trim();
	    //actHeader.contains(opportunitName);	
		Assert.assertEquals(actHeader, opportunitName);
	}


}
