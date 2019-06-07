package com.janaldous.codekata.businessrules.tree;

import java.util.ArrayList;
import java.util.List;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.operation.Command;
import com.janaldous.codekata.businessrules.rule.IBusinessRule;

public class BusinessRuleTree {
	
	private TreeIterator iter;
	
	public BusinessRuleTree(BusinessRuleNode root) {
		this.iter = new TreeIterator(root);
	}
	
	public List<Command> getOperations(Payment payment) {
		List<Command> operations = new ArrayList<Command>();
		
		while (iter.hasNext()) {
			IBusinessRule rule = iter.next();
			if (rule != null) {
				Command command = rule.getCommand(payment);
				if (command != null) {
					operations.add(command);
				}
			}
		}
		
		return operations;
	}
	
}
