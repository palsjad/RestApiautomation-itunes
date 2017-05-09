package com.wbl.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.wbl.helper.Constants;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class TwitterRestApi {

	public HttpResponse getData() {

		HttpResponse response = null;

		HttpClient client = HttpClientBuilder.create().build();

		HttpGet get = new HttpGet(Constants.GETURL);

		get.addHeader("content-type", "application/json");
		 
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
		consumer.setTokenWithSecret(Constants.ACCESS_TOKEN, Constants.TOKEN_SECRET);

		try

		{

			consumer.sign(get);

			response = client.execute(get);

		} catch (ClientProtocolException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		} catch (OAuthMessageSignerException e1) {
 			e1.printStackTrace();
		} catch (OAuthExpectationFailedException e1) {
 			e1.printStackTrace();
		} catch (OAuthCommunicationException e1) {
 			e1.printStackTrace();
		}
		

		return response;
	}

// *********************************************************************************************

	public HttpResponse postData() {

		HttpResponse response = null;

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(Constants.POSTURL);

		try {
			// creating the request data
			
// We can create 			

			JSONObject obj = new JSONObject(); // here to create the request data we create the HJSONObject lcass .

			obj.put("name", "Pankaj");
			obj.put("location", "Dublin");
			
			
			StringEntity entity = new StringEntity(obj.toString());
			

			// setting the request entity payload to post method
			
			post.setEntity(entity);
		
			
/*
			
//*********************************************************************************			
// request data can be created with NameValuePair too as following
			
			List<NameValuePair> pair = new ArrayList<NameValuePair>();
			pair.add( new BasicNameValuePair("name", "Pankaj"));
			pair.add( new BasicNameValuePair("location", "Dublin"));
			
			post.setEntity(new UrlEncodedFormEntity(pair));
//*********************************************************************************			
*/
			

			post.addHeader("content-type", "application/json");


			OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
			consumer.setTokenWithSecret(Constants.ACCESS_TOKEN, Constants.TOKEN_SECRET);

			consumer.sign(post);

			response = client.execute(post);

		} catch (ClientProtocolException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		} catch (OAuthMessageSignerException e1) {
 			e1.printStackTrace();
		} catch (OAuthExpectationFailedException e1) {
 			e1.printStackTrace();
		} catch (OAuthCommunicationException e1) {
 			e1.printStackTrace();
		}
		

		return response;
	}

// *********************************************************************************************
 
	
	public HttpResponse postMessage() {

		HttpResponse response = null;

		HttpClient client = HttpClientBuilder.create().build();
 

		HttpPost post1 = new HttpPost(Constants.POSTURL1);

		try {
 
			JSONObject obj = new JSONObject();  
			
			JSONObject obj1 = new JSONObject();  
			
			 

			/*
				{		 
				  "event": {
				    		"type": "message_create",
			    			"message_create": {      "target": {
				                                                  "recipient_id": "856678409467871232"
				                                           },
				                                           
				                               "message_data": {
				                                                  "text": "Hello timepassPJ!"
				                                           }
				                              }
			                 }
				}
			  
			
			
			obj.put("type", "message_create");
			obj.put("message_create.target.recipient_id", "856678409467871232");
//			obj.put("message_create.message_data", "Hello World!");
		*/
			
			JSONObject obj2 = new JSONObject();  

 			obj1.put("text", "Hello World!");
 			obj2.put("message_data", obj1);
 			
			JSONObject obj3 = new JSONObject();  
			JSONObject obj4 = new JSONObject();  

			obj3.put("recipient_id", "856678409467871232");
			obj4.put("target", obj3);
			
			JSONObject obj5 = new JSONObject();  
			obj5.put("message_create", obj2);
			obj5.put("message_create", obj4);

			
			JSONObject obj6 = new JSONObject();  
			obj6.put("type", "message_create");
			
			
			JSONObject obj7 =  new JSONObject();  
 			
			obj7.put("event", obj6);
			obj7.put("event", obj5);


 			
		/*	obj.put("type", "message_create");
			obj.put("message_create.target.recipient_id", "856678409467871232");
//			obj.put("message_create.message_data", "Hello World!");
 			obj.put("message_create.message_data.text", "Hello World!");
 			
 		*/
 			 
 		
 		 
 		 

  		StringEntity entity = new StringEntity(obj7.toString());
  		
  		System.out.println("entity : " + entity.toString()  );
 	 	
 	 //		obj1.put("event", new obj.toString());
 			
 	//		obj1.put("event", obj);
  			 
 //			StringEntity entity = new StringEntity(obj1.toString());
 

 
			post1.setEntity(entity);
			

	//		post1.addHeader("content-type", "application/json");

			OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
			consumer.setTokenWithSecret(Constants.ACCESS_TOKEN, Constants.TOKEN_SECRET);

 
			consumer.sign(post1);
 
			response = client.execute(post1);
 
		} catch (ClientProtocolException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		} catch (OAuthMessageSignerException e1) {
 			e1.printStackTrace();
		} catch (OAuthExpectationFailedException e1) {
 			e1.printStackTrace();
		} catch (OAuthCommunicationException e1) {
 			e1.printStackTrace();
		}

		
		return response;
		
	}

}
