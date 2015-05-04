package someInterfaceStuff;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote{
	public void update() throws RemoteException;

}
