

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        String infoR,nombreFichero;
        try {
            System.out.println("Gestor de seguridad cargado en Cliente");
            String url = "//localhost:1330/SERVIDOR";
            ServidorInterfaz objetoRemoto = (ServidorInterfaz) Naming.lookup(url);
            System.out.println("Obtenida referencia a objeto remoto");
            SupportC otro = new SupportC();
            
            infoR=objetoRemoto.LeerFichero(nombreFichero=otro.NombreFichero());
            otro.GuardarP(infoR, nombreFichero);

        } catch (NotBoundException ex){
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
    }

}
