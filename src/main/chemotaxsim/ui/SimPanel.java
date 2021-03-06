package main.chemotaxsim.ui;

import main.chemotaxsim.main.Bacterium;
import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimPanel extends JPanel {
    private static final int INTERVAL = 20;
    private CSArea area;

    /**
     * Construct a new SimPanel
     */
    public SimPanel() {
        setPreferredSize(new Dimension(CSArea.WIDTH, CSArea.HEIGHT));
        this.area = new CSArea();
        addTimer();
        setFocusable(true);
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseHandler());
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

    /**
     * Paints everything
     * @param g   Graphics object to use
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        GradientPaint gp = new GradientPaint(0, 0, color1, w, 0, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        drawSim(g);
    }

    /**
     * Draws simulator onto Graphics object
     * @param g    Graphics object to use
     */
    private void drawSim(Graphics g) {
        drawBacteria(g);
    }

    /**
     * Draws all bacteria onto Graphics object
     * @param g    Graphics object to use
     */
    private void drawBacteria(Graphics g) {
        for (Bacterium next : area.getBacteria()) {
            drawBacterium(g, next);
        }
    }

    /**
     * Draw an individual bacterium and rotate it according to its current angle of rotation
     * @param g    Graphics object to use
     * @param b    Bacterium to be drawn
     */
    private void drawBacterium(Graphics g, Bacterium b) {
        Graphics2D g2d = (Graphics2D) g.create();
        int ctrX = (Bacterium.BACTERIUM_WIDTH / 2 + b.getX());
        int ctrY = (Bacterium.BACTERIUM_HEIGHT / 2 + b.getY());
        g2d.rotate(Math.toRadians(b.getDegreeOfRotation()), ctrX, ctrY);
        g2d.setColor(Bacterium.BACTERIUM_COLOR);
        g2d.fillOval(b.getX(), b.getY(), Bacterium.BACTERIUM_WIDTH, Bacterium.BACTERIUM_HEIGHT);
    }

    /**
     * Update and repaint simulator
     */
    public void update() {
        area.update();
        repaint();
    }
}
