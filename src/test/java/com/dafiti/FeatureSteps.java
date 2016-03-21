package com.dafiti;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import util.*;

public class FeatureSteps {	
	private WebDriver driver;
	
	private String baseUrl;
	
	private Scenario scenario;	
	private LinkManager link;
	private PageManager pgManager;
	private StepSupport stepSupport;
	private EvidenceSteps evidenceSteps;
	private CheckoutPage checkout;
	private BobLogin bobLogin;
	private BobKanuiHome bobKanui;
	private BobKanuiPET bobKanuiPET;
		
	
	@Before
	public void beforeScenario(Scenario _scenario){
		this.driver = new FirefoxDriver();
		this.driver.navigate().to("");
		this.driver.manage().window().maximize();		
		
		this.stepSupport = new StepSupport(this.driver);	
		this.link = new LinkManager(this.driver);
		this.pgManager = new PageManager(this.driver);		
		this.checkout = new CheckoutPage(this.driver);
		this.bobLogin = new BobLogin(this.driver);
		this.bobKanui = new BobKanuiHome(this.driver);
		this.bobKanuiPET = new BobKanuiPET(this.driver);
		this.evidenceSteps = new EvidenceSteps("/home/murinha/projetos/bdd-mktplace/Evidences/");		
		this.scenario = _scenario;
	}
	
	@Given("^that i am at \"(.*?)\" url$")
	public void that_i_am_at_url(String baseUrl) throws Throwable {
		this.baseUrl = baseUrl;
		this.pgManager.NavegateTo(baseUrl);		
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"that_i_am_at_url");
	}
	
	@When("^i click on \"(.*?)\" link$")
	public void i_click_on_link(String linkName) throws Throwable {
		this.link.ClickOnLink(linkName);		
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"i_click_on_link_"+linkName);
	}
	
	
	
	@When("^i fill field \"(.*?)\" with value \"(.*?)\" in \"(.*?)\"$")
	public void i_fill_field_with_value_in(String fieldName, String value, String pageName) throws Throwable {
	    
		switch (pageName){
		case "Bob - Login":
			this.bobLogin.FillField(fieldName, value);
			break;
		
		default:
			break;
		}
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"i_fill_field_with_value_in"+pageName);
	}

	@When("^i click on button \"(.*?)\" in \"(.*?)\"$")
	public void i_click_on_button_in(String button, String pageName) throws Throwable {
		
		switch (pageName){
		case "Bob - Login":
			this.bobLogin.ClickOnButton(button);
		}
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"i_click_on_button_in"+pageName);
	}
	
	/*========Kanui===========*/
	
	@When("^i mouseover on \"(.*?)\" menu, click on \"(.*?)\" option in \"(.*?)\"$")
	public void i_mouseover_on_menu_click_on_option_in(String menu, String option, String pageName) throws Throwable {
		
		switch (pageName){
		case "Bob Kanui":
			this.bobKanui.MouseoverMenuClickOption(menu, option);
			break;
		
		default:
			break;
		}

	}
	
	@When("^i search a product by \"(.*?)\" with value \"(.*?)\"$")
	public void i_search_a_product_by_with_value(String filter, String value) throws Throwable {
		Assert.assertTrue(this.bobKanuiPET.SearchProductByValue(filter, value));
			    
	}
	
	@When("^i select the product$")
	public void i_select_the_product() throws Throwable {
		this.bobKanuiPET.SelectProduct();
	    
	}


	
	
	@Then("^i wait for \"(.*?)\" page to load$")
	public void i_wait_for_page_to_load(String pageName) throws Exception{
		this.pgManager.WaitPageToLoad(pageName);
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"i_wait_for_page_to_load_"+pageName);		
	}
	
		
	//======================================Mkt-Place===============================================//
	
	@Then("^i checkout for \"(.*?)\" times with SKU_Config \"(.*?)\" and SKU_Simple \"(.*?)\"$")	
	public void i_checkout_for_times_with_SKU_Config_and_SKU_Simple(int count, String skuConfig, String skuSimple) throws Throwable {
		RestSupport rest = new RestSupport(this.driver, this.baseUrl, this.stepSupport);
		for (int i = 0; i < count; i++) {			
			rest.AddToCart(skuConfig,skuSimple);
			this.pgManager.WaitPageToLoad("cart");
			this.link.ClickOnLink("Finalizar compra");
			this.pgManager.WaitPageToLoad("checkout");
			//this.checkout.SelectFreightOptions("Frete grátis");
			this.pgManager.WaitPageToLoad("checkout");
			this.checkout.SelectPaymentMethod("boleto");
			this.pgManager.WaitPageToLoad("checkout");
			this.checkout.SubmitButton("Finalizar compra");
			this.pgManager.WaitPageToLoad("Sucess Page");
			this.link.ClickOnLink("Acompanhe Seu Pedido");
			this.pgManager.WaitPageToLoad("Customer order");
		}
	}
		
	@Then("^i checkout for \"(.*?)\" times with \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void i_checkout_for_times_with_and_and_and(int count, String skuConfig1, String skuSimple1, String skuConfig2, String skuSimple2) throws Throwable {
		RestSupport rest = new RestSupport(this.driver, this.baseUrl, this.stepSupport);
		for (int i = 0; i < count; i++) {			
			rest.AddToCart(skuConfig1,skuSimple1);
			this.pgManager.WaitPageToLoad("cart");
			rest.AddToCart(skuConfig2,skuSimple2);
			this.pgManager.WaitPageToLoad("cart");
			this.link.ClickOnLink("Finalizar compra");
			this.pgManager.WaitPageToLoad("checkout");
			this.checkout.SelectFreightOptions("Frete grátis");
			this.pgManager.WaitPageToLoad("checkout");
			this.checkout.SelectPaymentMethod("Débito em conta");
			this.pgManager.WaitPageToLoad("checkout");
			this.checkout.SubmitButton("Finalizar compra");
			this.pgManager.WaitPageToLoad("Sucess Page");
			this.link.ClickOnLink("Acompanhe Seu Pedido");
			this.pgManager.WaitPageToLoad("Customer order");
		}
	}	
	//======================================Mkt-Place===============================================//	
	
	@Then("^i will see \"(.*?)\" page$")
	public void i_will_see_page(String pageName) throws Throwable {
		Thread.sleep(5000);
		this.pgManager.WaitPageToLoad(pageName);
		this.evidenceSteps.takeAPrint(this.scenario.getName(),"i_will_see_page_"+pageName);
	}
	
	
	

	
	@After
	public void afterScenario() {
		  this.driver.quit();		  
	}
}