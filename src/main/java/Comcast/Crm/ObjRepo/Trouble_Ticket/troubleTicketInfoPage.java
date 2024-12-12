package Comcast.Crm.ObjRepo.Trouble_Ticket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class troubleTicketInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public  troubleTicketInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public void viewHeaderMasg(String titleName) {
		String actHeader=getHeaderMsg().getText().trim();
		if(actHeader.contains(titleName)) {
			System.out.println(titleName+" varifiction === PASS");
		}else {
			System.out.println(titleName+" varification ==== FAIL");
		}
	}


}
