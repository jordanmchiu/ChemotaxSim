package main.chemotaxsim.main;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Bacterium {
    public static final Color BACTERIUM_COLOR = new Color(0, 0, 0);
    public static final int ROTATION = 10;
    public static final int MAX_DX = 5;
    public static final int MAX_RUN_TIME = 100;
    public static final int MIN_RUN_TIME = 5;
    public static final int MIN_TUMBLE_TIME = 5;
    public static final int MAX_TUMBLE_TIME = 20;

    private int previousNutrient;
    private int x;
    private int y;
    private int degreeOfRotation;
    private int timeUntilSwitch;
    private boolean isTumbling;

    /**
     * Construct a new bacterium at given position that is tumbling,
     * is facing right, and has a previous nutrient value of 50.
     */
    public Bacterium(int x, int y) {
        setPosition(x, y);
        this.isTumbling = true;
        this.degreeOfRotation = 0;
        this.previousNutrient = CSArea.getNutrientAtWidth(this.x);
        this.timeUntilSwitch = MIN_TUMBLE_TIME;
    }

    public int getPreviousNutrient() {
        return this.previousNutrient;
    }

    public void tumble() {
        this.isTumbling = true;
    }

    public void run() {
        this.isTumbling = false;
    }

    /**
     * If bacteria is running, move bacterium in a straight line at degree of rotation
     * If bacteria is tumbling, rotate bacterium ROTATION degrees
     */
    public void move() {
        this.timeUntilSwitch -= 1;
        if (this.timeUntilSwitch <= 0)
            handleSwitch();

        if (this.isTumbling)
            this.degreeOfRotation += ROTATION;
        if (this.degreeOfRotation >= 360)
            this.degreeOfRotation -= 360;

        if (!this.isTumbling) {
            this.x += (int) (MAX_DX * Math.sin(degreesToRadians(this.degreeOfRotation)));
            this.y += (int) (MAX_DX * Math.cos(degreesToRadians(this.degreeOfRotation)));
        }

        handleBoundary();
    }

    /**
     * private helper method to convert degrees to radians
     * @param degree    degree to be converted
     */
    private double degreesToRadians(int degree) {
        return degree / (2 * Math.PI);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void handleBoundary() {
        if (x < 0)
            x = 0;
        else if (x > CSArea.WIDTH)
            x = CSArea.WIDTH;

        if (y < 0)
            y = 0;
        else if (y > CSArea.HEIGHT)
            y = CSArea.HEIGHT;
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

            if (this.timeUntilSwitch > MAX_RUN_TIME)
                this.timeUntilSwitch = MAX_RUN_TIME;
            else if (this.timeUntilSwitch < MIN_RUN_TIME)
                this.timeUntilSwitch = MIN_RUN_TIME;

            this.previousNutrient = measureNutrient();
        }

        if (!this.isTumbling) {
            this.timeUntilSwitch = ThreadLocalRandom.current().nextInt(MIN_TUMBLE_TIME, MAX_TUMBLE_TIME + 1);
            this.tumble();
        }
    }

    /**
     * Get nutrient concentration at current position
     * @return  nutrient concentration at given x-pos
     */
    public int measureNutrient() {
        return CSArea.getNutrientAtWidth(this.x);
    }
}
