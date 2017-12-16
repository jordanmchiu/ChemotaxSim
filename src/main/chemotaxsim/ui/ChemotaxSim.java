package main.chemotaxsim.ui;

import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;

public class ChemotaxSim extends JFrame {
    private static final int INTERVAL = 20;
    private CSArea csArea;
    private SimPanel sp;

    public ChemotaxSim() {
        // stub
    }

    private void addTimer() {
        // stub
    }

    /**
     * Centres frame on desktop
     */
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public static void main(String[] args) {
        new ChemotaxSim();
    }

}
