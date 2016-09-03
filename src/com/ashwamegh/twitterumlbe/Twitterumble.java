package com.ashwamegh.twitterumlbe;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class Twitterumble {

	static String consumerKeyStr = "Place your consumer key here.";
	static String consumerSecretStr = "Place your consumer Secret key here.";
	static String accessTokenStr = "Place your Access Token here.";
	static String accessTokenSecretStr = "Place your Access Token Secret here.";


	public static void main(String[] args) throws Exception {
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,
				consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

		HttpPost httpPost = new HttpPost(
				"https://api.twitter.com/1.1/statuses/update.json?status=Testing%20Twitterumble.");

		oAuthConsumer.sign(httpPost);

		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpPost);

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode + ':'
				+ httpResponse.getStatusLine().getReasonPhrase());
		System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));

	}
}
