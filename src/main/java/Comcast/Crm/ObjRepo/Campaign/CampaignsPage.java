package Comcast.Crm.ObjRepo.Campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	
	public  CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement  createCampaignEdt ;

	public WebElement getCreateCampaignEdt() {
		return createCampaignEdt;
	
	
	}
}
