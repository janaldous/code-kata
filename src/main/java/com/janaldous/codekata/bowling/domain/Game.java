package com.janaldous.codekata.bowling.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
	private Frame[] frames;
}
