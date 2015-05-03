package code;

import java.util.ArrayList;
public class Player {

	private String _name;
	private TileRack _tr;
	private Inventory _inv;
	private Scrabble _scrabble;
	
	public Player(Scrabble s, String name){
		_name = name;
		_scrabble = s;
		_inv = _scrabble.getInventory();
		_tr = new TileRack();
	}
	
	public TileRack getTileRack(){
		return _tr;
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
	
		public String getName(){return _name;}
}

