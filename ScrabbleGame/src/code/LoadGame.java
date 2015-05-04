package code;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class LoadGame {	
	
	private String _fileToRead;
	private Scrabble _scrabble;

	private String[] _tokens;

	
	public LoadGame() throws IOException{

		JFrame jf = new JFrame();
		FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.LOAD);
		chooser.setDirectory("C:\\"); chooser.setFile("*.txt");
		chooser.setVisible(true); String filename = chooser.getFile();
		String path = chooser.getDirectory(); 
		//System.out.println(path);
		String filetoRead = path + filename; _fileToRead = filetoRead;
		File file = new File(_fileToRead); FileReader fw = new FileReader(file.getAbsoluteFile());
		BufferedReader bw = new BufferedReader(fw);
		
		String s = (bw.readLine());
		String delims = "%";
		_tokens = s.split(delims);
		
		for (int i = 0; i < _tokens.length; i++){
			
		    System.out.println(_tokens[i]);
		    System.out.print("....................");
		    
		}
		
		updatePlayers();
		updateBoard();
		
		
		}
	
	public void updateBoard(){
		String boardRep = _tokens[5];
		Board board = _scrabble.getBoard();
		for(int row = 0; row < 20; row ++){
			for(int col = 0; col < 20; col ++){
				if(boardRep.charAt((row*20)+col) == '-'){
					board.setTile(null,row,col);
				}
				else{
					char i = boardRep.charAt((row*20)+col);
					if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
						board.setTile(new Tile(i,1),row,col);
					}
					else if(i == 'Y'){
						board.setTile(new Tile(i,2),row,col);
					}
					else{
						board.setTile(new Tile(i,5),row,col);}}}}}
	
	public void updatePlayers(){
		String playerRep = _tokens[2];
		String [] playerList = playerRep.split(";");
		int numOfPlayers = playerList.length;
		_scrabble = new Scrabble(numOfPlayers);
		for(int i = 0; i < numOfPlayers; i++){
			String[] info = playerList[i].split(",");
			_scrabble.getPlayer(i).setName(info[0]);
			_scrabble.getPlayer(i).setColor(info[1]);
		}
	}

		String[] tokens = s.split(delims);
		
		for (int i = 0; i < tokens.length; i++){
			
		    System.out.println(tokens[i]);
		    System.out.print("....................");
		    
		}
		
		String boardRep = tokens[10];
		
		//System.out.println(boardRep);
		
		
		//Scrabble _scrabble = new Scrabble(1);
		Board board = _scrabble.getBoard();
		
		
		for(int row = 0; row < 20; row ++){
			for(int col = 0; col < 20; col ++){
				if(boardRep.charAt((row*20)+col) == '-'){
					board.setTile(null,row,col);
				}
				else{
					char i = boardRep.charAt((row*20)+col);
					if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
						board.setTile(new Tile(i,1),row,col);
					}
					else if(i == 'Y'){
						board.setTile(new Tile(i,2),row,col);
					}
					else{
						board.setTile(new Tile(i,5),row,col);
					}
				}
			}
		}
		
		}

}


