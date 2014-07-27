package edu.hacks.good.CommandHandler;

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
	public void handleCommand() {
		System.out.println("Illegal Command. Doing Nothing.");
		
	}

}
