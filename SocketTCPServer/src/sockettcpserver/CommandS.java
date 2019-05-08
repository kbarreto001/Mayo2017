package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommandS {

    protected String nombreFichero;

    public Byte[] RecibirFichero(DataInputStream disSocket) {
        int tamañoFichero;
        Byte[] fichero = null;
        try {
            System.out.println("Recibo el fichero: " + (nombreFichero = disSocket.readUTF()));
            System.out.println("con un tamaño de: " + (tamañoFichero = disSocket.readInt()));
            fichero = new Byte[tamañoFichero];
            for (int i = 0; i < fichero.length; i++) {
                fichero[i] = disSocket.readByte();
            }
            if (fichero[fichero.length - 1] == disSocket.readByte()) {
                System.out.println("Fichero recibido correctamente");
            } else {
                System.out.println("Algo salio mal");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return fichero;
    }

    public void GuardarFichero(Byte[] fichero) throws FileNotFoundException, IOException {
        File ficheroN = new File(nombreFichero);
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroN));) {
            for (int i=0;i<fichero.length;i++){
                dos.writeByte(fichero[i]);
            }
             System.out.println("Fichero guardado correctamente");             
        }
    }

    public void Repeticiones (Byte[] fichero){
        Byte[] ceros = new Byte[256];        
        int maxR=0,maxV=0;
        for (int i=0;i<ceros.length;i++){
            for(int j=0;j<fichero.length;j++){
                if ((int)fichero[j]==i){
                    ceros[i]=(byte)((int)ceros[i]+1);
                }
            }
        }
        for (int k=0;k<ceros.length;k++){
            if(ceros[k]>maxR){
                maxR=ceros[k];
                maxV=k;
            }
        }
        System.out.println("El que mas se repite es: "+maxV);
        System.out.println("se repitio: "+maxR);        
    }

}
