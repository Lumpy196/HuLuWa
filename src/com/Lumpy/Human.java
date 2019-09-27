package  com.Lumpy;



public class Human extends Creature{
	private int counter = 11;

	public Human(String name, int axis_x, int axis_y, int index) {
		super(name, axis_x, axis_y, index);
		// TODO Auto-generated constructor stub
	}
	public void checkUp(){
		System.out.println("人类名:" +this.getName()+ "坐标为:" +this.getAxis_x() +this.getAxis_y());
	}
}
