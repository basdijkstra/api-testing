package restassuredexercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredExercises4Test {

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

	}

	/*******************************************************
	 * Create a ResponseSpecification that checks whether:
	 * - the response has statusCode 200
	 * - the response contentType is JSON
	 ******************************************************/

	@BeforeClass
	public static void createResponseSpecification() {

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
		when().
		then();
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

		given().
		when().
		then();

		given().
		when().
		then();
	}
}