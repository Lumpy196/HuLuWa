package com.Lumpy.swingGUI;

import com.Lumpy.creature.Thing2D;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Tile extends Thing2D {

    public Tile(int axis_x, int axis_y) {
        super(axis_x, axis_y);


        ImageIcon iia = new ImageIcon("res/image/tile.png");
        Image image = iia.getImage();
        this.setImage(image);
    }
}
