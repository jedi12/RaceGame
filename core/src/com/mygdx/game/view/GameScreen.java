package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.model.Car;
import com.mygdx.game.utils.UI;

public class GameScreen implements Screen {
    private TextureAtlas mTextureAtlas;
    private SpriteBatch mBatch;
    private Car mCar;
    private OrthographicCamera mCamera;
    private UI mUI;

    public static float deltaCff;

    @Override
    public void show() {
        mBatch = new SpriteBatch();
        mCar = new Car(mTextureAtlas.findRegion("car"), 0, 0, 1f, 1f * 1.97f);
        mUI = new UI();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        mBatch.setProjectionMatrix(mCamera.combined);
        mBatch.begin();
        mCar.draw(mBatch);
        mBatch.end();
        mUI.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        mCamera = new OrthographicCamera(20f, 20f * aspectRatio);
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
        mBatch.dispose();
        mUI.dispose();
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        mTextureAtlas = textureAtlas;
    }
}
