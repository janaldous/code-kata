package com.janaldous.codekata.bowling.parser;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BowlingScoreParserTest {

	@Parameterized.Parameters(name 
	        = "{index}: Test with scoreStr={0}, result: {1}")
	    public static Iterable<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        		{"X", new int[] {10, 0}},
	        		{"9/", new int[] {9, 1}},
	        		{"9-", new int[] {9, 0}},
	        		{"72", new int[] {7, 2}},
	        		{"XXX", new int[] {10, 10, 10}},
	        		{"X51", new int[] {10, 5, 1}},
	        		{"X5/", new int[] {10, 5, 5}},
	        		{"X5-", new int[] {10, 5, 0}},
	        		{"5/X", new int[] {5, 5, 10}},
	        		{"5/-", new int[] {5, 5, 0}},
	        		{"5--", new int[] {5, 0, 0}},
	        		{"51-", new int[] {5, 1, 0}},
	        		{"X--", new int[] {10, 0, 0}},
	        });
	    }
	
	private int[] expected;
	private String scoreStr;
	public BowlingScoreParserTest(String scoreStr, int[] expected) {
		this.expected = expected;
		this.scoreStr = scoreStr;
	}
	
	@Test
    public void testResults() {
        assertArrayEquals(expected, BowlingScoreParser.getScore(scoreStr));
    }
	
}
