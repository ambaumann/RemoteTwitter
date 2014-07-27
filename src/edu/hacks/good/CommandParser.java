package edu.hacks.good;

public class CommandParser {

	public static SystemCommand parseCommand(String command){
		for(SystemCommand systemCommand : SystemCommand.values()){
			if(command.toString().toUpperCase().startsWith(systemCommand.toString().toUpperCase())){
				return systemCommand;
			}
		}
		return SystemCommand.ILLEGAL_COMMAND;
		
	}
	
}
