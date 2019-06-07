package com.janaldous.codekata.businessrules.rule.impl;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.domain.PaymentType;
import com.janaldous.codekata.businessrules.operation.Command;
import com.janaldous.codekata.businessrules.operation.impl.PackingSlipOperation;
import com.janaldous.codekata.businessrules.rule.AbstractBusinessRule;

public class ProductRule extends AbstractBusinessRule {

	@Override
	protected boolean fulfillsCondition(Payment payment) {
		return PaymentType.PRODUCT == payment.getType();
	}
	
	@Override
	protected Command command(Payment payment) {
		return (Command) new PackingSlipOperation(payment);
	}
}
