package com.Lumpy.creature;


import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Thing2D {

    private int axis_x;
    private int axis_y;

    private String name;

    private Image image;

    public Thing2D(int axis_x, int axis_y) {
        this.axis_x = axis_x;
        this.axis_y = axis_y;
    }

    public int getAxis_x() {
        return axis_x;
    }

    public void setAxis_x(int axis_x) {
        this.axis_x = axis_x;
    }

    public int getAxis_y() {
        return axis_y;
    }

    public void setAxis_y(int axis_y) {
        this.axis_y = axis_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImage(URL url) {
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        this.image = image;
    }

}
