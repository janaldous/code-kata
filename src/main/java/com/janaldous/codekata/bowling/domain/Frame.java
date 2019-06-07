package com.janaldous.codekata.bowling.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Frame {
	protected Score try1;
	protected Score try2;
	protected int rolls;
	
	public Frame(int try1, int try2, int rolls) {
		this(new Score(try1), new Score(try2), rolls);
	}
}
