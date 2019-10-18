package restassuredexercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class RestAssuredExercises2Test {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	/*******************************************************
	 * Have this DataProvider return three test data rows:
	 * country code - zip code - state
	 * us           - 90210    - California
	 * us           - 12345    - New York
	 * ca           - Y1A      - Yukon
	 ******************************************************/
	
	@DataProvider
	public static Object[][] zipCodeData() {
		return new Object[][] {
			// TEST DATA GOES HERE
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
	public void checkStateForCountryCodeAndZipCode() {
		
		given().
		when().
		then();
	}
}