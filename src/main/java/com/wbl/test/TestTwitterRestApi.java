package com.wbl.test;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.json.JSONObject;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/
import org.testng.annotations.Test;

import com.wbl.page.TwitterRestApi;

public class TestTwitterRestApi {

	TwitterRestApi twitter;
	HttpResponse response;

	@BeforeClass
	public void before() {

		twitter = new TwitterRestApi();

	}

	 
	@Test
	public void testGetAccountSettings() throws IllegalStateException, ParseException, IOException {

		// HttpResponse response = twitter.getData();

		response = twitter.getData();

		System.out.println(response.getStatusLine().getStatusCode());

		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

		/*
		 * until here its all HttpCleint. now we hv to parse the response and
		 * extract the json key value pair from the response we use org.json
		 * there are other libraries like googles simple json
		 * 
		 * IOUTils is used as json object may not parse the response string
		 * properly. IOUtils reads the response properly and sends it as the
		 * string
		 * 
		 */

		JSONObject jsonObj = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
		// get entity will give us thet actual response body entity
		// get content gives us the entire content which is converted to a
		// string and passing it to the json object constructor

		System.out.println(jsonObj.get("screen_name"));
		System.out.println(jsonObj.get("always_use_https"));
		System.out.println(jsonObj.get("geo_enabled"));

		Assert.assertEquals(jsonObj.get("screen_name"), "PalsPj");
		Assert.assertEquals(jsonObj.get("always_use_https"), true);
		Assert.assertEquals(jsonObj.get("geo_enabled"), false);

	}

	@Test
	public void testPostAccountUpdates() throws IllegalStateException, ParseException, IOException {

		HttpResponse response = twitter.postData();

		System.out.println(response.getStatusLine().getStatusCode());

		JSONObject jsonObj = new JSONObject(IOUtils.toString(response.getEntity().getContent()));

		System.out.println(jsonObj);

		System.out.println(jsonObj.get("screen_name"));
		System.out.println(jsonObj.get("name"));
		System.out.println(jsonObj.get("location"));

		Assert.assertEquals(jsonObj.get("screen_name"), "PalsPj");
		Assert.assertEquals(jsonObj.get("name"), "panks");
		Assert.assertEquals(jsonObj.get("location"), "Dublin");

		
	}

	
	
	@Test
	public void testPostMessage() throws IllegalStateException, ParseException, IOException {

		HttpResponse response = twitter.postMessage();

		System.out.println(response.getStatusLine().getStatusCode());
		
		System.out.println(response.getStatusLine().getReasonPhrase());


		/*JSONObject jsonObj = new JSONObject(IOUtils.toString(response.getEntity().getContent()));

		System.out.println(jsonObj);

		System.out.println(jsonObj.get("screen_name"));
		System.out.println(jsonObj.get("name"));
		System.out.println(jsonObj.get("location"));
*/
	}

}

