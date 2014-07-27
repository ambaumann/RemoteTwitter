package edu.hacks.good.tests;

import java.util.Date;

import org.junit.Test;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Scopes;
import twitter4j.Status;
import twitter4j.SymbolEntity;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import edu.hacks.good.CommandHandler.SoundControlCommandHandler;

public class SoundControlCommandHandlerTests {

	@SuppressWarnings("serial")
	@Test
	public void testSoundIsTurnedAllTheWayUp(){
		SoundControlCommandHandler handler = SoundControlCommandHandler.create();
		handler.handleCommand(new Status(){

			@Override
			public int compareTo(Status o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public RateLimitStatus getRateLimitStatus() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getAccessLevel() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public UserMentionEntity[] getUserMentionEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public URLEntity[] getURLEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HashtagEntity[] getHashtagEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public MediaEntity[] getMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public MediaEntity[] getExtendedMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public SymbolEntity[] getSymbolEntities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Date getCreatedAt() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getText() {
				return "VOLUME 99";
			}

			@Override
			public String getSource() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isTruncated() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public long getInReplyToStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getInReplyToUserId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getInReplyToScreenName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GeoLocation getGeoLocation() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Place getPlace() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isFavorited() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRetweeted() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int getFavoriteCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public User getUser() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isRetweet() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Status getRetweetedStatus() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long[] getContributors() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getRetweetCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isRetweetedByMe() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public long getCurrentUserRetweetId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isPossiblySensitive() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String getLang() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Scopes getScopes() {
				// TODO Auto-generated method stub
				return null;
			}});
	}
}
