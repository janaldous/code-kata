package com.janaldous.codekata.businessrules.operation;

import com.janaldous.codekata.businessrules.domain.Payment;

public abstract class AbstractPaymentOperation implements Command {
	
	@SuppressWarnings("unused")
	private Payment payment;
	
	public AbstractPaymentOperation(Payment payment) {
		this.payment = payment;
	}
	
}
