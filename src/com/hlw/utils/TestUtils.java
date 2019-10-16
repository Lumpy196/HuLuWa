package com.hlw.utils;

import com.hlw.worldcraft.Field;
import com.hlw.worldcraft.Grid;

import java.util.ArrayList;

public class TestUtils {

    public static void TestPrintPositon(Field field) {
        for (int i = 0; i < field.getAliveCreatures().size(); i++) {
            System.out.println(field.getAliveCreatures().get(i).getClass()
                    + " x = " + field.getAliveCreatures().get(i).getAxis_x()
                    + " y = " + field.getAliveCreatures().get(i).getAxis_y()
                    + " grid_x = " + field.getAliveCreatures().get(i).getGrid().getAxis_x()
                    + " grid_y = " + field.getAliveCreatures().get(i).getGrid().getAxis_y()
                    + " health = " + field.getAliveCreatures().get(i).getHealth()
                    + " grid_occupier = " + field.getAliveCreatures().get(i).getGrid().getOccupier().getClass());
        }
        System.out.println();
    }

    public static void TestPrintGrids(Field field) {
        int count = 0;
        for (int i = 0; i < field.getGrids().size(); i++) {
            ArrayList<Grid> gridcol = field.getGrids().get(i);
            for (int j = 0; j < gridcol.size(); j++) {
                if (gridcol.get(j).isEmptyOccupier()) {
                    System.out.print("0 ");
                } else {
                    count++;
                    System.out.print("1 ");
                }
            }

            System.out.println();
        }
        System.out.println("count = " + count);
    }
}
