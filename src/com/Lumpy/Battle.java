package  com.Lumpy;


public class Battle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuLuWa calabash[] = new HuLuWa[7];
		calabash[0] = new HuLuWa("´óÍÞ", 0, 0, 0, COLOR.RED);
		calabash[1] = new HuLuWa("¶þÍÞ", 0, 1, 1, COLOR.ORANGE);
		calabash[2] = new HuLuWa("ÈýÍÞ", 0, 2, 2, COLOR.YELLOW);
		calabash[3] = new HuLuWa("ËÄÍÞ", 0, 3, 3, COLOR.GREEN);
		calabash[4] = new HuLuWa("ÎåÍÞ", 0, 4, 4, COLOR.CYAN);
		calabash[5] = new HuLuWa("ÁùÍÞ", 0, 5, 5, COLOR.BLUE);
		calabash[6] = new HuLuWa("ÆßÍÞ", 0, 6, 6, COLOR.PURPLE);
		
		Grandpa grandpa = new Grandpa("Ò¯Ò¯", 1, 3);
		
		Snake snake = new Snake("Éß¾«", 5, 4);
		Goblin goblin[] = new Goblin[8];
		for(int i = 0;i < 8;i++){
			String goblinName = new String();
			goblinName = "à¶†ª" +String.valueOf(i + 1);
			goblin[i] = new Goblin(goblinName, 6, i + i%2, 0);
			
			
		}
		for(int i = 0; i < 7;i++){
			//calabash[i].checkUp();
		}
		for(int i = 0; i < 8;i++){
			
			//System.out.println(goblin[i].getName());
		}
		GenerateFormation Formation = new GenerateFormation();
		Formation.PrintSurprise();
	}


}
