package com.Lumpy.creature;


public class HuLuWa extends Human {

	private COLOR color;

	public HuLuWa(String name, int axis_x, int axis_y, COLOR color) {
		super(name, axis_x, axis_y);
		this.color = color;
	}

	public enum COLOR {
		RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
	}

	public COLOR getColor() {
		return color;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}


}

