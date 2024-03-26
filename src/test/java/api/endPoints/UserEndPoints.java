package api.endPoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {
	
	//To zperform CRUD operation =Create,Retrieve,Update and Delete
	
	//Create User
	public static Response createUser(User payload ){
		Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
		
	}

	//Read user
	public static Response readUser(String UserName ){
		Response response= given()
		.pathParam("username", UserName)
		.when()
		.get(Routes.get_url);
		return response;
		
	}
	
	//Update User
	public static Response UpdateUser(String UserName,User payload  ){
		Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.body(payload)
		.when()
		.put(Routes.update_url);
		return response;
		
	}
	
	//Delete User
	public static Response deleteUser(String UserName ){
		Response response= given()
		.pathParam("username", UserName)
		.when()
		.delete(Routes.delete_url);
		return response;
		
	}
	
}
