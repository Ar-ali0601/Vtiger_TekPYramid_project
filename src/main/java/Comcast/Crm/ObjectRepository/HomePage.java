package Comcast.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;

public class HomePage {
	
	WebDriverUtility wdu= new WebDriverUtility();
	
	WebDriver driver;
	public HomePage(WebDriver hdriver) {
		this.driver=hdriver;
		PageFactory.initElements(hdriver,this);
	}
	
	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(xpath = "//a[text()='Products']")
	 private WebElement productLink ;
	
	@FindBy(xpath="//a[@href=\"index.php?module=Potentials&action=index\"]")
	 private WebElement opportunitieLink;
	
	@FindBy(xpath="//a[text()='Calendar']")
    private WebElement calendarLink;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLink;

	@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")
	 private WebElement contactLink;

	@FindBy(xpath="//a[@href=\"index.php?module=Leads&action=index\"]")
	 private WebElement leadLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")
	 private WebElement more;
	
	@FindBy(name="Campaigns")
	 private WebElement CompaignsLink;
	
	@FindBy(xpath="//a[text()='Documents']")
    private WebElement documentsLink;
	
	@FindBy(xpath="//a[@href=\"index.php?module=HelpDesk&action=index\"]")
	private WebElement troubleTicketLink ;
	
	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getTroubleTicketLink() {
		return troubleTicketLink;
	}

		//Administrator
		@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	   private  WebElement  adminImg;
		
		public WebDriverUtility getWdu() {
			return wdu;
		}

		@FindBy(xpath = "//a[text()='Sign Out']")
		private WebElement logOut ;
		
		@FindBy(id="_my_preferences_")
		private WebElement myPreference;
		
		@FindBy(name = "Vendors")
		private WebElement vendorsLink;

		@FindBy(name = "Invoice")
		private WebElement invoiceLink;
		
		@FindBy(name = "Project Milestones")
		private WebElement  ProjectMilestonesLink;
		
		@FindBy(name = "Sales Order")
		private WebElement SalesOrderLink;
		
		
	public WebElement getOpportunitieLink() {
		return opportunitieLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getMyPreference() {
		return myPreference;
	}

	//More
	@FindBy(xpath="//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")
	private WebElement element;
	
	public WebElement getelement() {
		return element;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getCompaignsLink() {
		return CompaignsLink;
	}

		
	public void moreModule(WebDriver driver) {
		wdu.moveToEelment(driver,getMore());
	}
	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getProjectMilestonesLink() {
		return ProjectMilestonesLink;
	}

	public WebElement getSalesOrderLink() {
		return SalesOrderLink;
	}

	public WebElement getElement() {
		return element;
	}

	public  void logOut() {
		wdu.moveToEelment(driver, adminImg);
		logOut.click();
	}
	
}
