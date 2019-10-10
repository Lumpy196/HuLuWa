package com.Lumpy.swingGUI;

import com.Lumpy.creature.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SwingJPanel extends JPanel {

    private List<Creature> aliveHuman = new ArrayList<>();

    private List<Creature> aliveMonster = new ArrayList<>();

    private final int girdWidth = 75;

    private final int imageWidth = 50;

    private final int imageLength = 60;

    private final int humanQuantity = 8;

    private final int monsterQuantity = 10;


    public void initCreature() {

        HuLuWa calabash[] = new HuLuWa[7];

        calabash[0] = new HuLuWa("´óÍÞ", 1, 1, 0, HuLuWa.COLOR.RED, "HuLuWa_1");
        calabash[1] = new HuLuWa("¶þÍÞ", 1, 2, 1, HuLuWa.COLOR.ORANGE, "HuLuWa_2");
        calabash[2] = new HuLuWa("ÈýÍÞ", 1, 3, 2, HuLuWa.COLOR.YELLOW, "HuLuWa_3");
        calabash[3] = new HuLuWa("ËÄÍÞ", 2, 3, 3, HuLuWa.COLOR.GREEN, "HuLuWa_4");
        calabash[4] = new HuLuWa("ÎåÍÞ", 3, 4, 4, HuLuWa.COLOR.CYAN, "HuLuWa_5");
        calabash[5] = new HuLuWa("ÁùÍÞ", 3, 5, 5, HuLuWa.COLOR.BLUE, "HuLuWa_6");
        calabash[6] = new HuLuWa("ÆßÍÞ", 3, 6, 6, HuLuWa.COLOR.PURPLE, "HuLuWa_7");

        for (int i = 0; i < calabash.length; i++) {
            aliveHuman.add(calabash[i]);
        }

        Grandpa grandpa = new Grandpa("Ò¯Ò¯", 0, 0, 7, "hitHandRush");
        aliveHuman.add(grandpa);

        Snake snake = new Snake("Éß¾«", 0, 0, 8, "hitHandRush");
        aliveMonster.add(snake);

        Scorpion scorpion = new Scorpion("Ð«×Ó", 0, 0, 9, "hitHandRush");
        aliveMonster.add(scorpion);

        Goblin goblin[] = new Goblin[8];

        for (int i = 0; i < 8; i++) {
            String goblinName = "Ð¡Ñý";
            goblin[i] = new Goblin(goblinName, 0, 0, 10 + i, "hitHandRush");
            aliveMonster.add(goblin[i]);
        }
    }

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
        initCreature();
        deployCreature(g);
    }

}
