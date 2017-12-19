package main.chemotaxsim.main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSArea {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public static final int MAX_BACTERIA = 10;
    public static final int MIN_NUTRIENT = 10;
    public static final int MAX_NUTRIENT = 90;
    public static final Random RND = new Random();

    private List<Bacterium> bacteria;

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
        if (keyCode == KeyEvent.VK_R)
            setup();
        else if (keyCode == KeyEvent.VK_X)
            System.exit(0);
    }

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
        if (this.bacteria.size() <= MAX_BACTERIA)
            this.bacteria.add(new Bacterium(x, y));
    }

    public List<Bacterium> getBacteria() {
        return null; // stub
    }

    public void moveBacteria() {
        // stub
    }

    private void moveBacterium() {

    }

    public int getNutrientAtWidth(int x) {
        return 0;
    }

}
