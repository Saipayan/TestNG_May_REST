package com.qa.tests;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class POSTAPI  extends TestBase{

	
	TestBase testbase;
	String serviceURL;
	String ApiUrl;
	RestClient restclient ;
	String FinalURL;
	String Request_body="{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
	CloseableHttpResponse closeableHttpResponse;
	
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
		
		System.out.println("Hello World!!!");
		closeableHttpResponse=restclient.post(Request_body, FinalURL);
	    
		// Get HttpResponse Status
        System.out.println(closeableHttpResponse.getProtocolVersion());              // HTTP/1.1
        System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());   // 200
        System.out.println(closeableHttpResponse.getStatusLine().getReasonPhrase()); // OK
        System.out.println(closeableHttpResponse.getStatusLine().toString());        // HTTP/1.1 200 OK
        HttpEntity  entity = closeableHttpResponse.getEntity();
        if (entity != null) {
            // return it as a String
            String result = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            System.out.println(result);
        }
	
	}
	
	
	
	
	
	
	
	
	
}
