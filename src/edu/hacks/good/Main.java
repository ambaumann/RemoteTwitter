package edu.hacks.good;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import edu.hacks.good.CommandHandler.CommandHandler;

public class Main {

	public static boolean exit = false;
	
	public static void main(String[] args){
		
		Twitter twitter = TwitterConnection.create();
		
		while(true){
			Paging paging = new Paging();
			paging.setCount(1);
			
				ResponseList<Status> statuses;
				try {
					statuses = twitter.getHomeTimeline(paging);
					handleStatus(twitter, statuses.get(0));
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
				System.out.println("Yo");
				System.out.println(System.getProperty("user.home"));
				try {
					Thread.sleep(120 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
		
	
	
	private static void handleStatus(Twitter twitter, Status status) {
		System.out.println(status.toString() +" " + status.toString());
		SystemCommand systemCommand = CommandParser.parseCommand(status.getText());
		CommandHandler commandHandler = CommandHandlerFactory.getCommandHandler(systemCommand);
		commandHandler.handleCommand(status);
	}
}
