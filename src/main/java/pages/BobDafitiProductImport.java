package pages;

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
		
		String idElement="";

				
		switch (icon){
		case "Attribute Set":
			idElement = "ext-comp-1005";
			break;
				
		default:
			throw new NoSuchElementException("Icon ' "+icon+" ' not found");
		}
		this.driver.findElement(By.id(idElement)).click();
	}
	
	public void ClickOnButton (String button) throws Throwable{
		String classElement = "";
		
		switch (button){
		case "Browse":
			classElement = "x-form-file";
			break;
		case "Upload file":
		case "OK":
			classElement = "x-btn-mc";
			break;
				
		default:
			throw new NoSuchElementException("Button ' "+button+" ' not found");
			
		}
		this.driver.findElement(By.className(classElement)).click();
	
	}
	
	public void SelectFile (String file, String path) throws Throwable{
		
		((JavascriptExecutor) driver).executeScript("document.getElementsById('ext-comp-1006'.removeAttribute('readonly');");
	    this.driver.findElement(By.id("ext-comp-1006")).sendKeys(path + file);
	    
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
