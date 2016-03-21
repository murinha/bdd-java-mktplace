package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BobKanuiHome {
	
	private WebDriver driver;
	WebElement weMenu = null;
	WebElement weOption = null;
	
	
	
	public BobKanuiHome(WebDriver _driver){
		this.driver = _driver;
		
	}
	
	public void MouseoverMenuClickOption (String menu, String option){
		Actions action = new Actions(this.driver);
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("navigation")));
		
		switch (menu){
		case "Orders":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[1]"));
			
			switch (option){
			case "Order Processing":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[1]/span[2]/span/a[1]/span"));
				break;
				
			case "Order Operations":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[1]/span[2]/span/a[2]/span"));
				break;
				
			default:
				break;
			
			}
			break;
			
		case "Customers":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/a[1]"));			
			break;
			
		case "Catalog":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[2]"));
			
			switch (option){
			case "PET":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[2]/span[2]/span/a[1]"));
				
				
				break;
			
			default:
				break;
			}
			break;
			
			
		case "Stock":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]"));
			
			switch (option){
			case "Overview":
				this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[2]/span/a[1]"));
				break;
				
			case "Upload":
				this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[2]/span/a[2]"));
				break;
			
			default:
				break;
			}		
			break;
			
		case "Fulfillment":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[4]"));
					
			break;
		
		case "Content":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[5]"));
					
			break;
			
		case "Promotion":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[6]"));
					
			break;
			
		case "Marketplace":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[7]"));
			
			switch (option){
			case "Configuration":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[7]/span[2]/span/a[1]"));
				break;
				
			case "Merchant":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[7]/span[2]/span/a[2]"));
				break;
				
			default:
				break;
			}
			break;
			
		case "Newsletter":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/a[2]"));
								
			break;
			
		case "Profile":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[8]"));
								
			break;
			
		case "System":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[9]"));
					
			break;
			
		case "Reporting":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[10]"));
					
			break;
			
			
		case "MercadoLivre":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[11]"));
					
			break;
			
		case "ExternalShop":
			weMenu = this.driver.findElement(By.xpath("//*[@id='navigation']/span[12]"));
			
			switch (option){
			case "Venture":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[12]/span[2]/span/a[1]"));
				break;
			
			case "Venture Orders":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[12]/span[2]/span/a[2]"));
				break;
				
			case "Partner":
				weOption = this.driver.findElement(By.xpath("//*[@id='navigation']/span[12]/span[2]/span/a[3]"));
				break;
				
			default:
				break;
				
			}
			break;
			
		default:
			break;
		}
		
		action.moveToElement(weMenu).moveToElement(weOption).click().build().perform();
	}

}
