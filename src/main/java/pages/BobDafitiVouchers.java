package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BobDafitiVouchers {
	
	private WebDriver driver;
	private Actions action;
	private WebElement we;
	private WebElement myDynamicElement;
	
	
	public BobDafitiVouchers (WebDriver _driver){
		this.driver = _driver;
	}
	
	public void ClickOnIcon (String icon) throws NoSuchElementException{
		String idElement = "";
		
		
		switch (icon){
		case "Create new item":
			String parameter = "/index/edit";
			String url = this.driver.getCurrentUrl()+parameter;
			this.driver.navigate().to(url);
					
			break;
			
			
		case "Type":
			
			this.driver.findElement(By.id("mainForm-type")).click();
			break;
			
		default:
			throw new NoSuchElementException("bla");
		
		}
		
	}
	
	
	public void SelectOption (String option) throws NoSuchElementException{
		
		switch (option){
		case "credit":
			break;
		
		case "coupon":
			this.driver.findElement(By.xpath("//*[@id='mainForm-type']/option[3]")).click();
			break;
		
		default:
			throw new NoSuchElementException("bla");
			
		}
		
	}
	
	public void FillField (String fieldName, String fieldValue) {
		
		Actions action = new Actions (driver);
		we = null;
		
		myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mainForm-name")));		
		
		String idElement = ""; 
		
		switch (fieldName){
		case "Name":
			idElement = "mainForm-name";
			break;
		
		case "Description":
			idElement = "mainForm-description";			
			break;
		
		case "Discount amount":
			idElement = "mainForm-discount_amount_default";
			break;
		
		case "Percentage":
			idElement = "mainForm-discount_percentage";
			break;
			
		case "Usage Limit":
			idElement = "mainForm-usage_limit";
			break;
		
		case "Code length":
			idElement = "mainForm-cide_length";
			break;
		
		case "Code prefix":
			idElement = "mainForm-code_prefix";
			break;
		
		case "Duration (days)":
			idElement = "mainForm-duration_in_days";
			break;
		
		case "Minimum order amount":
			idElement = "conditions-Subtotal-subtotal";
			break;
			
		case "Devices model (coma separated)":
			idElement = "conditions-DeviceModel-DeviceModel";
			break;
			
		default:
			break;
			
			
		}
		
		this.driver.findElement(By.id(idElement)).sendKeys(fieldValue);
	}

	
}
