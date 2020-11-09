import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class QuestionFour {
	@BeforeTest
	public void setupQuestionFour(){
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://ca22ba9d-3436-4bfd-bfab-25344c9f5392.mock.pstmn.io/api/v1/resources/resources/17bb4ca1-f0e9-4f05-b606-70aab69b78b1";
	    //RestAssured.basePath = "/base path goes here but not needed for question 4/";
	}
	@Test
	    // Below is a common used rest assured format that is useful if using cucumber
	    // I wanted to write these these test questions in various formats
	    // To demonstrate that I can use different styles
	    // In the below steps I do a given on rest assured API called and do a DELETE command
	    // I then Assert that status code returned from API is 204
    public void testDelete(){
		given()
		.when()
		.delete()
		.then().assertThat().
        statusCode(204);	
	}
	@Test
		// In the below steps I also wanted to demonstrate doing a delete similar to the steps above in 
	    // some sleeker code but also printing the header response to console
	    // and then printing out that I have completed question 4
	public void deleteResponseHeaders(){
		   System.out.println("The headers in the response "+
           delete("https://ca22ba9d-3436-4bfd-bfab-25344c9f5392.mock.pstmn.io/api/v1/resources/resources/17bb4ca1-f0e9-4f05-b606-70aab69b78b1").then().extract()
           .headers());
		   System.out.println("This is the completion of question 4");		   
		}
}