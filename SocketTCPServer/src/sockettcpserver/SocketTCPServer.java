package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    public static void main(String[] args) {
        int counter=1,size=1000;
        Byte[] fichero;
        try{
            ServerSocket server = new ServerSocket(5000,size);
            System.out.println("Soy el servidor");
            while(true){
                Socket connection = server.accept();
                System.out.println("Conexion No.: "+counter+" Recibida de: "+connection.getInetAddress().getHostName());
                DataOutputStream dosSocket = new DataOutputStream(connection.getOutputStream());
                DataInputStream disSocket = new DataInputStream(connection.getInputStream());
                CommandS otro = new CommandS();
                
                fichero=otro.RecibirFichero(disSocket);
                otro.GuardarFichero(fichero);
                otro.Repeticiones(fichero,dosSocket);
                
                connection.close();
                dosSocket.close();
                disSocket.close();
                counter++;
            }
        } catch (IOException ex){
            System.out.println("Error: "+ex.getLocalizedMessage());
        }        
    }
    
}
