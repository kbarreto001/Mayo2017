

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements ServidorInterfaz{

    Implementacion() throws RemoteException{
        super();
    }
    
    @Override
    public int sum(int a, int b)throws RemoteException {
        return a+b;
    }    

    @Override
    public String LeerFichero(String nombreFichero) throws RemoteException {
        String[] ficheroT;
        CommandS otro = new CommandS();
        ficheroT=otro.LeerFichero(nombreFichero);
        return otro.PalabraR(ficheroT);
    }
}
