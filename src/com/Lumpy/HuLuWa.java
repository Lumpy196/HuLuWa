package com.Lumpy;

enum COLOR{
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}
public class HuLuWa extends Human {
	private int index;
	private int counter = 1;
	private COLOR color;
	public HuLuWa(String name,int axis_x, int axis_y, int index, COLOR color){
		super(name,axis_x,axis_y);
		this.setName(name);
		this.index = index;
		this.color = color;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public COLOR getColor() {
		return color;
	}
	public void setColor(COLOR color) {
		this.color = color;
	}
	
	public void checkUp(){
		System.out.println("��«��:" +this.getName()+ "����Ϊ:" +this.getAxis_x() +this.getAxis_y());
	}
}
