package code;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame {

	private JButton[][] _boardOfButtons = new JButton[20][20];
	private Board _b;
	private Scrabble _scrabble;
	private ArrayList<RackGUI> _rackGUI;
	
	public GUI(Scrabble s){
		 try {
	            UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		_scrabble = s;
		_b = _scrabble.getBoard();
		JFrame frame = new JFrame("Scrabble");	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 1100);	GridLayout grid = new GridLayout(20, 20, 0, 0);	frame.setLayout(grid);
		_rackGUI = new ArrayList<RackGUI>();
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				int letterMultiplier = _b.getLetterMultiplier((row*20)+col);
				int wordMultiplier = _b.getWordMultiplier((row*20)+col);
				frame.add(_boardOfButtons[row][col] = new TileGUI(row, col, letterMultiplier, wordMultiplier));
			}
		}
		frame.setVisible(true);
		
		for(int i = 0; i <_scrabble.getNumberofPlayers(); i++){
			_rackGUI.add(new RackGUI(_scrabble.getPlayer(i)));
		}
		
	}
	
	public void update(){
		updateBoard();
		updateRacks();
	}
	
	public void updateRacks(){
		for(int i = 0; i < _scrabble.getNumberofPlayers(); i++){
			for(int j = 0; j < 12; j++){
				_rackGUI.get(i).getRackOfButtons()[0][j].setText(_rackGUI.get(i).getPlayer().getTileRack().getTile(j).getChar());}}}
	
	public void updateBoard(){	
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				int letterMultiplier = _b.getLetterMultiplier((row*20)+col);
				int wordMultiplier = _b.getWordMultiplier((row*20)+col);
				//frame.add(_boardOfButtons[row][col] = new TileGUI(row, col, letterMultiplier, wordMultiplier));
				_boardOfButtons[row][col].setText(Integer.toString((letterMultiplier)) + "," + Integer.toString(wordMultiplier));
			}
		}
	}

	private class TileGUI extends JButton {
		private int _row,_col,_letterMult,_wordMult;
		private TileGUI(int row, int col, int letterMult, int wordMult){
			_row = row; _col = col; _letterMult = letterMult; _wordMult = wordMult;
		}
	}

	private class RackGUI{
		
		private JButton[][] _rackOfButtons = new JButton[1][12];
		private JLabel _points = new JLabel("Points: 0000");
		private Player _player;
		private ArrayList<String> _letters;
		
		private RackGUI(Player player){
				_player = player;
				JFrame frame = new JFrame("Tile Rack"); frame.add(_points);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(1500, 103);
				GridLayout grid = new GridLayout(1, 0, 0, 0); frame.setLayout(grid);
				int row = 0;
				for(int col=0; col<12; col++){
					frame.add(_rackOfButtons[row][col] = new TileGUI(row, col, 1, 1));
				}
				frame.setTitle(_player.getName() + "'s Tile Rack"); frame.setVisible(true);
		}
		
		public JButton[][] getRackOfButtons(){return _rackOfButtons;}
		public Player getPlayer(){return _player;}
	}

}

