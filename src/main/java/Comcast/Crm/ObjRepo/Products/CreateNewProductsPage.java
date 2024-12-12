package Comcast.Crm.ObjRepo.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductsPage {
	
	
	public  CreateNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath  = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement  saveBtn;
	

}
