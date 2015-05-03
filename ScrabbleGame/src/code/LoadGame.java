package code;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

public class LoadGame {
	
	private String _fileToRead;
	
	public LoadGame() throws IOException{

	JFrame jf = new JFrame();
	FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.LOAD);
	chooser.setDirectory("C:\\"); chooser.setFile("*.txt");
	chooser.setVisible(true); String filename = chooser.getFile();
	String path = chooser.getDirectory(); System.out.println(path);
	String filetoRead = path + filename;
	_fileToRead = filetoRead;
	File file = new File(_fileToRead);
	FileReader fw = new FileReader(file.getAbsoluteFile());
	BufferedReader bw = new BufferedReader(fw);
    String s = (bw.readLine());
    String delims = "%";
    String[] tokens = s.split(delims);
    
    for (int i = 0; i < tokens.length; i++){
        System.out.println(tokens[i]);
    }
    
	}
}


