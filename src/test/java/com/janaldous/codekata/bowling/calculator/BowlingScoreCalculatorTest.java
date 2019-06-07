package com.janaldous.codekata.bowling.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.janaldous.codekata.bowling.calculator.BowlingScoreCalculator;
import com.janaldous.codekata.bowling.domain.Frame;
import com.janaldous.codekata.bowling.domain.FrameTen;
import com.janaldous.codekata.bowling.domain.Game;
import com.janaldous.codekata.bowling.domain.Score;

public class BowlingScoreCalculatorTest {

	@Test
	public void test() {
		Frame frame1 = new Frame(new Score(5), new Score(5), 2);
		Frame frame2 = new Frame(new Score(5), new Score(5), 2);
		
		Frame[] frames = new Frame[2];
		frames[0] = frame1;
		frames[1] = frame2;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(25, score);
	}
	
	@Test
	public void test2() {
		Frame frame1 = new Frame(new Score(5), new Score(4), 2);
		Frame frame2 = new Frame(new Score(5), new Score(5), 2);
		
		Frame[] frames = new Frame[2];
		frames[0] = frame1;
		frames[1] = frame2;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(19, score);
	}
	
	@Test
	public void testSpare1() {
		Frame frame1 = new Frame(new Score(5), new Score(5), 2);
		Frame frame2 = new Frame(new Score(5), new Score(5), 2);
		Frame frame3 = new Frame(new Score(5), new Score(5), 2);
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(40, score);
	}
	
	@Test
	public void testSpare2() {
		Frame frame1 = new Frame(new Score(4), new Score(6), 2);
		Frame frame2 = new Frame(new Score(3), new Score(7), 2);
		Frame frame3 = new Frame(new Score(7), new Score(3), 2);
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(40, score);
	}
	
	@Test
	public void testSpare3() {
		Frame frame1 = new Frame(new Score(4), new Score(6), 2);
		Frame frame2 = new Frame(new Score(3), new Score(3), 2);
		Frame frame3 = new Frame(new Score(7), new Score(0), 2);
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(26, score);
	}
	
	@Test
	public void testStrike1() {
		Frame frame1 = new Frame(new Score(10), new Score(0), 1);//30
		Frame frame2 = new Frame(new Score(10), new Score(0), 1);//20
		Frame frame3 = new Frame(new Score(10), new Score(0), 1);//10
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(60, score);
	}
	
	@Test
	public void testStrike2() {
		Frame frame1 = new Frame(new Score(10), new Score(0), 1);//15
		Frame frame2 = new Frame(new Score(5), new Score(0), 2);//5
		Frame frame3 = new Frame(new Score(1), new Score(0), 2);//1
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(21, score);
	}
	
	@Test
	public void testStrike_Spare() {
		Frame frame1 = new Frame(new Score(10), new Score(0), 1);//20
		Frame frame2 = new Frame(new Score(5), new Score(5), 2);//11
		Frame frame3 = new Frame(new Score(1), new Score(0), 2);//1
		
		Frame[] frames = new Frame[3];
		frames[0] = frame1;
		frames[1] = frame2;
		frames[2] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(32, score);
	}
	
	@Test
	public void testLastFrame() {
		Frame frame1 = new Frame(new Score(10), new Score(0), 1);//20
		Frame frame3 = new FrameTen(new Score(1), new Score(9), new Score(1), 2);//11
		
		Frame[] frames = new Frame[2];
		frames[0] = frame1;
		frames[1] = frame3;
		
		Game game = new Game(frames);
		
		BowlingScoreCalculator calculator = new BowlingScoreCalculator();
		int score = calculator.calculateScore(game);
		assertEquals(31, score);
	}

}
