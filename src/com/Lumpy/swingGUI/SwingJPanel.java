package com.Lumpy.swingGUI;

import com.Lumpy.creature.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SwingJPanel extends JPanel {

    private List<Creature> aliveHuman = new ArrayList<>();

    private List<Creature> aliveMonster = new ArrayList<>();

    private final int girdWidth = 75;

    private final int imageWidth = 50;

    private final int imageLength = 60;

    private int humanQuantity = 8;

    private int monsterQuantity = 10;



    public void deployCreature(Graphics graphics) {
        ListIterator<Creature> listIterator_h = aliveHuman.listIterator();
        while (listIterator_h.hasNext()) {
            Creature creature = listIterator_h.next();
            graphics.drawImage(creature.getImage(), creature.getAxis_x() * girdWidth, creature.getAxis_y() * girdWidth,
                    imageLength, imageWidth, this);
        }

    }

    public void paint(Graphics g) {

        super.paint(g);
        deployCreature(g);
    }

}
