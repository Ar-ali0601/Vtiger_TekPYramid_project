package Comcast.Crm.ObjRepo.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class ProductsInfoPage {
	
	
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerMsg;
	
	public  ProductsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public void viewHeaderMasg(String productName) {
		String actHeader=getHeaderMsg().getText().trim();
		boolean status=actHeader.contains(productName);
		Assert.assertEquals(status, true);
//		if(actHeader.contains(productName)) {
//			System.out.println(productName+" varifiction === PASS");
//		}else {
//			System.out.println(productName+" varification ==== FAIL");
//		}
	}


}
