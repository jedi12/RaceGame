package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.utils.Assets;
import com.mygdx.game.view.GameScreen;

public class Main extends Game {
	private Screen mGameScreen;
	private Assets mAssets;

	@Override
	public void create() {
		mAssets = new Assets();
		mGameScreen = new GameScreen();
		((GameScreen) mGameScreen).setTextureAtlas(mAssets.getManager().get("atlas1.atlas", TextureAtlas.class));
		setScreen(mGameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		mGameScreen.dispose();
		mAssets.dispose();
	}
}
