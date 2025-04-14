package stepDefinations;

import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Assert;

import JSON.Json1;

public class apiTesting {

	public static Response response;

	@Given("^The base URI is set to \"([^\"]*)\"$")
	public void the_base_URI_is_set_to(String arg1) {
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
	}

	@When("^I create a new object with payload(\\d+)$")
	public void i_create_a_new_object_with_payload(int arg1) {
		response =given().header("Content-Type", "application/json").body(Json1.payLoad()).when().post();
	}

	@Then("^The response status code should be (\\d+)$")
	public void the_response_status_code_should_be(int arg1) {
		response.then().assertThat().statusCode(200);
	}

	@Then("^The \"([^\"]*)\" in response should be \"([^\"]*)\"$")
	public void the_in_response_should_be(String field, String expectedValue) {
		String jsonPath;

		switch (field.toLowerCase()) {
		case "cpu model":
			jsonPath = "data.\"CPU model\"";
			break;
		case "price":
			jsonPath = "data.price";
			break;
		case "name":
			jsonPath = "name";
			break;
		default:
			throw new IllegalArgumentException("Unmapped field: " + field);
		}

		response.then().body(jsonPath, equalTo(expectedValue));

	}

	@Then("^The \"([^\"]*)\" header should be \"([^\"]*)\"$")
	public void the_header_should_be(String arg1, String arg2) {

	}

	@Then("^I store the \"([^\"]*)\" and \"([^\"]*)\" from the response$")
	public void i_store_the_and_from_the_response(String arg1, String arg2) {

	}

	@When("^I update the object using payload(\\d+)$")
	public void i_update_the_object_using_payload(int arg1){

	}

	@Then("^I store the updated \"([^\"]*)\" from the response$")
	public void i_store_the_updated_from_the_response(String arg1) {

	}

	@When("^I retrieve the object by ID$")
	public void i_retrieve_the_object_by_ID(){

	}

	@Then("^The \"([^\"]*)\" in response should match the updated price$")
	public void the_in_response_should_match_the_updated_price(String arg1){

	}




}
