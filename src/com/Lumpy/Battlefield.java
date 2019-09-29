package com.Lumpy;

import com.Lumpy.creature.Creature;

import java.util.Iterator;
import java.util.List;

public class Battlefield {

    private static final int BFMAXSIZE_X = 10;
    private static final int BFMAXSIZE_Y = 30;

    public static Creature battlefield[][] = new Creature[BFMAXSIZE_X][BFMAXSIZE_Y];

    public Battlefield() {
        for (int axis_x = 0; axis_x < battlefield.length; axis_x++)
            for (int axis_y = 0; axis_y < battlefield[0].length; axis_y++)
                battlefield[axis_x][axis_y] = null;
    }

    public static Creature[][] getBattlefield() {
        return battlefield;
    }


    public static void setBattlefield(List<Creature> creatures) {
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
            for (int axis_y = 0; axis_y < battlefield[0].length; axis_y++) {
                if (battlefield[axis_x][axis_y] != null) {
                    System.out.printf("%s ", battlefield[axis_x][axis_y].getName());
                } else {
                    //System.out.print("¨€¨€¨€¨€ ");
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
    }

    public static void cleanBattlefield() {
        for (int axis_x = 0; axis_x < battlefield.length; axis_x++) {
            for (int axis_y = 0; axis_y < battlefield[0].length; axis_y++) {
                battlefield[axis_x][axis_y] = null;
            }
        }
    }

}

