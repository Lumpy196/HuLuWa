package com.Lumpy.swingGUI;


import com.Lumpy.creature.Thing2D;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

public class Player extends Thing2D implements Runnable {
    private Field field;

    public Player(int x, int y, Field field) {
        super(x, y);

        this.field = field;

        //URL loc = this.getClass().getClassLoader().getResource("player.png");

        ImageIcon iia = new ImageIcon("res/image/player.png");
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void move(int x, int y) {
        int nx = this.getAxis_x() + x;
        int ny = this.getAxis_y() + y;
        this.setAxis_x(nx);
        this.setAxis_y(ny);
    }

    public void run() {
        while (!Thread.interrupted()) {
            Random rand = new Random();

            this.move(rand.nextInt(10), rand.nextInt(10));
            try {

                Thread.sleep(rand.nextInt(1000) + 1000);
                this.field.repaint();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}