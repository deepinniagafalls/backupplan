package client;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import sever.Board;
import sever.LoadGame;
import sever.Player;
import sever.SaveGame;
import sever.Scrabble;

public class GUI extends JFrame{

	private JButton[][] _boardOfButtons = new BoardTileGUI[20][20];
	private Board _b;
	private Scrabble _scrabble;
	private ArrayList<RackGUI> _rackGUI;
	private DialogBox _dialogBox;
	
	public GUI(Scrabble s){
		// try {
	         //   UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
	       // } catch(Exception e) {
	      //      e.printStackTrace();
	      //  } 
		_scrabble = s;	_b = _scrabble.getBoard();
		JFrame frame = new JFrame("Scrabble");	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 1100);	GridLayout grid = new GridLayout(20, 20, 0, 0);	frame.setLayout(grid);
		_rackGUI = new ArrayList<RackGUI>();
		for(int row=0; row<20; row++){
			for(int col=0; col<20; col++){
				int letterMultiplier = _b.getLetterMultiplier((row*20)+col);
				int wordMultiplier = _b.getWordMultiplier((row*20)+col);
				frame.add(_boardOfButtons[row][col] = new BoardTileGUI(row, col, letterMultiplier, wordMultiplier));
			}
		}
		frame.setVisible(true);
		
		for(int i = 0; i <_scrabble.getNumberofPlayers(); i++){
			_rackGUI.add(new RackGUI(_scrabble.getPlayer(i)));
		}
		
		_dialogBox = new DialogBox(_scrabble);
		
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

	private class RackTileGUI extends JButton {
		private int _row,_col,_letterMult,_wordMult;
		private RackTileGUI(int row, int col, int letterMult, int wordMult){
			_row = row; _col = col; _letterMult = letterMult; _wordMult = wordMult;
		}
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class BoardTileGUI extends JButton{
		private int _row,_col,_letterMult,_wordMult;
		private BoardTileGUI(int row, int col, int letterMult, int wordMult){
			_row = row; _col = col; _letterMult = letterMult; _wordMult = wordMult;
		}
		
		public void actionPerformed(ActionEvent e) {
			
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
					frame.add(_rackOfButtons[row][col] = new RackTileGUI(row, col, 1, 1));
				}
				frame.setTitle(_player.getName() + "'s Tile Rack"); frame.setVisible(true);
		}
		
		public JButton[][] getRackOfButtons(){return _rackOfButtons;}
		public Player getPlayer(){return _player;}
	}

	private class DialogBox extends JFrame{
			
			private static final long serialVersionUID = 1L;
			private JTextField filename = new JTextField(), dir = new JTextField();
			private JButton open = new JButton("Open"), save = new JButton("Save");
			private JButton pass = new JButton("Pass");
			private Scrabble _scrabble;
			private int _currentTurn,_numberOfPlayers;
			private int _c = 0;
			private JLabel label1;
			private boolean _isPlayerFrameStillEmpty = false;
			private ArrayList<String> name = new ArrayList<String>();

			private DialogBox(Scrabble scrabble){
				String path = "Documents/words.txt";
				_scrabble = scrabble;
			    JFrame frame = new JFrame();   JPanel p = new JPanel();
				p.add(open);p.add(save);p.add(pass);
				open.addActionListener(new OpenL());save.addActionListener(new SaveL());pass.addActionListener(new PassT());
				label1 = new JLabel("Turn: " + "Mike",null,JLabel.CENTER);
				
				
				Container cp = getContentPane();
				cp.add(p, BorderLayout.SOUTH);
				p.add(label1);
				
				dir.setEditable(false);
				filename.setEditable(false);
				p.setLayout(new GridLayout(1, 3));
				cp.add(p, BorderLayout.NORTH);
				
				
				frame.add(p);
				p.setVisible(true);
				frame.pack();
				frame.setVisible(true);
			}
			


			public class OpenL implements ActionListener {

				public void actionPerformed(ActionEvent e) {
						try {
							new LoadGame();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				}
			}

			public class SaveL implements ActionListener {
				
				public void actionPerformed(ActionEvent e) {
					try {
						new SaveGame(_scrabble);
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			private void run(JFrame frame, int width, int height) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(width, height);
				frame.setVisible(true);
			}

			private class PassT implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					_scrabble.switchTurn();
				}

				
				}

	}

			public int scoreHelper(char c){
				if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
					return 1;
				}
				if(c=='B' || c=='C' || c=='D' || c=='F' || c=='G' || c=='H' || c=='J' || c=='K' || c=='L' || c=='M' || c=='N' || c=='P' || c=='Q' || c=='R' || c=='S' || c=='T' || c=='V' || c=='W' || c=='X' || c=='Z'){
					return 5;
				}
				if(c=='Y'){
					return 2;
				}
				return 0;
			}
			

}

		
	


