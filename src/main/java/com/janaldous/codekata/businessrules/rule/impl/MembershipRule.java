package com.janaldous.codekata.businessrules.rule.impl;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.domain.PaymentType;
import com.janaldous.codekata.businessrules.operation.Command;
import com.janaldous.codekata.businessrules.operation.impl.MembershipPaymentOperation;
import com.janaldous.codekata.businessrules.rule.AbstractBusinessRule;

public class MembershipRule extends AbstractBusinessRule {

	@Override
	public boolean fulfillsCondition(Payment payment) {
		return PaymentType.MEMBERSHIP == payment.getType();
	}

	@Override
	protected Command command(Payment payment) {
		return (Command) new MembershipPaymentOperation(payment);
	}

}
