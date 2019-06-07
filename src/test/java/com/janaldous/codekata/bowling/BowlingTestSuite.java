package com.janaldous.codekata.bowling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.janaldous.codekata.bowling.calculator.BowlingScoreCalculatorTest;
import com.janaldous.codekata.bowling.parser.BowlingScoreParserIT;
import com.janaldous.codekata.bowling.parser.BowlingScoreParserTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BowlingScoreCalculatorTest.class,
   BowlingScoreParserTest.class,
   BowlingScoreParserIT.class
})
public class BowlingTestSuite {

}
