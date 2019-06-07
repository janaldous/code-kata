package com.janaldous.codekata.businessrules;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.janaldous.codekata.businessrules.operation.Command;

public class CommandExecutionTest {

	private List<String> output;
	
	private class SampleCommand implements Command {

		@Override
		public void execute() {
			output.add("sample command");
		}
		
	}
	
	@Test
	public void testCommandExecution() {
		List<Command> operations = new ArrayList<>();
		output = new ArrayList<>();
		operations.add(new SampleCommand());
		operations.add(new SampleCommand());
		
		assertEquals(0, output.size());
		
		CommandExecutor ce = new CommandExecutor();
		ce.execute(operations);
		
		assertEquals(2, output.size());
	}
	
}
