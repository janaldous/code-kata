package com.janaldous.codekata.businessrules.rule;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.operation.Command;

public abstract class AbstractBusinessRule implements IBusinessRule {

	protected abstract boolean fulfillsCondition(Payment payment);
	
	protected abstract Command command(Payment payment);
	
	@Override
	public Command getCommand(Payment payment) {
		if (fulfillsCondition(payment)) {
			return command(payment);
		}
		return null;
	}

}
