package com.Lumpy.swing;

import com.Lumpy.creature.Creature;

import javax.swing.*;

public class SwingJPanel extends JPanel {

    SwingJFrame swingJFrame;

    public Creature creature = new Creature("尼日利亚猎妈人", 1, 1, 100);

    //ImageIcon imageIcon =

    public void init(SwingJFrame swingJFrame) {
        this.swingJFrame = swingJFrame;
        creature.setAxis_x(200);
        creature.setAxis_y(50);


    }

}
