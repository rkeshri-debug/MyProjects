/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.testcases;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.module.PostAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


public class APIPost {
	
	@Test
	public void succesTest() {
		int randNumber = (int)(Math.random() * 100000);
    	String randomMail = "post"+randNumber+"@testmaildomain.com";
    	PostAPI.executeApi(randomMail);
    	PostAPI.searchIn();
    	PostAPI.validateAnalyser();
	}
}

