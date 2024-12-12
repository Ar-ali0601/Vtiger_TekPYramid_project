package Comcast.Crm.ObjRepo.Lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadsInfoPage {
	
	
    WebDriver driver;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public leadsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
		
	}
	public void viewHeaderMsg(String CompanyName) {
		String actHeaderMsg=getHeaderMsg().getText().trim();
		if (actHeaderMsg.contains(CompanyName)) {
			System.out.println(CompanyName + " name is verified==PASS");
		} else {
			System.out.println(CompanyName + " name is not verified==Fail");
		}


	}
}
