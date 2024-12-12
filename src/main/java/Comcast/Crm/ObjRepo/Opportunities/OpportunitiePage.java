package Comcast.Crm.ObjRepo.Opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;


public class OpportunitiePage {
	WebDriverUtility wdu= new WebDriverUtility();


	public OpportunitiePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt=\"Create Opportunity...\"]")
	private WebElement createOpportunitie;
	
	public WebElement getCreateOpportunitie() {
		return createOpportunitie;
	}


	public WebElement getOpportunitieName() {
		return opportunitieName;
	}


	public WebElement getRelatedType() {
		return relatedType;
	}


	public WebElement getOpType() {
		return opType;
	}


	@FindBy(name="potentialname")
	private WebElement opportunitieName;
	
	@FindBy(id="related_to_type")
	private WebElement  relatedType;
	
	
	@FindBy(name="opportunity_type")
	private WebElement opType;
	
	 public void related() {
		 wdu.selectValue(relatedType, "Accounts");
	 }
	 public void type() {
		 wdu.selectValue(opType, "Existing Business");
	 }
}
