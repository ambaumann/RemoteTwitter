package edu.hacks.good;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class PostReply {
	public static void postReply(String toPost){
		Twitter twitter = TwitterConnection.getTwitterInstance();
		try {
			twitter.updateStatus(new StatusUpdate(toPost + " #ToPhone"));
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
