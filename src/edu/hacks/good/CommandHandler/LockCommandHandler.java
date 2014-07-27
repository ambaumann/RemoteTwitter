package edu.hacks.good.CommandHandler;

import java.io.IOException;

import twitter4j.Status;
import twitter4j.TwitterException;
import edu.hacks.good.PostReply;
import edu.hacks.good.SystemCommand;
import edu.hacks.good.TwitterConnection;

public class LockCommandHandler implements CommandHandler {

	public static LockCommandHandler create(){
		return new LockCommandHandler();
	}
	
	private LockCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.LOCK;
	}

	@Override
	public void handleCommand(Status status) {
		try {
			TwitterConnection.getTwitterInstance().destroyStatus(status.getId());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostReply.postReply("Command worked! Compter will lock.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("rundll32.exe user32.dll, LockWorkStation");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Lock Command Succeeded");
		//System.exit(0);

	}
}
