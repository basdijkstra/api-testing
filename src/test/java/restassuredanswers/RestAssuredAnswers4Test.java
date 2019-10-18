package restassuredanswers;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;

import org.junit.*;

public class RestAssuredAnswers4Test {

	private static RequestSpecification requestSpec;
	private static ResponseSpecification responseSpec;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	/*******************************************************
	 * Create a RequestSpecification that specifies:
	 * - that the baseUri is "http://localhost"
	 * - that the port to be used is 9876
	 ******************************************************/

	@BeforeClass
	public static void createRequestSpecification() {

		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://localhost").
			setPort(9876).
			build();
	}
		
	/*******************************************************
	 * Create a ResponseSpecification that checks whether:
	 * - the response has statusCode 200
	 * - the response contentType is JSON
	 ******************************************************/
	
	@BeforeClass
	public static void createResponseSpecification() {
		
		responseSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				build();		
	}

	/*******************************************************
	 * Perform a GET request to /us/90210
	 * Use the previously created RequestSpecification and
	 * ResponseSpecification to set up the base URI and port
	 * as well as execute the specified standard checks.
	 * Additionally, check that 'country abbreviation' is
	 * equal to 'US'
	 * Also, test your tests: are the checks from the
	 * ResponseSpecification really executed?
	 ******************************************************/
	
	@Test
	public void useRequestAndResponseSpecification() {
		
		given().
			spec(requestSpec).
		when().
			get("/us/90210").
		then().
			spec(responseSpec).
		and().
			body("'country abbreviation'",equalTo("US"));
	}

	/*******************************************************
	 * Perform a GET request to /secretZipCode
	 * Use the previously created RequestSpecification, as well
	 * as basic authentication with username = admin and password = welcome1234
	 * Extract the value of the response element 'zipCode' into a String variable
	 *
	 * Then perform a second GET request to /ca/{zipCode}, where {zipCode} is replaced
	 * by the zip code you retrieved earlier. Use a path parameter to do this.
	 * Use the RequestSpecification here as well.
	 * Finally, assert that the value of the response body element
	 * places[0].'place name' is equal to 'Secret Location Studios'
	 *
	 * This test, when done well, consists of two API calls.
	 ******************************************************/

	@Test
	public void retrieveAndExtractZipCode_thenAssertOnLocation() {

		String zipCode =

			given().
				spec(requestSpec).
			and().
				auth().
				preemptive().
				basic("admin","welcome1234").
			when().
				get("/secretZipCode").
			then().
				extract().
				path("zipCode");

		given().
			spec(requestSpec).
		and().
			pathParam("zipCode", zipCode).
		when().
			get("/ca/{zipCode}").
		then().
			assertThat().
			body("places[0].'place name'", equalTo("Secret Location Studios"));
	}
}