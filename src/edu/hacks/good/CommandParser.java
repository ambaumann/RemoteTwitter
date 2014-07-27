package edu.hacks.good;

public class CommandParser {

	public static SystemCommand parseCommand(String command){
		for(SystemCommand systemCommand : SystemCommand.values()){
			if(systemCommand.toString().equalsIgnoreCase(command)){
				return systemCommand;
			}
		}
		return SystemCommand.ILLEGAL_COMMAND;
		
	}
	
}
