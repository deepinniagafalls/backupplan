package code;
import java.util.ArrayList;
import java.awt.Color;
public class Player {

	private String _name;
	private TileRack _tr;
	private Inventory _inv;
	private Scrabble _scrabble;
	private int _score;
	private Color _color;
	
	public Player(Scrabble s, String name){
		_name = name;
		_scrabble = s;
		_inv = _scrabble.getInventory();
		_tr = new TileRack();
	}
	

	
	class TileRack {
		
		private ArrayList<Tile> _rack;
	
		public TileRack(){
			_rack = new ArrayList<Tile>();
			fillRack();}

		public void fillRack(){
			while (_rack.size() < 12){
				_rack.add(_inv.removeRandomTile());}}
		
		public Tile removeTile(int i){return _rack.remove(i);}
		public int getSize() {return _rack.size();}
		public Tile getTile(int i){return _rack.get(i);}}
		public int getScore(){return _score;}
		public String getName(){return _name;}
		public Color getColor(){return _color;}
		public TileRack getTileRack(){return  _tr;}
}

