package util;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class RestSupport {
	private String baseUrl;
	private WebDriver driver;
	private StepSupport stepSupport;
	
	public RestSupport(WebDriver _driver, String _baseUrl, StepSupport _stepSupport){
		this.baseUrl = _baseUrl;
		this.driver = _driver;
		this.stepSupport = _stepSupport;
	}
	
	public JSONArray SolrProductsRequest() throws IOException{
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		    .url(this.baseUrl+":8080/solr/dafiti/select?q=*%3A*&rows=500&fl=sku%2Cskus&wt=json&indent=true")
		    .build();
		Response responses = null;
		responses = client.newCall(request).execute();

		String jsonData = responses.body().string();
		
		JSONObject Jobject = new JSONObject(jsonData);		
		Jobject = (JSONObject) Jobject.get("response");
		Object skuValues = Jobject.get("docs");
		
		JSONArray jArray = (JSONArray) skuValues;
		int randIndex = this.stepSupport.randomIndex(1, jArray.length());
		
		JSONObject skuConfig = jArray.getJSONObject(randIndex);
		
		JSONArray skus = skuConfig.getJSONArray("skus");
		
		return skus;
	}
	
	public void AddProductsToCart(JSONArray skus){
		String addcart = "/cart/add?";
		String sku = "p="+skus.getString(0);
		String skuSimple = "&sku="+skus.getString(1);
		
		this.driver.navigate().to(this.baseUrl+addcart+sku+skuSimple);		
	}

	public void AddToCart(String skuConfig, String skuSimple) {
		String addcart = "/cart/add?";
		String sku_config = "p="+skuConfig;
		String sku_simple = "&sku="+skuSimple;
		
		this.driver.navigate().to(this.baseUrl+addcart+sku_config+sku_simple);		
	}
}
