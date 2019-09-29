package com.Lumpy.Utils;

import java.io.FileReader;
import java.io.IOException;

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
                    System.out.println("��˵�����أ�");
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
}
