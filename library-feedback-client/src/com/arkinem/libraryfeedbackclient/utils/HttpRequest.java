package com.arkinem.libraryfeedbackclient.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.OutputStream;
import org.json.*;

public class HttpRequest {
	
	private static final String serviceBaseUrl = "http://localhost:8080/api";

	private static final String POST_PARAMS = "userName=Pankaj";


	public static String sendGet(String endpointUrl) throws IOException {
		
		URL url = new URL(serviceBaseUrl + endpointUrl);
		System.out.println(url);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		
		int responseCode = connection.getResponseCode();
		//System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();

			// print result
			System.out.println("response: " + response.toString());
			
			return response.toString();

		} else {
			System.out.println("GET request failed.");
			return "";
		}
	}

//	private static void sendPOST() throws IOException {
//		URL obj = new URL(POST_URL);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod("POST");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//
//		// For POST only - START
//		con.setDoOutput(true);
//		OutputStream os = con.getOutputStream();
//		os.write(POST_PARAMS.getBytes());
//		os.flush();
//		os.close();
//		// For POST only - END
//
//		int responseCode = con.getResponseCode();
//		System.out.println("POST Response Code :: " + responseCode);
//
//		if (responseCode == HttpURLConnection.HTTP_OK) { //success
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					con.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//
//			// print result
//			System.out.println(response.toString());
//		} else {
//			System.out.println("POST request not worked");
//		}
//	}
 }