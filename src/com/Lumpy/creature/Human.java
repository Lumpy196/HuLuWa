package com.Lumpy.creature;



public class Human extends Creature{
	private int counter = 11;

	public Human(String name, int axis_x, int axis_y, int index, String imageIndex) {
		super(name, axis_x, axis_y, index, imageIndex);
		// TODO Auto-generated constructor stub
	}
	public void checkUp(){
		System.out.println("������:" +this.getName()+ "����Ϊ:" +this.getAxis_x() +this.getAxis_y());
	}
}
