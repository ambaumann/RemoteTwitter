package edu.hacks.good.CommandHandler;

import twitter4j.Status;
import edu.hacks.good.SystemCommand;

public class RestartCommandHandler implements CommandHandler {

	public static RestartCommandHandler create(){
		return new RestartCommandHandler();
	}
	
	private RestartCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.RESTART;
	}

	@Override
	public void handleCommand(Status status) {
		//			runtime.exec("shutdown -r -t 0");
		System.out.println("Restart Command Succeeded");
		//System.exit(0);

	}
}
