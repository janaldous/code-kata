package com.janaldous.codekata.bowling.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrameTen extends Frame {
	private Score try3;
	
	public FrameTen(Score try1, Score try2, Score try3, int rolls) {
		super(try1, try2, rolls);
		this.try3 = try3;
	}

	public FrameTen(int try1, int try2, int try3, int rolls) {
		this(new Score(try1), new Score(try2), new Score(try3), rolls);
	}

}
