package com.Lumpy;

import java.util.*;

import com.Lumpy.Utils.FormationUtils;
import com.Lumpy.creature.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Creature> aliveHuman = new ArrayList<>();

        List<Creature> aliveMonster = new ArrayList<>();
        
        HuLuWa calabash[] = new HuLuWa[7];

        calabash[0] = new HuLuWa("大娃", 0, 0, 0, HuLuWa.COLOR.RED);
        calabash[1] = new HuLuWa("二娃", 0, 1, 1, HuLuWa.COLOR.ORANGE);
        calabash[2] = new HuLuWa("三娃", 0, 2, 2, HuLuWa.COLOR.YELLOW);
        calabash[3] = new HuLuWa("四娃", 0, 3, 3, HuLuWa.COLOR.GREEN);
        calabash[4] = new HuLuWa("五娃", 0, 4, 4, HuLuWa.COLOR.CYAN);
        calabash[5] = new HuLuWa("六娃", 0, 5, 5, HuLuWa.COLOR.BLUE);
        calabash[6] = new HuLuWa("七娃", 0, 6, 6, HuLuWa.COLOR.PURPLE);

        for (int i = 0; i < calabash.length; i++) {
            aliveHuman.add(calabash[i]);
        }

        Grandpa grandpa = new Grandpa("爷爷", 1, 3, 7);

        aliveHuman.add(grandpa);

        Snake snake = new Snake("蛇精", 5, 4, 8);
        Scorpion scorpion = new Scorpion("蝎子", 7, 8, 9);

        aliveMonster.add(snake);
        aliveMonster.add(scorpion);

        Goblin goblin[] = new Goblin[8];
        for (int i = 0; i < 8; i++) {
            String goblinName = new String();
            goblinName = "小妖" + String.valueOf(i + 1);
            goblin[i] = new Goblin(goblinName, 6, i + i % 2, 0);
            aliveMonster.add(goblin[i]);
        }


        Iterator<Creature> iterator1 = aliveHuman.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next().getName() + " ");
        }

        int a;
        do {
            //BattleField.getBattefield();


            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
/*            int[] temp = FormationUtils.getFormationFromFile(a);
            Battlefield.initBattleField(temp, 0);
            Battlefield.getBattefield();
            for (int i = 0; i < Battlefield.battefield.length; i++) {
                for (int j = 0; j < Battlefield.battefield[0].length; j++) {
                    if (j < calabash.length && i < calabash.length && Battlefield.battefield[i][j] == 1) {
                        System.out.printf("%s ", calabash[i].getName());
                    } else {
                        System.out.print("████ ");
                    }
                }
                System.out.println();
            }
            Battlefield.cleanBattlefield();*/


        } while (a != 5);


    }

}
