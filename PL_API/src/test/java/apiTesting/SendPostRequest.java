package apiTesting;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendPostRequest {

	public static void main(String[] args) throws ParseException {
		List<String> dckList = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {

			RestAssured.baseURI = "http://guidetolenders.quinstage.com/plpost.jsp?";

			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("Authorization", "Basic ZHJlZGR5:QnJzbm5yczY4Iw== Token MjEwOTE0NDM5MjQyMDE1");
			JSONObject requestParams = new JSONObject();
			requestParams.put("LoanPurpose", "Debt Consolidation");
			requestParams.put("CashOut", "10000");
			requestParams.put("CreditRating", "Good");
			requestParams.put("EmploymentStatus", "7");
			requestParams.put("Dob", "01/01/1992");
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			String s = "alicialallen" + randomInt + "@gmail.com";
			requestParams.put("Email", s);
			requestParams.put("PostalCode", "94404");
			requestParams.put("Fname", "allen");
			requestParams.put("Lname", "alicia");
			requestParams.put("Street", "1945 GARVEY");
			requestParams.put("City", "WEST COVINA");
			requestParams.put("State", "CA");
			requestParams.put("OwnHome", "Renter");
			requestParams.put("TimeAtResidence", "Less than 1 year.");
			requestParams.put("PhoneConsentLang", "TCPA Text");
			requestParams.put("AFN", "4directionsmedia_PL");
			requestParams.put("AF", "21091443");
			requestParams.put("SkipVerify", "Yes");
			requestParams.put("getTYLink", "Yes");
			requestParams.put("qacs", "720");
			requestParams.put("HomePhone", "6505045360");
			requestParams.put("SSN", "666583350");
			requestParams.put("dping", "yes");
			requestParams.put("Income", "80000");
			requestParams.put("AFFID", "6780-293479");
			request.body(requestParams.toJSONString());

			Response response = request.post("");

			// String s1=response.prettyPrint();

			//int statusCode = response.getStatusCode();
			// System.out.println(statusCode);
			// Assert.assertEquals(statusCode, "400");
			// Assert.assertEquals(String.valueOf(statusCode), "200");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.asString());
			System.out.println(json);
			String dck = (String) json.get("LeadID");
			dckList.add(dck);
		

		}

		for (String s : dckList) {
			System.out.println(s);
		}

		// String successCode = response.jsonPath().get("SuccessCode");
		// Assert.assertEquals("Correct Success code was returned", successCode,
		// "OPERATION_SUCCESS");

	}

}
