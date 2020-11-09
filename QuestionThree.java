import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QuestionThree {

	@SuppressWarnings("unchecked")
	@Test
	public void VerifyPost()
	{   
		 // Specify the base URL to the RESTful web service
		 RestAssured.baseURI ="https://ca22ba9d-3436-4bfd-bfab-25344c9f5392.mock.pstmn.io/api/v1/resources/resources";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification request = RestAssured.given();
		 
		 
         // Create a json object to store the request parameters sent in POST command
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("deleted", "false"); // Cast
		 requestParams.put("description", "9-RM resource 20200928121933264 - description");
		 requestParams.put("metadata", "null");
		 requestParams.put("name", "r-RM resource 20200928121933264 - name");
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 
		 // Convert json object of parameters to string
		 request.body(requestParams.toJSONString());
		 
		 // Post the json object
		 Response response = request.post();
		 
		 // Get Response Body 
		 ResponseBody<?> body = response.getBody();
		 
		 // Get Response Body as String 
		 String bodyStringValue = body.asString();
		 
		 // Validate if Response Body Contains key value pair for name and value fields
		 Assert.assertTrue(bodyStringValue.contains("name\": \"r-RM resource 20200928121933264 - name"));
		 
		 // Create local variable to store status code
		 int statusCode = response.getStatusCode();
		 
		 // Validate if status code is equal to 201 signifying successful post
		 Assert.assertEquals(statusCode /*actual value*/, 201 /*expected value*/, "Correct status code returned");
			
		 // Now we print out the body response in the console for verification
		 // and a prompt stating that question 3 is completed		 
		 System.out.println(bodyStringValue);
	     System.out.println("This is the completion of question 3");

	}
	
}
	


