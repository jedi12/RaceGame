package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public abstract class GameObject {
    private Polygon mBounds;
    private Sprite mObject;

    GameObject(TextureRegion textureRegion, float x, float y, float width, float height) {
        mObject = new Sprite(textureRegion);
        mObject.setSize(width, height);
        mObject.setOrigin(width / 2f, height / 2f);
        mObject.setPosition(x, y);

        mBounds = new Polygon(new float[] {0f, 0f, width, 0f, width, height, 0f, height});
        mBounds.setPosition(x, y);
        mBounds.setOrigin(width / 2f, height / 2f);
    }

    public void draw(SpriteBatch spriteBatch) {
        mObject.setPosition(mBounds.getX(), mBounds.getY());
        mObject.setRotation(getBounds().getRotation());
        mObject.draw(spriteBatch);
    }

    public Polygon getBounds() {
        return mBounds;
    }
}
