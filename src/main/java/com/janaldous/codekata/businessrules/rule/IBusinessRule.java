package com.janaldous.codekata.businessrules.rule;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.operation.Command;

public interface IBusinessRule {
	
	Command getCommand(Payment payment);

}
