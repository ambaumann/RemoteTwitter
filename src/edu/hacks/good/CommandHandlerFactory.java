package edu.hacks.good;

import java.util.HashMap;
import java.util.Map;

import edu.hacks.good.CommandHandler.CommandHandler;
import edu.hacks.good.CommandHandler.IllegalCommandHandler;
import edu.hacks.good.CommandHandler.ShutdownCommandHandler;

public class CommandHandlerFactory {
	private static Map<SystemCommand, CommandHandler> getCommandHandler(){
		if(commandHandlers.isEmpty()){
			commandHandlers.put(SystemCommand.SHUTDOWN, ShutdownCommandHandler.create());
			commandHandlers.put(SystemCommand.ILLEGAL_COMMAND, IllegalCommandHandler.create());
		}
		return commandHandlers;
	}
	
	private static Map<SystemCommand, CommandHandler> commandHandlers = new HashMap<SystemCommand, CommandHandler>();
	
	public static CommandHandler getCommandHandler(SystemCommand systemCommand){
		if(getCommandHandler().containsKey(systemCommand)){
			return getCommandHandler().get(systemCommand);
		}else{
			throw new IllegalArgumentException();
		}
	}
}
