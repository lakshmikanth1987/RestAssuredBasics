package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=Dataproviders.class)
	public void testPostUser(String userId,String Username,String fName,String lName,String Email,String password,String phone) {
		
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(Username);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(Email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);	
	}

	@Test(priority=2,dataProvider="UserNames",dataProviderClass=Dataproviders.class)
	public void testDeleteUserByName(String username) {
		Response response=UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
