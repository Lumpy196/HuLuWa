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

    private volatile boolean threadIsAlive;

    public Creature(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y);

        this.field = field;

        this.grid = this.field.getGrid(axis_x, axis_y);

        this.grid.setOccupier(this);

        grid = this.field.getGrid(axis_x, axis_y);

        threadIsAlive = true;


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

    public boolean threadIsAlive() {
        return threadIsAlive;
    }

    public void setThreadIsAlive(boolean threadIsAlive) {
        this.threadIsAlive = threadIsAlive;
    }

    public void killCreature() {
        threadIsAlive = false;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean move(int axis_x, int axis_y) {
        //Todo: Rules for the Routes of the creatures
        int nx = this.getAxis_x() + axis_x;

        if (nx >= this.field.getMaxsize() || nx < 0) {
            nx = this.getAxis_x() - 2 * axis_x;
        }

        int ny = this.getAxis_y() + axis_y;

        if (ny >= this.field.getMaxsize() || ny < 0) {
            ny = this.getAxis_y() - 2 * axis_y;
        }
        synchronized (this.field.getGrid(nx, ny)) {
            if (this.field.getGrid(nx, ny).isEmptyOccupier()) {

                this.grid.clearOccupier();
                this.grid = this.field.getGrid(nx, ny);
                this.grid.setOccupier(this);
                this.setAxis_x(nx);
                this.setAxis_y(ny);

                return true;
            } else if (this.field.getGrid(nx, ny).getOccupier().isHumanity() != this.isHumanity()) {
                attack(axis_x, axis_y);
                return true;

            } else {
                return false;
            }
        }

    }

    public boolean attack(int axis_x, int axis_y) {
        //Todo: Rules for the methods that creatures use to attack each other.

        int nx = axis_x + this.getAxis_x();
        int ny = axis_y + this.getAxis_y();

        Creature enemy = this.field.getGrid(nx, ny).getOccupier();

        this.setHealth(this.getHealth() - enemy.getOffense());
        enemy.setHealth(enemy.getHealth() - this.getOffense());

        if (this.getHealth() <= 0) {
            this.setThreadIsAlive(false);
            this.killCreature();
        }

        if (enemy.getHealth() <= 0) {
            this.setThreadIsAlive(false);
            this.killCreature();
        }

        return true;
    }

    @Override
    public void run() {
        while (threadIsAlive) {

            Random random = new Random();

            int goal_x = random.nextInt(6);
            int goal_y = random.nextInt(6);


            this.move(goal_x, goal_y);

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
            System.out.println("thread " + this.getName() + " is dead");
            this.grid.clearOccupier();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
