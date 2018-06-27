package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
    private Rectangle mRectangle;
    private Sprite mSprite;

    GameObject(Texture texture, float x, float y, float width, float height) {
        mRectangle = new Rectangle(x, y, width, height);
        mSprite = new Sprite(texture);
    }

    public void draw(SpriteBatch spriteBatch) {
        mSprite.setBounds(mRectangle.getX(), mRectangle.getY(), mRectangle.getWidth(), mRectangle.getHeight());
        mSprite.draw(spriteBatch);
    }
}
