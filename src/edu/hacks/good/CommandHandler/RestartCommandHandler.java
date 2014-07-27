package edu.hacks.good.CommandHandler;

import java.io.IOException;

import twitter4j.Status;
import twitter4j.TwitterException;
import edu.hacks.good.SystemCommand;
import edu.hacks.good.TwitterConnection;

public class RestartCommandHandler implements CommandHandler {

	public static RestartCommandHandler create(){
		return new RestartCommandHandler();
	}
	
	private RestartCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.RESTART;
	}

	@Override
	public void handleCommand(Status status) {
		try {
			TwitterConnection.getTwitterInstance().destroyStatus(status.getId());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PostReply.postReply("Command worked! ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("shutdown -r -t 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Restart Command Succeeded");
		System.exit(0);

	}
}
