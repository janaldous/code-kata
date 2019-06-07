package com.janaldous.codekata.businessrules.domain;

import java.util.List;

import lombok.Data;

import com.janaldous.codekata.businessrules.operation.Command;

/**
 * from http://codekata.com/kata/kata16-business-rules/
 * @author janaldoustorres
 */
@Data
public class Payment {
	private PaymentType type;
	private Order order;
	private List<Command> operations;
}
