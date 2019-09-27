package  com.Lumpy;


public class Creature {

	private int index;
	private int counter = 111;
	private String name;
	private int axis_x;
	private int axis_y;

	Creature(String name, int axis_x, int axis_y, int index) {
		this.name = name;
		this.axis_x = axis_x;
		this.axis_y = axis_y;
		this.index = index;
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
		System.out.println("葫芦娃:" +name+ "坐标为:" +axis_x +axis_y);
	}
}
