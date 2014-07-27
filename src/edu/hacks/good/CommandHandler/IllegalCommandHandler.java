package edu.hacks.good.CommandHandler;

import twitter4j.Status;
import edu.hacks.good.SystemCommand;

public class IllegalCommandHandler implements CommandHandler {

	public static IllegalCommandHandler create(){
		return new IllegalCommandHandler();
	}
	
	private IllegalCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.ILLEGAL_COMMAND;
	}

	@Override
	public void handleCommand(Status status) {
		System.out.println("Illegal Command. Doing Nothing.");
		
	}

}
