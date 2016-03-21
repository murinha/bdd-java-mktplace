package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PageManager {
	
	private WebDriver driver;
	
	public PageManager(WebDriver _driver){
		this.driver = _driver;
	}
	
	public void NavegateTo(String baseUrl) throws Throwable {
		this.driver.get(baseUrl);
	}
	
	public void WaitPageToLoad(String pageName) {
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		
	}
	
	public void NavegateToTestABUrl(String testAbParameter){
		String urlAb = this.driver.getCurrentUrl()+testAbParameter;
		this.driver.navigate().to(urlAb);
	}

	public void NavegateToProductUrl(String productUrl) throws InterruptedException {		
		this.driver.navigate().to(productUrl);		
	}
}