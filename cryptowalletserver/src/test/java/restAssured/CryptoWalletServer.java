package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CryptoWalletServer {
	
	String url ="https://crypto-wallet-server.mock.beeceptor.com";
	String token;
	String type; 
	String exp_time;
	
	@Test (enabled = true, priority = 0)
	public void registeruser() {
		
		RestAssured.baseURI = url;
		
		
		JSONObject js = new JSONObject();
		js.put("username", "user123");
		js.put("password", "securepassword");
		js.put("email", "user@example.com");
		
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("/api/v1/register")
		.then().statusCode(200).log().all();
	}
	
	@Test (enabled = true, priority = 1)
	public void loginuser() {
		
		RestAssured.baseURI = url;
		
		JSONObject js = new JSONObject();
		js.put("username", "user123");
		js.put("password", "securepassword");
				
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("/api/v1/login")
		.then().statusCode(200).log().all();
		
		
	}

	@Test (enabled = true, priority = 2)
	public void balance() {
		
		RestAssured.baseURI = url;
				
		given().contentType(ContentType.JSON).when().get("/api/v1/balance")
		.then().statusCode(200).log().all();
	}
	
	@Test (enabled = true, priority = 3)
	public void transaction() {
		
		RestAssured.baseURI = url;
		
		given().contentType(ContentType.JSON).when().get("/api/v1/transactions")
		.then().statusCode(200).log().all();
	}
	
	
	@Test (enabled = true, priority = 4)
	public void transferTrans() {
		
		RestAssured.baseURI = url;
		JSONObject js = new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", "5.0");
		js.put("currency", "ETH");
		
		given().contentType(ContentType.JSON).when().post("/api/v1/transactions").then().statusCode(200).log().all();
		
	}
	
	@Test (enabled = true, priority = 5)
	public void calculateTrans() {
		
		RestAssured.baseURI = url;
		JSONObject js = new JSONObject();
		js.put("amount", "2.5");
		js.put("currency", "BTC");
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		given().contentType(ContentType.JSON).when().post("/api/v1/transaction_fee")
		.then().statusCode(200).log().all();
		
	}
	
	
	@Test (enabled = true, priority = 6)
	public void getExchangeRate() {
		
		RestAssured.baseURI = url;
				
		given().contentType(ContentType.JSON).when().get("/api/v1/exchange_rates")
		.then().statusCode(200).log().all();
		
	}
	
	
}
