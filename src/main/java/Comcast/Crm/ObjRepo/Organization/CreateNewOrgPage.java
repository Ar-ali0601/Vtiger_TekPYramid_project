package Comcast.Crm.ObjRepo.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgPage {
	
	WebDriver driver;
	public  CreateNewOrgPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	
	@FindBy(name = "accountname")
	private WebElement  orgNameEdt;

	@FindBy(name="industry")
	private WebElement industryEdt;
	
	@FindBy(id = "phone")
    private WebElement phoneEdt;
	
	@FindBy(name = "accounttype")
    private WebElement typeEdt;
	
	@FindBy(xpath  = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement  saveBtn;
	

	
	public WebElement getIndustryEdt() {
		return industryEdt;
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;	
	}
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}
	public WebElement getTypeEdt() {
		return typeEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	
	public void createOrg(String orgName) {
		orgNameEdt.clear();
	   orgNameEdt.sendKeys(orgName);
	  saveBtn.click();
	}
	public void createOrg(String orgName ,String industryOrg, String type  ) {
		orgNameEdt.sendKeys(orgName);
		Select sel= new Select(industryEdt);
		sel.selectByVisibleText(industryOrg);
		Select sel2= new Select(typeEdt);
		sel2.selectByVisibleText(type);
		saveBtn.click();
	}

	public void createOrgwithPhone(String orgName ,String phoneNumber ) {
		orgNameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(phoneNumber);
		saveBtn.click();

	}
	
	
	

	
}
