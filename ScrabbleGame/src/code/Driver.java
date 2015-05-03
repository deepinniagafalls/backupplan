package code;

public class Driver {
	
	public static void main(String args[]){
		Scrabble s = new Scrabble(2);
		GUI g = new GUI(s);
		g.update();
		Dialog d = new Dialog(s);
	}
	
	
	public Driver(){
		
	}
}
