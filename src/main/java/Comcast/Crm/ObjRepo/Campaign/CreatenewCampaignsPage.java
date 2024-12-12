package Comcast.Crm.ObjRepo.Campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewCampaignsPage {
	
	
	WebDriver driver;
	public  CreatenewCampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}


	@FindBy(name = "campaignname")
	private WebElement  compaignNameEdt;
	
	@FindBy(xpath  = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement  saveBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCompaignNameEdt(String compaignName) {
		return compaignNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createCampaign(String compaignName) {
		compaignNameEdt.sendKeys(compaignName);
		saveBtn.click();
		}
		
	


	
	

}
