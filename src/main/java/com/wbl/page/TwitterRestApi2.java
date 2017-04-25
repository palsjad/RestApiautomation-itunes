package com.wbl.page;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.wbl.helper.Constants;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

 
public class TwitterRestApi2 {
	
	public HttpResponse getData() {
		
		
		HttpResponse response = null;
		
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(Constants.GETURL);
		
		get.addHeader("content-type", "application/json");
//		
//		OAuthConsumer consumer = new CommonsHttpOAuthConsumer("rilzXBpc5zOXdpP7du0zLn3ae","eAVh2P4zTs9fZspmMyUW2VKOPt2S6lbZcoqTN81fKZxOoaiojI");
//		consumer.setTokenWithSecret("3139129795-IczF26keA2NUYX7mjZLaDVoVv9tkSnvRcjukFuc", "t6Bzp4D3hf7avymUkzJ9mLmKyh2syYo4cQkc2C0oFOvuJ");
//	 	
		
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY,Constants.CONSUMER_SECRET);
		consumer.setTokenWithSecret(Constants.ACCESS_TOKEN,Constants.TOKEN_SECRET);
				
		try 
		
		{
			
			consumer.sign(get);

			response = client.execute(get);
		 	 
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthMessageSignerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (OAuthExpectationFailedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (OAuthCommunicationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return response;
	}

	 
		
		public HttpResponse postData() {
			
			
			HttpResponse response = null;
			
			HttpClient client = HttpClientBuilder.create().build();
			
			HttpPost post = new HttpPost("https://api.twitter.com/1.1/account/update_profile.json");
			
		
			
			try {
				//creating the request data
				
			JSONObject obj = new JSONObject(); // here to create the request data we create the HJSONObject lcass .
	 
			obj.put("name",  "Pankaj");
			obj.put("location",  "Dublin");
			StringEntity entity = new StringEntity(obj.toString());
			
			//setting the request entity / payload to post method
			post.setEntity(entity);
			
			post.addHeader("content-type", "application/json");
			
			OAuthConsumer consumer = new CommonsHttpOAuthConsumer("rilzXBpc5zOXdpP7du0zLn3ae","eAVh2P4zTs9fZspmMyUW2VKOPt2S6lbZcoqTN81fKZxOoaiojI");
			consumer.setTokenWithSecret("3139129795-IczF26keA2NUYX7mjZLaDVoVv9tkSnvRcjukFuc", "t6Bzp4D3hf7avymUkzJ9mLmKyh2syYo4cQkc2C0oFOvuJ");
		 
				
				consumer.sign(post);

				response = client.execute(post);
			 	 
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OAuthMessageSignerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OAuthExpectationFailedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OAuthCommunicationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			return response;
		}

}



//***************************************************************************************//

//here we are using the google simple json

/*
* 
* String jsonStr = IOUtils.toString(response.getEntity().getContent());
* 
* JSONParser parser = new JSONParser();
* 
* JSONObject jsonObj = (JSONObject) parser.parse(jsonStr);
* 
* 
* JSONArray jsonArr = new JSONArray();
* 
* 
* // jsonArr = (JSONArray) parser.parse(json );
* 
* 
* ;
* 
* if(jsonArr.size()>0){ for (Object data : jsonArr) { JSONObject jsonrow =
* (JSONObject) parser.parse(String.valueOf(data));
* 
* String User_Id= (String)jsonrow.get("screen_name"); // Each User_Id will be
* displayed. String temp = (String)jsonrow.get("always_use_https"); }
* 
* } else { System.out.println("Empty Array...."); }
*/

/*
* 
* 
* for (int i = 0; i < array.length(); i++) { JSONObject object =
* array.getJSONObject(i)System.out.println("the id is {}",
* object.getInt("id")); System.out.println("the insertDate is {}",
* object.getString("insertDate")); System.out.println("read is {}",
* object.getBoolean("read")); System.out.println("the site is {}",
* object.getString("site")); System.out.println("the Email is {}",
* object.getString("Email")); System.out.println("the location is {}",
* object.getString("location"));
* 
* }
*/

