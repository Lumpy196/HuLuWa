package com.hlw.creature;

import com.hlw.worldcraft.Field;

public class Snake extends Monster{

    public Snake(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y, field);
		// TODO Auto-generated constructor stub
        this.setImage(this.getClass().getClassLoader().getResource("snake.png"));
        this.setHealth(800);
        this.setOffense(100);
        this.setCreatureName("snake");
	}
	
}
