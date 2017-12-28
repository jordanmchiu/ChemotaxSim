package main.chemotaxsim.ui;

import main.chemotaxsim.main.CSArea;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private static final String RESTART_TXT = "R to restart";
    private static final String CLICK_TXT = "Click to spawn bacteria (Max: " + CSArea.MAX_BACTERIA + ")";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private JLabel restartLbl;
    private JLabel clickLbl;

    /**
     * Construct info panel with basic instructions for user
     */
    public InfoPanel() {
        setBackground(new Color(180, 180, 180));
        restartLbl = new JLabel(RESTART_TXT);
        restartLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        clickLbl = new JLabel(CLICK_TXT);
        clickLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(clickLbl);
        add(Box.createHorizontalStrut(10));
        add(restartLbl);
    }
}
