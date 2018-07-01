package com.mygdx.game.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    private AssetManager mManager;

    public Assets() {
        mManager = new AssetManager();
        mManager.load("atlas1.atlas", TextureAtlas.class);
        mManager.finishLoading();
    }

    public AssetManager getManager() {
        return mManager;
    }

    public void dispose() {
        mManager.dispose();
    }
}
