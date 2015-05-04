package server;
import java.util.ArrayList;
import java.util.Random;

import server.ServerCode;
import server.Tile;

public class Inventory {
	private ArrayList<Tile> _tileBag;
	private ServerCode _scrabble;
	
	public Inventory(ServerCode s){
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
	
	public void resetTileBag(){
		_tileBag = new ArrayList<Tile>();
	}
	
	public void addTile(char i){
		int pointvalue;
	
		if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
			pointvalue = 1;
		}
		else if (i == 'Y'){
			pointvalue = 2;
		}
		else{
			pointvalue = 5;
		}
		Tile t = new Tile(i,pointvalue);
		_tileBag.add(t);
	}
}