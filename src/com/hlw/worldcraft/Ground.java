package com.hlw.worldcraft;

import javax.swing.*;

public final class Ground extends JFrame {

    public static final int OFFSET = 30;

    public Ground() {
        InitUI();
    }


    public void InitUI() {
        Field field = new Field();
        add(field);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(field.getBoardWidth() + OFFSET + field.getMaxsize(),
                field.getBoardHeight() + 2 * OFFSET);
        setLocationRelativeTo(null);
        setTitle("Ground");
    }

}

