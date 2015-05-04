package code;
import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class SaveGame {
	
		private Scrabble _scrabble;
		private String _fileToWriteTo;
		
		public SaveGame(Scrabble s) throws IOException{

			_scrabble = s;
			JFrame jf = new JFrame();
			FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.SAVE);
			//FileDialog chooser = new FileDialog(j,"Save your file",FileDialog.LOAD);
			chooser.setDirectory("C:\\");chooser.setFile("*.txt");chooser.setVisible(true);
			String filename = chooser.getFile();
			String path = chooser.getDirectory();
			System.out.println(path);
			String filetoWrite = path + filename;
			_fileToWriteTo = filetoWrite;
			
			File file = new File(_fileToWriteTo);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			

			String boardsize = "20 20";
			bw.write(boardsize);
			bw.write("\r\n");
			
			String content = "/part2/res/words.txt";
			bw.write(content);
			bw.write("\r\n");
			
			for(int i = 0; i <_scrabble.getNumberofPlayers(); i = i + 1 ){
				Player p = _scrabble.getPlayer(i);
				
				bw.write("[" + p.getName() + "," +p.getColor() + "," + p.getScore());
				bw.write(",");
				bw.write("[");
				for(int j = 0; j <12; j = j+1){
					bw.write(p.getTileRack().getTile(j).getChar());
				}
				bw.write("]");
				bw.write("]");
				if(i < _scrabble.getNumberofPlayers()-1){
					bw.write(";");
				}
			}
			
			bw.write("\r\n");
			
			int turn = _scrabble.getTurn();
			bw.write(turn);
			bw.write("\r\n");
			
			for(int i = 0; i < _scrabble.getInventory().getSize(); i = i + 1 ){
				bw.write("[" + _scrabble.getInventory().getTile(i).getChar() + "]");
			}
			bw.write("\r\n");
			
			for(int i = 0; i<20; i = i + 1){
				for(int j = 0; j<20; j = j +1){
					if(_scrabble.getBoard().getTile(i, j) == null){
						bw.write("-");
					}
					else{
						_scrabble.getBoard().getTile(i, j).getChar();
						_scrabble.getBoard().getTile(i,j).getColor();
						bw.write("[" + _scrabble.getBoard().getTile(i, j).getChar() +  ", " + _scrabble.getBoard().getTile(i, j).getColor() + "]");
					}
					
				}
			}
			bw.close();
			System.out.println("Done");
			
		}
		
		
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(jaeheunk) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @date 2015-APRIL-10
		 * Method that writes to a file
		 */
		public void writeNewFile() throws IOException{
			
			
		}
		

}
