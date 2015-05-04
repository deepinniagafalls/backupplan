package someInterfaceStuff;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.Board;
import server.Inventory;
import server.Player;

public interface IServer extends Remote{
public Board getBoard() throws RemoteException;
public void switchTurn() throws RemoteException;
public int getTurn() throws RemoteException;
public int getNumberofPlayers() throws RemoteException;
public Player getPlayer(int i) throws RemoteException;
public Inventory getInventory() throws RemoteException;



}
