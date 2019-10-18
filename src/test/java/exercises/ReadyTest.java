package exercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;

public class ReadyTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

    @Test
    public void amIReady() {

        given().
        when().
            get("http://localhost:9876/us/90210").
        then().
            assertThat().
            statusCode(200);
    }
}
