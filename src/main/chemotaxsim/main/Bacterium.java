package main.chemotaxsim.main;

import java.awt.*;

public class Bacterium {
    public static final Color BACTERIUM_COLOR = new Color(0, 0, 0);
    public static final int DX = 5;
    public static final int DY = 5;

    private int previousNutrientValue;
    private int x;
    private int y;
    private int degreeOfRotation;
    private boolean isTumbling;

    /**
     * Construct a new bacterium at given position that is not tumbling,
     * is facing straight up, and has a previous nutrient value of 0.
     */
    public Bacterium(int x, int y) {
        this.x = x;
        this.y = y;
        this.isTumbling = false;
        this.degreeOfRotation = 0;
        this.previousNutrientValue = 0;
    }

    public int getPreviousNutrientValue() {
        return this.previousNutrientValue;
    }

    public void tumble() {
        this.isTumbling = true;
    }

    public void run() {
        this.isTumbling = false;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void handleBoundary() {
        // stub
    }

    public void measureNutrient() {
        // stub
    }
}
