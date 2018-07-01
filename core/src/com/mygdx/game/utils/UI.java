package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class UI {
    private Stage mStage;
    private Skin mSkin;
    private Label mLabel;

    public UI() {
        mStage = new Stage(new FitViewport(800, 600));
        mSkin = new Skin(Gdx.files.internal("skin.json"));
        addLabelToStage();
    }

    private void addLabelToStage() {
        mLabel = new Label("HELLO!\nMy name is\nEvgrompel", mSkin.get("default", Label.LabelStyle.class));
        mLabel.setAlignment(Align.center);
        mLabel.setPosition(400, 300, Align.center);
        mLabel.setFontScale(3f);
        mStage.addActor(mLabel);
    }

    public void draw() {
        mStage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mStage.act();
        mStage.draw();
    }

    public void dispose() {
        mStage.dispose();
    }
}
