package com.janaldous.codekata.bowling.parser;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.janaldous.codekata.bowling.calculator.BowlingScoreCalculator;
import com.janaldous.codekata.bowling.domain.Game;

@RunWith(Parameterized.class)
public class BowlingScoreParserIT {

	@Parameterized.Parameters(name 
	        = "{index}: Test with scoreStr={0}, result: {1}")
	    public static Iterable<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        		{"X X X X X X X X X XXX", 300},
	        		{"9- 9- 9- 9- 9- 9- 9- 9- 9- 9--", 90},
	        		{"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5", 150},
	        		{"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/X", 155},
	        });
	    }
	
	private int expectedScore;
	private String scoreStr;
	public BowlingScoreParserIT(String scoreStr, int expectedScore) {
		this.expectedScore = expectedScore;
		this.scoreStr = scoreStr;
	}
	
	@Test
	public void test() {
		Game game = BowlingScoreParser.parse(scoreStr);
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int totalScore = calculator.calculateScore(game);
		assertEquals(expectedScore, totalScore);
	}
	
}
