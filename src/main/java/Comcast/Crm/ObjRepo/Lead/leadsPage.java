package Comcast.Crm.ObjRepo.Lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadsPage {
	
	
	WebDriver driver;
	public  leadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateLeadsEdt() {
		return createLeadsEdt;
	}

	@FindBy(xpath = "//img[@alt=\"Create Lead...\"]")
	private WebElement  createLeadsEdt ;
	

	
	
	}



