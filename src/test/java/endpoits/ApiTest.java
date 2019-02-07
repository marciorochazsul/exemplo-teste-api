package endpoits;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import utils.Report;
import utils.Utilitarios;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.log4j.PropertyConfigurator;

public class ApiTest {
	
	String baseUrl;
	
	@Rule
	public Report screenshotTestRule = new Report();
	
	public ApiTest() {
		Utilitarios.deletarRelatorio();
	}
	
	@Before
	public void inicializaTest() {
		
		PropertyConfigurator.configure("log4j.properties");
		baseUrl = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";
	}
	
	
	@Test
	public void validaRetornoDosMeses() {		
		
	given().log().all()  	  
  	.when()
  	   .get(baseUrl)
  	.then()
  	   .statusCode(200).assertThat().
  	   body("meses",hasItems("112","124","136","148"));
  	  	
	}
	
	@Test
	public void validaRetornoDosValores() {	
		
	given().log().all()  	  
  	.when()
  	   .get(baseUrl)
  	.then()
  	   .statusCode(200).assertThat().
  	   body("valor",hasItems("2.802","3.174","3.564","3.971"));
  	  	
	}
	

}
