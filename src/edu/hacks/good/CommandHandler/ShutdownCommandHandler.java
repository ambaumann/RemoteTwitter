package edu.hacks.good.CommandHandler;

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
		Runtime.getRuntime();
		//			runtime.exec("shutdown -s -t 0");
		System.out.println("Shutdown Command Succeeded");
		//System.exit(0);
		try {
			TwitterConnection.getTwitterInstance().destroyStatus(status.getId());
			PostReply.postReply("Shutdown worked! Yo have big balls.");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
