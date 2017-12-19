package main.chemotaxsim.ui;

import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;

public class ChemotaxSim extends JFrame {

    public ChemotaxSim() {
        super("ChemotaxSim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        CSArea csArea = new CSArea();
        SimPanel sp = new SimPanel(csArea);
        add(sp);
        pack();
        centreOnScreen();
        setVisible(true);
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
