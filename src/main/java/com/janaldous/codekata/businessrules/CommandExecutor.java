package com.janaldous.codekata.businessrules;

import java.util.List;

import com.janaldous.codekata.businessrules.operation.Command;

public class CommandExecutor {
	
	public void execute(List<Command> commands) {
		for(Command command: commands) {
			command.execute();
		}
	}
	
}
