package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	private WebDriver driver;
	private WebDriverWait waitElement;
	private Actions build;
	
	public CheckoutPage(WebDriver _driver){
		this.driver = _driver;
		waitElement = new WebDriverWait(this.driver,30);
		this.build = new Actions(driver);		
	}
	
	public void SelectPaymentMethod(String paymentMethod) throws InterruptedException{
		String idElement = "";
		switch (paymentMethod) {
		case "Boleto":
			idElement = "boleto";
			break;
			
		case "Cartão de crédito":			
			break;
			
		case "Débito em conta":
			idElement = "debit";
			break;
			
		default:
			throw new NoSuchElementException("Element "+paymentMethod+" not found");
		}
		
		this.driver.findElement(By.id(idElement)).click();
		Thread.sleep(5000);
	}
	
	public void SelectFreightOptions(String freightOptions) throws InterruptedException{
		String idElement = "";
		switch (freightOptions) {
		case "Frete grátis":
			idElement = "delivery-type-1";
			break;
			
		default:
			throw new NoSuchElementException("Element "+freightOptions+" not found");
		}
		
		this.driver.findElement(By.id(idElement)).click();
		Thread.sleep(5000);
	}
	
	public void SubmitButton(String buttonName) throws InterruptedException{
		String xpathElement = "";
		
		switch (buttonName) {
		case "Finalizar compra":
			xpathElement = "//form[@id='finish-checkout']/div[2]/div[2]/button";
			break;

		default:
			throw new NoSuchElementException("Element "+buttonName+" not found");
		}		
		this.driver.findElement(By.xpath(xpathElement)).submit();
	}
}
