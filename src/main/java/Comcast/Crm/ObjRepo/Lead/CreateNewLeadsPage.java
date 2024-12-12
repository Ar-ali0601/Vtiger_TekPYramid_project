package Comcast.Crm.ObjRepo.Lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPage {

	

	WebDriver driver;
	public  CreateNewLeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	@FindBy(name = "company")
	private WebElement  companyNameEdt;
	
	
	@FindBy(xpath  = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement  saveBtn;

	
	public WebElement getcompanyNameEdt() {
		return companyNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createLead(String companyName,String lastName) {
		companyNameEdt.sendKeys(companyName);
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

}
