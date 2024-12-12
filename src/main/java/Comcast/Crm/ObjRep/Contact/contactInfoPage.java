package Comcast.Crm.ObjRep.Contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public  contactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public void viewHeaderMasg(String lastName) {
		String actHeader=getHeaderMsg().getText().trim();
		if(actHeader.contains(lastName)) {
			System.out.println(lastName+" varifiction === PAss");
		}else {
			System.out.println(lastName+" varification ==== fail");
		}
	}
	
	
	

}
