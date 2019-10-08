package com.Lumpy.creature;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Creature {


	private int index;
	//private int counter = 111;
	private String name;
	private int axis_x;
	private int axis_y;
	//private static int health = 100;
	private Image image;
	private String imageIndex;

	public Creature(String name, int axis_x, int axis_y, int index, String imageIndex) {
		this.name = name;
		this.axis_x = axis_x;
		this.axis_y = axis_y;
		this.index = index;
		this.imageIndex = imageIndex + ".jpg";

		try {
			this.image = ImageIO.read(new FileInputStream("res/image/" + this.imageIndex));
		} catch (IOException e) {
			System.out.println("No Image File Found!");
			e.printStackTrace();
		}

	}

	public void move() {
		//Todo: Rules for the Routes of the creatures
	}

	public void attack() {
		//Todo: Rules for the methods that creatures use to attack each other.
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAxis_x() {
		return axis_x;
	}

	public void setAxis_x(int axis_x) {
		this.axis_x = axis_x;
	}

	public int getAxis_y() {
		return axis_y;
	}

	public void setAxis_y(int axis_y) {
		this.axis_y = axis_y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(String imageIndex) {
		this.imageIndex = imageIndex;
	}

	public void checkUp(){
		System.out.println("葫芦娃:" + name + "坐标为:" + axis_x + axis_y);
	}
}
