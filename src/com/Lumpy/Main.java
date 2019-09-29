package com.Lumpy;

import java.util.*;

import com.Lumpy.creature.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Creature> Ground = new ArrayList<>();
        HuLuWa calabash[] = new HuLuWa[7];
        calabash[0] = new HuLuWa("´óÍÞ", 0, 0, 0, HuLuWa.COLOR.RED);
        calabash[1] = new HuLuWa("¶þÍÞ", 0, 1, 1, HuLuWa.COLOR.ORANGE);
        calabash[2] = new HuLuWa("ÈýÍÞ", 0, 2, 2, HuLuWa.COLOR.YELLOW);
        calabash[3] = new HuLuWa("ËÄÍÞ", 0, 3, 3, HuLuWa.COLOR.GREEN);
        calabash[4] = new HuLuWa("ÎåÍÞ", 0, 4, 4, HuLuWa.COLOR.CYAN);
        calabash[5] = new HuLuWa("ÁùÍÞ", 0, 5, 5, HuLuWa.COLOR.BLUE);
        calabash[6] = new HuLuWa("ÆßÍÞ", 0, 6, 6, HuLuWa.COLOR.PURPLE);

        Grandpa grandpa = new Grandpa("Ò¯Ò¯", 1, 3, 7);

        Snake snake = new Snake("Éß¾«", 5, 4, 8);
        Goblin goblin[] = new Goblin[8];
        for (int i = 0; i < 8; i++) {
            String goblinName = new String();
            goblinName = "Ð¡Ñý" + String.valueOf(i + 1);
            goblin[i] = new Goblin(goblinName, 6, i + i % 2, 0);
            Ground.add(goblin[i]);

        }


        for (int i = 0; i < calabash.length; i++) {
            Ground.add(calabash[i]);
        }

        Iterator<Creature> iterator1 = Ground.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next().getName() + " ");
        }

        int a;
        do {
            //BattleField.getBattefield();


            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
            int[] temp = BattleField.getFormationFromFile(a);
            BattleField.initBattleField(temp, 0);
            BattleField.getBattefield();
            for (int i = 0; i < BattleField.battefield.length; i++) {
                for (int j = 0; j < BattleField.battefield[0].length; j++) {
                    if (j < calabash.length && i < calabash.length && BattleField.battefield[i][j] == 1) {
                        System.out.printf("%s ", calabash[i].getName());
                    } else {
                        System.out.print("¨€¨€¨€¨€ ");
                    }
                }
                System.out.println();
            }
            BattleField.cleanBattlefield();


        } while (a != 5);


    }

}
