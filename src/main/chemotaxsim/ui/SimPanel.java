package main.chemotaxsim.ui;

import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;

public class SimPanel extends JPanel {
    private static final String RESTART = "R to restart";
    private CSArea area;

    public SimPanel(CSArea area) {
        setPreferredSize(new Dimension(CSArea.WIDTH, CSArea.HEIGHT));
        setBackground(Color.WHITE); // change this to a gradient if possible
        this.area = area;
    }

    public void drawSim(Graphics g) {
        // stub
    }

    public void paintComponent(Graphics g) {
        // stub
    }

    public void drawBacteria(Graphics g) {
        // stub
    }

    public void drawBacterium(Graphics g) {
        // stub
    }

    public void update() {
        // stub
    }

    public void simPaused() {
        // stub
    }

    public void simRestart() {
        // stub
    }
}
