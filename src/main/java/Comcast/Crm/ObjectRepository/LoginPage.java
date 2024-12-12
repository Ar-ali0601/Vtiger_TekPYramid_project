package Comcast.Crm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comcast.Crm.Generic.WebdriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement UserName;
	
	@FindBy(name="user_password")
	private WebElement Password;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	// provide Action
    public void loginToApp(String userName , String password) {
	 UserName.sendKeys(userName);
	 Password.sendKeys(password);
	 LoginButton.click();
	
}
	

}
