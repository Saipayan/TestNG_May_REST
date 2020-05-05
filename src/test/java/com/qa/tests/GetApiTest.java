package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase {
	
	TestBase testbase;
	String serviceURL;
	String ApiUrl;
	RestClient restclient ;
	String FinalURL;
	CloseableHttpResponse closeablehttpresponse;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException
	{
		testbase=new TestBase();
		serviceURL=prop.getProperty("URL");
		ApiUrl=prop.getProperty("Api");
		FinalURL=serviceURL + ApiUrl;
		
		System.out.println(FinalURL);
		
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException
	{
		restclient = new RestClient();
		
		closeablehttpresponse=restclient.get_with(FinalURL);
		
		int status_code=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println(status_code);
		Assert.assertEquals(Status_code_200, status_code);
		
		
		String RespomseBody=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		
		JSONObject myJsonObject = new JSONObject(RespomseBody);
		
		System.out.println(RespomseBody);
		
		
		
		
		String jsonExp = "$.data[0].id";
		 int id_0 = JsonPath.read(RespomseBody, jsonExp);
		 System.out.println("id 0 : "+id_0);
		
		
		
		
		
		
		
	}

}
