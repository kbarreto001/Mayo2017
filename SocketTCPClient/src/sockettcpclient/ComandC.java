package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ComandC {

    protected File fichero;

    public File NombreFichero() {
        Scanner sc = new Scanner(System.in);
        String nombreFichero;
        System.out.println("Escriba el nombre del fichero");
        nombreFichero = sc.next();
        
        return fichero = new File(nombreFichero);
    }

    public Byte[] LeerFichero(File fichero) {
        Byte[] ficheroInf = new Byte[(int) fichero.length()];
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(fichero));) {
            for (int i = 0; i < ficheroInf.length; i++) {
                ficheroInf[i] = dis.readByte();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }        
        return ficheroInf;               
    }
    
    public void EnviarFichero(Byte[] fichero, DataOutputStream dosSocket, File ficheroN){
        try{
            dosSocket.writeUTF(ficheroN.getName());
            dosSocket.writeInt((int)ficheroN.length());
            for (int i=0;i<fichero.length;i++){
                dosSocket.writeByte(fichero[i]);
            }
            dosSocket.writeByte(fichero[fichero.length-1]);
        } catch (IOException ex){
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
    }

}
