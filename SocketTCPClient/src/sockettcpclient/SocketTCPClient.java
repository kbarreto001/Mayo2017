package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class SocketTCPClient {

    public static void main(String[] args) {
        Byte[] fichero;
        File nombreFichero;
        System.out.println("Soy el cliente");
        try (
                Socket client = new Socket("localhost", 5000);
                DataOutputStream dosSocket = new DataOutputStream(client.getOutputStream());
                DataInputStream disSocket = new DataInputStream(client.getInputStream());) {
            ComandC fich = new ComandC();
            
            fichero = fich.LeerFichero(nombreFichero=fich.NombreFichero());
            fich.EnviarFichero(fichero, dosSocket, nombreFichero);      
                        
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }
}
