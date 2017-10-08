package com.example.elad.flyingbaloons;

/**
 * Created by elad on 16/05/2017.
 */

public class Baloon {
    float x;
    float y;
    int Color;
    int StepX;
    int StepY;
    int counter;

    public Baloon(float x, float y, int color, int stepX, int stepY) {
        this.x = x;
        this.y = y;
        Color = color;
        StepX = stepX;
        StepY = stepY;
        counter = 0;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public int getStepX() {
        return StepX;
    }

    public void setStepX(int stepX) {
        StepX = stepX;
    }

    public int getStepY() {
        return StepY;
    }

    public void setStepY(int stepY) {
        StepY = stepY;
    }
}
