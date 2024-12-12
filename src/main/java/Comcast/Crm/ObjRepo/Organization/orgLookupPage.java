package Comcast.Crm.ObjRepo.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgLookupPage {
	
	public  orgLookupPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(name = "search_text")
	private WebElement searchText;

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public void  orgLookUpp(String orgName) {
		searchText.sendKeys(orgName);
        searchBtn.click();
		
		
	}
	
	
}
