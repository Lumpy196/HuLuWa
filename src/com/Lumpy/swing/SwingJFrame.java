package com.Lumpy.swing;

import javax.swing.*;

public class SwingJFrame extends JFrame {
    public SwingJFrame() {

        SwingJPanel swingJPanel = new SwingJPanel();

        this.add(swingJPanel);

        this.setTitle("��~��~�廷");

        this.setSize(800, 600);

        //this.setLayout(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setVisible(true);



        //MainJpanel mainJpanel = new MainJpanel();
    }

}
