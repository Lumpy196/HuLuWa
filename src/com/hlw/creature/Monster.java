package com.hlw.creature;

import com.hlw.worldcraft.Field;

public class Monster extends Creature{

    public Monster(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y, field);
		// TODO Auto-generated constructor stub
        this.setHumanity(false);
	}
	
}
