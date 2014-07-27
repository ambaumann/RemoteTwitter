package edu.hacks.good;
import java.io.IOException;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

	public static boolean exit = false;
	
	public static void main(String[] args){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(AuthenticationKeys.TWITTER_ACCESS_TOKEN)
			.setOAuthConsumerSecret(AuthenticationKeys.TWITTER_ACCESS_TOKEN_SECRET)
			.setOAuthAccessToken(AuthenticationKeys.TWITTER_CONSUMER_KEY)
			.setOAuthAccessTokenSecret(AuthenticationKeys.TWITTER_CONSUMER_SECRET);
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		
		//twitter.addListener(listener);
		while(true){
			try {
				twitter.verifyCredentials();
			} catch (TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Paging paging = new Paging();
			paging.setCount(1);
			try {
				ResponseList<Status> statuses = twitter.getHomeTimeline(paging);
				handleStatus(twitter, statuses.get(0));
			} catch (TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Yo");
			try {
				Thread.sleep(120 * 1000);
			} catch (InterruptedException e) {
			}
		}
	}
	private static void shutdown() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("shutdown -s -t 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	private static void handleStatus(Twitter twitter, Status status) {
		System.out.println("doing nothing");
		switch(status.getText()){
			case "Restart":
			try {
				twitter.destroyStatus(0);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				shutdown();
				break;
			default:
				System.out.println("doing nothing");
				break;
		}
		System.out.println("doing nothing");
		
	}
}
