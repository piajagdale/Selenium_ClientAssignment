package Com.StepDefinetion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;



public class APIForeginRates {
	Response response;
	 		
	@Given("Rates API for latest foreign exchange rates")
	public void setUpAPI() {
		RestAssured.baseURI ="https://api.ratesapi.io/api/";
	}

	@When("API is Available")
	public void invokeAPI() {
		response=  RestAssured.given().header("Content-Type", "application/html")
			   .when().get("latest")
			   .then().log().all().assertThat().statusCode(200).extract().response();
	     
	}

	@Then("Verify the success status code of the response is success")
	public void validateAPIStatus() {
		
		 Assert.assertEquals(200, response.getStatusCode());
	    
		 System.out.println("Status Code of Response is :" + response.getStatusCode());

	}
	
}
