package Comcast.Crm.ObjRepo.Trouble_Ticket;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Crm.generic.BaseUtility.BaseUtility;

public class createNewtroubleTicketPage extends BaseUtility {

	public createNewtroubleTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "ticket_title")
	private WebElement ticketTitleEdt;

	// assign To
	@FindBy(xpath = "//input[@value='T']")
	private WebElement radioBtnGroup;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement radioBtnUser;

	public WebElement getTicketTitleEdt() {
		return ticketTitleEdt;
	}

	public WebElement getRadioBtnGroup() {
		return radioBtnGroup;
	}

	public WebElement getRadioBtnUser() {
		return radioBtnUser;
	}

	public WebElement getContactorOrgTypedrop() {
		return contactorOrgTypedrop;
	}

	public WebElement getContactOrOrg() {
		return contactOrOrg;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getStatusdrop() {
		return statusdrop;
	}

	@FindBy(name = "parent_type")
	private WebElement contactorOrgTypedrop;

	@FindBy(xpath = "//input[@name=\"parent_name\"]/following-sibling::img[@alt=\"Select\"]")
	private WebElement contactOrOrg;

	@FindBy(xpath = "//input[@name=\"product_name\"]/following-sibling::img[@alt=\"Select\"]")
	private WebElement productName;

	@FindBy(name = "ticketstatus")
	private WebElement statusdrop;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	@FindBy(id = "search_txt")
	private WebElement searchtext;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(name = "search")
	private WebElement searchBtn;

	public void addcontactDetail(WebDriver driver, String orgName) {
		contactorOrgTypedrop.click();

		searchtext.sendKeys();
		searchBtn.click();
		String dxpath = "//a[text()='" + orgName.trim() + "']";
		driver.findElement(By.xpath(dxpath)).click();

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("HelpDesk&action")) {
				break;
			}

			saveBtn.click();

		}
	}
}
