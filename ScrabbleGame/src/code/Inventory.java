package code;
import java.util.ArrayList;
import java.util.Random;

public class Inventory {
	private ArrayList<Tile> _tileBag;
	private Scrabble _scrabble;
	
	public Inventory(Scrabble s){
		_scrabble = s;
		_tileBag = new ArrayList<Tile>();
		fillBag();}

	private void fillBag() {
		for (int i = 'A'; i <= 'Z'; i = i + 1){
			if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
				for (int j = 0; j < 29; j++){
					_tileBag.add(new Tile((char)i,1));}}
			else if (i == 'Y'){
				for (int j = 0; j < 15; j++){
					_tileBag.add(new Tile((char)i,2));}}
			else{
				for (int j = 0; j < 12; j++){
					_tileBag.add(new Tile((char)i,5));}}}}

	public Tile removeRandomTile(){
		int randomIndex = new Random().nextInt(_tileBag.size()-1);
		return _tileBag.remove(randomIndex);}
	
	public int getSize(){
		return _tileBag.size();}
	
	public Tile getTile(int i){
		return _tileBag.get(i);}
}