package com.Lumpy.swingGUI;

import com.Lumpy.creature.Creature;

import javax.swing.*;
import java.awt.*;

public class SwingJPanel extends JPanel {

    Creature creature = new Creature("test", 1, 1, 1, "HuLuWa_1");

    public void paint(Graphics g) {
        super.paint(g);

        g.drawLine(10, 10, 40, 40);
        g.drawImage(creature.getImage(), 50, 100, 250, 200, this);
    }

}
