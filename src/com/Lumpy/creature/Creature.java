package com.Lumpy.creature;


import com.Lumpy.swingGUI.Field;
import com.Lumpy.swingGUI.Grid;
import com.Lumpy.swingGUI.Ground;


import java.util.ArrayList;
import java.util.Random;

public class Creature extends Thing2D implements Runnable {

    private Field field;

    private Grid grid;

    public Creature(int axis_x, int axis_y, Field field) {
		super(axis_x, axis_y);

        this.field = field;

        grid = this.field.getGrid(axis_x, axis_y);
        //grid.setOccupier(this);

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



        this.setAxis_x(nx);
        this.setAxis_y(ny);
        return true;
	}

	public void attack() {
		//Todo: Rules for the methods that creatures use to attack each other.
	}

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Random random = new Random();

            int goal_x = random.nextInt(5);
            int goal_y = random.nextInt(5);

            this.move(goal_x, goal_y);
            System.out.println("x+" + goal_x + ", y+" + goal_y);
            //this.move(rand.nextInt(10), rand.nextInt(10));
            try {

                Thread.sleep(random.nextInt(100) + 100);
                this.field.repaint();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
