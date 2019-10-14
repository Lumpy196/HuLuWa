package com.hlw.creature;


import com.hlw.Thing2D;
import com.hlw.worldcraft.Field;
import com.hlw.worldcraft.Grid;


import java.util.Random;

public class Creature extends Thing2D {

    private Field field;

    private Grid grid;

    private volatile boolean threadIsAlive;

    public Creature(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y);

        this.field = field;

        threadIsAlive = true;

        grid = this.field.getGrid(axis_x, axis_y);


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

                this.field.getGrid(nx, ny).setOccupier(this);
                this.field.getGrid(this.getAxis_x(), this.getAxis_y()).clearOccupier();
                this.setAxis_x(nx);
                this.setAxis_y(ny);
                this.grid.setAxis_x(nx);
                this.grid.setAxis_y(ny);
                if (this instanceof HuLuWa) {
                    //System.out.println(((HuLuWa) this).getColor() + ": x+" + axis_x + ", y+" + axis_y);
                }
                return true;
            } else {
                return false;
            }
        }

    }

    public void attack() {
        //Todo: Rules for the methods that creatures use to attack each other.
    }

    @Override
    public void run() {
        while (threadIsAlive) {

            Random random = new Random();

            int goal_x = random.nextInt(5);
            int goal_y = random.nextInt(5);

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