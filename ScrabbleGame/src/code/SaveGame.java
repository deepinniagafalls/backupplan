package code;
import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
			
			bw.write("%");
			String boardsize = "20 20";

			bw.write("%");
			bw.write(boardsize);
			
			bw.write("%");
			String content = "/part2/res/words.txt";
			bw.write(content);
			bw.write("%");
			
			for(int i = 0; i <_scrabble.getNumberofPlayers(); i = i + 1 ){
				Player p = _scrabble.getPlayer(i);
				p.getScore();
				p.getColor();
				PlayerFrame_047 pf = _bf.getPlayerFrame(i);
				bw.write("[" +p.getColor() + ", " + p.getScore() + "]");
				
				bw.write("%");
				bw.write("[");
				for(int j = 0; j <12; j = j+1){
					pf.getPlayerSpace(j).getTile().getChar();
					bw.write(pf.getPlayerSpace(j).getTile().getChar());
				}
				bw.write("]");
				bw.write("%");
			}
			
			int turn = _bf.getGame().getCurrentTurn();
			
			bw.write(" " + turn);
			bw.write("%");
			
			for(int i = 0; i < _scrabble.getInv().getSize(); i = i + 1 ){
				bw.write("[" + _scrabble.getInv().getTile(i).getChar() + "]");
			}
			bw.write("%");
			
			for(int i = 0; i<20; i = i + 1){
				for(int j = 0; j<20; j = j +1){
					if(_b.getTile(i, j) == null){
						bw.write("-");
					}
					else{
						_b.getTile(i, j).getChar();
						_bf.getTileSpace(i,j).getColor();
						bw.write("[" + _b.getTile(i, j).getChar() +  ", " + _bf.getTileSpace(i,j).getColor() + "]");
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

}
