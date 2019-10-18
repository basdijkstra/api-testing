package restassuredanswers;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.*;

@RunWith(DataProviderRunner.class)
public class RestAssuredAnswers2Test {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	/*******************************************************
	 * Create a DataProvider with three test data rows:
	 * country code - zip code - state
	 * us           - 90210    - California
	 * us           - 12345    - New York
	 * ca           - Y1A      - Yukon
	 ******************************************************/
	
	@DataProvider
	public static Object[][] zipCodeData() {
		return new Object[][] {
				{ "us", "90210", "California" },
				{ "us", "12345", "New York" },
				{ "ca", "Y1A", "Yukon" }
		};
	}
	
	/*******************************************************
	 * Request zip code data for given country / zip
	 * combinations by sending a GET to http://localhost:9876/{countryCode}/{zipCode}.
	 * Use the test data collection created
	 * above. Check that the state returned by the API
	 * matches the expected value.
	 * Use the GPath expression places[0].state to retrieve
	 * the value for the state.
	 ******************************************************/
	
	@Test
	@UseDataProvider("zipCodeData")
	public void checkStateForCountryCodeAndZipCode(String countryCode, String zipCode, String expectedState) {
		
		given().
			pathParam("countryCode", countryCode).
			pathParam("zipCode", zipCode).
		when().
			get("http://localhost:9876/{countryCode}/{zipCode}").
		then().
			assertThat().
			body("places[0].state",equalTo(expectedState));
	}
}