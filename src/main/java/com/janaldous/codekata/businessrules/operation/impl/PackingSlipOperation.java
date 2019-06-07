package com.janaldous.codekata.businessrules.operation.impl;

import lombok.EqualsAndHashCode;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.operation.AbstractPaymentOperation;

@EqualsAndHashCode(callSuper=false)
public class PackingSlipOperation extends AbstractPaymentOperation {
	
	public PackingSlipOperation(Payment payment) {
		super(payment);
	}

	@Override
	public void execute() {
		// generate packing slip
	}

}
