package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Car;

public class GameScreen implements Screen {
    private Texture mCarTexture;
    private SpriteBatch mSpriteBatch;
    private Car mCar;

    @Override
    public void show() {
        mCarTexture = new Texture(Gdx.files.internal("car.png"));
        mSpriteBatch = new SpriteBatch();
        mCar = new Car(mCarTexture, 0, 0, 146, 288);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mSpriteBatch.begin();
        mCar.draw(mSpriteBatch);
        mSpriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mCarTexture.dispose();
        mSpriteBatch.dispose();
    }
}
