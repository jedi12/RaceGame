package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.view.GameScreen;

public class CarController {
    private float carSpeed;
    private float velocity = 10f;
    private float speedMax = 10f;
    private float rotationSpeed = 150f;

    private Polygon carBounds;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            carSpeed = carSpeed + velocity * GameScreen.deltaCff;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            carSpeed = carSpeed - velocity * GameScreen.deltaCff;
        } else {
            downSpeed();
        }

        carSpeed = sliceSpeed();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carBounds.rotate(rotationSpeed * GameScreen.deltaCff);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carBounds.rotate(-rotationSpeed * GameScreen.deltaCff);
        }

        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff,
                            carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff);
    }

    private void downSpeed() {
        if (carSpeed > velocity * GameScreen.deltaCff) {
            carSpeed = carSpeed - velocity * GameScreen.deltaCff;
        } else if (carSpeed < -velocity * GameScreen.deltaCff) {
            carSpeed = carSpeed + velocity * GameScreen.deltaCff;
        } else {
            carSpeed = 0f;
        }
    }

    private float sliceSpeed() {
        if (carSpeed > speedMax) {
            return speedMax;
        } else if (carSpeed < -speedMax) {
            return -speedMax;
        }
        return carSpeed;
    }
}
