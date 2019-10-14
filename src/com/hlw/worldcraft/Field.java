package com.hlw.worldcraft;


import com.hlw.Thing2D;
import com.hlw.creature.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JPanel;

public class Field extends JPanel {

    private static final int OFFSET = 20;
    private static final int SPACE = 20;
    private static final int MAXSIZE = 15;

    private boolean battleStart = false;

    private ArrayList tiles = new ArrayList();
    private ArrayList<Creature> aliveHuman = new ArrayList<Creature>();
    private ArrayList<Creature> aliveMonster = new ArrayList<Creature>();
    private ArrayList<Creature> aliveCreatures = new ArrayList<Creature>();

    private ArrayList<ArrayList<Grid>> grids = new ArrayList<>();

    private ArrayList<Creature> players = new ArrayList<>();

    private ArrayList<Thread> threads = new ArrayList<>();

    private int weight = OFFSET + MAXSIZE * SPACE;
    private int height = OFFSET + MAXSIZE * SPACE;

    private boolean completed = false;


    public Field() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getOFFSET() {
        return OFFSET;
    }

    public int getSPACE() {
        return SPACE;
    }

    public int getMaxsize() {
        return MAXSIZE;
    }

    public Grid getGrid(int axis_x, int axis_y) {
        return this.grids.get(axis_x).get(axis_y);
    }

    public int getBoardWidth() {
        return this.weight;
    }

    public int getBoardHeight() {
        return this.height;
    }

    public boolean killCreatures(Creature creature) {
        creature.killCreature();
        if (creature instanceof Human) {
            aliveHuman.remove(creature);
        } else if (creature instanceof Monster) {
            aliveMonster.remove(creature);
        } else {
            return false;
        }
        aliveCreatures.remove(creature);
        return true;
    }

    public final void initCreatures() {

        aliveHuman.add(new HuLuWa(0, 1, HuLuWa.COLOR.RED, this));
        aliveHuman.add(new HuLuWa(0, 2, HuLuWa.COLOR.ORANGE, this));
        aliveHuman.add(new HuLuWa(2, 3, HuLuWa.COLOR.YELLOW, this));
        aliveHuman.add(new HuLuWa(0, 3, HuLuWa.COLOR.GREEN, this));
        aliveHuman.add(new HuLuWa(0, 4, HuLuWa.COLOR.CYAN, this));
        aliveHuman.add(new HuLuWa(0, 5, HuLuWa.COLOR.BLUE, this));
        aliveHuman.add(new HuLuWa(10, 5, HuLuWa.COLOR.PURPLE, this));

        aliveHuman.add(new Grandpa(1, 1, this));

        aliveCreatures.addAll(aliveHuman);

        aliveMonster.add(new Goblin(6, 1, this));
        aliveMonster.add(new Goblin(6, 2, this));
        aliveMonster.add(new Goblin(6, 3, this));
        aliveMonster.add(new Goblin(6, 4, this));
        aliveMonster.add(new Goblin(6, 5, this));
        aliveMonster.add(new Goblin(6, 6, this));

        aliveMonster.add(new Snake(5, 1, this));
        aliveMonster.add(new Scorpion(5, 2, this));

        aliveCreatures.addAll(aliveMonster);

    }

    public final void initWorld() {

        for (int axis_x = 0; axis_x < MAXSIZE; axis_x++) {
            ArrayList<Grid> gridCol = new ArrayList<>();
            for (int axis_y = 0; axis_y < MAXSIZE; axis_y++) {
                gridCol.add(new Grid(axis_x, axis_y, null));
            }
            this.grids.add(gridCol);
        }

        initCreatures();

        for (int axis_x = 0; axis_x < MAXSIZE; axis_x++) {
            for (int axis_y = 0; axis_y < MAXSIZE; axis_y++) {
                tiles.add(new Tile(axis_x, axis_y));
            }
        }

        players = aliveHuman;

    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList world = new ArrayList();
        world.addAll(tiles);
        world.addAll(players);

        for (int i = 0; i < world.size(); i++) {

            Thing2D item = (Thing2D) world.get(i);
            if (item instanceof Creature) {
                g.drawImage(item.getImage(), item.getAxis_x() * SPACE + OFFSET + 2, item.getAxis_y() * SPACE + OFFSET + 2, this);
            } else {
                g.drawImage(item.getImage(), item.getAxis_x() * SPACE + OFFSET, item.getAxis_y() * SPACE + OFFSET, this);
            }

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

            if (key == KeyEvent.VK_S && battleStart == false) {
                battleStart = true;
                ListIterator<Creature> listIterator = players.listIterator();
                while (listIterator.hasNext()) {
                    Creature player = listIterator.next();
                    Thread thread = new Thread(player);
                    //thread.setName(player.getImage().toString());
                    //System.out.println(thread.getName());
                    threads.add(thread);
                    thread.start();
                }

            } else if (key == KeyEvent.VK_R) {
                try {
                    restartLevel();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            repaint();
        }
    }

    public void killThread() throws InterruptedException {

        ListIterator<Creature> listIterator = players.listIterator();
        while (listIterator.hasNext()) {
            Creature player = listIterator.next();
            player.setThreadIsAlive(false);

        }
        threads.clear();
    }

    public void restartLevel() throws InterruptedException {
        System.out.println("Start to clean the trash.");
        tiles.clear();


        killThread();

        players.clear();
        aliveHuman.clear();
        aliveMonster.clear();
        aliveCreatures.clear();

        battleStart = false;

        System.out.println(Thread.activeCount());

        initWorld();

        if (completed) {
            completed = false;
        }
    }
}