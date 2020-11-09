import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QuestionTwo {

	@Test
	public void VerifyPagination()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://ca22ba9d-3436-4bfd-bfab-25344c9f5392.mock.pstmn.io/api/v1/resources/resources?sortBy=modificationDate&amp;direction=desc&amp;limit=50&amp;offset=0";
		
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		// this step specifies the content header as json data
		httpRequest.header("Content-Type", "application/json");

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.   
		Response response = httpRequest.request(Method.GET);

	    // Get Response Body 
	    ResponseBody<?> body = response.getBody();

	    // Get Response Body as String 
	    String bodyStringValue = body.asString();

	    // Validate if Response Body Contains the total value of 3 for pagination
	    Assert.assertTrue(bodyStringValue.contains("total\": 3"));
	    
	    // Declare local variable to get Status Code
	 	int statusCode = response.getStatusCode();
		
	 	// Now we validate if the Status Code of 200 was received in the response
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		
		// Now we print out the body response in the console for verification
		// and a prompt stating that question 2 is completed
		System.out.println(bodyStringValue);
		System.out.println("This is the completion of question 2");
		
		}

	}

