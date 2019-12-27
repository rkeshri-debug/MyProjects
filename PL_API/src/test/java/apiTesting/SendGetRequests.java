package apiTesting;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class SendGetRequests {

	
	public static void main(String[] args) {
	Response response=given().auth().basic("sk_test_XfoF59uY13o98skEk8prjm7g00I7ekT6rz", "")
					  .get("https://api.stripe.com/v1/customers");
	response.prettyPrint();
	String jsonresponse=response.asString();
	System.out.println(jsonresponse);
		//given().contentType(ContentType.JSON);
		//given().contentType("application/json");
		//given().header("content-type","application/json").auth().basic("sk_test_XfoF59uY13o98skEk8prjm7g00I7ekT6rz", "");
	}

}
