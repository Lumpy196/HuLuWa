package com.Lumpy;


import java.io.FileReader;
import java.io.IOException;
import java.lang.String;


public class BattleField {

    private static final int BFMAXSIZE = 15;


    private static int battefield[][] = new int[BFMAXSIZE][BFMAXSIZE];

    public BattleField() {
        for (int axis_x = 0; axis_x < battefield.length; axis_x++)
            for (int axis_y = 0; axis_y < battefield[0].length; axis_y++)
                battefield[axis_x][axis_y] = 0;
    }

    /**
     *
     */
    public static void getBattefield() {
        for (int axis_x = 0; axis_x < battefield.length; axis_x++) {
            for (int axis_y = 0; axis_y < battefield[0].length; axis_y++) {
                System.out.printf("%s ", battefield[axis_x][axis_y]);
            }
            System.out.println();
        }
    }

    /**
     * @param axis_x
     * @param axis_y
     * @param id
     */
    public static void setBattefield(int axis_x, int axis_y, int id) {
        battefield[axis_x][axis_y] = id;
    }

    /**
     *
     */
    public static int[] getFormationFromFile(int FormationKind) {

        try {
            String filename;
            switch (FormationKind) {
                case 1:
                    filename = "ladder";
                    break;
                case 2:
                    filename = "sneakysnake";
                    break;
                case 3:
                    filename = "wildgoose";
                    break;
                default:
                    System.out.println("ÄãÊäÄãÂèÄØ£¿");
                    filename = null;
                    break;
            }

            FileReader fileReader = new FileReader("res/Formation/" + filename + ".txt");

            char[] cbuf = new char[500];
            int b = fileReader.read(cbuf, 0, 500);
            fileReader.close();

            int result[] = StringUtils.string2Integer(String.valueOf(cbuf), BFMAXSIZE);

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            return result;
        } catch (IOException e) {
            System.out.println("No Formation File Found!");
            e.printStackTrace();
            return null;
        }
    }

    public static void initBattleField(int[] Formation, int firstSoldier) {
        battefield[0][firstSoldier] = 1;
        for (int count = 1; count < Formation.length; count++) {
            battefield[count][firstSoldier + Formation[count]] = 1;
        }

    }
}

