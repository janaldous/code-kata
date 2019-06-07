package com.janaldous.codekata.businessrules.rule.impl;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.domain.PhysicalOrder;
import com.janaldous.codekata.businessrules.domain.PhysicalOrderType;
import com.janaldous.codekata.businessrules.operation.Command;
import com.janaldous.codekata.businessrules.operation.impl.AgentCommissionPaymentOperation;
import com.janaldous.codekata.businessrules.rule.AbstractBusinessRule;

public class ProductRule2 extends AbstractBusinessRule {

	@Override
	protected boolean fulfillsCondition(Payment payment) {
		if (payment.getOrder() != null && payment.getOrder() instanceof PhysicalOrder) {
			PhysicalOrder order = (PhysicalOrder) payment.getOrder();
			return order.getType() == PhysicalOrderType.BOOK
					|| order.getType() == PhysicalOrderType.OTHER; 
		}
		return false;
	}

	@Override
	protected Command command(Payment payment) {
		return (Command) new AgentCommissionPaymentOperation(payment);
	}

}
