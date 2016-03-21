package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BobLogin {
	private WebDriver driver;
		
	public BobLogin(WebDriver _driver){
		this.driver = _driver;
		
	}
	
	public void FillField (String fieldName, String value){
		this.driver.findElement(By.id(fieldName)).sendKeys(value);
	}
	
	public void ClickOnButton (String button){
		this.driver.findElement(By.id(button)).click();
	}
}
