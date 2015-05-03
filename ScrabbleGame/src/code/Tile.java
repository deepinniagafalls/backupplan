package code;

public class Tile {

	private char _letter;
	private int _pointValue;
	
	public Tile(char j, int i){
		_letter = j;
		_pointValue = i;}
	
	public String getChar(){	
		return Character.toString(_letter);}
	
	public int getValue(){
		return _pointValue;}
}
