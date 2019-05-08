

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorInterfaz extends Remote{
    public int sum(int a, int b) throws RemoteException;    
    
    public String LeerFichero(String nombreFichero) throws RemoteException;
    
}
