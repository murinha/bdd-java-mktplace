package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BobDafitiProductImport {
	
	private WebDriver driver;
	private WebElement myDynamicElement;
	private WebElement we;

	
	public BobDafitiProductImport (WebDriver _driver){
		this.driver = _driver;
	}
	

	
	
	
	public void ClickOnIcon(String icon) throws Throwable{
		Actions action = new Actions (driver);
		we = null;
			
		switch (icon){
		case "Attribute Set":
			this.driver.findElement(By.id("ext-comp-1005")).click();
			break;
		
		case "Refresh":
			this.driver.navigate().refresh();
			myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.id("ext-comp-1005")));
			//action.moveToElement(this.driver.findElement(By.xpath("//*[@id='ext-gen38']"))).click().build().perform();
			//we = this.driver.findElement(By.className("refresh"));
			break;
		
		case "Preview":
			action.moveToElement(this.driver.findElement(By.xpath("//*[@class='status-processed'][last()]/a[1]"))).click().build().perform();
			myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.id("submitimport")));
			break;
			
		case "Download":
			action.moveToElement(this.driver.findElement(By.xpath("//*[@class='status-imported'][last()]/a[2]"))).click().build().perform();
			myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.id("catalog_import_result")));
			break;
			
		default:
			throw new NoSuchElementException("Icon ' "+icon+" ' not found");
		}
		//we.click();
	}
	
	public void ClickOnButton (String button) throws Throwable{
		we = null;
		
		switch (button){
		case "Browse":
			we =  this.driver.findElement(By.xpath("//*[contains(text(), 'Browse')]"));
			break;
		case "Upload file":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Upload file')]"));
			break;
		case "OK":
			myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.className("x-btn-mc")));
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'OK')]"));
			break;
			
		case "Update products":
			we = this.driver.findElement(By.id("submitimport"));
			break;
				
		default:
			throw new NoSuchElementException("Button ' "+button+" ' not found");
			
		}
		we.click();
	
	}
	
	public void SelectFile (String file, String path) throws Throwable{
		
		//((JavascriptExecutor) driver).executeScript("document.getElementsById('ext-comp-1006'.removeAttribute('readonly');");
	    this.driver.findElement(By.id("ext-comp-1006-file")).sendKeys(path+file);
	}
	    
	    
	
	
	public void SelectOption (String option) throws NoSuchElementException{
		Actions action = new Actions (driver);
		we = null;

		myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-comp-1005']"))); 
				
		
		switch (option){
		case "Shoes":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Shoes')][1]"));			
			break;
		
		case "Accessories":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Accessories')][1]"));
			break;
			
		case "Apparel":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Apparel')][1]"));
			break;
			
		case "Home & Decor":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Home & Decor')]"));
			break;
			
		case "Beauty":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Beauty')]"));
			break;
			
		case "Babies":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Babies')]"));
			break;
			
		case "Sports Accessories":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Sports Accessories')]"));
			break;
		
		case "Sports Apparel":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Sports Apparel')]"));
			break;
			
		case "Sports Equipment":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Sports Equipment')]"));
			break;	
			
		case "Sports Shoes":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Sports Shoes')]"));
			break;	
		
		case "Vale Presente":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Vale Presente']"));
			break;	
			
		case "Gifts":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Gifts')]"));
			break;
		
		case "Free Sample":
			we = this.driver.findElement(By.xpath("//*[contains(text(), 'Free Sample')]"));
			break;
		default:
			throw new NoSuchElementException("Option" +option+ "does not exist");
			
		}
		action.moveToElement(we).click().build().perform();
		
	}
}
