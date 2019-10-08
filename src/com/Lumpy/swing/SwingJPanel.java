package com.Lumpy.swing;

import com.Lumpy.creature.Creature;

import javax.swing.*;
import java.awt.*;

import javafx.application.Application;

public class SwingJPanel extends JPanel {

    Creature creature = new Creature("test", 1, 1, 1);

    public void paint(Graphics g) {
        super.paint(g);

        g.drawLine(10, 10, 40, 40);
        g.drawImage(creature.getImage(), 50, 100, 500, 400, this);
    }

}
