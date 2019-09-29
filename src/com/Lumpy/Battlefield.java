package com.Lumpy;

import com.Lumpy.creature.Creature;

import java.util.ArrayList;
import java.util.Iterator;

public class Battlefield {

    private static final int BFMAXSIZE = 10;

    //public static int battefield[][] = new int[BFMAXSIZE][BFMAXSIZE];
    public static Creature battlefield[][] = new Creature[BFMAXSIZE][BFMAXSIZE];

    public Battlefield() {
        for (int axis_x = 0; axis_x < battlefield.length; axis_x++)
            for (int axis_y = 0; axis_y < battlefield[0].length; axis_y++)
                battlefield[axis_x][axis_y] = null;
    }

    public static Creature[][] getBattlefield() {
        return battlefield;
    }


    public static void setBattefield(Creature[][] battefield) {
        Battlefield.battlefield = battlefield;
    }

    public static void setBattlefield(ArrayList<Creature> creatures) {
        Iterator<Creature> iterator = creatures.iterator();
        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            int axis_x = creature.getAxis_x();
            int axis_y = creature.getAxis_y();
            battlefield[axis_x][axis_y] = creature;
        }
    }

    public static void printBattlefield() {
        for (int axis_x = 0; axis_x < battlefield.length; axis_x++) {
            for (int axis_y = 0; axis_y < battlefield.length; axis_y++) {
                if (battlefield[axis_x][axis_y] != null) {
                    System.out.printf("%s ", battlefield[axis_x][axis_y].getName());
                }
                System.out.println();
            }
        }
    }

    public static void setFormation(int formation) {

    }


    /*


    public static void cleanBattlefield() {
        for (int axis_x = 0; axis_x < battefield.length; axis_x++)
            for (int axis_y = 0; axis_y < battefield[0].length; axis_y++)
                battefield[axis_x][axis_y] = 0;
    }

    public static void getBattefield() {
        for (int axis_x = 0; axis_x < battefield.length; axis_x++) {
            for (int axis_y = 0; axis_y < battefield[0].length; axis_y++) {
                System.out.printf("%s       ", battefield[axis_x][axis_y]);
            }
            System.out.println();
        }
    }

    //public void getBattefield()

    public static void setBattefield(Creature creature) {
        battefield[creature.getaxis_x()][creature.getaxis_y()] = 1;
    }*/


   /* public static void initBattleField(int[] formation, int firstSoldier) {
        battefield[0][firstSoldier] = 1;
        for (int count = 1; count < formation.length; count++) {
            battefield[count][firstSoldier + formation[count]] = 1;
        }
    }*/

    public static void initBattleField(int[] formation, int firstsolder, ArrayList<Creature> creatures) {
        Iterator<Creature> iterator = creatures.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Creature temp = iterator.next();
            temp.setAxis_y(firstsolder + formation[count]);
            temp.setAxis_x(count);
            count++;
        }
    }
}

