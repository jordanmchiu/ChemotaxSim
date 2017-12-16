package main.chemotaxsim.main;

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
        // constructor
    }

    public void setup() {
        // stub
    }

    public List<Bacterium> getBacteria() {
        return null; // stub
    }

    public void moveBacteria() {
        // stub
    }

    public int getNutrientAtWidth(int x) {
        return 0;
    }

}
