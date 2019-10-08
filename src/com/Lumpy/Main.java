package com.Lumpy;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.Lumpy.creature.*;
import com.Lumpy.swingGUI.SwingJFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException {
        // TODO Auto-generated method stub
        List<Creature> aliveHuman = new ArrayList<>();

        List<Creature> aliveMonster = new ArrayList<>();

        HuLuWa calabash[] = new HuLuWa[7];

 /*       calabash[0] = new HuLuWa("大娃", 0, 0, 0, HuLuWa.COLOR.RED);
        calabash[1] = new HuLuWa("二娃", 0, 0, 1, HuLuWa.COLOR.ORANGE);
        calabash[2] = new HuLuWa("三娃", 0, 0, 2, HuLuWa.COLOR.YELLOW);
        calabash[3] = new HuLuWa("四娃", 0, 0, 3, HuLuWa.COLOR.GREEN);
        calabash[4] = new HuLuWa("五娃", 0, 0, 4, HuLuWa.COLOR.CYAN);
        calabash[5] = new HuLuWa("六娃", 0, 0, 5, HuLuWa.COLOR.BLUE);
        calabash[6] = new HuLuWa("七娃", 0, 0, 6, HuLuWa.COLOR.PURPLE);

        for (int i = 0; i < calabash.length; i++) {
            aliveHuman.add(calabash[i]);
        }

        Grandpa grandpa = new Grandpa("爷爷", 0, 0, 7);
        aliveHuman.add(grandpa);

        Snake snake = new Snake("蛇精", 0, 0, 8);
        aliveMonster.add(snake);

        Scorpion scorpion = new Scorpion("蝎子", 0, 0, 9);
        aliveMonster.add(scorpion);

        Goblin goblin[] = new Goblin[8];

        for (int i = 0; i < 8; i++) {
            String goblinName = new String();
            goblinName = "小妖";
            goblin[i] = new Goblin(goblinName, 0, 0, 10 + i);
            aliveMonster.add(goblin[i]);
        }
*/

        SwingJFrame swingJFrame = new SwingJFrame();
        swingJFrame.setVisible(true);
/*
        int a, b;
        do {
            //Scanner scanner = new Scanner(System.in);
            //a = scanner.nextInt();
            //b = scanner.nextInt();
            int[] Formation1 = FormationUtils.getFormationFromFile(1, 15);
            int[] Formation2 = FormationUtils.getFormationFromFile(1, 15);
            FormationUtils.setFormation(Formation1, 1, aliveHuman);
            FormationUtils.setFormation(Formation2, 15, aliveMonster);
            Battlefield.setBattlefield(aliveHuman);
            Battlefield.setBattlefield(aliveMonster);
            Battlefield.printBattlefield();
            ScreenUtils.screenClear(200);
            Battlefield.cleanBattlefield();


        } while (true);
*/


    }

}
