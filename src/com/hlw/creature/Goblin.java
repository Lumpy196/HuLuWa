package com.hlw.creature;

import com.hlw.worldcraft.Field;

public class Goblin extends Monster{


    public Goblin(int axis_x, int axis_y, Field field) {
        super(axis_x, axis_y, field);
		// TODO Auto-generated constructor stub
        this.setImage(this.getClass().getClassLoader().getResource("goblin.png"));
        this.setHealth(100);
        this.setOffense(20);
        this.setCreatureName("goblin");
    }


	
}
