package edu.hacks.good;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.base.Preconditions;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnection {

	public static Twitter create(){
		createConnection();
		return twitter;
	}
	
	private static Twitter twitter;
	
	private static void createConnection(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(AuthenticationKeys.TWITTER_CONSUMER_KEY)
			.setOAuthConsumerSecret(AuthenticationKeys.TWITTER_CONSUMER_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        System.out.println("-----");
        try{
        // get request token.
        // this will throw IllegalStateException if access token is already available
        // this is oob, desktop client version
        RequestToken requestToken = twitter.getOAuthRequestToken(); 
 
        System.out.println("Got request token.");
        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Request token secret: " + requestToken.getTokenSecret());
 
        System.out.println("|-----");
 
        AccessToken accessToken = null;
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
            String pin = br.readLine();
        
            try{
                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
                }
            } catch (TwitterException te) {
                if (401 == te.getStatusCode()) {
                    System.out.println("Unable to get the access token.");
                } else {
                    te.printStackTrace();
                }
            }
        }
        System.out.println("Got access token.");
        System.out.println("Access token: " + accessToken.getToken());
        System.out.println("Access token secret: " + accessToken.getTokenSecret());
         
	    } catch (IllegalStateException ie) {
	        // access token is already available, or consumer key/secret is not set.
	        if (!twitter.getAuthorization().isEnabled()) {
	            System.out.println("OAuth consumer key/secret is not set.");
	            System.exit(-1);
	        }
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        TwitterConnection.twitter = twitter;
	}
	
	public static Twitter getTwitterInstance(){
		Preconditions.checkArgument(hasConnection(), "Twitter COnnection is not set up.");
		return twitter;
	}
	
	public static boolean hasConnection(){
		return twitter != null;
	}
}
