package  com.Lumpy;


public class Creature {
	private int counter = 111;
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	private String name;
	private int axis_x;
	private int axis_y;
	public Creature(String name, int axis_x, int axis_y){
		this.name = name;
		this.axis_x = axis_x;
		this.axis_y = axis_y;
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
	public void checkUp(){
		System.out.println("������:" +name+ "����Ϊ:" +axis_x +axis_y);
	}
}