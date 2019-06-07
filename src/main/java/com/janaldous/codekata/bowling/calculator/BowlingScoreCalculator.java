package com.janaldous.codekata.bowling.calculator;

import com.janaldous.codekata.bowling.domain.Frame;
import com.janaldous.codekata.bowling.domain.FrameTen;
import com.janaldous.codekata.bowling.domain.Game;

public class BowlingScoreCalculator {
	
	public int calculateScore(Game game) {
		Frame[] frames = game.getFrames();
		int totalScore = 0;
		// iterate backwards
		
		int i = frames.length - 1;
		
		if (frames[i] instanceof FrameTen) {
			totalScore += simpleSum((FrameTen) frames[i]);
		} else {
			totalScore += simpleSum(frames[i]);
		}
		i--;
		
		for (; i >= 0; i--) {
			Frame frame = frames[i];
			int roll1Score = frame.getTry1().getScore();
			int roll2Score = frame.getTry2().getScore();
			
			int frameScore = roll1Score + roll2Score;
			int additionalScore = 0;
			
			boolean isStrike = isStrike(frame);
			boolean isSpare = (frameScore == 10) && !isStrike;
			if (isStrike) {
				additionalScore = calculateAdditionalStrikeScore(frames, i);
			} else if (isSpare) {
				additionalScore = calculateAdditionalSpareScore(frames, i);
			}
			
			totalScore += frameScore + additionalScore;
		}
		
		return totalScore;
	}

	private int calculateAdditionalSpareScore(Frame[] frames, int i) {
		int additionalScore = 0;
		if (i+1 < frames.length) {
			additionalScore += frames[i+1].getTry1().getScore();
		}
		return additionalScore;
	}

	private int calculateAdditionalStrikeScore(Frame[] frames, int i) {
		int additionalScore = 0;
		if (i+1 < frames.length) {
			if (frames[i+1].getRolls() == 1) {
				additionalScore += frames[i+1].getTry1().getScore();
				if (i+2 < frames.length) {
					additionalScore += frames[i+2].getTry1().getScore();
				}
			} else {
				additionalScore += frames[i+1].getTry1().getScore();
				additionalScore += frames[i+1].getTry2().getScore();
			}
		}
		return additionalScore;
	}
	
	private boolean isStrike(Frame frame) {
		return frame.getTry1().getScore() == 10;
	}
	
	private int simpleSum(Frame frame) {
		return frame.getTry1().getScore() + frame.getTry2().getScore();
	}
	
	private int simpleSum(FrameTen lastFrame) {
		return lastFrame.getTry1().getScore() + lastFrame.getTry2().getScore() + lastFrame.getTry3().getScore();
	}
	
}
