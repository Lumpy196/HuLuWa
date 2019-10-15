package com.hlw.creature;

import com.hlw.worldcraft.Field;

public class Scorpion extends Monster{

    public Scorpion(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y, field);
		// TODO Auto-generated constructor stub
        this.setImage(this.getClass().getClassLoader().getResource("scorpion.png"));
        this.setHealth(1000);
        this.setOffense(150);
	}
	
}
