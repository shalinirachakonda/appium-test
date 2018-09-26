package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class RestGoogleTest {
	
	@Test
	public  void testGoogleApi() {
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		
		given().
			queryParam("Key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
			body("{"+
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
					"}").
		when().
			post("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).contentType(ContentType.JSON).and().body("status",equalTo("OK"));
		
		
	}

}


