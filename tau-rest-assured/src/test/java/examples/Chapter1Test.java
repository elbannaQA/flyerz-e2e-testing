package examples;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.*;

public class Chapter1Test {
    private static RequestSpecification requestSpec ;
    private static ResponseSpecification responseSpec;


    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
        };
    }

    @BeforeClass
    public static void createRequestSpecification(){
        requestSpec =  new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us/").
                build();
    }

    @BeforeClass
    public static void createResponseSpecifications(){
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test(dataProvider = "zipCodesAndPlaces")
    public void checkPlaceNameInResponseBody(String countryCode, String zipCode, String expectedPlaceName){

        given().
                spec(requestSpec).
                pathParams("countryCode", countryCode).pathParams("zipCode", zipCode).

                when().
                get("{countryCode}/{zipCode}").

                then().
                log().body().

                assertThat().
                spec(responseSpec).
                and().
//                contentType("application/json").
//                statusCode(200).
                //body(matchesJsonSchemaInClasspath("products-schema.json")).
                body("places[0].'place name'",equalTo(expectedPlaceName));
                //body("post code", equalTo("90210"));
    }

    @Test(dataProvider = "zipCodesAndPlaces")
    public void extractPlaceNameFromResponseBody(String countryCode, String zipCode, String expectedPlaceName){
        String placeName =
                given().
                        spec(requestSpec).
                        pathParams("countryCode", countryCode).pathParams("zipCode", zipCode).
                when().
                        get("{countryCode}/{zipCode}").
                then().
                        extract().
                        path("places[0].'place name'");

        Assert.assertEquals(placeName, expectedPlaceName);
        System.out.println(placeName);

    }

    @Test
    public void checkPlaceNameInResponseBody_1(){
        Location location =
                given().
                        when().
                        get("http://api.zippopotam.us/us/90210").
                        as(Location.class);

        Assert.assertEquals("Beverly Hills",
                location.getPlaces().get(0).getPlaceName());
    }
}

