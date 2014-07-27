package edu.hacks.good.CommandHandler;

import twitter4j.Status;
import edu.hacks.good.SystemCommand;

public interface CommandHandler {
	public SystemCommand getCommandType();
	public void handleCommand(Status status);
}
