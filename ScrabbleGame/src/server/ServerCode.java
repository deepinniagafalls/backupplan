package server;

import java.util.ArrayList;

import someInterfaceStuff.IServer;

public class ServerCode implements IServer, Runnable {

	private int _numOfPlayers, _turn;
	private ArrayList<Player> _players;
	private Board  _board;
	private Inventory _inv;
	private ServerCode _scrabble;
	
	public ServerCode(int numOfPlayers){
		_turn = 0;
		_scrabble = this;
		_numOfPlayers = numOfPlayers;
		_board = new Board(_scrabble);
		_inv = new Inventory(_scrabble);
		_players = new ArrayList<Player>();
		for(int i = 0; i < _numOfPlayers; i++){_players.add(new Player(_scrabble,"Mike"));}
		System.out.println(_numOfPlayers);
		System.out.println(_players.size());
	}
	
	public void switchTurn(){if(_turn<_numOfPlayers){_turn++;} else{_turn=0;}}
	public int getTurn(){return _turn;}
	public Board getBoard(){return _board;}
	public Inventory getInventory(){return _inv;}
	public int getNumberofPlayers(){return _numOfPlayers;}
	public Player getPlayer(int i){return _players.get(i);}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
