package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BobKanuiPET {
	
	private WebDriver driver;
	private WebElement weMain, weFilter;
	private WebElement we;
	private WebElement myDynamicElement;
	
	public BobKanuiPET (WebDriver _driver) {
		this.driver = _driver;
		
		
	}
	
	public boolean SearchProductByValue(String filter, String value) throws NoSuchElementException, InterruptedException, AssertionError{
		Actions action = new Actions(driver);
		weMain = null;
		weFilter = null;
		
		myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.id("ext-gen147")));
		
		weMain = this.driver.findElement(By.id("ext-gen184"));
		action.moveToElement(weMain).click().build().perform();
		
		myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='x-combo-list-inner']")));
		switch (filter){
					
		case "name":
			weFilter = this.driver.findElement(By.xpath("//*[@class='x-combo-list-inner']/div[1]"));
			break;
			
		case "sku":
			weFilter = this.driver.findElement(By.xpath("//*[@class='x-combo-list-inner']/div[2]"));
			break;
			
		case "barcode":
			weFilter = this.driver.findElement(By.xpath("//*[@class='x-combo-list-inner']/div[3]"));
			break;
		
		case "sku_supplier":
			weFilter = this.driver.findElement(By.xpath("//*[@class='x-combo-list-inner']/div[4]"));
			break;
		
		default:
			throw new NoSuchElementException("Element not found");
		
		}
		
		
		action.moveToElement(weMain).moveToElement(weFilter).click().build().perform();
		
		//inputing value into search field
		this.driver.findElement(By.id("ext-comp-1034")).clear();
		this.driver.findElement(By.id("ext-comp-1034")).sendKeys(value);
		
		//clicking on Filtro button
		this.driver.findElement(By.id("ext-gen190")).click();
		
		
		return !(this.driver.findElement(By.id("ext-comp-1061")).getText().equals("No data to display"));
				
	}
	
	public void SelectProduct (){
		we = null;
		Actions action = new Actions (driver);
		
		myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("ext-gen147")));
		
		//*[@id="ext-gen147"]/div[1]/table/tbody/tr/td[1]/div
		//*[@id="ext-gen147"]/div[1]/table/tbody/tr/td[1]/div
				
		we = this.driver.findElement(By.xpath("//*[@id='ext-gen147']/div[1]/table/tbody/tr/td[1]/div"));
//		action.moveToElement(we).click(we).build().perform();
		
		action.moveToElement(we).click().doubleClick(we).build().perform();
		
		
		myDynamicElement = (new WebDriverWait(driver, 200)).until(ExpectedConditions.presenceOfElementLocated(By.id("ext-comp-1081")));
						
	}
	

}
