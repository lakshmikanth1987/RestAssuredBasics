package api.endPoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import api.payload.Store;

import static io.restassured.RestAssured.given;

public class PetStoreEndPoints {

	
	 // POST Request --https://petstore.swagger.io/v2/store/order
	 //Get Order ID --  https://petstore.swagger.io/v2/store/order/1
	 //Delete Order ID -- https://petstore.swagger.io/v2/store/order/1
	
	
	
	//To get URL from .properties file
	
	public static ResourceBundle  getURL() {
		ResourceBundle routes= ResourceBundle.getBundle("routes"); //Load the Properties 
		return routes;
	}
	
	
	public static Response placeAnOrder(Store payload) {
		
		String post_url=getURL().getString("post_url");
		Response response=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);
				return response;
		
	}
	
}
