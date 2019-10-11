package com.Lumpy.creature;


import com.Lumpy.swingGUI.Field;

import java.util.Random;

public class Creature extends Thing2D implements Runnable {

    private Field field;

    public Creature(int axis_x, int axis_y, Field field) {
		super(axis_x, axis_y);

        this.field = field;

	}

    public void move(int axis_x, int axis_y) {
		//Todo: Rules for the Routes of the creatures
        int nx = this.getAxis_x() + axis_x;
        int ny = this.getAxis_y() + axis_y;
        this.setAxis_x(nx);
        this.setAxis_y(ny);

	}

	public void attack() {
		//Todo: Rules for the methods that creatures use to attack each other.
	}

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Random random = new Random();

            int goal_x = random.nextInt(20) - 5;
            int goal_y = random.nextInt(20) - 5;

            this.move(goal_x, goal_y);
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
