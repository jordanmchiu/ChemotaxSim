package main.chemotaxsim.ui;

import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimPanel extends JPanel {
    private static final String RESTART = "R to restart";
    private static final int INTERVAL = 20;

    private CSArea area;

    public SimPanel(CSArea area) {
        setPreferredSize(new Dimension(CSArea.WIDTH, CSArea.HEIGHT));
        setBackground(Color.WHITE); // change this to a gradient if possible
        this.area = area;
        addTimer();
    }

    /**
     * Initializes a timer that updates the simulator each INTERVAL seconds
     */
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        t.start();
    }

    /**
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            area.keyPressed(e.getKeyCode());
        }
    }

    /**
     * A mouse handler to respond to mouse events
     * Adds bacterium at given position when mouse is clicked
     */
    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            area.addBacterium(e.getX(), e.getY());
        }
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
        area.update();
        repaint();
    }
}
