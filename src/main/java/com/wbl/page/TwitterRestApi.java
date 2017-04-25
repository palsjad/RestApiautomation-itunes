package com.wbl.page;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
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

			JSONObject obj = new JSONObject(); // here to create the request data we create the HJSONObject lcass .

			obj.put("name", "Pankaj");
			obj.put("location", "Dublin");
			
			
			StringEntity entity = new StringEntity(obj.toString());

			// setting the request entity payload to post method
			
			post.setEntity(entity);

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
			
			
			/*
			 * { "event": { "type": "message_create", "message_create": {
			 * "target": { "recipient_id": "844385345234" }, "message_data": {
			 * "text": "Hello World!",} } } }
			 */

			obj.put("type", "message_create");
			obj.put("message_create.target.recipient_id", "856678409467871232");
			obj.put("message_create.message_data", "Hello World!");

			StringEntity entity = new StringEntity(obj.toString());

 
			post1.setEntity(entity);

			post1.addHeader("content-type", "application/json");

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
