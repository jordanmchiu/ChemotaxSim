package main.chemotaxsim.ui;

import javax.swing.*;
import java.awt.*;

public class ChemotaxSim extends JFrame {

    public ChemotaxSim() {
        super("ChemotaxSim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        InfoPanel ip = new InfoPanel();
        SimPanel sp = new SimPanel();
        add(sp);
        add(ip, BorderLayout.NORTH);
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
