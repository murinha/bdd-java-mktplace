package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkManager {
	
	private WebDriver driver;
	
	public LinkManager(WebDriver _driver){
		this.driver = _driver;		
	}
	
	public void ClickOnLink(String linkName) throws InterruptedException{		
		this.driver.findElement(By.linkText(linkName)).click();		
	}

}
