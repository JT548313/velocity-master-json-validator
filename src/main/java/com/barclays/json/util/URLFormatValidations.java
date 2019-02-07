package com.barclays.json.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.barclays.MasterJsonValidatorConstants;
import com.barclays.json.beans.Message;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class URLFormatValidations {
	// Check URL Format
	// Check for working URL

	private static final String USER_AGENT = "Mozilla/5.0";

	public static ArrayList<Message> validateURLFormat(String url) {
		System.out.println("Input URL: " + url);
		ArrayList<Message> messages = new ArrayList<Message>();

		// Description should be alphanumeric and char Limit: 512 chars
		if (!Pattern.matches(MasterJsonValidatorConstants.URL_FORMAT_REGEX, url)) {
			Message m = new Message();
			m.setClassName("Clone URL Validation");
			m.setErrDesc(
					"Incorrect URL format. \nHttps and ssh are only allowed protocols. \nClone URL should end with *.git\n"
							+ "Example URL: \"https://git@stash.barcapint.com:3456/buk_bukcprf/osv3_preflight.git\"\r\ninput URL: \""
							+ url + "\"");
			messages.add(m);
		}
		return messages;

	}

	/*
	 * To check for running instance
	 */
	@SuppressWarnings("unused")
	private static void sendGET(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			// print result
			System.out.println(responseCode);
		} else {
			System.out.println("GET request not worked");
		}

	}
}
