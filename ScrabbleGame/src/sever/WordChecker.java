package sever;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;

public class WordChecker {
	private boolean _vert;
	private ArrayList<Integer> _rowCoordinates, _colCoordinates;
	private Board _b;
	
	public WordChecker(Board board){
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_b = board;
	}
	
	public boolean isThisWord(){
		String wordForward = "", wordBackward = "";
		int firstRow = minIndex(_rowCoordinates);int lastRow = maxIndex(_rowCoordinates);
		int firstColumn = minIndex(_colCoordinates);int lastColumn = maxIndex(_colCoordinates);
		
		if(Math.abs(firstRow-lastRow) == 0){_vert = true;}
		else{_vert = false;}
		
		for(int i =0; i < _rowCoordinates.size(); i ++){
			wordForward = wordForward + _b.getTile(_rowCoordinates.get(i),_colCoordinates.get(i));
			wordBackward = _b.getTile(_rowCoordinates.get(i),_colCoordinates.get(i)) + wordBackward;
		}
		
		ReaderTool temp = new ReaderTool("Documents/words.txt");
		
		if(temp.isThisAWord(wordForward) || temp.isThisAWord(wordBackward)){
			return true;
		}
		else{
			return false;
		}
		}

	public Integer getScore(){
		return 0;
	}
	
	public int minIndex (ArrayList<Integer> list) {
		  return list.indexOf (Collections.min(list)); }
	
	public int maxIndex (ArrayList<Integer> list) {
		  return list.indexOf (Collections.max(list)); }
}
