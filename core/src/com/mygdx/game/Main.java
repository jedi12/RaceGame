package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.view.GameScreen;

public class Main extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
