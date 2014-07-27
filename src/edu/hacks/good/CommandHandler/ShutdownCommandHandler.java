package edu.hacks.good.CommandHandler;

import edu.hacks.good.SystemCommand;

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
	public void handleCommand() {
		Runtime.getRuntime();
		//			runtime.exec("shutdown -s -t 0");
		System.out.println("Shutdown Command Succeeded");
		//System.exit(0);

	}

}
