import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QuestionOne {
	
	@Test
	public void VerifyQuestionID()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://ca22ba9d-3436-4bfd-bfab-25344c9f5392.mock.pstmn.io/api/v1/resources/3fe5a362-6980-4266-a819-aa6882839292";
		
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		// Enable to specify the header content type as json data
		httpRequest.header("Content-Type", "application/json");
		
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.   
		Response response = httpRequest.request(Method.GET);
		
		
		
		// Declare local variable to get Status Code
		int statusCode = response.getStatusCode();
	    
		// Get Response Body 
		ResponseBody<?> body = response.getBody();
	   
		// Get Response Body as String 
		String bodyStringValue = body.asString();
	    
		// Validate if Response Body Contains the string for id field and its static value
		Assert.assertTrue(bodyStringValue.contains("id\": \"3fe5a362-6980-4266-a819-aa6882839292"));
		
		// Now we validate if the Status Code of 200 was received in the response
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		
		// Now we print out the body response in the console for verification
		// and a prompt stating that question 1 is completed
		System.out.println(bodyStringValue);
		System.out.println("This is the completion of question 1");
	 
	}

}