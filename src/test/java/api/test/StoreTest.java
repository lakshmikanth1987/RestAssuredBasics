package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endPoints.PetStoreEndPoints;

import api.payload.Store;
import io.restassured.response.Response;

public class StoreTest {
	
	
	Store storePayload;
	
	@BeforeClass
	public void setUpData() {
		
		System.out.println("************"+storePayload.getId());
		storePayload.setId(0);
		storePayload.setPetId(0);
		storePayload.setQuantity(0);
		storePayload.setShipDate("2024-03-26T07:58:07.751Z");
		storePayload.setStatus("placed");
		storePayload.setComplete("true");
		
	}
	
	@Test(priority = 1)
	public void testPlaceAnOrder() {

		Response response = PetStoreEndPoints.placeAnOrder(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
