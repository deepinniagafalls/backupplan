package server;
import java.util.ArrayList;
import java.util.Random;

public class Board {

	private Tile[][] _board;
	private Tile _tempTile;
	private int[] _letterMultipliers = new int[400];
	private int[] _wordMultipliers = new int[400];
	private ArrayList<Integer> _letterIndexRepeats = new ArrayList<Integer>();
	private ArrayList<Integer> _wordIndexRepeats = new ArrayList<Integer>();
	private Random _rand;
	private ServerCode _scrabble;
	
	private Tile _currentTile;
	
	public Board(ServerCode s){
		_rand = new Random();
		_scrabble = s;
		_board = new Tile[20][20];
		addMultipliers(0,60,2);addMultipliers(60,100,3);addMultipliers(100,400,1);
		addWordMultipliers(0,40,2);addWordMultipliers(40,60,3);addWordMultipliers(60,400,1);
	}

	public void addTile(Tile t, int x, int y){
		_board[x][y] = t;
	}
	
	public Tile removeTile(int x, int y){
		Tile temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	public Tile getTile(int x, int y){return _board[x][y];}
	public void setTile(Tile t, int x, int y){_board[x][y] = t;} 
	public void setTempTile(Tile t){_tempTile = t;}
	public Tile getTempTile(){return _tempTile;}
	public int getLetterMultiplier(int index){return _letterMultipliers[index];}
	public int getWordMultiplier(int index){return _wordMultipliers[index];}
	public void setLetterMultiplier(int index){_letterMultipliers[index] = 1;}
	public void setWordMultipliers(int index){_wordMultipliers[index] = 1;}
	public void setCurrentTile(Tile t){_currentTile = t;}
	
	public void addMultipliers(int start, int end, int number){
		for(int i=start; i<end; i++){
			int temp = _rand.nextInt(400);
			while(_letterIndexRepeats.contains(temp)){
				temp = _rand.nextInt(400);
			}
			_letterIndexRepeats.add(temp);
			_letterMultipliers[temp] = number;
	}
	}
	
	public void addWordMultipliers(int start, int end, int number){
		for(int i=start; i<end; i++){
			int temp = _rand.nextInt(400);
			while(_wordIndexRepeats.contains(temp)){
				temp = _rand.nextInt(400);
			}
			_wordIndexRepeats.add(temp);
			_wordMultipliers[temp] = number;
	}
	}
	
	public void boardClicked(int row,int col){
		if(_currentTile != null){
			setTile(_currentTile,row,col);
		}
		
	}
}
