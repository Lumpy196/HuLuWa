package com.Lumpy;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HuLuWa calabash[] = new HuLuWa[7];
        calabash[0] = new HuLuWa("大娃", 0, 0, 0, COLOR.RED);
        calabash[1] = new HuLuWa("二娃", 0, 1, 1, COLOR.ORANGE);
        calabash[2] = new HuLuWa("三娃", 0, 2, 2, COLOR.YELLOW);
        calabash[3] = new HuLuWa("四娃", 0, 3, 3, COLOR.GREEN);
        calabash[4] = new HuLuWa("五娃", 0, 4, 4, COLOR.CYAN);
        calabash[5] = new HuLuWa("六娃", 0, 5, 5, COLOR.BLUE);
        calabash[6] = new HuLuWa("七娃", 0, 6, 6, COLOR.PURPLE);

        Grandpa grandpa = new Grandpa("??", 1, 3);

        Snake snake = new Snake("蛇精", 5, 4);
        Goblin goblin[] = new Goblin[8];
        for (int i = 0; i < 8; i++) {
            String goblinName = new String();
            goblinName = "" + String.valueOf(i + 1);
            goblin[i] = new Goblin(goblinName, 6, i + i % 2, 0);
        }

        BattleField.getBattefield();
        int[] temp = BattleField.getFormationFromFile(1);
        BattleField.initBattleField(temp, 1);
        BattleField.getBattefield();

    }

}
