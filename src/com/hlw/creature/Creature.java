package com.hlw.creature;


import com.hlw.Thing2D;
import com.hlw.worldcraft.Field;
import com.hlw.worldcraft.Grid;


import java.util.Random;

public class Creature extends Thing2D {

    private Field field;

    private Grid grid;

    private int health;

    private int offense;

    private boolean humanity;

    private String creatureName;

    private volatile boolean threadIsAlive;

    public Creature(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y);

        this.field = field;

        this.grid = this.field.getGrid(axis_x, axis_y);

        this.grid.setOccupier(this);

        grid = this.field.getGrid(axis_x, axis_y);

        threadIsAlive = true;


    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public boolean isHumanity() {
        return humanity;
    }

    public void setHumanity(boolean humanity) {
        this.humanity = humanity;
    }

    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }

    public boolean threadIsAlive() {
        return threadIsAlive;
    }

    public void setThreadIsAlive(boolean threadIsAlive) {
        this.threadIsAlive = threadIsAlive;
    }

    public void killCreature() {
        this.threadIsAlive = false;
    }


    public boolean move(int distance_x, int distance_y) {
        //Todo: Rules for the Routes of the creatures
        int goal_x = this.getAxis_x() + distance_x;

        if (goal_x >= this.field.getMaxsize() || goal_x < 0) {
            goal_x = this.getAxis_x() - distance_x;
        }

        int goal_y = this.getAxis_y() + distance_y;

        if (goal_y >= this.field.getMaxsize() || goal_y < 0) {
            goal_y = this.getAxis_y() - distance_y;
        }
        try {
            synchronized (this.field.getGrid(goal_x, goal_y)) {
                if (this.field.getGrid(goal_x, goal_y).isEmptyOccupier()) {

                    System.out.println("Creature " + this.getCreatureName() + " moved from ("
                            + this.getAxis_x() + ", " + this.getAxis_y() + ") to ("
                            + goal_x + ", " + goal_y + ")");

                    this.grid.clearOccupier();
                    this.grid = this.field.getGrid(goal_x, goal_y);
                    this.grid.setOccupier(this);
                    this.setAxis_x(goal_x);
                    this.setAxis_y(goal_y);

                    return true;
                } else if (this.field.getGrid(goal_x, goal_y).getOccupier().isHumanity() != this.isHumanity()) {
                    attack(goal_x, goal_y);
                    return true;

                } else {
                    return false;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("fuck me");
            System.out.println(this.field.getGrid(goal_x, goal_y).getOccupier().getClass());
            System.out.println(this);
            e.printStackTrace();
            return false;
        }

    }

    public boolean attack(int goal_x, int goal_y) {
        //Todo: Rules for the methods that creatures use to attack each other.

        Creature enemy = this.field.getGrid(goal_x, goal_y).getOccupier();

        System.out.println("Creature " + this.getCreatureName()
                + " attacked " + enemy.getCreatureName()
                + " from (" + this.getAxis_x() + ", " + this.getAxis_y()
                + ") to (" + goal_x + ", " + goal_y + ")");

        this.setHealth(this.getHealth() - enemy.getOffense());
        enemy.setHealth(enemy.getHealth() - this.getOffense());

        if (this.getHealth() <= 0) {
            this.field.killCreatures(this);
            System.out.println("Creature " + enemy.getCreatureName() + " killed " + this.getCreatureName());
        }

        if (enemy.getHealth() <= 0) {
            this.field.killCreatures(enemy);
            System.out.println("Creature " + this.getCreatureName() + " retaliated and killed " + enemy.getCreatureName());
        }
        return true;
    }

    @Override
    public void run() {
        while (threadIsAlive) {

            Random random = new Random();

            int distance_x = random.nextInt(6) - 3;
            int distance_y = random.nextInt(6) - 3;

            this.move(distance_x, distance_y);

            try {
                Thread.sleep(random.nextInt(100) + 200);
                this.field.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
                threadIsAlive = false;
            }

        }
        try {
            sleep(100);
            System.out.println("Creature " + this.getCreatureName() + " is dead");
            this.grid.clearOccupier();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
