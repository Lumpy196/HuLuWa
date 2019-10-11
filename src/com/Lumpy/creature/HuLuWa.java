package com.Lumpy.creature;


import java.awt.*;
import java.lang.invoke.SwitchPoint;
import java.net.URL;

public class HuLuWa extends Human {

	private COLOR color;

	public HuLuWa(int axis_x, int axis_y, COLOR color) {
		super(axis_x, axis_y);
		this.color = color;
		String imageName = new String();
		switch (this.color) {
			case RED: {
				imageName = "1.png";
				break;
			}

			case ORANGE: {
				imageName = "2.png";
				break;
			}

			case YELLOW: {
				imageName = "3.png";
				break;
			}

			case GREEN: {
				imageName = "4.png";
				break;
			}

			case CYAN: {
				imageName = "5.png";
				break;
			}

			case BLUE: {
				imageName = "6.png";
				break;
			}

			case PURPLE: {
				imageName = "7.png";
				break;
			}

			default: {
				System.out.println("We don't have a HuLuWa named as" + color);
				break;
			}
		}

		URL location = this.getClass().getClassLoader().getResource(imageName);
		this.setImage(location);
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

