package main.chemotaxsim.main;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Bacterium {
    public static final Color BACTERIUM_COLOR = new Color(0, 0, 0);
    public static final int BACTERIUM_WIDTH = 10;
    public static final int BACTERIUM_HEIGHT = 20;
    public static final int ROTATION = 30;
    public static final int MAX_DX = 5;
    public static final int MAX_RUN_TIME = 500;
    public static final int MIN_RUN_TIME = 5;
    public static final int MIN_TUMBLE_TIME = 5;
    public static final int MAX_TUMBLE_TIME = 50;

    private int previousNutrient;
    private int x;
    private int y;
    private int degreeOfRotation;
    private int timeUntilSwitch;
    private boolean isTumbling;

    /**
     * Construct a new bacterium at given position that is tumbling and facing right.
     * @param x     x-pos to place bacterium
     * @param y     y-pos to place bacterium
     */
    public Bacterium(int x, int y) {
        setPosition(x, y);
        this.isTumbling = true;
        this.degreeOfRotation = 0;
        this.previousNutrient = CSArea.getNutrientAtWidth(this.x);
        this.timeUntilSwitch = ThreadLocalRandom.current().nextInt(MIN_TUMBLE_TIME, MAX_TUMBLE_TIME + 1);
    }

    /**
     * Gets previous nutrient value
     * @return previous nutrient value
     */
    public int getPreviousNutrient() {
        return this.previousNutrient;
    }

    /**
     * Sets bacterium to tumble
     */
    public void tumble() {
        this.isTumbling = true;
    }

    /**
     * Sets bacterium to run
     */
    public void run() {
        this.isTumbling = false;
    }

    /**
     * If bacterium is tumbling, rotate bacterium ROTATION degrees counterclockwise
     * If bacterium is running, move bacterium in a straight line at degree of rotation
     *    - If bacterium is moving away from nutrients, decrease time until next tumble more quickly
     *    - If bacterium is moving towards nutrients, decrease time until next tumble more slowly
     */
    public void move() {
        if (this.timeUntilSwitch <= 0) {
            handleSwitch();
        }

        if (this.isTumbling) {
            this.degreeOfRotation += ROTATION;
            if (this.degreeOfRotation >= 360) {
                this.degreeOfRotation -= 360;
            }
            this.timeUntilSwitch -= 2;
        } else if (!this.isTumbling) {
            this.x += (int) (MAX_DX * Math.sin(Math.toRadians(this.degreeOfRotation)));
            this.y += (int) (MAX_DX * Math.cos(Math.toRadians(this.degreeOfRotation)));

            if (measureNutrient() < getPreviousNutrient()) {
                this.timeUntilSwitch -= 3;
            } else if (measureNutrient() >= getPreviousNutrient()) {
                this.timeUntilSwitch -= 1;
            }
        }

        handleBoundary();
    }

    /**
     * Sets position of bacterium to given position
     * @param x   x-coord to be set
     * @param y   y-coord to be set
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * If bacterium reaches boundary, keep bacterium at that boundary
     */
    public void handleBoundary() {
        if (x < 0) {
            x = 0;
        } else if (x > CSArea.WIDTH - 10) {
            x = CSArea.WIDTH - 10;
        }

        if (y < 0) {
            y = 0;
        } else if (y > CSArea.HEIGHT - 10) {
            y = CSArea.HEIGHT - 10;
        }
    }

    /**
     * If bacteria is running, switch to tumble
     *
     * If bacteria is tumbling, switch to run and assign length of run according to current
     * and previous nutrient levels.  Assign current nutrient concentration to previous nutrient concentration.
     *      - If currentNutrient > previousNutrient, probability of having a higher run time is increased
     *      - If currentNutrient < previousNutrient, probability of having a higher run time is decreased
     *      - If currentNutrient = previousNutrient, probability of having a higher run time stays the same
     */
    public void handleSwitch() {
        if (this.isTumbling) {
            this.run();

            if (measureNutrient() > getPreviousNutrient()) {
                this.timeUntilSwitch = ThreadLocalRandom.current().nextInt(getPreviousNutrient(), measureNutrient() + 1);
            } else if (measureNutrient() < getPreviousNutrient()) {
                this.timeUntilSwitch = ThreadLocalRandom.current().nextInt(measureNutrient(), getPreviousNutrient() + 1);
            } else {
                this.timeUntilSwitch = measureNutrient();
            }

            if (this.timeUntilSwitch > MAX_RUN_TIME) {
                this.timeUntilSwitch = MAX_RUN_TIME;
            } else if (this.timeUntilSwitch < MIN_RUN_TIME) {
                this.timeUntilSwitch = MIN_RUN_TIME;
            }

            this.previousNutrient = measureNutrient();
        } else if (!this.isTumbling) {
            this.tumble();
            this.timeUntilSwitch = ThreadLocalRandom.current().nextInt(MIN_TUMBLE_TIME, MAX_TUMBLE_TIME + 1);
        }
    }

    /**
     * Get nutrient concentration at current position
     * @return  nutrient concentration at given x-pos
     */
    public int measureNutrient() {
        return CSArea.getNutrientAtWidth(this.x);
    }

    /**
     * Get current x-pos of bacterium
     * @return  current x-pos of bacterium
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get current y-pos of bacterium
     * @return  current y-pos of bacterium
     */
    public int getY() {
        return this.y;
    }

    /**
     * Get current degree of rotation of bacterium
     * @return  current degree of rotation of bacterium
     */
    public int getDegreeOfRotation() {
        return this.degreeOfRotation;
    }
}
