package com.janaldous.codekata.businessrules.operation.impl;

import lombok.EqualsAndHashCode;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.operation.AbstractPaymentOperation;

@EqualsAndHashCode(callSuper=false)
public class PackingSlipDuplicationOperation extends AbstractPaymentOperation  {

	public PackingSlipDuplicationOperation(Payment payment) {
		super(payment);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
