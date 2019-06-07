package com.janaldous.codekata.businessrules.tree;

import java.util.Iterator;
import java.util.Stack;

import com.janaldous.codekata.businessrules.rule.IBusinessRule;

public class TreeIterator {
	private Stack<BusinessRuleNode> stack;
 
	public TreeIterator(BusinessRuleNode root) {
		this.stack = new Stack<BusinessRuleNode>();
		if (root != null) {
			stack.push(root);
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	// need to optimize not to go through branch if parent node 
	// does not fulfillCondition
	public IBusinessRule next() {
		BusinessRuleNode node = stack.pop();
		IBusinessRule result = node.value();
		Iterator<BusinessRuleNode> iter = node.children().iterator();
		
		while(iter.hasNext()) {
			node = iter.next();
			stack.push(node);
		}

		return result;
	}
}
