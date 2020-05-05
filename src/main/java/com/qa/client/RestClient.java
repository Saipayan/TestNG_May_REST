package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class RestClient {
	
	
	
	
	public CloseableHttpResponse get_with(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient httpclient=HttpClients.createDefault();
	
	HttpGet httpget=new HttpGet(url);
	httpget.addHeader("Content-Type", "application/json");
	
	
	
	CloseableHttpResponse closeablehttpresponse=httpclient.execute(httpget);
	return closeablehttpresponse;
	
	
	
	}
	
	public CloseableHttpResponse get_without(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpGet httpget=new HttpGet(url);
		httpget.addHeader("Content-Type", "application/json");
		
		
		
		CloseableHttpResponse closeablehttpresponse=httpclient.execute(httpget);
		return closeablehttpresponse;
		
		
		
		}
	
	public CloseableHttpResponse  post(String Request,String URL) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response=null;

		try {
		    HttpPost request = new HttpPost(URL);
		    //StringEntity params = new StringEntity(Request.toString());
		    request.addHeader("content-type", "application/json");
		    request.setEntity(new StringEntity(Request, Charset.forName("UTF-8")));
		    //request.seten
		    response = httpClient.execute(request);
		    
		// handle response here...
		} catch (Exception ex) {
		    // handle exception here
		} finally {
		    httpClient.close();
		}
		
		return response ;
	}
	
	
}


	
	

