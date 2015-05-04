package server;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
public class Player {

	private String _name;
	private TileRack _tr;
	private Inventory _inv;
	private ServerCode _scrabble;
	private int _score;
	private Color _color;
	
	public Player(ServerCode s, String name){
		_name = name;
		_scrabble = s;
		_inv = _scrabble.getInventory();
		_tr = new TileRack();
		Random random = new Random();
		float hue = random.nextFloat();
		float saturation = (random.nextFloat() * 1.0f) + 0.6f;
		float luminance = (random.nextFloat() * 1.1f) + 0.7f; 
		_color = Color.getHSBColor(hue, saturation, luminance);

	}
	public Color getC(){
		return _color;
		}
	
	public TileRack getTileRack(){return  _tr;}
	

	
	public class TileRack {
		
		private ArrayList<Tile> _rack;
	
		public TileRack(){
			_rack = new ArrayList<Tile>();
			fillRack();}

		public void fillRack(){
			while (_rack.size() < 12){
				_rack.add(_inv.removeRandomTile());}}
		
		public Tile removeTile(int i){return _rack.remove(i);}
		public int getSize() {return _rack.size();}
		public Tile getTile(int i){return _rack.get(i);}
		public int getScore(){return _score;}
		public String getName(){return _name;}
		public void setName(String name){_name = name;}
		public Color getColor(){return _color;}
		public void setColor(Color color){_color = color;}
		
		
		public void boardClicked(int index){
			if(_scrabble.getBoard().getCurrent())
		}
	}
}

