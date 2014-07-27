package edu.hacks.good.CommandHandler;

import java.io.IOException;

import twitter4j.Status;
import twitter4j.TwitterException;
import edu.hacks.good.PostReply;
import edu.hacks.good.SystemCommand;
import edu.hacks.good.TwitterConnection;

public class ShutdownCommandHandler implements CommandHandler {
	
	public static ShutdownCommandHandler create(){
		return new ShutdownCommandHandler();
	}
	
	private ShutdownCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.SHUTDOWN;
	}

	@Override
	public void handleCommand(Status status) {
		Runtime runtime = Runtime.getRuntime();
		//		
		System.out.println("Command Succeeded");
		
		try {
			TwitterConnection.getTwitterInstance().destroyStatus(status.getId());
			PostReply.postReply("Command worked! Yo have big balls.");
			Thread.sleep(1500);
			runtime.exec("shutdown -s -t 0");
			System.exit(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
