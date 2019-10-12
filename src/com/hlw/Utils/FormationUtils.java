package com.hlw.Utils;

import com.hlw.creature.Creature;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FormationUtils {

    public static int[] string2Integer(String string, int length) {
        String[] temp = string.split(" ");
        int result[] = new int[length];
        for (int count = 0; count < length; count++) {
            result[count] = Integer.valueOf(temp[count]);
        }
        return result;
    }

    public static int[] getFormationFromFile(int formationKind, int formationlength) {

        try {
            String filename = null;
            switch (formationKind) {
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
                    System.out.println("ÄãËµÄãÂèÄØ£¿");
                    break;
            }

            FileReader fileReader = new FileReader("res/Formation/" + filename + ".txt");
            char[] cbuf = new char[500];
            int b = fileReader.read(cbuf, 0, 500);
            fileReader.close();

            return FormationUtils.string2Integer(String.valueOf(cbuf), formationlength);

        } catch (IOException e) {
            System.out.println("No Formation File Found!");
            e.printStackTrace();
            return null;
        }
    }

    public static void setFormation(int[] formation, int firstSoldier, List<Creature> creatures) {
        Iterator<Creature> iterator = creatures.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            creature.setAxis_x(count);
            creature.setAxis_y(firstSoldier + formation[count]);
            count++;
        }
    }
}
