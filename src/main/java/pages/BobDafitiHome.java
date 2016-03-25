package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BobDafitiHome {
	
	private WebDriver driver;
	private WebElement we = null;
	private WebElement we1 = null;
	private WebElement myDynamicElement;
	
	
	public BobDafitiHome (WebDriver _driver)
	{
		this.driver = _driver;

	}
	
	public void VerifyMenu (String mainMenu)throws NoSuchElementException
	{
		String xpathElement = "";
		
		myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.id("navigation")));
		switch (mainMenu)
		{
		
		case "MainMenu":
			xpathElement = "//*[@id=\"navigation\"]";
			break;
			
		default:
			throw new NoSuchElementException("Menu ' "+mainMenu+" ' not found");
			
		}
		this.driver.findElement(By.xpath(xpathElement)).click();
		
	}
		
	
	public void MouseoverMenuClickOption (String menu, String option){
		Actions action = new Actions(driver);

		
					
			switch (menu)
			{
	
			case "Orders":
				
				switch (option)
				{
				case "Order Processing":
					
					break;
				
				default:
					throw new NoSuchElementException("Menu ' "+menu+" ' - SubMenu '"+option+"' not found");
				}
				break;
			
			case "Catalog":
				
				we = this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[1]"));
				switch (option)
				{
				case "PET":
					
					we1 = this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[2]/span/a[1]/span"));
					
					break;
					
				case "Categories":
					
					break;
					
				case "Brands":
					
					break;
				
				case "Product import":
					we1 = this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[2]/span/a[5]/span"));
									
					break;
					
				case "Category import":
					we1 = this.driver.findElement(By.xpath("//*[@id='navigation']/span[3]/span[2]/span/a[8]/span"));
					break;
				
				default:
					throw new NoSuchElementException("Menu ' "+menu+" ' - SubMenu '"+option+"' not found");
					
					
				}
				break;
				
			case "Promotion":
				we = this.driver.findElement(By.xpath("//*[@id='navigation']/span[6]/span[1]"));
												
				switch (option)
				{
				case "Cart Price Rules":
					
					break;
					
				case "Vouchers":
					we1 = this.driver.findElement(By.xpath("//*[@id='navigation']/span[6]/span[2]/span/a[2]/span"));
					break;
				
				default:
					throw new NoSuchElementException("Menu ' "+menu+" ' - SubMenu '"+option+"' not found");
					
				}
				break;
			case "Stores":
				switch (option)
				{
				case "Configuration":
					
					break;
				
				default:
					throw new NoSuchElementException("Menu ' "+menu+" ' - SubMenu '"+option+"' not found");
				}
				break;
			
			default:
				throw new NoSuchElementException("Menu ' "+menu+" ' - SubMenu '"+option+"' not found");
			}
									
			action.moveToElement(we).moveToElement(we1).click().build().perform();
			
			
	}
	
}
