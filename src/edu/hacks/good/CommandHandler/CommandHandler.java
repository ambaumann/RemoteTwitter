package edu.hacks.good.CommandHandler;

import edu.hacks.good.SystemCommand;

public interface CommandHandler {
	public SystemCommand getCommandType();
	public void handleCommand();
}
