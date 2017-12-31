package main.chemotaxsim.main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CSArea {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final int MAX_BACTERIA = 10;
    public static final float MIN_NUTRIENT = 10;
    public static final float MAX_NUTRIENT = 90;

    private List<Bacterium> bacteria;

    /**
     * Construct new CSArea with empty list of Bacteria
     */
    public CSArea() {
        this.bacteria = new ArrayList<Bacterium>();
        setup();
    }

    /**
     * Updates bacteria
     */
    public void update() {
        moveBacteria();
    }

    /**
     * Resets or exits simulator in response to given key pressed code
     * @param keyCode   the key pressed
     */
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R) {
            setup();
        } else if (keyCode == KeyEvent.VK_X) {
            System.exit(0);
        }
    }

    /**
     * Clears all bacteria from CSArea
     */
    public void setup() {
        this.bacteria.clear();
    }

    /**
     * Adds a new bacterium at given coordinate if total bacteria are
     * less than or equal to MAX_BACTERIA
     *
     * @param x     x-coord
     * @param y     y-coord
     */
    public void addBacterium(int x, int y) {
        if (this.bacteria.size() <= MAX_BACTERIA) {
            this.bacteria.add(new Bacterium(x, y));
        }
    }

    /**
     * Returns list of all bacteria in CSArea
     * @return    list of all bacteria
     */
    public List<Bacterium> getBacteria() {
        return this.bacteria;
    }

    /**
     * Move all bacteria in CSArea
     */
    public void moveBacteria() {
        for (Bacterium b : this.bacteria) {
            b.move();
        }
    }

    /**
     * Get nutrient concentration at given x-pos
     * @param x   given x-pos
     * @return    nutrient conc at x-pos based on width and min/max nutrient concentrations
     */
    public static int getNutrientAtWidth(float x) {
        return Math.round((x * ((MAX_NUTRIENT - MIN_NUTRIENT) / WIDTH)) + MIN_NUTRIENT);
    }

}
