package Comcast.Crm.Generic.WebdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void maximizedwebPage(WebDriver driver ) {
		driver.manage().window().maximize();
		
	}
	public void minimizedwebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	// ImplictlyWait
	
	public void waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//ExplictWait
	public void waitForElementPresent(WebElement visible ,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
		wait.until(ExpectedConditions.visibilityOf(visible));
		
	}
	public void waitForElementNotPresent(WebElement Notvisible ,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
		wait.until(ExpectedConditions.invisibilityOf(Notvisible));

	}
	public void waitForElementToClick(WebElement click ,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
		wait.until(ExpectedConditions.elementToBeClickable(click));
	}
	public void waitForElementT(WebElement click ,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
		wait.until(ExpectedConditions.elementToBeSelected(click));

	}
	public void waitForElementAllPresent(WebElement allvisible , WebDriver driver ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
		wait.until(ExpectedConditions.visibilityOfAllElements(allvisible));	
	}
	//Select 
	
	public void selectIndex(WebElement index  , int indexNum) {
		Select select = new Select(index); 
		select.selectByIndex(indexNum);
	}
	

	public void selectValue(WebElement value  , String text) {
		Select select = new Select(value); 
		select.selectByValue(text);
	}

	public void selectVisible(WebElement visible  , String visibleText ) {
		Select select = new Select(visible); 
		select.selectByVisibleText(visibleText);
	}

	public void selectAll(WebElement all  ) {
		Select select = new Select(all); 
		select.getAllSelectedOptions();
	}
	

	public void select1st(WebElement first  ) {
		Select select = new Select(first); 
		select.getFirstSelectedOption();
	}
	
	
	// Actions Class
	public void  rightClick(WebDriver driver) {
		 Actions  action= new Actions(driver);
		action.contextClick().perform();		
	}
	public void  doubleClick(WebDriver driver) {
		 Actions  action= new Actions(driver);
		action.doubleClick().perform();		
	}
	public void  clickAndHold(WebDriver driver) {
		 Actions  action= new Actions(driver);
		action.clickAndHold().perform();		
	}
	public void  dragAndDrop(WebElement src , WebElement dist ,WebDriver driver) {
		 Actions  action= new Actions(driver);
		action.dragAndDrop(src , dist).perform();		
	}
	public void  moveToEelment(WebDriver driver,WebElement element) {
		 Actions  action= new Actions(driver);
		action.moveToElement(element).perform();		
	}
     
	
	// JavascriptExecutor
	
	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	public void scrollByIntoview(WebElement element ,WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	public void scrollToBodyEnd(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void refreshPage(WebDriver driver){	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
// TakeScreenshot
	public String getScreenShot(WebDriver driver ,String testName) throws IOException {
		Date d = new Date();
	    String	date=d.toString().replace(":","_").replace(" ", "_");
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		File dest= new File("./Screenshot/"+ testName+"_"+date+".png");
		FileUtils.copyFile(src, dest);
		return filepath;
	}
	
	//Fram
	 
	public void handleFrame(int index,WebDriver driver) {
		driver.switchTo().frame(index);
	}
	public void handleFram(String nameId ,WebDriver driver  ) {
		driver.switchTo().frame(nameId);// 
	}
	public void handleFrame(WebElement framElement ,WebDriver driver ) {
		driver.switchTo().frame(framElement);
	}
	public void swithcPrentFram(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void switchRootFram(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	// GetWindow Method  
	
	public  void SwitchtoChildWindow(WebDriver driver ,String childWindow) {
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
		String actUrl	=driver.switchTo().window(id).getCurrentUrl();
		if(actUrl.contains(childWindow)) {
			break;
		}
		}
		}
		
		public  void SwitchtoParentWindow(String parentWindow ,WebDriver driver) {
			Set<String> allIds = driver.getWindowHandles();
			for(String id:allIds) {
			String actUrl	=driver.switchTo().window(id).getCurrentUrl();
			if(actUrl.contains(parentWindow)) {	
			}
			}
		
	}
	
	
}
