package Comcast.Crm.ObjRepo.Trouble_Ticket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class troubleTicketPage {
	
	public troubleTicketPage (WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Ticket...\"]")
	private WebElement createtroubleTicket ;

	public WebElement getCreatetroubleTicket() {
		return createtroubleTicket;
	}

}
