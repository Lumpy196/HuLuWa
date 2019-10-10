package com.Lumpy.swingGUI;


import com.Lumpy.creature.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Field extends JPanel {

    private final int OFFSET = 30;
    private final int SPACE = 20;

    private ArrayList tiles = new ArrayList();
    private Player player;

    private ArrayList<Creature> aliveHuman = new ArrayList<Creature>();
    private ArrayList<Creature> aliveMonster = new ArrayList<Creature>();

    private ArrayList<Creature> aliveCreatures = new ArrayList<Creature>();

    private int humanQuantity = 8;
    private int monsterQuantity = 8;

    private int creatureQuantity = humanQuantity + monsterQuantity;



    private int w = 0;
    private int h = 0;
    private boolean completed = false;

    private String level =
            "..........\n" +
                    "..........\n" +
                    "..........\n" +
                    "..........\n" +
                    "..........\n" +
                    "..........\n" +
                    "..........\n" +
                    "..........\n";

    public Field() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    public final void initCreatures() {

        aliveHuman.add(new HuLuWa(0, 1, HuLuWa.COLOR.RED));
        aliveHuman.add(new HuLuWa(0, 2, HuLuWa.COLOR.ORANGE));
        aliveHuman.add(new HuLuWa(0, 3, HuLuWa.COLOR.YELLOW));
        aliveHuman.add(new HuLuWa(0, 3, HuLuWa.COLOR.GREEN));
        aliveHuman.add(new HuLuWa(0, 4, HuLuWa.COLOR.CYAN));
        aliveHuman.add(new HuLuWa(0, 5, HuLuWa.COLOR.BLUE));
        aliveHuman.add(new HuLuWa(0, 6, HuLuWa.COLOR.PURPLE));
        aliveHuman.add(new Grandpa(1, 1));

        aliveCreatures.addAll(aliveHuman);

        aliveMonster.add(new Goblin(6, 1));
        aliveMonster.add(new Goblin(6, 2));
        aliveMonster.add(new Goblin(6, 3));
        aliveMonster.add(new Goblin(6, 4));
        aliveMonster.add(new Goblin(6, 5));
        aliveMonster.add(new Goblin(6, 6));

        aliveMonster.add(new Snake(5, 1));
        aliveMonster.add(new Scorpion(5, 2));

        aliveCreatures.addAll(aliveMonster);

    }

    public final void initWorld() {

        int x = OFFSET;
        int y = OFFSET;


        Tile a;


        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                if (this.w < x) {
                    this.w = x;
                }

                x = OFFSET;
            } else if (item == '.') {
                a = new Tile(x, y);
                tiles.add(a);
                x += SPACE;
            } else if (item == '@') {
                player = new Player(x, y, this);
                x += SPACE;
            } else if (item == ' ') {
                x += SPACE;
            }

            h = y;
        }

        player = new Player(0 + OFFSET, 0 + OFFSET,
                this);

    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList world = new ArrayList();
        world.addAll(tiles);


        world.add(player);


        for (int i = 0; i < world.size(); i++) {

            Thing2D item = (Thing2D) world.get(i);
            g.drawImage(item.getImage(), item.getAxis_x(), item.getAxis_y(), this);
/*            if (item instanceof Player) {
                g.drawImage(item.getImage(), item.getAxis_x() + 2, item.getAxis_y() + 2, this);
            } else {
                g.drawImage(item.getImage(), item.getAxis_x(), item.getAxis_y(), this);
            }*/

            if (completed) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (completed) {
                return;
            }


            int key = e.getKeyCode();


            if (key == KeyEvent.VK_LEFT) {


                player.move(-SPACE, 0);

            } else if (key == KeyEvent.VK_RIGHT) {


                player.move(SPACE, 0);

            } else if (key == KeyEvent.VK_UP) {


                player.move(0, -SPACE);

            } else if (key == KeyEvent.VK_DOWN) {


                player.move(0, SPACE);

            } else if (key == KeyEvent.VK_S) {

                new Thread(player).start();

            } else if (key == KeyEvent.VK_R) {
                restartLevel();
            }

            repaint();
        }
    }


    public void restartLevel() {

        tiles.clear();
        initWorld();
        if (completed) {
            completed = false;
        }
    }
}