package com.hlw.creature;


import com.hlw.worldcraft.Field;

import java.net.URL;

public class HuLuWa extends Human {

	public enum COLOR {
		RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
	}

	private COLOR color;

	public HuLuWa(int axis_x, int axis_y, COLOR color, Field field) {
		super(axis_x, axis_y, field);
		this.color = color;
		String imageName = new String();
		switch (this.color) {
			case RED: {
                imageName = "red.png";
				break;
			}

			case ORANGE: {
                imageName = "orange.png";
				break;
			}

			case YELLOW: {
                imageName = "yellow.png";
				break;
			}

			case GREEN: {
                imageName = "green.png";
				break;
			}

			case CYAN: {
                imageName = "cyan.png";
				break;
			}

			case BLUE: {
                imageName = "blue.png";
				break;
			}

			case PURPLE: {
                imageName = "purple.png";
				break;
			}

			default: {
				System.out.println("We don't have a HuLuWa named as" + color);
				break;
			}
		}

		URL location = this.getClass().getClassLoader().getResource(imageName);
		this.setImage(location);

        this.setHealth(300);
        this.setOffense(100);
	}


	public COLOR getColor() {
		return color;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}


}

