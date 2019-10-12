package com.hlw.swingGUI;

import com.hlw.Thing2D;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Tile extends Thing2D {

    public Tile(int axis_x, int axis_y) {
        super(axis_x, axis_y);

        URL location = this.getClass().getClassLoader().getResource("tile.png");
        ImageIcon iia = new ImageIcon(location);
        Image image = iia.getImage();
        this.setImage(image);
    }

}
