package com.janaldous.codekata.businessrules.tree;

import java.util.ArrayList;
import java.util.List;

import com.janaldous.codekata.businessrules.rule.IBusinessRule;

public class BusinessRuleNode {
	private List<BusinessRuleNode> children;
	private IBusinessRule rule;
	
	public BusinessRuleNode(IBusinessRule rule) {
		this.children = new ArrayList<BusinessRuleNode>();
		this.rule = rule;
	}
	
	public IBusinessRule value() {
		return rule;
	}
	
	public void addChild(BusinessRuleNode node) {
		this.children.add(node);
	}
	
	public List<BusinessRuleNode> children() {
		return this.children;
	}
}
