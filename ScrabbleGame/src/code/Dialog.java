package code;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Dialog extends JFrame {
	
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

	public Dialog(Scrabble scrabble){
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

	private class SaveL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			try {
				new SaveGame(_scrabble);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void run(JFrame frame, int width, int height) {
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
