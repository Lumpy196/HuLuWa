package com.Lumpy;

import com.Lumpy.creature.Creature;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;


public class Battlefield {

    private static final int BFMAXSIZE_X = 10;
    private static final int BFMAXSIZE_Y = 30;

    public ArrayList<ArrayList<Position>> battlefield = new ArrayList<ArrayList<Position>>();

    public Battlefield() {
        for (int i = 0; i < BFMAXSIZE_X; i++) {
            ArrayList<Position> arrayList = new ArrayList<Position>();
            for (int j = 0; j < BFMAXSIZE_Y; j++) {

            }
        }
    }



}

