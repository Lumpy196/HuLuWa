package com.Lumpy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private static final int BFMAXSIZE = 10;
    public static int battefield[][] = new int[BFMAXSIZE][BFMAXSIZE];

    public BattleField() {
        for (int axis_x = 0; axis_x < battefield.length; axis_x++)
            for (int axis_y = 0; axis_y < battefield[0].length; axis_y++)
                battefield[axis_x][axis_y] = 0;
    }

}

