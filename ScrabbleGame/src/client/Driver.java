package client;

import java.io.IOException;

import server.SaveGame;
import server.ServerCode;

public class Driver {
	
	public static void main(String args[]) throws IOException{
		ServerCode s = new ServerCode(2);
		GUI g = new GUI(s);
		g.update();
		SaveGame sg = new SaveGame(s);
		//LoadGame lg = new LoadGame();
	}
	
	
	
	public Driver(){
		
	}
}
