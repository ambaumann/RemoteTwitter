package edu.hacks.good.CommandHandler;

import twitter4j.Status;
import edu.hacks.good.SystemCommand;

public class LockCommandHandler implements CommandHandler {

	public static LockCommandHandler create(){
		return new LockCommandHandler();
	}
	
	private LockCommandHandler(){}
	
	@Override
	public SystemCommand getCommandType() {
		return SystemCommand.LOCK;
	}

	@Override
	public void handleCommand(Status status) {
		Runtime.getRuntime();
		//			runtime.exec("rundll32.exe user32.dll, LockWorkStation");
		System.out.println("Lock Command Succeeded");
		//System.exit(0);

	}
}
