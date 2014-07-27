
package edu.hacks.good.CommandHandler;

import java.io.IOException;

import twitter4j.Status;
import twitter4j.TwitterException;

import com.google.common.base.Preconditions;

import edu.hacks.good.SystemCommand;
import edu.hacks.good.TwitterConnection;

public class FileHandler implements CommandHandler {
	
	public static FileHandler create(){
		return new FileHandler();
	}

	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.SCRIPT;
	}

	@Override
	public void handleCommand(Status status) {
			String[] strings = status.getText().split("\\s+");
			Preconditions.checkArgument(strings.length == 2, "Incorrect number of arguments.");
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
				runtime.exec("C:\\RemoteTwitter\\Scripts\\"+ strings[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

