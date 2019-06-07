package com.janaldous.codekata.bowling.parser;

import java.util.ArrayList;
import java.util.List;

import com.janaldous.codekata.bowling.domain.Frame;
import com.janaldous.codekata.bowling.domain.FrameTen;
import com.janaldous.codekata.bowling.domain.Game;

public class BowlingScoreParser {
	
	private static final String STRIKE = "X";

	public static Game parse(String scoreStr) {
		String[] scores = scoreStr.split(" ");
		List<Frame> frames = new ArrayList<>();
		
		for (String score: scores) {
			frames.add(getFrame(score));
		}
		
		Frame[] output = new Frame[scores.length];
		
		return new Game((Frame[]) frames.toArray(output));
	}

	static Frame getFrame(String scoreStr) {
		int[] scores = getScore(scoreStr);
		if (scores.length == 2) {
			int rolls = (scores[0] == 10) ? 1 : 2;
			return new Frame(scores[0], scores[1], rolls);
		} else if (scores.length == 3) {
			return new FrameTen(scores[0], scores[1], scores[2], 3);
		}
		
		throw new IllegalArgumentException();
	}
	
	
	static int[] getScore(String scoreStr) {
		if (scoreStr.length() == 1) {
			if (STRIKE.equals(scoreStr)) {
				return new int[] { 10, 0 };
			}
		} else if (scoreStr.length() == 2) {
			int roll1 = Integer.parseInt(scoreStr.substring(0,1));
			String roll2Str = scoreStr.substring(1,2);
			int roll2 = 0;
			if (roll2Str.contains("/")) {
				roll2 = 10-roll1;
			} else if (roll2Str.contains("-")) {
				roll2 = 0;
			} else if (roll2Str.matches("-?\\d+")) {
				roll2 = Integer.parseInt(roll2Str);
			}
			return new int[] { roll1, roll2 };
		} else if (scoreStr.length() == 3) {
			String roll1Str = scoreStr.substring(0,1);
			int roll1 = 0;
			if (roll1Str.contains("X")) {
				roll1 = 10;
			} else {
				roll1 = Integer.parseInt(roll1Str);
			}
			String roll2Str = scoreStr.substring(1,2);
			int roll2 = 0;
			String roll3Str = scoreStr.substring(2,3);
			int roll3 = 0;
			
			if (roll2Str.contains("/")) {
				roll2 = 10-roll1;
			} else if (roll2Str.contains("-")) {
				roll2 = 0;
			} else if (roll2Str.matches("-?\\d+")) {
				roll2 = Integer.parseInt(roll2Str);
			} else if (roll2Str.contains("X")) {
				roll2 = 10;
			}
			
			if (roll3Str.contains("/")) {
				roll3 = 10-roll2;
			} else if (roll3Str.contains("-")) {
				roll3 = 0;
			} else if (roll3Str.matches("-?\\d+")) {
				roll3 = Integer.parseInt(roll3Str);
			} else if (roll3Str.contains("X")) {
				roll3 = 10;
			}
			
			return new int[] {roll1, roll2, roll3};
		}
		throw new IllegalArgumentException();
	}
}
