package Comcast.Crm.ObjRepo.Campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampaignInfoPage {

	
WebDriver driver;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public CampaignInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public void viewHeaderMsg(String CampaignName) {
		String actHeaderMsg=getHeaderMsg().getText();
		 boolean status=actHeaderMsg.contains(CampaignName);
	      Assert.assertEquals( status,true);
	}
}
