package Comcast.Crm.ObjRep.Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comcast.Crm.Generic.WebdriverUtility.JavaUtility;
import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;

public class CreateNewContactPage {

	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement contactNameEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])")
	private WebElement saveBtn;

//	@FindBy(name="industry")
//	private WebElement industryEdt;
//	public WebElement getIndustryEdt() {
//		return industryEdt;
//	}

	public WebElement getContactNameEdt() {
		return contactNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name = "support_start_date")
	private WebElement startDate;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img[@alt=\"Select\"]")
	private WebElement selectOrgImg;

	public WebElement getSelectOrgImg() {
		return selectOrgImg;
	}

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	public void createContactOnly(String lastName) {
		contactNameEdt.sendKeys(lastName);
		saveBtn.click();

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

	public void createContact(String lastName ,JavaUtility javaLib ) {
	    contactNameEdt.sendKeys(lastName);
	    getStartDate().sendKeys(javaLib.getSystemDate());
	    getEndDate().sendKeys(javaLib.getRequiredDate(30));
	    saveBtn.click();
	}

	public void createContactOrg(WebDriver driver , String lastName, WebDriverUtility wdu ,String orgName) throws Throwable {
		getContactNameEdt().sendKeys(lastName);
		getSelectOrgImg().click();
		wdu.SwitchtoChildWindow(driver,"module=Accounts");
		getSearchText().sendKeys(orgName);
		getSearchBtn().click();
		String dxpath="//a[text()='"+orgName.trim()+"']";
		Thread.sleep(2000);
		driver.findElement(By.xpath(dxpath)).click();
		wdu.SwitchtoChildWindow(driver,"Contacts&action");
		
		
	}

}
