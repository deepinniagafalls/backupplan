package client;

import java.io.IOException;

import sever.SaveGame;
import sever.Scrabble;

public class Driver {
	
	public static void main(String args[]) throws IOException{
		Scrabble s = new Scrabble(2);
		GUI g = new GUI(s);
		g.update();
		SaveGame sg = new SaveGame(s);
		//LoadGame lg = new LoadGame();
	}
	
	
	
	public Driver(){
		
	}
}
