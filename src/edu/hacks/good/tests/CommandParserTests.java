package edu.hacks.good.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.hacks.good.CommandParser;
import edu.hacks.good.SystemCommand;

public class CommandParserTests {
	
	@Test
	public void TestShutdownReturnsProperCommand(){
		SystemCommand systemCommand = CommandParser.parseCommand("Shutdown");
		assertEquals(SystemCommand.SHUTDOWN, systemCommand);
	}
}
