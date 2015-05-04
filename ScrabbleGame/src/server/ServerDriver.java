package server;

import java.util.ArrayList;

public class ServerDriver {

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		for(String s : args){
			input.add(s);
		}
		int portnumber = Integer.parseInt(input.get(1)); 
		String hostname = input.get(0);
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
			System.out.println("Security manager started");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
				System.out.println("Security manager started");
			}
	}
	}
}
