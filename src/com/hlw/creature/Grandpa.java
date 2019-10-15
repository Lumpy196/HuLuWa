package com.hlw.creature;

import com.hlw.worldcraft.Field;

public class Grandpa extends Human{

	public Grandpa(int axis_x, int axis_y, Field field) {
		super(axis_x, axis_y, field);
		// TODO Auto-generated constructor stub

        this.setImage(this.getClass().getClassLoader().getResource("grandpa.png"));
        this.setHealth(200);
        this.setOffense(0);
	}
}
