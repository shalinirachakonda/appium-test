package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class CreateDeletPlaceTest {
	
	@Test
	public void createDeletePlace() {
		
		RestAssured.baseURI= "https://maps.googleapis.com";
		String b= "{"+
				"\"location\": {"+
				"\"lat\": -33.8669710,"+
				"\"lng\": 151.1958750"+
				"},"+
				"\"accuracy\": 50,"+
				"\"name\": \"Google Shoes!\","+
				"\"phone_number\": \"(02) 9374 4000\","+
				"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				"\"types\": [\"shoe_store\"],"+
				"\"website\": \"http://www.google.com.au/\","+
				"\"language\": \"en-AU\""+
				"}";
		Response res= given().
			queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
			body(b).
		when().
			post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("INVALID_REQUEST")).
		extract().response();
		String responseString= res.asString();
		System.out.println("response is "+responseString);
		
		JsonPath js= new JsonPath(responseString);
		String placeId= js.get("place_id");
		System.out.println("place id is "+placeId);
		
		given().
			queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
			body("{"
					+ "place_id:"+placeId+"}").
		when().
			post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("INVALID_REQUEST"));
	}

}
